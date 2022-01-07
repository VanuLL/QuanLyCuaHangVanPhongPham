import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTaiKhoan implements Doc {
	private Scanner sc = new Scanner(System.in);
	private int n;
	private TaiKhoan[] ds = new TaiKhoan[n];
	private TaiKhoan[] dsS = new TaiKhoan[n];
	private int x;
	private String chuoiTaiKhoan;
	

	public String getChuoiTaiKhoan() {
		return chuoiTaiKhoan;
	}

	public void setChuoiTaiKhoan(String chuoiTaiKhoan) {
		this.chuoiTaiKhoan = chuoiTaiKhoan;
	}


	public DanhSachTaiKhoan() {
		super();
	}
	
	public TaiKhoan[] getDsS() {
		return dsS;
	}


	public void setDsS(TaiKhoan[] dsS) {
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

	public TaiKhoan[] getDs() {
		return ds;
	}

	public void setDs(TaiKhoan[] ds) {
		this.ds = ds;
	}
	public void nhapDSTK() {
		System.out.print("Mời bạn nhập số lượng: ");
		setN(Integer.parseInt(sc.nextLine()));
		setDs(ds = Arrays.copyOf(ds, n)); //Tang do dai mang ds len n
		for (int i = 0; i < ds.length; i++) {
			ds[i] = new TaiKhoan();
			ds[i].nhapTaiKhoan();
			for (int j = 0; j < i; j++) {
				if (i == 0)
					break;
				if (ds[i].getTk().compareTo(ds[j].getTk())==0) {
					System.out.print("Bị trùng, nhập lại ID: ");
					ds[i].setTk(sc.nextLine());
					j = -1;
				}
			}
		}
	}
	
	public void xuatDSTK() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng");
			return;
		}
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuatTaiKhoan();
		}
	}
	
	public void them() {
		System.out.print("\nMời bạn nhập vào dữ liệu cần thêm\n");
		TaiKhoan a = new TaiKhoan();
		a.nhapTaiKhoan();
		int flag = 0;
		for (int i = 0; i < ds.length; i++) {
			if(a.getTk().compareTo(ds[i].getTk())==0) {
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
		TaiKhoan a = new TaiKhoan();
		a.setTk(sc.nextLine());
		for (int i = x; i < ds.length; i++) {
			if(ds[i].getTk().compareTo(a.getTk())==0) {
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
		System.out.print("\nMời nhập vào id cần sửa: ");
		int flag = 0, count = 0;
		TaiKhoan a = new TaiKhoan();
		a.setTk(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if(ds[i].getTk().compareTo(a.getTk())==0) {
				flag = 1;
				count = i;
			}
		}
		if (flag == 1) {
			System.out.println("Mời nhập lại toàn bộ thông tin nhân viên!");
			a.nhapTaiKhoan();
			for (int i = 0; i < ds.length; i++) {
				if (ds[i].getTk().compareTo(ds[count].getTk())==0) {
					ds[count] = a;
					break;
				}
				if(ds[i].getTk().compareTo(a.getTk())==0) {
					System.out.println("Dữ liệu trùng, mời nhập lại toàn bộ thông tin!");
					a.nhapTaiKhoan();
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
		TaiKhoan a = new TaiKhoan();
		a.setTk(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getTk().compareTo(a.getTk())==0) {
				ds[i].xuatTaiKhoan();
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
			FileReader fr=new FileReader("DSTK.txt");
			BufferedReader br = new BufferedReader(fr);
			String st, cp = "";
			int count=0;
	        while(true) {
	        	st = br.readLine();
	        	if (st == null) {
	        		break;
	        	} else {
	        		count++;
	        		String s[] = st.split(";");
	        		setDs(ds=Arrays.copyOf(ds, count));
	        		String tk = s[0];
	        		String mk = s[1];
	        		String quyen = s[2];
	        		cp+=tk+";"+mk+";"+quyen+";";
	        	}
	        }
	        setChuoiTaiKhoan(cp);
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
						if (ds[i].getTk().compareTo(dsS[j].getTk())==0) {
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
				FileWriter fw = new FileWriter("DSTK.txt");
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
			FileReader fr=new FileReader("DSTK.txt");
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
	        		String tk = s[0];
	        		String mk = s[1];
	        		String quyen = s[2];
	        		dsS[dsS.length-1] = new TaiKhoan(tk, mk, quyen);
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
		DanhSachTaiKhoan a = new DanhSachTaiKhoan();
		a.nhapDSTK();
		a.xuatDSTK();
	}
}
