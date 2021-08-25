package alex.almansa.cubes.controller;

import alex.almansa.cubes.component.CubeComponent;
import alex.almansa.cubes.model.Cube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = CubeController.PATH)

public class CubeController {

    public static final String PATH = "/cubes";
    @Autowired
    private CubeComponent cubeComponent;


    /**
     * Function to get all cubes
     *
     * @return
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "Returns all cubes")
    public List< Cube> getAllCubes() {
        return cubeComponent.getCubes();
    }

    /**
     * Function to get one cube
     *
     * @return
     */
    @GetMapping(value = "/one")
    @ApiOperation(value = "Returns a specific cube")
    public Cube getCube(Integer id, HttpServletResponse response) {

        if (id == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return cubeComponent.getCubes().get(id);
    }

    /**
     * Function to create a cube
     *
     * @return Returns the cube created
     */
    @PostMapping(value = "/create")
    @ApiOperation(value = "Creates a cube or modifies it if it already existed")
    public Cube createCube(@RequestBody Cube cube) {
        return cubeComponent.createCube(cube);

    }

    /**
     * Function to create a cube
     *
     * @return Returns the cube created
     */
    @PostMapping(value = "/update")
    @ApiOperation(value = "Creates a cube or modifies it if it already existed")
    public Cube updateCube(@RequestBody Cube cube) {
        return cubeComponent.updateCube(cube);
    }

    /**
     * Function that determines if two cubes intersect
     *
     * @return boolean indicating if they intersect or not
     */
    @GetMapping(value = "/intersect")
    @ApiOperation(value = "Checks if the cubes intersect or not")
    public Float updateCube(Integer cube1Id, Integer cube2Id) {
        return cubeComponent.calculateIntersection(cube1Id, cube2Id);
    }
}
