import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Tests {
    private WeatherAPI weather;
    ArrayList a = new ArrayList();

    @Before
    public void init() { weather = new WeatherAPI(); }

    @Test
    public void getTemperatureThisTime() {
        assertEquals(0, weather.getTemperatureThisTime());
    }

    @Test
    public void getHighestAndLowestThreeDays() {
        assertTrue(weather.getHighestAndLowestThreeDays() == a);
    }

    @Test
    public void getGEO() {
        assertTrue(weather.getGEO() == null);
    }
}
