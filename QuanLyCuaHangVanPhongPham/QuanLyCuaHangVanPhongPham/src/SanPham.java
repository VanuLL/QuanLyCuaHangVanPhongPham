import java.util.Scanner;

public class SanPham extends ThueSanPham {
	Scanner sc = new Scanner(System.in);
	private String maSanPham, tenSanPham, tenThuongHieu, moTaSanPham;
	private float donGia;
	private int soLuongTrongKho;
	private String coms;
	

	public String getComs() {
		return coms;
	}


	public void setComs(String coms) {
		this.coms = coms;
	}


	public SanPham() {
		super();
	}


	public SanPham(String maSanPham, String tenSanPham, String tenThuongHieu, String moTaSanPham, float donGia,
			int soLuongTrongKho) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tenThuongHieu = tenThuongHieu;
		this.moTaSanPham = moTaSanPham;
		this.donGia = donGia;
		this.soLuongTrongKho = soLuongTrongKho;
	}


	public String getMaSanPham() {
		return maSanPham;
	}


	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}


	public String getTenSanPham() {
		return tenSanPham;
	}


	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}


	public String getTenThuongHieu() {
		return tenThuongHieu;
	}


	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}


	public String getMoTaSanPham() {
		return moTaSanPham;
	}


	public void setMoTaSanPham(String moTaSanPham) {
		this.moTaSanPham = moTaSanPham;
	}


	public float getDonGia() {
		return donGia;
	}


	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}


	public int getSoLuongTrongKho() {
		return soLuongTrongKho;
	}


	public void setSoLuongTrongKho(int soLuongTrongKho) {
		this.soLuongTrongKho = soLuongTrongKho;
	}

	public void nhapSanPham() {
		System.out.print("Mời nhập mã sản phẩm: ");
		setMaSanPham(sc.nextLine());
		System.out.print("Mời nhập tên: ");
		setTenSanPham(sc.nextLine());
		System.out.print("Mời nhập thương hiệu: ");
		setTenThuongHieu(sc.nextLine());
		System.out.print("Mời nhập mô tả sản phẩm: ");
		setMoTaSanPham(sc.nextLine());
		System.out.print("Mời nhập đơn giá sản phẩm: ");
		setDonGia(Float.parseFloat(sc.nextLine()));
		System.out.print("Mời nhập số lượng sản phẩm: ");
		setSoLuongTrongKho(Integer.parseInt(sc.nextLine()));
	}
	
	public float chiPhiMua() {
		return getDonGia()*getSoLuongTrongKho();
	}
	@Override
	public String toString() {
		return maSanPham + ";" +tenSanPham+ ";" +tenThuongHieu+ ";" +moTaSanPham+ ";" +donGia+ ";" +soLuongTrongKho+ ";";
	}
	public void xuatSanPham() {
		System.out.printf("%-15s%-15s%-15s%-15s%-15.2f%-15d\n", maSanPham, tenSanPham, tenThuongHieu,moTaSanPham, donGia, soLuongTrongKho);
	}
	@Override
	public void thue() {
		// TODO Auto-generated method stub
		if (chiPhiMua() < 500000) {
			super.setThue(chiPhiMua()*2/100);
		} else if (chiPhiMua() > 1000000) {
			super.setThue(chiPhiMua()*1/100);
		}
	}
	public float tongChiPhi() {
		return chiPhiMua() + super.getThue();
	}
}
