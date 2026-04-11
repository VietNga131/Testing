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
            { -1, 100, false, "Lỗi dữ liệu" },
            { 160, 100, false, "Khẩn cấp - Yêu cầu sơ tán" },
            { 100, 600, true, "Khẩn cấp - Yêu cầu sơ tán" },
            { 50, 100, false, "Bình thường" },
            { 80, 300, true, "Khẩn cấp - Yêu cầu sơ tán" },
            { 80, 300, false, "Cảnh báo thời tiết xấu" },
            { 50, 100, true, "Cảnh báo thời tiết xấu" },
            { 80, 100, true, "Bão nguy hiểm" },
            { 100, 100, false, "Cảnh báo thời tiết xấu" }
        });
    }

    @Test
    public void testDongDuLieu() {
        String actualOutput = Stormm.stormAssessment(speed, rainfall, region);
        String errorMessage = String.format("Failed tại input: speed=%d, rainfall=%d, region=%b", speed, rainfall, region);

        assertEquals(errorMessage, eOutput, actualOutput);
    }
}