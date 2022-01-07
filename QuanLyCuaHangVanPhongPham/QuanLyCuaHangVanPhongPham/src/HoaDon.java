import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HoaDon extends ChiTietHoaDon {
	private int n;
	private SanPham[] dsS = new SanPham[n];
	private SanPham[] dsS1 = new SanPham[n];
	private Scanner sc = new Scanner(System.in);
	private String idHoaDon, idNhanVien, idKhachHang;
	String ngayLapHoaDon;
	private Pattern pattern = Pattern.compile("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)");
	private int soLuongCT;
	private ChiTietHoaDon ds[] = new ChiTietHoaDon[n];
	private float sum = 0;
	
	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}
	
	public String getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public SanPham[] getDsS1() {
		return dsS1;
	}

	public void setDsS1(SanPham[] dsS1) {
		this.dsS1 = dsS1;
	}

	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		while (true) {
			if (pattern.matcher(ngayLapHoaDon).matches()) {
				break;
			} else {
				ngayLapHoaDon = sc.nextLine();
			}
		}
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(String idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getSoLuongCT() {
		return soLuongCT;
	}

	public void setSoLuongCT(int soLuongCT) {
		this.soLuongCT = soLuongCT;
	}

	public void setDs(ChiTietHoaDon[] ds) {
		this.ds = ds;
	}
	
	public void nhapHoaDon() {
		System.out.print("Mời bạn nhập mã hóa đơn: ");
		setIdHoaDon(sc.nextLine());
		System.out.print("Mời bạn nhập mã nhân viên: ");
		setIdNhanVien(sc.nextLine());
		System.out.print("Mời bạn nhập mã khách hàng: ");
		setIdKhachHang(sc.nextLine());
		System.out.print("Mời bạn nhập số lượng chi tiết: ");
		setSoLuongCT(Integer.parseInt(sc.nextLine()));
		setDs(ds= Arrays.copyOf(ds, getSoLuongCT()));
		for (int i = 0; i < ds.length; i++) {
			ds[i] = new ChiTietHoaDon();
			ds[i].nhapCTHD();
			ds[i].setMaHoaDon(getIdHoaDon());
		}
		int count = 0;
		for (int i = 0; i < ds.length - 1; i++) {
			for (int j = i + 1; j < ds.length; j++) {
				if (ds[i].getMaSanPham().compareTo(ds[j].getMaSanPham())==0 && i!=j && ds[i].getSoLuong()!=0) {
					ds[i].setSoLuong(ds[i].getSoLuong()+ds[j].getSoLuong());
					ds[j].setSoLuong(0);
					count++;
				}
			}
		}
		ChiTietHoaDon a = new ChiTietHoaDon();
		for (int i = 0; i < ds.length-1; i++) {
			for (int j = i + 1; j < ds.length; j++) {
				if (ds[i].getSoLuong() < ds[j].getSoLuong()) {
					a = ds[i];
					ds[i] = ds[j];
					ds[j] = a;
				}
			}
		}
		setDs(ds=Arrays.copyOf(ds, ds.length-count));
		setSoLuongCT(ds.length);
		System.out.print("Ngày nhập hóa đơn: ");
		setNgayLapHoaDon(sc.nextLine());
	}
	public void xuatHoaDon() {
		System.out.println("Nhân Viên: ");
		System.out.println("Mã hóa đơn: ");
		System.out.println("Chi tiết hóa đơn: ");
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuatCTHD();
		}
	}
	
	public void xuatConsole() {
		doc();
		float su = 0;
		System.out.print("+");
		for (int i = 0; i < 63; i++) {
			System.out.print("-");
		}
		System.out.println("+");
		System.out.printf("|%-15s|%-15s|%-15s|%-15s|\n", "Mã sản phẩm","Tên sản phẩm", "Đơn Giá", "Số lượng mua");
		System.out.print("+");
		for (int i = 0; i < 63; i++) {
			System.out.print("-");
		}
		System.out.println("+");
		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < dsS.length; j++) {
				if (ds[i].getMaSanPham().compareTo(dsS[j].getMaSanPham())==0) {
					System.out.printf("|%-15s %-15s %-15.2f %-15d|\n", ds[i].getMaSanPham(), dsS[j].getTenSanPham(), dsS[j].getDonGia(), ds[i].getSoLuong());
					su += dsS[j].getDonGia()*ds[i].getSoLuong();
					break;
				}
			}
		}
		System.out.print("+");
		for (int i = 0; i < 63; i++) {
			System.out.print("-");
		}
		System.out.println("+");
		setSum(su);
		System.out.printf("|%-63s|\n","Tổng tiền: " + sum);
		System.out.printf("|%-63s|\n","Mã nhân viên phụ trách: " + getIdNhanVien());
		System.out.printf("|%-63s|\n", "Ngày lập hóa đơn: " + getNgayLapHoaDon());
		System.out.print("+");
		for (int i = 0; i < 63; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	public void tongTienHD() {
		doc();
		float su = 0;
		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < dsS.length; j++) {
				if (ds[i].getMaSanPham().compareTo(dsS[j].getMaSanPham())==0) {
					su += dsS[j].getDonGia()*ds[i].getSoLuong();
					break;
				}
			}
		}
		setSum(su);
	}
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
	public void doc1() {
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
	        		setDsS1(dsS1=Arrays.copyOf(dsS1, count));
	        		maSanPham = s[0];
	        		tenSanPham = s[1];
	        		tenThuongHieu = s[2];
	        		moTaSanPham = s[3];
	        		donGia = Float.parseFloat(s[4]);
	        		soLuongTrongKho = Integer.parseInt(s[5]);
	        		dsS1[dsS1.length-1] = new SanPham(maSanPham, tenSanPham, tenThuongHieu, moTaSanPham, donGia, soLuongTrongKho);
	        	}
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi");
		}
	}
	public void ghiHD() {
		try {
			tongTienHD();
			if (ds.length > 0) {
				FileWriter fw = new FileWriter("ghiHD.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				String s = idHoaDon +";"+ idNhanVien+";"+ idKhachHang+";"+ ngayLapHoaDon+ ";" + sum +";";
				bw.write(s);
			 	bw.newLine();
				bw.close();
				fw.close();
			}
		} catch (Exception e) {
			System.err.println("Lỗi ghi hóa đơn!");
		}
		ghiCTHD();
		ghiSanPham();
	}
	private void ghiSanPham() {
		doc1();
		// TODO Auto-generated method stub
		if (ds.length > 0) {
			for (int i = 0; i < dsS1.length; i++) {
				for (int j = 0; j < ds.length; j++) {
					if (ds[j].getMaSanPham().compareTo(dsS1[i].getMaSanPham())==0) {
						dsS1[i].setSoLuongTrongKho(dsS1[i].getSoLuongTrongKho()-ds[j].getSoLuong());
					}
				}
			}
		}
		try {
			FileWriter fw = new FileWriter("DSSP.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < dsS1.length; i++) {
				bw.write(dsS1[i].toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void ghiCTHD() {
		try {
			if (ds.length > 0) {
				FileWriter fw = new FileWriter("ghiCTHD.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < ds.length; i++) {
					bw.write(ds[i].toString());
					bw.newLine();
				}
				bw.close();
				fw.close();
			}
		} catch (Exception e) {
			System.err.println("Lỗi ghi chi tiết hóa đơn!");
		}
	}
	public static void main(String[] args) {
		HoaDon a = new HoaDon();
		a.nhapHoaDon();
	}
}
