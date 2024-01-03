public class GiangVien {
    private String maGiangVien;
    private String hoTen;
    private String hocHam;
    private String hocVi;

    public GiangVien() {
    }

    public GiangVien(String maGiangVien, String hoTen, String hocHam, String hocVi) {
        this.maGiangVien = maGiangVien;
        this.hoTen = hoTen;
        this.hocHam = hocHam;
        this.hocVi = hocVi;
    }

    public GiangVien(String[] data) {
        this(data[0], data[1], data[2], data[3]);
    }

    public void xuatGiangVien() {
        System.out.printf(
                "Mã giảng viên: %s\nHọ và tên: %s\nHọc hàm: %s\nHọc vị: %s\n",
                this.maGiangVien, this.hoTen,
                this.hocHam, this.hocVi);
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

}
