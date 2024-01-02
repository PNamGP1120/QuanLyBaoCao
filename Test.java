import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        BaoCaoKhoaLuan baoCaoKhoaLuan=new BaoCaoKhoaLuan();
        baoCaoKhoaLuan.nhapBaoCao(new GiangVien("GV1-GiangVien1-HH1-HV1".split("-")),new SinhVien("2251052069-SinhVien9-2023-true-02/12/2004-IT".split("-")));
        System.out.print( baoCaoKhoaLuan.tinhTrungBinh());
    }
}
