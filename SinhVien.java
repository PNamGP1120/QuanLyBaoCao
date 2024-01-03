import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class SinhVien {
    private String mSSV;
    private String hoTen;
    private Year khoaHoc;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private ChuyenNganh chuyenNganh;

    /**
     * constructor
     *
     * @param mSSV
     * @param hoTen
     * @param khoaHoc
     * @param gioiTinh
     * @param ngaySinh
     * @param chuyenNganh
     */
    public SinhVien(
            String mSSV,
            String hoTen,
            Year khoaHoc,
            Boolean gioiTinh,
            LocalDate ngaySinh,
            ChuyenNganh chuyenNganh) {
        this.mSSV = mSSV;
        this.hoTen = hoTen;
        this.khoaHoc = khoaHoc;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.chuyenNganh = chuyenNganh;
    }

    /**
     * Constructor add 1 line data from a file
     *
     * @param String[] data
     */
    public SinhVien(String[] data) {
        this(
                data[0],
                data[1],
                Year.of(Integer.parseInt(data[2])),
                Boolean.parseBoolean(data[3]),
                LocalDate.parse(data[4], DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                ChuyenNganh.valueOf(data[5]));
    }

    /**
     * Hiển thị sinh viên theo định dạng sau
     *
     * MSSV: %s
     * Họ và tên: %s
     * Khóa học: %s
     * Giới tính: %s
     * Ngày sinh: %s
     * Chuyên ngành: %s
     */
    public void xuatSinhVien() {
        System.out.printf("""
                MSSV: %s\n
                Họ và tên: %s\n
                Khóa học: %s\n
                Giới tính: %s\n
                Ngày sinh: %s\n
                Chuyên ngành: %s\n
                """,
                this.mSSV,
                this.hoTen,
                this.khoaHoc.format(DateTimeFormatter.ofPattern(CauHinh.YEAR_FORMATTER)),
                CauHinh.getGioiTinh(this.gioiTinh),
                this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),
                this.chuyenNganh);
    }

    /**
     * @return MSSV
     */
    public String getmSSV() {
        return mSSV;
    }

    /**
     * @param MSSV
     */
    public void setmSSV(String mSSV) {
        this.mSSV = mSSV;
    }

    /**
     * @return Họ và tên sinh viên
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return khóa học của sinh viên
     */
    public Year getKhoaHoc() {
        return khoaHoc;
    }

    /**
     * @param khoaHoc
     */
    public void setKhoaHoc(Year khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    /**
     * @return giới tính của sinh viên
     */
    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh
     */
    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return ngày sinh của sinh viên
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return chuyên ngành của sinh viên
     */
    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    /**
     * @param chuyenNganh
     */
    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

}
