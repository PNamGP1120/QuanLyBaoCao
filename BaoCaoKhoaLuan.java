import java.time.LocalDate;

public class BaoCaoKhoaLuan extends BaoCao{
    private static int soLuongBaoCaoKhoaLuan;
    private double tyLeDaoVan;
    private HoiDong hoiDong;
    public BaoCaoKhoaLuan(){
        this.maBaoCao="KL".concat(String.format("%03d",soLuongBaoCaoKhoaLuan++));
    }
    public BaoCaoKhoaLuan(String tenBaoCao, String chuoiLink, LocalDate ngayBaoCao, GiangVien giangVienHuongDan, SinhVien...sinhViens){
        super(tenBaoCao,chuoiLink,ngayBaoCao,giangVienHuongDan,sinhViens);
        this.maBaoCao="KL".concat(String.format("%03d",soLuongBaoCaoKhoaLuan++));
    }

    @Override
    public void chamDiem() {

    }

    @Override
    public void xemDiem() {

    }
}
