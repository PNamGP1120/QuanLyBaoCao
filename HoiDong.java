import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoiDong implements ThemThanhVien {
    private String maHoiDong;

    private LocalDate ngayLamViec;

    public List<GiangVienThamGiaHoiDong> getGiangViens() {
        return giangViens;
    }

    public void setGiangViens(List<GiangVienThamGiaHoiDong> giangViens) {
        this.giangViens = giangViens;
    }

    private List<GiangVienThamGiaHoiDong>giangViens=new ArrayList<>();


    public HoiDong(String maHoiDong, LocalDate ngayLamViec) {
        this.maHoiDong = maHoiDong;
        this.ngayLamViec = ngayLamViec;

        System.out.print("Nhập số lượng giảng viên trong hội đồng: ");
        int soLuongGiangVien=Integer.parseInt(CauHinh.sc.nextLine());

        System.out.print("Nhập mã giảng viên (Chủ tịch): ");
        nhapHoiDong(NhiemVu.CHU_TICH,Main.timGiangVien(CauHinh.sc.nextLine()));
        System.out.print("Nhập mã giảng viên (Thư ký): ");
        nhapHoiDong(NhiemVu.THU_KY,Main.timGiangVien(CauHinh.sc.nextLine()));
        System.out.print("Nhập mã giảng viên (Phản biện): ");
        nhapHoiDong(NhiemVu.PHAN_BIEN,Main.timGiangVien(CauHinh.sc.nextLine()));
        if(soLuongGiangVien>3){
            System.out.println("Nhập giảng viên khác");
        }
        for(int i=0;i<soLuongGiangVien-3;i++){
            System.out.printf("Giảng viên thứ %d\n",i+1);
            System.out.print("Nhập mã giảng viên: ");
            String maGiangVien=CauHinh.sc.nextLine();
            System.out.print("""
                    Chọn nhiệm vụ: 
                        1. Thư ký
                        2. Phản biện
                        3. Ủy viên
                            -->\t""");
            int choose=Integer.parseInt(CauHinh.sc.nextLine());

            if(choose==1){
                nhapHoiDong(NhiemVu.THU_KY,Main.timGiangVien(maGiangVien));
            } else if (choose==2) {
                nhapHoiDong(NhiemVu.PHAN_BIEN,Main.timGiangVien(maGiangVien));
            } else if (choose==3) {
                nhapHoiDong(NhiemVu.UY_VIEN,Main.timGiangVien(maGiangVien));
            }
        }
    }




    @Override
    public void nhapHoiDong(NhiemVu nhiemVu, GiangVien giangVien) {
        giangViens.add(new GiangVienThamGiaHoiDong(this,giangVien,nhiemVu));
    }
    public void chamDiem(){
        this.giangViens.forEach(GiangVienThamGiaHoiDong::chamDiem);
    }
    public void xemDiem(){
        this.giangViens.forEach(GiangVienThamGiaHoiDong::xemDiem);
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
