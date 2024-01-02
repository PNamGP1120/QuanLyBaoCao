//import java.io.FileNotFoundException;
//import java.lang.reflect.InvocationTargetException;
//import java.time.LocalDate;
//import java.time.Year;
//import java.time.format.DateTimeFormatter;
//
//public class Main {
//    public static void main(String[] args) throws RuntimeException {
//        QuanLyBaoCao quanLyBaoCao=new QuanLyBaoCao();
//        try {
//            quanLyBaoCao.loadFileSinhVien("src\\Data\\SinhVien.txt");
//            quanLyBaoCao.loadFileGiangVien("src\\Data\\GiangVien.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
////        try {
////            quanLyBaoCao.dangKyBaoCao("BaoCao","2251052069","2251052065");
////        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
////                 IllegalAccessException e) {
////            throw new RuntimeException(e);
////        }
//
//        quanLyBaoCao.hienThiSinhVien();
////        GiangVien giangVien=new GiangVien("a","a","a","a");
////        BaoCao baoCao=new BaoCao();
////        baoCao.nhapBaoCao(giangVien);
////        baoCao.xuatBaoCao();
//
//
//    }
//}