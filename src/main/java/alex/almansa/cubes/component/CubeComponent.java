package alex.almansa.cubes.component;

import alex.almansa.cubes.model.Cube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CubeComponent {
    @Autowired
    private Map<Integer,Cube> cubes;

    public List<Cube> getCubes() {
        List<Cube> cubeList = new ArrayList<>(cubes.values());
        return cubeList;
    }

    public Cube createCube(Cube cube){
        cube.setId(cubes.size());
        cubes.put(cube.getId(), cube);
        return cube;
    }

    public Cube updateCube(Cube cube){
        cubes.put(cube.getId(), cube);
        return cube;
    }

    public Float calculateIntersection(Integer cube1Id, Integer cube2Id){
        if (cube1Id == null || cube2Id == null || cubes.get(cube1Id) == null || cubes.get(cube2Id) == null ) {
            throw new IllegalArgumentException("The value of the ids is not correct or doesn't exist");
        } else {
            return cubes.get(cube1Id).calculateIntersection(cubes.get(cube2Id));
        }
    }
}
