import org.example.Storm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StormTest1 {

    // --- Test hợp lệ ---
    @Test
    public void testNormal() {
        assertEquals("Bình thường",
                Storm.stormAssessment(50, 100, false));
    }

    @Test
    public void testOneRisk() {
        assertEquals("Cảnh báo thời tiết xấu",
                Storm.stormAssessment(90, 100, false));
    }

    @Test
    public void testTwoRisk() {
        assertEquals("Bão nguy hiểm",
                Storm.stormAssessment(90, 250, false));
    }

    @Test
    public void testThreeRisk() {
        assertEquals("Khẩn cấp - Yêu cầu sơ tán",
                Storm.stormAssessment(90, 250, true));
    }

    // --- Boundary test cho v ---
    @Test
    public void testWindBoundaryBelow() {
        assertEquals("Lỗi dữ liệu",
                Storm.stormAssessment(-1, 100, false));
    }

    @Test
    public void testWindBoundaryAt0() {
        assertEquals("Bình thường",
                Storm.stormAssessment(0, 100, false));
    }

    @Test
    public void testWindBoundaryAt88() {
        assertEquals("Bình thường",
                Storm.stormAssessment(88, 100, false));
    }

    @Test
    public void testWindBoundaryAt89() {
        assertEquals("Cảnh báo thời tiết xấu",
                Storm.stormAssessment(89, 100, false));
    }

    @Test
    public void testWindBoundaryAbove() {
        assertEquals("Lỗi dữ liệu",
                Storm.stormAssessment(301, 100, false));
    }

    // --- Boundary test cho m ---
    @Test
    public void testRainBoundaryBelow() {
        assertEquals("Lỗi dữ liệu",
                Storm.stormAssessment(50, -1, false));
    }

    @Test
    public void testRainBoundaryAt199() {
        assertEquals("Bình thường",
                Storm.stormAssessment(50, 199, false));
    }

    @Test
    public void testRainBoundaryAt200() {
        assertEquals("Cảnh báo thời tiết xấu",
                Storm.stormAssessment(50, 200, false));
    }

    @Test
    public void testRainBoundaryAbove() {
        assertEquals("Lỗi dữ liệu",
                Storm.stormAssessment(50, 1001, false));
    }

    // --- Test biến c ---
    @Test
    public void testLocationTrue() {
        assertEquals("Cảnh báo thời tiết xấu",
                Storm.stormAssessment(50, 100, true));
    }
}
