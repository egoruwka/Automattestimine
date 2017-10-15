package WeatherAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class Tests {

    Weather weather;

    @BeforeEach
    void sutUP_tests(){
        weather = new Weather("Tallinn", "EE", "Celsius");
    }

    @Test
    void getForecastJSON() {
        try {
            assertNotNull(weather.getWeatherJSON());
        } catch (IOException e) {
            fail("Null!");
        }
    }

    @Test
    void getWeatherJSON() {
        try {
            assertNotNull(weather.getForecastJSON());
        } catch (IOException e) {
            fail("Null!");
        }
    }

}
