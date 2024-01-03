import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    private static List<SinhVien>sinhViens=new ArrayList<>();
    private static List<GiangVien>giangViens=new ArrayList<>();
    private static QuanLyBaoCao quanLyBaoCao=new QuanLyBaoCao();
    static {
        try {
            sinhViens=LoadFile.docFileSinhVien("src\\Data\\SinhVien.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            giangViens=LoadFile.docFileGiangVien("src\\Data\\GiangVien.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static SinhVien timSinhVien(String mSSV) {
        return sinhViens.stream().filter(sinhVien -> sinhVien.getmSSV().equals(mSSV)).findFirst().get();
    }


    public static void main(String[] args) {
        sinhViens.forEach(sinhVien -> sinhVien.xuatSinhVien());
        timSinhVien("SV12").xuatSinhVien();

//        SinhVien sinhVien=new SinhVien("22","Nam", Year.of(Integer.parseInt("2004")),true, LocalDate.parse("02/12/2004",DateTimeFormatter.ofPattern("dd/MM/yyyy")),ChuyenNganh.IT);
//        SinhVien sinhVien=new SinhVien("22-Nam-2004-true-02/12/2004-IT".split("-"));
//        sinhVien.xuatSinhVien();
//        BaoCao baoCao=new BaoCaoDoAn("BC1","Báo cáo 1","D:\\",LocalDate.now(),new GiangVien("a","Thanh","HH1","HH2"));
//        baoCao.chamDiem();
//        baoCao.xemDiem();
//        BaoCao baoCao=new BaoCaoThucTap("BC1","Báo cáo 1","D:\\",LocalDate.now(),new GiangVien("a","Thanh","HH1","HH2"));
//        baoCao.chamDiem();
//        baoCao.xemDiem();
//        NhiemVu nhiemVu=NhiemVu.CHU_TICH;
//        System.out.print(nhiemVu.toString().equals("CHU_TICH"));
//        HoiDong hoiDong=new HoiDong("111",LocalDate.now().plusDays(25),new GiangVien("1","d","d","d"),new GiangVien("1","d","d","d"),new GiangVien("1","d","d","d"));
//        hoiDong.chamDiem();
//        hoiDong.xemDiem();



//        sinhViens.forEach(SinhVien::xuatSinhVien);
//        giangViens.forEach(GiangVien::xuatGiangVien);
//        try {
//            quanLyBaoCao.themBaoCao("BaoCaoDoAn", giangViens.get(0),sinhViens.get(0), sinhViens.get(1));
//            quanLyBaoCao.themBaoCao("BaoCaoThucTap",giangViens.get(0),sinhViens.get(3),sinhViens.get(4));
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            quanLyBaoCao.xemDanhSach("BaoCaoDoAn");
//            quanLyBaoCao.xemDanhSach("BaoCaoThucTap");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        quanLyBaoCao.chamDiem("DA000");
//        quanLyBaoCao.xemDiem("DA000");

    }
}
