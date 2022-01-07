import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class ChiTietHoaDon {
	private Scanner sc = new Scanner(System.in);
	private String maHoaDon, maSanPham;
	private int soLuong;
	private String coms;
	private int n;
	private SanPham[] dsS = new SanPham[n];
	public SanPham[] getDsS() {
		return dsS;
	}
	public void setDsS(SanPham[] dsS) {
		this.dsS = dsS;
	}
	public String getComs() {
		return coms;
	}
	public void setComs(String coms) {
		this.coms = coms;
	}
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		int flag = 0, tempt = 0, i = 0;
		while (true) {
			for (i = 0; i < dsS.length; i++) {
				if (maSanPham.compareTo(dsS[i].getMaSanPham())==0) {
					flag = 1;
					break;
				}
				if (dsS[i].getSoLuongTrongKho()==0) {
					tempt = dsS[i].getSoLuongTrongKho();
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				break;
			} else {
				System.out.print("Mã không tồn tại trong kho hoặc hết hàng mời nhập mã khác: ");
				maSanPham = sc.nextLine();
			}
		}
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		int flag = 0, temp = 0, sum = 0;
		while (true) {
			temp = 0;
			for (int i = 0; i < dsS.length; i++) {
				if (maSanPham.compareTo(dsS[i].getMaSanPham())==0) {
					temp = dsS[i].getSoLuongTrongKho();
					flag = 1;
					break;
				}
			}
			sum = temp - soLuong;
			if (flag == 1 && sum < 0) {
				System.out.print("Trong kho còn " + temp + " mời nhập số lượng khác: ");
				soLuong = Integer.parseInt(sc.nextLine());
			} else {
				break;
			}
		}
		this.soLuong = soLuong;
	}
	//Doc san pham vao mang tam dsS
	public void doc() {
		try {
			FileReader fr=new FileReader("DSSP.txt");
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
	        		setDsS(dsS=Arrays.copyOf(dsS, count));
	        		maSanPham = s[0];
	        		tenSanPham = s[1];
	        		tenThuongHieu = s[2];
	        		moTaSanPham = s[3];
	        		donGia = Float.parseFloat(s[4]);
	        		soLuongTrongKho = Integer.parseInt(s[5]);
	        		dsS[dsS.length-1] = new SanPham(maSanPham, tenSanPham, tenThuongHieu, moTaSanPham, donGia, soLuongTrongKho);
	        	}
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi");
		}
	}
	public void nhapCTHD() {
		doc();
		System.out.print("Mời nhập mã sản phẩm: ");
		setMaSanPham(sc.nextLine());
		System.out.print("Mời nhập số lượng: ");
		setSoLuong(Integer.parseInt(sc.nextLine()));
	}
	public void xuatCTHD(){
		System.out.printf("%-15s %-15s\n", maSanPham, soLuong);
	}
	public String toString() {
		return maHoaDon+";"+maSanPham +";"+ soLuong+";";
	}
}
