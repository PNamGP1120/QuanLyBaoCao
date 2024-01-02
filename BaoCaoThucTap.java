import java.time.LocalDate;

public class BaoCaoThucTap extends BaoCao{
    private static int soLuongBaoCaoThucTap;

    private String danhGiaCuaDoanhNghiep;
    public BaoCaoThucTap(){
        this.maBaoCao="TT".concat(String.format("%03d",soLuongBaoCaoThucTap++));
    }
    public BaoCaoThucTap(String tenBaoCao, String chuoiLink, LocalDate ngayBaoCao, GiangVien giangVienHuongDan, SinhVien...sinhViens){
        super(tenBaoCao,chuoiLink,ngayBaoCao,giangVienHuongDan,sinhViens);
        this.maBaoCao="TT".concat(String.format("%03d",soLuongBaoCaoThucTap++));
    }

    @Override
    public void chamDiem() {
        System.out.printf("Báo cáo thực tập: %s\n",this.getTenBaoCao());
        System.out.print("Nhập điểm: ");
        this.diem=Double.parseDouble(CauHinh.sc.nextLine());
        System.out.print("Đánh giá của doanh nghiệp: ");
        this.danhGiaCuaDoanhNghiep=CauHinh.sc.nextLine();
    }

    @Override
    public void xemDiem() {
        this.xuatBaoCao();
        System.out.printf("Đánh giá của doanh nghiệp: %s",this.danhGiaCuaDoanhNghiep);
    }

}
