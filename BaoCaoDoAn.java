import java.time.LocalDate;

public class BaoCaoDoAn extends BaoCao{
    private static int soLuongBaoCaoDoAn;
    private double tyLeDaoVan;
    public BaoCaoDoAn(){
        this.maBaoCao="DA".concat(String.format("%03d",soLuongBaoCaoDoAn++));
    }
    public BaoCaoDoAn(String tenBaoCao, String chuoiLink,LocalDate ngayBaoCao, GiangVien giangVienHuongDan, SinhVien...sinhViens){
        super(tenBaoCao,chuoiLink,ngayBaoCao,giangVienHuongDan,sinhViens);
        this.maBaoCao="DA".concat(String.format("%03d",soLuongBaoCaoDoAn++));
    }

    @Override
    public void chamDiem() {
        this.tyLeDaoVan=CauHinh.turnitin();
        System.out.printf("Báo cáo đồ án: %s\n",this.getTenBaoCao());
        System.out.print("Nhập điểm: ");
        this.diem=Double.parseDouble(CauHinh.sc.nextLine());
    }

    @Override
    public void xemDiem() {
        this.xuatBaoCao();
        System.out.printf("Tỷ lệ đạo văn: %.2f",this.tyLeDaoVan);
    }
}
