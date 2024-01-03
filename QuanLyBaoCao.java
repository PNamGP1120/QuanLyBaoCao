import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;

public class QuanLyBaoCao {
    private List<BaoCao> baoCaoList = new ArrayList<>();

    public void themBaoCao(BaoCao... baoCaos) {
        baoCaoList.addAll(Arrays.asList(baoCaos));
    }

    public void dangKyBaoCao(String classPate, GiangVien giangVien, SinhVien... sinhViens)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Class c = Class.forName(classPate);
        BaoCao baoCao = (BaoCao) c.getConstructor().newInstance();
        baoCao.nhapBaoCao(giangVien, sinhViens);
        baoCaoList.add(baoCao);
    }

    public void xoaBaoCao(String maBaoCao) {
        baoCaoList.removeIf(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao));
    }

    //Sửa tên báo cáo, Sửa giảng viên hướng dẫn, Sửa sinh viên, Sửa ngày báo cáo, Sửa điểm báo cáo, Sửa link báo cáo
    public void suaBaoCao(BaoCao baoCao, String string, int flag) {
        switch (flag) {
            case 1 -> baoCao.setTenBaoCao(string);
            case 2 -> baoCao.setChuoiLink(string);
        }
    }

    public void suaBaoCao(BaoCao baoCao, LocalDate ngay) {
        baoCao.setNgayBaoCao(ngay);
    }

    public void suaBaoCao(BaoCao baoCao, GiangVien gv) {
        baoCao.setGiangVienHuongDan(gv);
    }

    public void suaBaoCao(BaoCao baoCao, SinhVien sv, int flag) {
        if (flag == 1) {
            baoCao.themSinhVien(sv);
        } else if (flag == 2) {
            baoCao.xoaSinhVien(sv);
        }
    }

    public void suaDiem(BaoCao baoCao) {
        baoCao.suaDiem();
    }

    public void xemDanhSach(String classPate) throws ClassNotFoundException {
        locBaoCao(classPate).forEach(BaoCao::xuatBaoCao);
    }

    public void chamDiem(String maBaoCao) {
        this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao)).findFirst().get().chamDiem();
    }

    public void xemDiem(String maBaoCao) {
        this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoCao)).findFirst().get().xemDiem();
    }

    public BaoCao timKiem(String maBaoBao) {
        return this.baoCaoList.stream().filter(baoCao -> baoCao.getMaBaoCao().equals(maBaoBao)).findFirst().get();
    }

    public List<BaoCao> timKiem(LocalDate date) {
        return this.baoCaoList.stream().filter(baoCao -> {
            return date.equals(baoCao.getNgayBaoCao());
        }).toList();
    }

    public List<BaoCao> timKiem(LocalDate date1, LocalDate date2) {
        return this.baoCaoList.stream().filter(baoCao -> {
            return date1.isBefore(baoCao.getNgayBaoCao()) && date2.isAfter(baoCao.getNgayBaoCao());
        }).toList();
    }

    public List<BaoCao> locBaoCao(String classPate) throws ClassNotFoundException {
        Class c = Class.forName(classPate);
        return this.baoCaoList.stream().filter(c::isInstance).toList();
    }

    public HoiDong timKiemHoiDong(LocalDate date) throws ClassNotFoundException {
        String classPate = "KhoaLuanTotNghiep";
        Class c = Class.forName(classPate);
        List<BaoCaoKhoaLuan> baoCaoKhoaLuans = (List<BaoCaoKhoaLuan>) this.baoCaoList.stream().filter(c::isInstance);
        return baoCaoKhoaLuans.stream()
                .filter(baoCaoKhoaLuan -> baoCaoKhoaLuan.getHoiDong().getNgayLamViec().equals(date)).findFirst().get()
                .getHoiDong();
    }

    public List<BaoCaoKhoaLuan> timKiemHoiDong(LocalDate date1, LocalDate date2) throws ClassNotFoundException {
        String classPate = "KhoaLuanTotNghiep";
        Class c = Class.forName(classPate);
        List<BaoCaoKhoaLuan> baoCaoKhoaLuans = (List<BaoCaoKhoaLuan>) this.baoCaoList.stream().filter(c::isInstance);
        return baoCaoKhoaLuans.stream().filter(baoCaoKhoaLuan -> {
            return date1.isBefore(baoCaoKhoaLuan.getNgayBaoCao()) && date2.isAfter(baoCaoKhoaLuan.getNgayBaoCao());
        }).toList();
    }


    public void sortBaoCaos(int pthucSort) {
        switch (pthucSort) {
            case 1 -> baoCaoList.sort(Comparator.comparing(BaoCao::getNgayBaoCao));
            case 2 -> baoCaoList.sort(Comparator.comparing(BaoCao::getTenBaoCao));
        }

    }
}
