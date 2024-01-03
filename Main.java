import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void menu() {
        System.out.print(
                """
                                        Menu
                        ======================================
                        1. Đăng ký Báo cáo
                        2. Xóa Báo cáo
                        3. Sửa Báo cáo
                        4. Xem danh sách báo cáo theo loại
                        5. Sắp xếp Báo cáo
                        6. Tìm kiếm Báo cáo
                        7. Chấm điểm Báo cáo
                        8. Xem điểm Báo cáo
                        9. Tìm hội đồng chấm khóa luận
                        0. Thoát chương trình
                        ======================================
                        -->\t\t""");
    }

    public static void menuLoaiBaoCao() {
        System.out.print("""
                \t\t\t1. Báo cáo thực tập
                \t\t\t2. Báo cáo đồ án ngành
                \t\t\t3. Báo cáo khóa luận tốt nghiệp
                \t\t\t4. Báo cáo
                \t\t\t-->\t\t""");
    }

    private static List<SinhVien> sinhVienList = new ArrayList<>();
    private static List<GiangVien> giangVienList = new ArrayList<>();
    private static final QuanLyBaoCao quanLyBaoCao = new QuanLyBaoCao();

    static {
        try {
            sinhVienList = LoadFile.docFileSinhVien("src\\Data\\SinhVien.txt");
            giangVienList = LoadFile.docFileGiangVien("src\\Data\\GiangVien.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SinhVien timSinhVien(String mSSV) {
        return sinhVienList.stream().filter(sinhVien -> sinhVien.getmSSV().equals(mSSV)).findFirst().get();
    }

    public static GiangVien timGiangVien(String maGiangVien) {
        return giangVienList.stream().filter(giangVien -> giangVien.getMaGiangVien().equals(maGiangVien)).findFirst().get();
    }

    public static void main(String[] args) {
        quanLyBaoCao.themBaoCao(new BaoCaoDoAn(
                "Đồ án 1",
                "D:\\DoAn",
                LocalDate.parse("12/12/2024", DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                timGiangVien("GV01"),
                timSinhVien("SV01")));
        quanLyBaoCao.themBaoCao(new BaoCaoThucTap(
                        "Thực tập 1",
                        "D:\\ThucTap",
                        LocalDate.parse("10/12/2024", DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                        timGiangVien("GV02"),
                        timSinhVien("SV02"),
                        timSinhVien("SV03")
                )
        );
        List<GiangVien> giangViens=new ArrayList<>();
        giangViens.add(timGiangVien("GV04"));
        giangViens.add(timGiangVien("GV05"));
        giangViens.add(timGiangVien("GV06"));
        quanLyBaoCao.themBaoCao(new BaoCaoKhoaLuan("" +
                "Khóa luận 1",
                "D:\\KhoaLuan",
                LocalDate.parse("10/12/2024", DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                timGiangVien("GV03"),
                giangViens,
                timSinhVien("SV10"),
                timSinhVien("SV12")
                )
        );

        boolean flagExit = true;
        while (flagExit) {
            menu();
            switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                case 1 -> {
                    System.out.println("Chọn loại báo cáo nào: ");
                    System.out.print("""
                        \t\t\t1. Báo cáo thực tập
                        \t\t\t2. Báo cáo đồ án ngành
                        \t\t\t3. Báo cáo khóa luận tốt nghiệp
                        \t\t\t-->\t\t""");
                    int flagDangKy = Integer.parseInt(CauHinh.sc.nextLine());
                    System.out.print("Nhập số lượng sinh viên thực hiện (1/2): ");
                    int soLuongSinhVienTYhucHien = Integer.parseInt(CauHinh.sc.nextLine());

                    while (soLuongSinhVienTYhucHien < 1 || soLuongSinhVienTYhucHien > 2) {
                        System.out.println("Bạn nhập sai!! Vui lòng nhập lại: ");
                        soLuongSinhVienTYhucHien = Integer.parseInt(CauHinh.sc.nextLine());
                    }

                    SinhVien[] sinhViens = new SinhVien[soLuongSinhVienTYhucHien];
                    for (int i = 0; i < soLuongSinhVienTYhucHien; i++) {
                        System.out.print("Nhập MSSV thứ " + (i + 1) + ": ");
                        sinhViens[i] = timSinhVien(CauHinh.sc.nextLine());
                    }

                    System.out.print("Nhập mã giảng viên hướng dẫn: ");
                    GiangVien giangVien = timGiangVien(CauHinh.sc.nextLine());
                    try {
                        switch (flagDangKy) {
                            case 1 -> quanLyBaoCao.dangKyBaoCao("BaoCaoThucTap", giangVien, sinhViens);

                            case 2 -> quanLyBaoCao.dangKyBaoCao("BaoCaoDoAn", giangVien, sinhViens);

                            case 3 -> quanLyBaoCao.dangKyBaoCao("BaoCaoKhoaLuan", giangVien, sinhViens);
                        }
                        break;
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                             | InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2 -> {
                    System.out.print("Nhập mã báo cáo cần xóa: ");
                    quanLyBaoCao.xoaBaoCao(CauHinh.sc.nextLine());
                    System.out.println("Đã xóa thành công!");
                    break;
                }
                case 3 -> {
                    System.out.println("-----------Sửa báo cáo-----------");
                    System.out.print("Nhập mã báo cáo bạn muốn sữa: ");
                    BaoCao baoCao = quanLyBaoCao.timKiem(CauHinh.sc.nextLine());
                    System.out.println("1. Sửa tên\n" +
                            "2. Sửa chuỗi link\n" +
                            "3. Thay đổi ngày báo cáo\n" +
                            "4. Thay đổi giảng viên hướng dẫn\n" +
                            "5. Thay đổi sinh viên tham gia\n" +
                            "6. Chấm lại báo cáo\n");
                    switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                        case 1 -> {
                            System.out.print("Sửa tên báo cáo thành: ");
                            quanLyBaoCao.suaBaoCao(baoCao, CauHinh.sc.nextLine(), 1);
                        }

                        case 2 -> {
                            System.out.print("Sửa chuỗi link thành: ");
                            quanLyBaoCao.suaBaoCao(baoCao, CauHinh.sc.nextLine(), 2);
                        }

                        case 3 -> {
                            System.out.print("Thay đổi ngày báo cáo thành: ");
                            quanLyBaoCao.suaBaoCao(baoCao, LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)));
                        }

                        case 4 -> {
                            System.out.println("__Thay đổi giảng viên hướng dẫn__");
                            System.out.print("Nhập mã GV hướng dẫn thay thế: ");
                            quanLyBaoCao.suaBaoCao(baoCao, timGiangVien(CauHinh.sc.nextLine()));
                        }

                        case 5 -> {
                            System.out.println("__Thay đổi sinh viên tham gia__");
                            System.out.println("Sinh viên hiện tại trong báo cáo: ");
                            baoCao.getSinhViens().forEach(sinhVien -> sinhVien.xuatSinhVien());
                            System.out.println("1. Thêm sinh viên\n" +
                                    "2. Xóa sinh viên\n" +
                                    "3. Thay đổi sinh viên");
                            int flag = Integer.parseInt(CauHinh.sc.nextLine());

                            if (flag == 1) {
                                System.out.print("Nhập MSSV bạn muốn thêm vào: ");
                                SinhVien sinhVien = timSinhVien(CauHinh.sc.nextLine());
                                quanLyBaoCao.suaBaoCao(baoCao, sinhVien, 1);
                            } else if (flag == 2) {
                                System.out.print("Nhập MSSV bạn muốn xóa: ");
                                SinhVien sinhVien = timSinhVien(CauHinh.sc.nextLine());
                                quanLyBaoCao.suaBaoCao(baoCao, sinhVien, 2);
                            } else if (flag == 3) {
                                System.out.print("Nhập MSSV người bạn muốn đổi: ");
                                SinhVien sinhVien = timSinhVien(CauHinh.sc.nextLine());
                                quanLyBaoCao.suaBaoCao(baoCao, sinhVien, 2);
                                System.out.print("Bạn muốn đổi thành sinh viên (MSSV): ");
                                sinhVien = timSinhVien(CauHinh.sc.nextLine());
                                quanLyBaoCao.suaBaoCao(baoCao, sinhVien, 1);
                            }
                        }
                        case 6 -> {
                            System.out.println("__Sửa điểm báo cáo__");
                            quanLyBaoCao.suaDiem(baoCao);
                        }
                    }
                }
                case 4 -> {
                    menuLoaiBaoCao();
                    int flagDanhSach = Integer.parseInt(CauHinh.sc.nextLine());
                    try {
                        switch (flagDanhSach) {
                            case 1 -> quanLyBaoCao.xemDanhSach("BaoCaoThucTap");

                            case 2 -> quanLyBaoCao.xemDanhSach("BaoCaoDoAn");

                            case 3 -> quanLyBaoCao.xemDanhSach("BaoCaoKhoaLuan");

                            case 4 -> quanLyBaoCao.xemDanhSach("BaoCao");
                        }
                        break;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 5 -> {
                    System.out.println("-----------Lọc và sắp sắp xếp-----------");
                    System.out.print("Sắp xếp báo cáo theo: \n" +
                            "\t\t\t1. Ngày báo cáo\n" +
                            "\t\t\t2. Tên báo cáo\n" +
                            "\t\t\t-->\t\t");
                    int flagSapXep = Integer.parseInt(CauHinh.sc.nextLine());
                    quanLyBaoCao.sortBaoCaos(flagSapXep);

                    System.out.println("Lọc báo cáo theo: \n");
                    System.out.print("""
                            \t\t\t1. Báo cáo thực tập
                            \t\t\t2. Báo cáo đồ án ngành
                            \t\t\t3. Báo cáo khóa luận tốt nghiệp
                            \t\t\t4. Không
                            \t\t\t-->\t\t""");
                    int flagLoc = Integer.parseInt(CauHinh.sc.nextLine());
                    String classPatse = null;
                    switch (flagLoc) {
                        case 1 -> classPatse = "BaoCaoThucTap";
                        case 2 -> classPatse = "BaoCaoDoAn";
                        case 3 -> classPatse = "BaoCaoKhoaLuan";
                        case 4 -> classPatse = "BaoCao";
                    }

                    try {
                        quanLyBaoCao.locBaoCao(classPatse).forEach(baoCao -> baoCao.xuatBaoCao());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                }
                case 6 -> {
                    System.out.println("-----------Tìm kiếm báo cáo-----------");
                    System.out.print("1. Tìm kiếm theo mã báo cáo\n" +
                            "2. Tìm kiếm theo tên báo cáo\n" +
                            "3. Tìm kiếm theo ngày\n" +
                            "4. Tìm kiếm theo khoảng ngày\n" +
                            "\t\t\t-->\t\t");
                    switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                        case 1 -> {
                            System.out.print("Nhập mã báo cáo: ");
                            quanLyBaoCao.timKiem(CauHinh.sc.nextLine()).xuatBaoCao();
                        }
                        case 2 -> {
                            System.out.print("Nhập tên báo cáo: ");
                            quanLyBaoCao.timKiem(CauHinh.sc.nextLine(),1).forEach(baoCao -> baoCao.xuatBaoCao());
                        }
                        case 3 -> {
                            System.out.print("Nhập ngày báo cáo: ");
                            quanLyBaoCao.timKiem(LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER))).forEach(baoCao -> baoCao.xuatBaoCao());
                        }
                        case 4 -> {
                            System.out.print("Nhập khoảng thời gian: ");
                            System.out.print("Ngày 1: ");
                            LocalDate date1 = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER));
                            System.out.print("Ngày 2: ");
                            LocalDate date2 = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER));
                            quanLyBaoCao.timKiem(date1,date2).forEach(baoCao -> baoCao.xuatBaoCao());
                        }
                    }

                }
                case 7 -> {
                    System.out.println("Chấm điểm báo cáo");
                    System.out.print("Nhập mã báo cáo: ");
                    quanLyBaoCao.chamDiem(CauHinh.sc.nextLine());
                    break;
                }
                case 8 -> {
                    System.out.println("Xem điểm báo cáo");
                    System.out.print("Nhập mã báo cáo: ");
                    quanLyBaoCao.xemDiem(CauHinh.sc.nextLine());
                    break;
                }
                case 9 -> {
                    System.out.println("-----------Tìm kiếm hội đồng-----------");
                    System.out.print("1. Tìm kiếm theo mã hội đồng\n" +
                            "2. Tìm kiếm hội đồng theo ngày làm việc\n" +
                            "3. Tìm kiếm hội đồng theo khoảng ngày\n" +
                            "4. Xuất tất cả hội đồng\n" +
                            "\t\t\t-->\t\t");
                    switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                        case 1 -> {
                            System.out.print("Nhập mã hội đồng: ");
                            try {
                                quanLyBaoCao.timKiemHoiDong(CauHinh.sc.nextLine()).xuatHoiDong();
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 2 -> {
                            System.out.print("Nhập ngày làm việc: ");
                            try {
                                quanLyBaoCao.timKiemHoiDong(LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER))).forEach(hoiDong -> hoiDong.xuatHoiDong());
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 3 -> {
                            System.out.print("Nhập khoảng thời gian: ");
                            System.out.print("Ngày 1: ");
                            LocalDate date1 = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER));
                            System.out.print("Ngày 2: ");
                            LocalDate date2 = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER));
                            try {
                                quanLyBaoCao.timKiemHoiDong(date1,date2).forEach(HoiDong::xuatHoiDong);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 4 -> {
                            System.out.println("__Các hội đồng hiện có__");
                            try {
                                quanLyBaoCao.timKiemHoiDong().forEach(hoiDong -> hoiDong.xuatHoiDong());
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                case 0 -> flagExit = false;
            }
        }
    }
}