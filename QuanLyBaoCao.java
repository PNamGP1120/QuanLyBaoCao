import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuanLyBaoCao {
    private List<BaoCao> baoCaoList=new ArrayList<>();
    public void themBaoCao(String classPate, GiangVien giangVien, SinhVien...sinhViens) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c=Class.forName(classPate);
        BaoCao baoCao=(BaoCao) c.getConstructor().newInstance();
        baoCao.nhapBaoCao(giangVien,sinhViens);
        baoCaoList.add(baoCao);
    }
    public void xemDanhSach(String classPate) throws ClassNotFoundException {
        Class c=Class.forName(classPate);
        this.baoCaoList.stream().filter(c::isInstance).forEach(BaoCao::xuatBaoCao);
    }

    public void chamDiem(String maBaoCao){
        this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao)).findFirst().get().chamDiem();
    }
    public void xemDiem(String maBaoCao){
        this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao)).findFirst().get().xemDiem();
    }
}
