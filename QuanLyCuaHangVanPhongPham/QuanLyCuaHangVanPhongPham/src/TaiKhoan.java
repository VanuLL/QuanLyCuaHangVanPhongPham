import java.util.Scanner;

public class TaiKhoan {
	Scanner sc = new Scanner(System.in);
	private String tk, mk, quyen;
	private String coms;
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(String tk, String mk, String quyen) {
		super();
		this.tk = tk;
		this.mk = mk;
		this.quyen = quyen;
	}

	public String getComs() {
		return coms;
	}

	public void setComs(String coms) {
		this.coms = coms;
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		while (true) {
			if(tk.compareTo("admin")==0) {
				System.out.printf("Mời nhập lại: ");
				tk = sc.nextLine();
			}
			else {
				break;
			}
		}
		this.tk = tk;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		while (true) {
			if(quyen.compareTo("staff")!=0 && quyen.compareTo("manager")!=0) {
				System.out.println("Quyền chỉ có thể là staff hoặc manager!");
				System.out.printf("Nhập lại quyền: ");
				quyen = sc.nextLine();
			}
			else {
				break;
			}
		}
		this.quyen = quyen;
	}
	@Override
	public String toString() {
		return getTk() +";"+ getMk() +";"+ getQuyen() +";";
	}
	public void nhapTaiKhoan() {
		System.out.print("Mời bạn nhập tài khoản: ");
		setTk(sc.nextLine());
		System.out.print("Mời bạn nhập mật khẩu: ");
		setMk(sc.nextLine());
		System.out.print("Mời bạn nhập quyền truy cập: ");
		setQuyen(sc.nextLine());
	}
	public void xuatTaiKhoan() {
		System.out.printf("%-15s%-15s%-15s\n", tk, mk, quyen);
	}
}
