import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKhachHang implements Doc {
	private Scanner sc = new Scanner(System.in);
	private int n;
	private KhachHang[] ds = new KhachHang[n];
	private KhachHang[] dsS = new KhachHang[n];
	private int x;

	public DanhSachKhachHang() {
		super();
	}
	
	public KhachHang[] getDsS() {
		return dsS;
	}


	public void setDsS(KhachHang[] dsS) {
		this.dsS = dsS;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		while (true) {
			if (x>=0&&x<ds.length) {
				break;
			} else {
				System.out.printf("Giá trị x không được lớn hơn %d và không được âm\n", ds.length-1);
				System.out.println("Mời nhập lại: ");
				x = Integer.parseInt(sc.nextLine());
			}
		}
		this.x = x;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public KhachHang[] getDs() {
		return ds;
	}

	public void setDs(KhachHang[] ds) {
		this.ds = ds;
	}
	public void nhapDSKH() {
		System.out.print("Mời bạn nhập số lượng: ");
		setN(Integer.parseInt(sc.nextLine()));
		setDs(ds = Arrays.copyOf(ds, n)); //Tang do dai mang ds len n
		for (int i = 0; i < ds.length; i++) {
			ds[i] = new KhachHang();
			ds[i].nhapKhachHang();
			for (int j = 0; j < i; j++) {
				if (i == 0)
					break;
				if (ds[i].getId().compareTo(ds[j].getId())==0) {
					System.out.print("Bị trùng, nhập lại ID: ");
					ds[i].setId(sc.nextLine());
					j = -1;
				}
			}
		}
	}
	
	public void xuatDSKH() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng");
			return;
		}
		for (int i = 0; i < 60;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("%-15s%-15s%-15s%-15s\n","ID","Tên","Tuổi","Số điện thoại");
		for (int i = 0; i < 60;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuatKhachHang();
		}
		for (int i = 0; i < 60;i++) {
			System.out.print("=");	
		}
		System.out.println("");
	}
	
	public void them() {
		System.out.print("\nMời bạn nhập vào dữ liệu cần thêm\n");
		KhachHang a = new KhachHang();
		a.nhapKhachHang();
		int flag = 0;
		for (int i = 0; i < ds.length; i++) {
			if(a.getId().compareTo(ds[i].getId())==0) {
				ds[i] = a;
				flag = 1;
			}
		}
		if (flag==1) {
			return;
		} else {
			setDs(ds=Arrays.copyOf(ds, ds.length+1));
			ds[ds.length-1] = a;
		}
	}
	
	public void xoa() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng, không thể xóa!");
			return;
		}
		System.out.println("Mời nhập vào id cần xóa: ");
		int flag = 0, count = 0;
		KhachHang a = new KhachHang();
		a.setId(sc.nextLine());;
		for (int i = x; i < ds.length; i++) {
			if(ds[i].getId().compareTo(a.getId())==0) {
				flag = 1;
				count = i;
			}
		}
		if (flag == 1) {
			for (int i = count; i < ds.length-1; i++) {
				ds[i] = ds[i+1];
			}
			setDs(ds=Arrays.copyOf(ds, ds.length-1));
			setN(ds.length);
		}
		else {
			System.out.println("Không tìm thấy mã để xóa!");
		}
	}
	
	public void sua() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng, không thể xóa!");
			return;
		}
		System.out.printf("Mời nhập vào id cần sửa: ");
		int flag = 0, count = 0;
		KhachHang a = new KhachHang();
		a.setId(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if(ds[i].getId().compareTo(a.getId())==0) {
				flag = 1;
				count = i;
			}
		}
		if (flag == 1) {
			System.out.println("Mời nhập lại toàn bộ thông tin nhân viên!");
			a.nhapKhachHang();
			for (int i = 0; i < ds.length; i++) {
				if (ds[i].getId().compareTo(ds[count].getId())==0) {
					ds[count] = a;
					break;
				}
				if(ds[i].getId().compareTo(a.getId())==0) {
					System.out.println("Dữ liệu trùng, mời nhập lại toàn bộ thông tin!");
					a.nhapKhachHang();
					ds[count] = a;
					i = -1;
				}
			}
		}
	}
	
	public void tim() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng, không thể tìm!");
			return;
		}
		int flag = 0;
		System.out.print("\nMời nhập vào id cần tìm: ");
		KhachHang a = new KhachHang();
		a.setId(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getId().compareTo(a.getId())==0) {
				ds[i].xuatKhachHang();
				flag = 1;
			}
		}
		if (flag==1) {
			return;
		} else {
			System.out.println("Không có mã cần tìm!");
		}
	}
	
	public void doc() {
		try {
			FileReader fr=new FileReader("DSKH.txt");
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
	        		setDs(ds=Arrays.copyOf(ds, count));
	        		String id = s[0];
	        		String ten = s[1];
	        		String tuoi = s[2];
	        		String sdt = s[3];
	        		ds[ds.length-1] = new KhachHang(id, ten, tuoi, sdt);
	        	}
	        }
	        System.err.println("Đọc thành công!");
	        fr.close();
	        br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi đọc");
		}
	}
	
	public void ghi() {
		try {	
			docS();
			int k = 0, flag = 0, count = 0;
			if (ds.length > 0 && dsS.length > 0) {
				for (int i = 0; i < ds.length; i++) {
					for (int j = 0; j < dsS.length; j++) {
						if (ds[i].getId().compareTo(dsS[j].getId())==0) {
							dsS[j].setComs("0");
							count++;
						} else {
							dsS[j].setComs("1");
						}
					}
				}
				setDs(ds=Arrays.copyOf(ds, ds.length + (dsS.length-count)));
				for (int i = ds.length-(dsS.length-count); i < ds.length;i++) {
					for (int j = 0; j < dsS.length; j++) {
						if (dsS[j].getComs().compareTo("0")==0) {
						} else {
							ds[i] = dsS[j];
							i+=1;
						}
					}
				}
			}
			if (ds.length > 0) {
				FileWriter fw = new FileWriter("DSKH.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				if (ds.length > 0) {
					for (int i = 0; i < ds.length; i++) {
						bw.write(ds[i].toString());
						bw.newLine();
					}
				}
				bw.close();
				fw.close();
		        System.err.println("Ghi thành công!");
			}
		} catch (Exception e) {
			System.err.println("Lỗi ghi!");
		}
	}

	@Override
	public void docS() {
		// TODO Auto-generated method stub
		try {
			FileReader fr=new FileReader("DSKH.txt");
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
	        		setDsS(dsS=Arrays.copyOf(dsS, count));
	        		String id = s[0];
	        		String ten = s[1];
	        		String tuoi = s[2];
	        		String sdt = s[3];
	        		dsS[dsS.length-1] = new KhachHang(id, ten, tuoi, sdt);
	        	}
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi");
		}
	}
	public static void main(String[] args) {
		DanhSachKhachHang a = new DanhSachKhachHang();
		a.doc();
		a.xuatDSKH();
	}

}
