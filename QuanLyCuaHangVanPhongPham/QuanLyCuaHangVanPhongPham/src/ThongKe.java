import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ThongKe {
	private int n;
	private NhanVien[] dsnv = new NhanVien[n];
	public ThongKe() {
		// TODO Auto-generated constructor stub
	}
	public void docDSNV() {
		// TODO Auto-generated method stub
		try {
			FileReader fr=new FileReader("DSNV.txt");
			BufferedReader br = new BufferedReader(fr);
			String st;
			int count=0;
	        while(true) {
	        	st = br.readLine();
	        	if (st == null) {
	        		break;
	        	} else {
	        		count++;
	        		String s[] = st.split(";");
	        		dsnv=Arrays.copyOf(dsnv, count);
	        		String id = s[0];
	        		String ten = s[1];
	        		String tuoi = s[2];
	        		String sdt = s[3];
	        		float gioLam = Float.parseFloat(s[4]);
	        		float luong = Float.parseFloat(s[5]);
	        		dsnv[dsnv.length-1] = new NhanVien(id, ten, tuoi, sdt, gioLam, luong);
	        	}
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi");
		}
	}
	public float tienThueNhanVien() {
		docDSNV();
		float sum = 0;
		for (int i = 0; i < dsnv.length; i++) {
			sum+=dsnv[i].luong;
		}
		return sum;
	}
	
	public float tongDoanhThu() {
		float sum = 0;
		try {
			FileReader fr=new FileReader("ghiHD.txt");
			BufferedReader br = new BufferedReader(fr);
			String st;
			int count=0;
	        while(true) {
	        	st = br.readLine();
	        	if (st == null) {
	        		break;
	        	} else {
	        		count++;
	        		String s[] = st.split(";");
	        		sum += Float.parseFloat(s[4]);
	        	}
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi");
		}
		return sum;
	}
	
	public float tongChiPhiNhapHang() {
		float sum = 0;
		try {
			FileReader fr=new FileReader("DSNH.txt");
			BufferedReader br = new BufferedReader(fr);
			String st;
			int count=0;
			String maSanPham, tenSanPham, tenThuongHieu, moTaSanPham;
			float donGia;
			int soLuongTrongKho;
	        while(true) {
	        	st = br.readLine();
	        	if (st == null) {
	        		break;
	        	} else {
	        		count++;
	        		String s[] = st.split(";");
	        		donGia = Float.parseFloat(s[4]);
	        		soLuongTrongKho = Integer.parseInt(s[5]);
	        		sum+=donGia*soLuongTrongKho;
	        	}
	        }
	        fr.close();
	        br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi đọc");
		}
		return sum;
	}
	public float tongThueNhapHang() {
		float sum = 0;
		try {
			FileReader fr=new FileReader("DSNH.txt");
			BufferedReader br = new BufferedReader(fr);
			String st;
			int count=0;
			float thue;
	        while(true) {
	        	st = br.readLine();
	        	if (st == null) {
	        		break;
	        	} else {
	        		count++;
	        		String s[] = st.split(";");
	        		thue = Float.parseFloat(s[7]);
	        		sum+=thue;
	        	}
	        }
	        fr.close();
	        br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return sum;
	}
	public static void main(String[] args) {
		ThongKe t = new ThongKe();
		System.out.println("Tiền thuê nhân viên là: " + t.tongThueNhapHang());
	}
}
