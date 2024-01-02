import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;

public class QuanLyBaoCao {
    private List<BaoCao> baoCaoList=new ArrayList<>();
    public void themBaoCao(BaoCao...baoCaos){
        baoCaoList.addAll(Arrays.asList(baoCaos));
    }
    public void dangKyBaoCao(String classPate, GiangVien giangVien, SinhVien...sinhViens) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c=Class.forName(classPate);
        BaoCao baoCao=(BaoCao) c.getConstructor().newInstance();
        baoCao.nhapBaoCao(giangVien,sinhViens);
        baoCaoList.add(baoCao);
    }
    public void xoaBaoCao(String maBaoCao){
        baoCaoList.removeIf(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao));
    }
    public void suaBaoCao(){

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
    public BaoCao timKiem(String maBaoBao){
        return this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoBao)).findFirst().get();
    }
    public List<BaoCao> timKiem(LocalDate date1,LocalDate date2){
        return this.baoCaoList.stream().filter(baoCao -> {
            return date1.isBefore(baoCao.ngayBaoCao) && date2.isAfter(baoCao.ngayBaoCao);
        }).toList();
    }
    public HoiDong timKiemHoiDong(LocalDate date) throws ClassNotFoundException {
        String classPate="KhoaLuanTotNghiep";
        Class c=Class.forName(classPate);
        List<BaoCaoKhoaLuan> baoCaoKhoaLuans = (List<BaoCaoKhoaLuan>) this.baoCaoList.stream().filter(c::isInstance);
        return baoCaoKhoaLuans.stream().filter(baoCaoKhoaLuan -> baoCaoKhoaLuan.getHoiDong().getNgayLamViec().equals(date)).findFirst().get().getHoiDong();
    }
    public List<BaoCaoKhoaLuan> timKiemHoiDong(LocalDate date1, LocalDate date2) throws ClassNotFoundException {
        String classPate="KhoaLuanTotNghiep";
        Class c=Class.forName(classPate);
        List<BaoCaoKhoaLuan> baoCaoKhoaLuans = (List<BaoCaoKhoaLuan>) this.baoCaoList.stream().filter(c::isInstance);
        return baoCaoKhoaLuans.stream().filter(baoCaoKhoaLuan -> {
            return date1.isBefore(baoCaoKhoaLuan.ngayBaoCao) && date2.isAfter(baoCaoKhoaLuan.ngayBaoCao);
        }).toList();
    }

}
