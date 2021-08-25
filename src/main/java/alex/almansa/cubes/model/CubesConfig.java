package alex.almansa.cubes.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CubesConfig {
    @Bean
    public Map<Integer, Cube> cubes() {
        Map<Integer, Cube> map = new HashMap<Integer, Cube>();
        return map;
    }
}
