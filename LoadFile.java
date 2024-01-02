import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadFile {
    private static List<SinhVien> sinhVienList=new ArrayList<>();
    private static List<GiangVien>giangVienList=new ArrayList<>();
    public static List<SinhVien> docFileSinhVien(String path) throws FileNotFoundException {
        List<SinhVien> sinhViens=new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            sinhViens.add(new SinhVien(scanner.nextLine().split("-")));
        }
        return sinhViens;
    }
    public static List<GiangVien> docFileGiangVien(String path) throws FileNotFoundException {
        List<GiangVien> giangViens=new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            giangViens.add(new GiangVien(scanner.nextLine().split("-")));
        }
        return giangViens;
    }
}
