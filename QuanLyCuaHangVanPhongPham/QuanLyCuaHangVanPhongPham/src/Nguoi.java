import java.util.Scanner;

public abstract class Nguoi {
	private Scanner sc = new Scanner(System.in);
	private String id, ten, tuoi, sdt;
	private String coms;
	
	public String getComs() {
		return coms;
	}
	public void setComs(String coms) {
		this.coms = coms;
	}
	public Nguoi() {
		// TODO Auto-generated constructor stub
	}
	public Nguoi(String id, String ten, String tuoi, String sdt) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.sdt = sdt;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		while (true) {
			if(sdt.length() > 10) {
				System.out.print("Độ dài phải bé hơn 10, nhập lại: ");
				sdt = sc.nextLine();
			} else if (sdt.length() <= 10){
				break;
			}
		}
		this.sdt = sdt;
	}
	public abstract void luong();
	public void nhapNguoi() {
		System.out.print("Nhập id: ");
		setId(sc.nextLine());
		System.out.print("Nhập tên: ");
		setTen(sc.nextLine());
		System.out.print("Nhập tuổi: ");
		setTuoi(sc.nextLine());
		System.out.print("Nhập số điện thoại: ");
		setSdt(sc.nextLine());
	}
	public void xuatNguoi() {
		System.out.printf("%-15s%-15s%-15s%-15s\n",id, ten, tuoi, sdt);
	}
}
