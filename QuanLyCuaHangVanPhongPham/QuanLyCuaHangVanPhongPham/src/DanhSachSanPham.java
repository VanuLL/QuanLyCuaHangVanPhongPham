import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements Doc {
	private Scanner sc = new Scanner(System.in);
	private int n;
	private SanPham[] ds = new SanPham[n];
	private SanPham[] dsS = new SanPham[n];
	private int x;

	public DanhSachSanPham() {
		super();
	}
	
	public SanPham[] getDsS() {
		return dsS;
	}


	public void setDsS(SanPham[] dsS) {
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

	public SanPham[] getDs() {
		return ds;
	}

	public void setDs(SanPham[] ds) {
		this.ds = ds;
	}
	public void nhapDSSP() {
		System.out.print("Mời bạn nhập số lượng: ");
		setN(Integer.parseInt(sc.nextLine()));
		setDs(ds = Arrays.copyOf(ds, n)); //Tang do dai mang ds len n
		for (int i = 0; i < ds.length; i++) {
			ds[i] = new SanPham();
			ds[i].nhapSanPham();
			for (int j = 0; j < i; j++) {
				if (i == 0)
					break;
				if (ds[i].getMaSanPham().compareTo(ds[j].getMaSanPham())==0) {
					System.out.print("Bị trùng, nhập lại ID: ");
					ds[i].setMaSanPham(sc.nextLine());
					j = -1;
				}
			}
		}
	}
	
	public void xuatDSSP() {
		if (ds.length==0) {
			System.out.println("Danh sách rỗng");
			return;
		}
		for (int i = 0; i < 90;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","Mã sản phẩm","Tên sản phẩm","Thương hiệu","Mô tả", "Đơn giá", "Tồn kho");
		for (int i = 0; i < 90;i++) {
			System.out.print("=");	
		}
		System.out.println("");
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuatSanPham();
		}
		for (int i = 0; i < 90;i++) {
			System.out.print("=");	
		}
		System.out.println("");
	}
	
	public void them() {
		System.out.print("\nMời bạn nhập vào dữ liệu cần thêm\n");
		SanPham a = new SanPham();
		a.nhapSanPham();
		int flag = 0;
		for (int i = 0; i < ds.length; i++) {
			if(a.getMaSanPham().compareTo(ds[i].getMaSanPham())==0) {
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
		SanPham a = new SanPham();
		a.setMaSanPham(sc.nextLine());;
		for (int i = x; i < ds.length; i++) {
			if(ds[i].getMaSanPham().compareTo(a.getMaSanPham())==0) {
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
		SanPham a = new SanPham();
		a.setMaSanPham(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if(ds[i].getMaSanPham().compareTo(a.getMaSanPham())==0) {
				flag = 1;
				count = i;
			}
		}
		if (flag == 1) {
			System.out.println("Mời nhập lại toàn bộ thông tin nhân viên!");
			a.nhapSanPham();
			for (int i = 0; i < ds.length; i++) {
				if (ds[i].getMaSanPham().compareTo(ds[count].getMaSanPham())==0) {
					ds[count] = a;
					break;
				}
				if(ds[i].getMaSanPham().compareTo(a.getMaSanPham())==0) {
					System.out.println("Dữ liệu trùng, mời nhập lại toàn bộ thông tin!");
					a.nhapSanPham();
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
		SanPham a = new SanPham();
		a.setMaSanPham(sc.nextLine());
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getMaSanPham().compareTo(a.getMaSanPham())==0) {
				ds[i].xuatSanPham();
				flag = 1;
			}
		}
		if (flag==1) {
			return;
		} else {
			System.out.println("Không có mã cần tìm!");
		}
	}
	
	public float chiPhiMua() {
		doc();
		float sum = 0;
		if (ds.length==0) {
			System.out.println("Danh sách rỗng, không thể tính chi phí!");
			return sum;
		}
		for (int i = 0; i < ds.length; i++) {
			sum+=ds[i].tongChiPhi();
		}
		return sum;
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
	        		setDs(ds=Arrays.copyOf(ds, count));
	        		maSanPham = s[0];
	        		tenSanPham = s[1];
	        		tenThuongHieu = s[2];
	        		moTaSanPham = s[3];
	        		donGia = Float.parseFloat(s[4]);
	        		soLuongTrongKho = Integer.parseInt(s[5]);
	        		ds[ds.length-1] = new SanPham(maSanPham, tenSanPham, tenThuongHieu, moTaSanPham, donGia, soLuongTrongKho);
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
						if (ds[i].getMaSanPham().compareTo(dsS[j].getMaSanPham())==0) {
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
				FileWriter fw = new FileWriter("DSSP.txt");
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
	public static void main(String[] args) {
		DanhSachSanPham a = new DanhSachSanPham();
		a.nhapDSSP();
		a.ghi();
		a.doc();
		a.xuatDSSP();
	}
}
