import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaoCao {
    protected String maBaoCao;
    protected String tenBaoCao;
    private String chuoiLink;
    private LocalDate ngayBaoCao;
    private GiangVien giangVienHuongDan;
    private List<SinhVien> sinhViens = new ArrayList<>();
    protected double diem;

    public BaoCao() {
    }

    public BaoCao(String tenBaoCao, String chuoiLink, LocalDate ngayBaoCao, GiangVien giangVienHuongDan,
                  SinhVien... sinhViens) {
        this.tenBaoCao = tenBaoCao;
        this.chuoiLink = chuoiLink;
        this.ngayBaoCao = ngayBaoCao;
        this.giangVienHuongDan = giangVienHuongDan;
        this.sinhViens.addAll(Arrays.asList(sinhViens));
    }

    public void nhapBaoCao(GiangVien giangVien, SinhVien... sinhViens) {
        System.out.print("Nhập tên báo cáo: ");
        this.tenBaoCao = CauHinh.sc.nextLine();
        System.out.print("Nhập chuỗi link: ");
        this.chuoiLink = CauHinh.sc.nextLine();
        System.out.print("Nhập ngày báo cáo: ");
        this.ngayBaoCao = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER));

        this.giangVienHuongDan = giangVien;
        if (sinhViens.length <= CauHinh.SO_SINH_VIEN_TOI_DA_LAM_BAO_CAO) {
            this.sinhViens.addAll(Arrays.asList(sinhViens));
        }
    }

    public void xuatBaoCao() {
        System.out.printf("""
                _________________________________________________
                Mã báo cáo: %s
                Tên báo cáo: %s
                Chuỗi Link: %s
                Tên giảng viên hướng dẫn: %s
                Sinh viên thực hiện: 
                %sNgày báo cáo: %s
                """,
                maBaoCao,
                tenBaoCao,
                chuoiLink,
                giangVienHuongDan.getHoTen(),
                getDanhSachTen(sinhViens),

                ngayBaoCao.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)));
    }

    public String getDanhSachTen(List<SinhVien> sinhViens) {
        StringBuilder s = new StringBuilder();
        for (SinhVien sinhVien : sinhViens) {
            s.append("- ".concat(sinhVien.getHoTen().concat("\n")));
        }
        return s.toString();
    }

    public abstract void xemDiem();

    public abstract void chamDiem();
    public abstract void suaDiem();

    // Getter and Setter
    public String getMaBaoCao() {
        return maBaoCao;
    }

    public void setMaBaoCao(String maBaoCao) {
        this.maBaoCao = maBaoCao;
    }

    public String getTenBaoCao() {
        return tenBaoCao;
    }

    public void setTenBaoCao(String tenBaoCao) {
        this.tenBaoCao = tenBaoCao;
    }

    public String getChuoiLink() {
        return chuoiLink;
    }

    public void setChuoiLink(String chuoiLink) {
        this.chuoiLink = chuoiLink;
    }

    public LocalDate getNgayBaoCao() {
        return ngayBaoCao;
    }

    public void setNgayBaoCao(LocalDate ngayBaoCao) {
        this.ngayBaoCao = ngayBaoCao;
    }

    public GiangVien getGiangVienHuongDan() {
        return giangVienHuongDan;
    }

    public void setGiangVienHuongDan(GiangVien giangVienHuongDan) {
        this.giangVienHuongDan = giangVienHuongDan;
    }

    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public void setSinhViens(List<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public  void themSinhVien(SinhVien sinhVien)
    {
        if(sinhViens.size()<=1){
            sinhViens.add(sinhVien);
        }
    }

    public void xoaSinhVien(SinhVien sinhVien){
        sinhViens.remove(sinhVien);
    }



    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
