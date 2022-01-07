import java.util.Scanner;

public class GiaoDienChinh {
	private static String ten;
	private static DanhSachKhachHang dskh = new DanhSachKhachHang();
	private static HoaDon hd = new HoaDon();
	private static ThongKe tke = new ThongKe();
	private static DanhSachNhanVien dsnv = new DanhSachNhanVien();
	private static DanhSachSanPham dssp = new DanhSachSanPham();
	private static PhieuNhapHang pnh = new PhieuNhapHang();
	private static DanhSachTaiKhoan dstk = new DanhSachTaiKhoan();
	private static String tk;
	private static String mk;
	private static Scanner sc = new Scanner(System.in);
	private static String luachon0;
	private static String luachon1;
	private static String luachon2;
	public static void giaoDien() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Chào bạn đến với giao diện đăng ");
		System.out.printf("|\t%-43s|\n","Nhập 1: Nếu bạn là nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 2: Nếu bạn là quản lý");
		System.out.printf("|\t%-43s|\n","Nhập 3: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("Bạn chọn: ");
		luachon0 = sc.nextLine();
		switch (luachon0) {
		case "1":
			System.out.print("Mời bạn nhập tài khoản: ");
			tk = sc.nextLine();
			System.out.print("Mời bạn nhập mật khẩu: ");
			mk = sc.nextLine();
			if(checkNV(tk, mk)!=1) {
				System.out.println("Tài khoản hoặc mật khẩu không đúng!");
				break;
			}
			do {
				luachon1 = "1";
				giaoDienNV();
			} while (luachon1 != "3");
			break;
		case "2":
			System.out.print("Mời bạn nhập tài khoản: ");
			tk = sc.nextLine();
			System.out.print("Mời bạn nhập mật khẩu: ");
			mk = sc.nextLine();
			if(checkQL(tk, mk)!=1) {
				System.out.println("Tài khoản hoặc mật khẩu không đúng!");
				break;
			}
			do {
				luachon1 = "1";
				giaoDienQL();
			} while (luachon1 != "6");
			break;
		case "3":
			System.err.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
			break;
		default:
			System.out.println("Dữ liệu bạn  sai rồi!");
			break;
		}
	}
	public static void giaoDienNV() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Chào bạn " + ten);
		System.out.printf("|\t%-43s|\n","Nhập 1: Nhập hóa đơn");
		System.out.printf("|\t%-43s|\n","Nhập 2: Xuất hóa đơn");
		System.out.printf("|\t%-43s|\n","Nhập 3: Xem danh sách khách hàng");
		System.out.printf("|\t%-43s|\n","Nhập 4: Xem kho hiện tại");
		System.out.printf("|\t%-43s|\n","Nhập 5: Trở Về");
		System.out.printf("|\t%-43s|\n","Nhập 6: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("Bạn chọn: ");
		luachon1 = sc.nextLine();
		switch (luachon1) {
		case "1":
			hd.nhapHoaDon();
			break;
		case "2":
			hd.ghiHD();
			hd.xuatConsole();			
			break;
		case "3":
			dskh.doc();
			dskh.xuatDSKH();			
			break;
		case "4":
			dssp.doc();
			dssp.xuatDSSP();		
			break;
		case "5":
			luachon1 = "5";
			break;
		case "6":
			System.err.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
			break;
		default:
			System.out.println("Bạn  sai dữ liệu!");
			break;
		}
	}
	public static void giaoDienQL() {
		System.out.println("");
		for (int i = 0; i < 52; i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Chào bạn " + ten);
		System.out.printf("|\t%-43s|\n","Nhập 1: Quản lý khách hàng");
		System.out.printf("|\t%-43s|\n","Nhập 2: Quản lý nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 3: Quản lý nhập hàng");
		System.out.printf("|\t%-43s|\n","Nhập 4: Xem kho hiện tại");
		System.out.printf("|\t%-43s|\n","Nhập 5: Thống kê");
		System.out.printf("|\t%-43s|\n","Nhập 6: Trở Về");
		System.out.printf("|\t%-43s|\n","Nhập 7: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("Bạn chọn: ");
		luachon1 = sc.nextLine();
		switch (luachon1) {
		case "1":
			do {
				QLKH();
			} while (luachon2!="9");
			break;
		case "2":
			do {
				QLNV();
			} while (luachon2!="9");
			break;
		case "3":
			do {
				QLNH();
			} while (luachon2!="9");
			break;
		case "4":
			dssp.doc();
			dssp.xuatDSSP();
			break;
		case "5":
			do {
				QLTK();
			} while (luachon2!="6");
			break;
		case "6":
			luachon1 = "6";
			break;
		case "7":
			System.err.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
			break;
		default:
			System.out.println("Bạn  sai dữ liệu!");
			break;
		}
	}
	public static void QLKH() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Nhập 1: Nhập danh sách khách hàng");
		System.out.printf("|\t%-43s|\n","Nhập 2: Xuất khách hàng");
		System.out.printf("|\t%-43s|\n","Nhập 3: Thêm khách hàng");
		System.out.printf("|\t%-43s|\n","Nhập 4: Tìm khách hàng theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 5: Sửa khách hàng theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 6: Xóa khách hàng theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 7: Đọc");
		System.out.printf("|\t%-43s|\n","Nhập 8: Lưu");
		System.out.printf("|\t%-43s|\n","Nhập 9: Trở về");
		System.out.printf("|\t%-43s|\n","Nhập 10: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.print("Bạn chọn: ");
		luachon2 = sc.nextLine();
		switch (luachon2) {
		case "1":
			dskh.nhapDSKH();
			break;
		case "2":
			dskh.xuatDSKH();
			break;
		case "3":
			dskh.them();
			break;
		case "4":
			dskh.tim();
			break;
		case "5":
			dskh.sua();
			break;
		case "6":
			dskh.xoa();
			break;
		case "7":
			dskh.doc();
			break;
		case "8":
			dskh.ghi();
			break;
		case "9":
			luachon2 = "9";
			break;
		case "10":
			System.out.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
		default:
			System.out.println("Dữ liệu bạn nhập chưa đúng!");
			break;
		}
	}
	public static void QLNV() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Nhập 1: Nhập danh sách nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 2: Xuất danh sách nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 3: Thêm nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 4: Tìm nhân viên theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 5: Sửa nhân viên theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 6: Xóa nhân viên theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 7: Đọc");
		System.out.printf("|\t%-43s|\n","Nhập 8: Lưu");
		System.out.printf("|\t%-43s|\n","Nhập 9: Trở về");
		System.out.printf("|\t%-43s|\n","Nhập 10: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.print("Bạn chọn: ");
		luachon2 = sc.nextLine();
		switch (luachon2) {
		case "1":
			dsnv.nhapDSNV();
			break;
		case "2":
			dsnv.xuatDSNV();
			break;
		case "3":
			dsnv.them();
			break;
		case "4":
			dsnv.tim();
			break;
		case "5":
			dsnv.sua();
			break;
		case "6":
			dsnv.xoa();
			break;
		case "7":
			dsnv.doc();
			break;
		case "8":
			dsnv.ghi();
			break;
		case "9":
			luachon2 = "9";
			break;
		case "10":
			System.out.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
		default:
			System.out.println("Dữ liệu bạn nhập chưa đúng!");
			break;
		}
	}
	public static void QLNH() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Nhập 1: Nhập danh sách sản phẩm");
		System.out.printf("|\t%-43s|\n","Nhập 2: Xuất danh sách sản phẩm");
		System.out.printf("|\t%-43s|\n","Nhập 3: Thêm sản phẩm");
		System.out.printf("|\t%-43s|\n","Nhập 4: Tìm sản phẩm theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 5: Sửa sản phẩm theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 6: Xóa sản phẩm theo mã");
		System.out.printf("|\t%-43s|\n","Nhập 7: Đọc");
		System.out.printf("|\t%-43s|\n","Nhập 8: Lưu(Xác định nhập)");
		System.out.printf("|\t%-43s|\n","Nhập 9: Trở về");
		System.out.printf("|\t%-43s|\n","Nhập 10: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.print("Bạn chọn: ");
		luachon2 = sc.nextLine();
		switch (luachon2) {
		case "1":
			pnh.nhapDSSP();
			break;
		case "2":
			pnh.xuatDSSP();
			break;
		case "3":
			pnh.them();
			break;
		case "4":
			pnh.tim();
			break;
		case "5":
			pnh.sua();
			break;
		case "6":
			pnh.xoa();
			break;
		case "7":
			pnh.doc();
			break;
		case "8":
			pnh.ghi();
			break;
		case "9":
			luachon2 = "9";
			break;
		case "10":
			System.out.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
		default:
			System.out.println("Dữ liệu bạn nhập chưa đúng!");
			break;
		}
	}
	public static void QLTK() {
		System.out.println("");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("|\t%-43s|\n","Nhập 1: Chi phí thuê nhân viên");
		System.out.printf("|\t%-43s|\n","Nhập 2: Tổng doanh thu");
		System.out.printf("|\t%-43s|\n","Nhập 3: Tổng chi phí nhập hàng");
		System.out.printf("|\t%-43s|\n","Nhập 4: Tổng thuế nhập hàng");
		System.out.printf("|\t%-43s|\n","Nhập 5: Tổng lợi nhuận");
		System.out.printf("|\t%-43s|\n","Nhập 6: Trở về");
		System.out.printf("|\t%-43s|\n","Nhập 7: Thoát");
		for (int i = 0; i < 52;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.print("Bạn chọn: ");
		luachon2 = sc.nextLine();
		switch (luachon2) {
		case "1":
			System.out.println("Tiền thuê nhân viên là: " + tke.tienThueNhanVien());
			break;
		case "2":
			System.out.println("Tổng doanh thu là: " + tke.tongDoanhThu());
			break;
		case "3":
			System.out.println("Tổng chi phí nhập hàng: " + tke.tongChiPhiNhapHang());
			break;
		case "4":
			System.out.println("Tổng thuế nhập hàng: " + tke.tongThueNhapHang());
			break;
		case "5":
			float sum = tke.tongDoanhThu()-tke.tongChiPhiNhapHang()-tke.tongThueNhapHang()-tke.tienThueNhanVien();
			System.out.println("Lợi nhuận là: " + sum);
			break;
		case "6":
			luachon2 = "6";
			break;
		case "7":
			System.out.println("Cảm ơn bạn đã dùng phần mềm!");
			System.exit(0);
		default:
			break;
		}
	}
	public static int checkNV(String tk, String mk) {
		String v = dstk.getChuoiTaiKhoan();
		String []s = v.split(";");
		for (int i = 0; i < s.length; i++) {
			if (i%3 == 0) {
				if(tk.compareTo(s[i])==0&&mk.compareTo(s[i+1])==0&&s[i+2].compareTo("staff")==0) {
					ten = tk;
					return 1;
				}
			}
		}
		return 0;
	}
	public static int checkQL(String tk, String mk) {
		String v = dstk.getChuoiTaiKhoan();
		String []s = v.split(";");
		for (int i = 0; i < s.length; i++) {
			if (i%3 == 0) {
				if(tk.compareTo(s[i])==0&&mk.compareTo(s[i+1])==0&&s[i+2].compareTo("staff")==0) {
					ten = tk;
					return 1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dstk.doc();
		while (true) {
			giaoDien();
		}
	}

}
