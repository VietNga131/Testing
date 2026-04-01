package KiemThuChucNang;

import java.util.Arrays;
import java.util.Collection;

import org.example.Storm;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GiaTriBien {

    private int speed;
    private int rainfall;
    private boolean region;
    private String eOutput;

    public GiaTriBien(int speed, int rainfall, boolean region, String eOutput) {
        this.speed = speed;
        this.rainfall = rainfall;
        this.region = region;
        this.eOutput = eOutput;
    }

    @Parameterized.Parameters(name = "TC {index}: speed={0}, rainfall={1}, region={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                { 80, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 1 & 30

                { -1, 250, true, "Lỗi dữ liệu" },                 // TC 2
                { 0, 250, true, "Bão nguy hiểm" },                // TC 3
                { 1, 250, true, "Bão nguy hiểm" },                // TC 4
                { 69, 250, true, "Bão nguy hiểm" },               // TC 5
                { 70, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 6
                { 71, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 7
                { 88, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 8
                { 89, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 9
                { 90, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 10
                { 149, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 11
                { 150, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 12
                { 151, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 13
                { 299, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 14
                { 300, 250, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 15
                { 301, 250, true, "Lỗi dữ liệu" },                // TC 16

                { 80, -1, true, "Lỗi dữ liệu" },                  // TC 17
                { 80, 0, true, "Bão nguy hiểm" },                 // TC 18
                { 80, 1, true, "Bão nguy hiểm" },                 // TC 19
                { 80, 199, true, "Bão nguy hiểm" },               // TC 20
                { 80, 200, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 21
                { 80, 201, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 22
                { 80, 499, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 23
                { 80, 500, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 24
                { 80, 501, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 25
                { 80, 999, true, "Khẩn cấp - Yêu cầu sơ tán" },   // TC 26
                { 80, 1000, true, "Khẩn cấp - Yêu cầu sơ tán" },  // TC 27
                { 80, 1001, true, "Lỗi dữ liệu" },                // TC 28

                { 80, 250, false, "Cảnh báo thời tiết xấu" }      // TC 29
        });
    }


    @Test
    public void testBoundaryValues() {

        String actualOutput = Storm.stormAssessment(speed, rainfall, region);
        String errorMessage = String.format("Sai kết quả ở input: speed=%d, rainfall=%d, region=%b", speed, rainfall, region);

        assertEquals(errorMessage, eOutput, actualOutput);
    }
}