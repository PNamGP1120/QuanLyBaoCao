import java.util.Scanner;

public class CauHinh {
    public static final Scanner sc = new Scanner(System.in);
    public static final String DATE_FORMATTER = "dd/MM/yyyy";
    public static final String YEAR_FORMATTER = "u";
    public static final int SO_SINH_VIEN_TOI_DA_LAM_BAO_CAO=2;
    public static double turnitin(){
        return Math.random();
    }
    public static String getGioiTinh(boolean gt) {
        if (gt) return "Nam";
        return "Nữ";
    }
}
