import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void menu(){
        System.out.print(
                """
                        MENU
                ---------------------------        
                1. Đăng ký Báo cáo
                2. Xóa Báo cáo
                3. Sửa Báo cáo
                4. Xem danh sách báo cáo theo loại
                5. Sắp xếp Báo cáo
                6. Tìm kiếm Báo cáo
                7. Chấm điểm Báo cáo
                8. Xem điểm Báo cáo
                0. Thoát chương trình
                ---------------------------
                -->\t\t""");
    }
    public static void menuLoaiBaoCao(){
        System.out.print("""
                            \t\t\t1. Báo cáo thực tập
                            \t\t\t2. Báo cáo đồ án ngành
                            \t\t\t3. Báo cáo khóa luận tốt nghiệp
                            \t\t\t3. Báo cáo
                            \t\t\t-->\t\t""");
    }
    private static List<SinhVien> sinhVienList=new ArrayList<>();
    private static List<GiangVien>giangVienList=new ArrayList<>();
    private static final QuanLyBaoCao quanLyBaoCao=new QuanLyBaoCao();
    static {
        try {
            sinhVienList=LoadFile.docFileSinhVien("src\\Data\\SinhVien.txt");
            giangVienList=LoadFile.docFileGiangVien("src\\Data\\GiangVien.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static SinhVien timSinhVien(String mSSV){
        return sinhVienList.stream().filter(sinhVien -> sinhVien.getmSSV().equals(mSSV)).findFirst().get();
    }
    public static GiangVien timGiangVien(String maGiangVien){
        return giangVienList.stream().filter(giangVien -> giangVien.getMaGiangVien().equals(maGiangVien)).findFirst().get();
    }
    public static void main(String[] args) {
        quanLyBaoCao.themBaoCao(new BaoCaoDoAn("Đồ án 1","D:\\DoAn", LocalDate.parse("12/12/2024", DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),timGiangVien("GV1"),timSinhVien("2")));
        quanLyBaoCao.themBaoCao(new BaoCaoThucTap("Thực tập 1","D:\\ThucTap", LocalDate.parse("10/12/2024", DateTimeFormatter.ofPattern(CauHinh.DATE_FORMATTER)),timGiangVien("GV2"),timSinhVien("2251052068"),timSinhVien("2251052067")));
//        quanLyBaoCao.themBaoCao(new BaoCaoKhoaLuan("Khóa luận 1","D:\\KhoaLuan",));
        boolean flagExit=true;
        while (flagExit){
            menu();
            switch (Integer.parseInt(CauHinh.sc.nextLine())){
                case 1:{
                    System.out.println("Chọn loại báo cáo nào: ");
                    menuLoaiBaoCao();
                    int flagDangKy=Integer.parseInt(CauHinh.sc.nextLine()) ;
                    System.out.print("Nhập số lượng sinh viên thực hiện (1/2): ");
                    int soLuongSinhVienTYhucHien=Integer.parseInt(CauHinh.sc.nextLine());

                    SinhVien[]sinhViens=new SinhVien[soLuongSinhVienTYhucHien];
                    for (int i=0;i<soLuongSinhVienTYhucHien;i++){
                        System.out.print("Nhập MSSV thứ "+(i+1)+": ");
                        sinhViens[i]=timSinhVien(CauHinh.sc.nextLine());
                    }

                    System.out.print("Nhập mã giảng viên hướng dẫn: ");
                    GiangVien giangVien=timGiangVien(CauHinh.sc.nextLine());
                    try {
                        if(flagDangKy==1){
                            quanLyBaoCao.dangKyBaoCao("BaoCaoThucTap",giangVien,sinhViens);
                        } else if (flagDangKy==2) {
                            quanLyBaoCao.dangKyBaoCao("BaoCaoDoAn",giangVien,sinhViens);
                        } else if (flagDangKy==3){
                            quanLyBaoCao.dangKyBaoCao("BaoCaoKhoaLuan",giangVien,sinhViens);

                        }
                        break;
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2:{
                    System.out.print("Nhập mã báo cáo cần xóa: ");
                    quanLyBaoCao.xoaBaoCao(CauHinh.sc.nextLine());
                    System.out.println("Đã xóa thành công!");
                    break;
                }
                case 4:{
                    menuLoaiBaoCao();
                    int flagDanhSach=Integer.parseInt(CauHinh.sc.nextLine()) ;
                    try {
                        if(flagDanhSach==1){
                            quanLyBaoCao.xemDanhSach("BaoCaoThucTap");
                        } else if (flagDanhSach==2) {
                            quanLyBaoCao.xemDanhSach("BaoCaoDoAn");
                        } else if (flagDanhSach==3){
                            quanLyBaoCao.xemDanhSach("BaoCaoKhoaLuan");

                        } else if (flagDanhSach==4) {
                            quanLyBaoCao.xemDanhSach("BaoCao");
                        }
                        break;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 7:{
                    System.out.println("Chấm điểm báo cáo");
                    System.out.print("Nhập mã báo cáo: ");
                    quanLyBaoCao.chamDiem(CauHinh.sc.nextLine());
                    break;
                }
                case 8:{
                    System.out.println("Xem điểm báo cáo");
                    System.out.print("Nhập mã báo cáo: ");
                    quanLyBaoCao.xemDiem(CauHinh.sc.nextLine());
                    break;
                }
                case 0:
                default:
                    flagExit=false;
            }
        }
    }
}