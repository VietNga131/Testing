package org.example;

public class Stormm {

    public static String stormAssessment(int speed, int rainfall, boolean region) {

        // ===== Bước 1: Kiểm tra dữ liệu hợp lệ =====
        if (speed < 0 || speed > 300 || rainfall < 0 || rainfall > 1000) {
            return "Lỗi dữ liệu";
        }

        // ===== Bước 2: Quy tắc ưu tiên cao (Override) =====
        if (speed >= 150) {
            return "Khẩn cấp - Yêu cầu sơ tán";
        }

        if (rainfall >= 500 && region) {
            return "Khẩn cấp - Yêu cầu sơ tán";
        }

        // ===== Bước 3: Điều chỉnh ngưỡng theo vị trí =====
        int nguongGio;
        if (region) {
            nguongGio = 70;
        } else {
            nguongGio = 89;
        }

        // ===== Bước 4: Xác định các điều kiện =====
        int count = 0;

        if (speed >= nguongGio) count++;
        if (rainfall >= 200) count++;
        if (region) count++;

        // ===== Bước 5: Decision Logic =====
        switch (count) {
            case 3:
                return "Khẩn cấp - Yêu cầu sơ tán";
            case 2:
                return "Bão nguy hiểm";
            case 1:
                return "Cảnh báo thời tiết xấu";
            default:
                return "Bình thường";
        }
    }

    // ===== Hàm main để test =====
    public static void main(String[] args) {
        System.out.println(stormAssessment(160, 100, false)); // Override gió → Khẩn cấp
        System.out.println(stormAssessment(80, 300, true));   // 3 điều kiện → Khẩn cấp
        System.out.println(stormAssessment(75, 100, true));   // 2 điều kiện → Nguy hiểm
        System.out.println(stormAssessment(50, 50, false));   // Bình thường
        System.out.println(stormAssessment(-1, 50, false));   // Lỗi
    }
}
