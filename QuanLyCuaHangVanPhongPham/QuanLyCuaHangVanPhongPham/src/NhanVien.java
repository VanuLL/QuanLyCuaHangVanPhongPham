import java.util.Scanner;

public class NhanVien extends Nguoi {
	private Scanner sc = new Scanner(System.in);
	float gioLam, luong;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public NhanVien(float gioLam, float luong) {
		super();
		this.gioLam = gioLam;
		this.luong = luong;
	}



	public NhanVien(String id, String ten, String tuoi, String sdt, float gioLam, float luong) {
		super(id, ten, tuoi, sdt);
		this.gioLam = gioLam;
		this.luong = luong;
	}



	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}
	
	public float getGioLam() {
		return gioLam;
	}

	public void setGioLam(float gioLam) {
		this.gioLam = gioLam;
	}
	@Override
	public void luong() {
		setLuong(getGioLam()*30000);
	}
	@Override
	public String toString() {
		return super.getId() +";"+ super.getTen() +";"+ super.getTuoi()+";"+super.getSdt()+";"+gioLam+";"+ luong +";";
	}
	public void nhapNhanVien() {
		super.nhapNguoi();
		System.out.print("Nhập giờ làm: ");
		setGioLam(Float.parseFloat(sc.nextLine()));
		luong();
	}
	public void xuatNhanVien() {
		System.out.printf("%-15s%-15s%-15s%-15s%-15.2f%-15.2f\n",super.getId() , super.getTen(), super.getTuoi(), super.getSdt(), gioLam, luong);
	}
	public static void main(String[] args) {
		NhanVien a = new NhanVien();
		a.nhapNhanVien();
		a.xuatNhanVien();
	}
}
