import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoiDong implements ThemThanhVien {
    private String maHoiDong;

    private LocalDate ngayLamViec;

    private List<GiangVienThamGiaHoiDong> giangViens = new ArrayList<>();
    public HoiDong(String maHoiDong, LocalDate ngayLamViec,List<GiangVien> giangViens){
        this.maHoiDong = maHoiDong;
        this.ngayLamViec = ngayLamViec;
        if(giangViens.size()>=3&&giangViens.size()<=5){
            nhapHoiDong(NhiemVu.CHU_TICH, giangViens.get(0));
            nhapHoiDong(NhiemVu.THU_KY, giangViens.get(1));
            nhapHoiDong(NhiemVu.PHAN_BIEN, giangViens.get(2));
            if(giangViens.size()>=4){
                nhapHoiDong(NhiemVu.UY_VIEN, giangViens.get(3));
                if(giangViens.size()>=5){
                    nhapHoiDong(NhiemVu.THU_KY, giangViens.get(4));
                }
            }

        }
    }

    public HoiDong(String maHoiDong, LocalDate ngayLamViec) {
        this.maHoiDong = maHoiDong;
        this.ngayLamViec = ngayLamViec;

        System.out.print("Nhập số lượng giảng viên trong hội đồng: ");
        int soLuongGiangVien = Integer.parseInt(CauHinh.sc.nextLine());

        while (soLuongGiangVien < 3 || soLuongGiangVien > 5) {
            System.out.println("SL giảng viên trong hội đồng phải >3 và <5!! Vui lòng nhập lại: ");
            soLuongGiangVien = Integer.parseInt(CauHinh.sc.nextLine());
        }

        System.out.print("Nhập mã giảng viên (Chủ tịch): ");
        nhapHoiDong(NhiemVu.CHU_TICH, Main.timGiangVien(CauHinh.sc.nextLine()));
        System.out.print("Nhập mã giảng viên (Thư ký): ");
        nhapHoiDong(NhiemVu.THU_KY, Main.timGiangVien(CauHinh.sc.nextLine()));
        System.out.print("Nhập mã giảng viên (Phản biện): ");
        nhapHoiDong(NhiemVu.PHAN_BIEN, Main.timGiangVien(CauHinh.sc.nextLine()));
        if (soLuongGiangVien > 3) {
            System.out.println("Nhập giảng viên khác");
        }
        for (int i = 0; i < soLuongGiangVien - 3; i++) {
            System.out.printf("Giảng viên thứ %d\n", i + 1);
            System.out.print("Nhập mã giảng viên: ");
            String maGiangVien = CauHinh.sc.nextLine();
            System.out.print("""
                    Chọn nhiệm vụ:
                        1. Thư ký
                        2. Phản biện
                        3. Ủy viên
                            -->\t""");
            int choose = Integer.parseInt(CauHinh.sc.nextLine());

            switch (choose) {
                case 1 -> nhapHoiDong(NhiemVu.THU_KY, Main.timGiangVien(maGiangVien));

                case 2 -> nhapHoiDong(NhiemVu.PHAN_BIEN, Main.timGiangVien(maGiangVien));

                case 3 -> nhapHoiDong(NhiemVu.UY_VIEN, Main.timGiangVien(maGiangVien));
            }

        }
    }

    @Override
    public void nhapHoiDong(NhiemVu nhiemVu, GiangVien giangVien) {
        giangViens.add(new GiangVienThamGiaHoiDong(this, giangVien, nhiemVu));
    }
    public void xuatHoiDong(){
        StringBuilder s=new StringBuilder();
        giangViens.forEach(giangVienThamGiaHoiDong -> {
            s.append(giangVienThamGiaHoiDong.getGiangVien().getHoTen().concat(" - ").concat(giangVienThamGiaHoiDong.getNhiemVu().toString().concat("\n"))) ;
        });
        System.out.printf("""
                Mã hội đồng: %s
                Ngày làm việc: %s
                Thành viên: 
                %s
                """,
                this.maHoiDong,
                this.ngayLamViec.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                s
                );
    }

    public void chamDiem() {
        this.giangViens.forEach(GiangVienThamGiaHoiDong::chamDiem);
    }

    public void xemDiem() {
        this.giangViens.forEach(GiangVienThamGiaHoiDong::xemDiem);
    }

    public void setGiangViens(List<GiangVienThamGiaHoiDong> giangViens) {
        this.giangViens = giangViens;
    }

    public List<GiangVienThamGiaHoiDong> getGiangViens() {
        return giangViens;
    }
    public String getMaHoiDong() {
        return maHoiDong;
    }

    public void setMaHoiDong(String maHoiDong) {
        this.maHoiDong = maHoiDong;
    }

    public LocalDate getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(LocalDate ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }
}
