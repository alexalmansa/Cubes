package alex.almansa.cubes;

import alex.almansa.cubes.component.CubeComponent;
import alex.almansa.cubes.model.Cube;
import alex.almansa.cubes.model.Point3D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CubesApplicationTests {
    @Autowired
    private CubeComponent cubeComponent;

    private Cube testCubes[] =
            {new Cube(0, new Point3D(10, 10, 10), 2),
                    new Cube(1, new Point3D(1, 2, 3), 30),
                    new Cube(2, new Point3D(1, 1, 1), 1),
                    new Cube(3, new Point3D(4, 10, 0), 5),
                    new Cube(4, new Point3D(3, 3, 3), 3),
                    new Cube(5, new Point3D(-3, -3, 3), 3),

            };

    @Test
    @DisplayName("Should Not Intersect")
    void shouldNotIntersect() {
        cubeComponent.createCube(testCubes[0]);
        cubeComponent.createCube(testCubes[2]);
        int idCube0 = cubeComponent.getCubes().get(0).getId();
        int idCube1 = cubeComponent.getCubes().get(1).getId();

        //operation
        float result1 = cubeComponent.calculateIntersection(idCube0, idCube1);

        //assertion
        Assertions.assertEquals(0, result1);
    }

    @Test
    @DisplayName("Should  Intersect")
    void shouldIntersect() {
        //prepare
        cubeComponent.createCube(testCubes[0]);
        cubeComponent.createCube(testCubes[1]);
        int idCube0 = cubeComponent.getCubes().get(0).getId();
        int idCube1 = cubeComponent.getCubes().get(1).getId();

        //operation
        float result1 = cubeComponent.calculateIntersection(idCube0, idCube1);

        //assertion
        Assertions.assertEquals(8, result1);
    }

    @Test
    @DisplayName("Correctly thrown exception")
    void shouldNotWork() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cubeComponent.createCube(new Cube(5, new Point3D(-3, -3, 3), -3));
        });
        String expectedMessage = "Invalid edge length value. Length has to be a positive number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
