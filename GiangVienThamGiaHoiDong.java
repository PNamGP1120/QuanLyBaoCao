public class GiangVienThamGiaHoiDong {
    private HoiDong hoiDong;
    private GiangVien giangVien;
    private NhiemVu nhiemVu;
    private double diem;
    private String nhanXet;
    public GiangVienThamGiaHoiDong(HoiDong hoiDong, GiangVien giangVien, NhiemVu nhiemVu){
        this.hoiDong=hoiDong;
        this.giangVien=giangVien;
        this.nhiemVu=nhiemVu;
    }
    public void xuatNhiemVuGiangVienTrongHoiDong(){
        System.out.printf("Mã hội đồng: %s\n",this.hoiDong.getMaHoiDong());
        System.out.printf("Họ và tên giảng viên: %s\n",this.giangVien.getHoTen());
        System.out.printf("Nhiệm vụ: %s\n",this.nhiemVu);
    }
    public void chamDiem(){
        System.out.printf("Họ và tên giảng viên: %s\n",this.giangVien.getHoTen());
        System.out.printf("Nhiệm vụ: %s\n",this.nhiemVu);
        System.out.print("Nhập điểm: ");
        this.diem= Double.parseDouble(CauHinh.sc.nextLine());
        System.out.print("Nhận xét: ");
        this.nhanXet=CauHinh.sc.nextLine();
    }
    public void xemDiem(){
        System.out.printf("Họ và tên giảng viên: %s\n",this.giangVien.getHoTen());
        System.out.printf("Nhiệm vụ: %s\n",this.nhiemVu);
        System.out.printf("Điểm: %.2f\n",this.diem);
        System.out.printf("Nhận xét: %s\n",this.nhanXet);
    }

    //setter and getter
    public HoiDong getHoiDong() {
        return hoiDong;
    }

    public void setHoiDong(HoiDong hoiDong) {
        this.hoiDong = hoiDong;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public NhiemVu getNhiemVu() {
        return nhiemVu;
    }

    public void setNhiemVu(NhiemVu nhiemVu) {
        this.nhiemVu = nhiemVu;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }


}
