import java.time.LocalDate;
import java.util.List;

public class BaoCaoKhoaLuan extends BaoCao {
    private static int soLuongBaoCaoKhoaLuan;

    private double tyLeDaoVan;
    private HoiDong hoiDong;

    public BaoCaoKhoaLuan() {
        this.maBaoCao = "KL".concat(String.format("%03d", soLuongBaoCaoKhoaLuan++));

    }

    public BaoCaoKhoaLuan(
            String tenBaoCao,
            String chuoiLink,
            LocalDate ngayBaoCao,
            GiangVien giangVienHuongDan,
            List<GiangVien> giangViens,
            SinhVien... sinhViens) {
        super(
                tenBaoCao,
                chuoiLink,
                ngayBaoCao,
                giangVienHuongDan,
                sinhViens);
        this.maBaoCao = "KL".concat(String.format("%03d", soLuongBaoCaoKhoaLuan++));
        hoiDong=new HoiDong("HD".concat(maBaoCao), getNgayBaoCao(),giangViens);
    }

    public double tinhTrungBinh() {

        for (int i = 0; i < hoiDong.getGiangViens().size(); i++) {
            this.diem += hoiDong.getGiangViens().get(i).getDiem();
        }

        return this.diem / hoiDong.getGiangViens().size();
    }

    @Override
    public void nhapBaoCao(GiangVien giangVien, SinhVien... sinhViens) {
        super.nhapBaoCao(giangVien, sinhViens);
        hoiDong = new HoiDong("HD".concat(maBaoCao), getNgayBaoCao());
    }

    @Override
    public void chamDiem() {
        System.out.printf("Báo cáo khóa luận: %s\n", this.getTenBaoCao());
        this.hoiDong.chamDiem();
        this.diem = tinhTrungBinh();
    }

    @Override
    public void xemDiem() {
        this.xuatBaoCao();
        this.hoiDong.xemDiem();
        System.out.println("_______________________________________________________");
        System.out.printf("Điểm trung bình: %.2f\n", this.diem);
    }

    @Override
    public void suaDiem() {
        hoiDong.xemDiem();
        System.out.print("Mã giảng viên người sửa điểm: ");
        String maGV = CauHinh.sc.nextLine();
        hoiDong.getGiangViens().stream().filter(gv->gv.getGiangVien().getMaGiangVien().equals(maGV)).findFirst().get().chamDiem();
        this.diem = tinhTrungBinh();
    }

    public double getTyLeDaoVan() {
        return tyLeDaoVan;
    }

    public void setTyLeDaoVan(double tyLeDaoVan) {
        this.tyLeDaoVan = tyLeDaoVan;
    }

    public HoiDong getHoiDong() {
        return hoiDong;
    }

    public void setHoiDong(HoiDong hoiDong) {
        this.hoiDong = hoiDong;
    }

}
