
public class KhachHang extends Nguoi {
	
	public KhachHang(String id, String ten, String tuoi, String sdt) {
		super(id, ten, tuoi, sdt);
		// TODO Auto-generated constructor stub
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return super.getId() +";"+super.getTen()+";"+super.getTuoi() +";"+super.getSdt()+";";
	}
	@Override
	public void luong() {
		// TODO Auto-generated method stub
	}
	
	public void nhapKhachHang() {
		super.nhapNguoi();
	}
	
	public void xuatKhachHang()	{
		super.xuatNguoi();
	}
	
}
