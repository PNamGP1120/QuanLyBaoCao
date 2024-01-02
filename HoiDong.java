import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoiDong implements ThemThanhVien {
    private String maHoiDong;
    private LocalDate ngayLamViec;
    private List<GiangVienThamGiaHoiDong>giangViens=new ArrayList<>();


    public HoiDong(String maHoiDong, LocalDate ngayLamViec, GiangVien...giangViens) {
        this.maHoiDong = maHoiDong;
        this.ngayLamViec = ngayLamViec;
        if(giangViens.length>=3&&giangViens.length<=5){
            List<GiangVien> giangVienList=Arrays.asList(giangViens);
            nhapHoiDong(NhiemVu.CHU_TICH,giangVienList.get(0));
            nhapHoiDong(NhiemVu.THU_KY,giangVienList.get(1));
            nhapHoiDong(NhiemVu.PHAN_BIEN,giangVienList.get(2));

            if(giangViens.length==4){
                nhapHoiDong(NhiemVu.PHAN_BIEN,giangVienList.get(3));
            }
            if(giangViens.length==5){
                nhapHoiDong(NhiemVu.UY_VIEN,giangVienList.get(4));
            }
        }
    }

    @Override
    public void nhapHoiDong(NhiemVu nhiemVu, GiangVien giangVien) {
        giangViens.add(new GiangVienThamGiaHoiDong(this,giangVien,nhiemVu));
    }

    //    @Override
//    public void nhapHoiDong(ChuyenNganh chuyenNganh,GiangVien giangVien) {
//        giangViens.add(new GiangVienThamGiaHoiDong(this,giangVien,NhiemVu.CHU_TICH));
//    }

    public String getMaHoiDong() {
        return maHoiDong;
    }

    public void setMaHoiDong(String maHoiDong) {
        this.maHoiDong = maHoiDong;
    }
    public void chamDiem(){
        this.giangViens.forEach(GiangVienThamGiaHoiDong::chamDiem);
    }
    public void xemDiem(){
        this.giangViens.forEach(GiangVienThamGiaHoiDong::xemDiem);
    }
}
