import java.util.Arrays;
import java.util.Collection;

import org.example.Stormm;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DongDuLieu {
    
    private int speed;
    private int rainfall;
    private boolean region;
    private String eOutput;

    public DongDuLieu(int speed, int rainfall, boolean region, String eOutput) {
        this.speed = speed;
        this.rainfall = rainfall;
        this.region = region;
        this.eOutput = eOutput;
    }

    @Parameterized.Parameters(name = "TC {index}: speed={0}, rainfall={1}, region={2} -> {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            { -1, 100, false, "Lỗi dữ liệu" }
        });
    }

    @Test
    public void testDongDieuKhien() {
        String actualOutput = Stormm.stormAssessment(speed, rainfall, region);
        String errorMessage = String.format("Failed tại input: speed=%d, rainfall=%d, region=%b", speed, rainfall, region);

        assertEquals(errorMessage, eOutput, actualOutput);
    }
}