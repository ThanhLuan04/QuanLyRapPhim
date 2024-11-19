package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.PopupMenu;

import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//import DuLieuTam.SharedData;
//import DuLieuTam.SharedDataHolder;
import dao.Ghe_DAO;
import dao.KhachHang_DAO;
import dao.LichChieuPhim_DAO;
import dao.Phim_Dao;
import dao.Phong_DAO;
import entity.Ghe;
import entity.KhachHang;
import entity.Phim;
import entity.Phong;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class GD_ChonGhe extends JPanel {

	Ghe_DAO gheDAO = new Ghe_DAO();
	private List<Ghe> danhsachghe;
	private Ghe[] Ghe;
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhim;
	private JTextField txtTenPhim;
	private JTextField txtThoiGian;
	private JTextField txtPhong;
	private JTextField txtGhe;
	private JTextField txtTongTien1;
	private JTextField txtTongTien2;
	private JTextField txtTienThua;
	private JTextField txtGioChieu;
	private String LayMaPhim,MaLichChieu,MaPhong;
	
	private Phim_Dao phimDAO;
	private JPanel panel3,panel2,panel1;
	private JLabel lblTienKhachDua,lblTienThua,lblTongTien2,lblThanhToan,lblGhe,lblTongTien1,lblPhong,lblTenPhim,lblThongTinVe;
	private JTextField txtTienKhachDua,txtSDT2,txtTenKH,txtSDT1;
	private JButton btnDat,btnHuy,btnTim;
	private JComboBox cboSex;
	private JLabel lblMaPhim,lblManHinhChinh;
	private JButton btnB05,btnB03,btnB02,btnB01,btnB04,btnB07,btnB08,btnB09,btnB10,btnB06;
	private JButton btnA09,btnA08,btnA07,btnA06,btnA03,btnA01,btnA02,btnA04,btnA05,btnA10;
	private JButton btnC01,btnC02,btnC03,btnC04,btnC05,btnC06,btnC07,btnC08,btnC09,btnC10; 
	private JButton btnD01,btnD02,btnD03,btnD04,btnD05,btnD06,btnD07,btnD08,btnD09,btnD10;
	private JButton btnE01,btnE02,btnE03,btnE04,btnE05,btnE06,btnE07,btnE09,btnE08,btnE10;
	private JLabel labelDaChon,labelTrong,labelDangChon,lblDaChon,lblGheTrong,lblDangChon,lblGioChieu;;
	private KhachHang_DAO khachhang_DAO;
	private String makhachhang;
	private Phim phimduocchon;
//	SharedData dulieutam;
	private Double Price,gia;
	private int Count;
	private String seatName;
	private ArrayList<String> selectedSeats;
	private double remainAmount;
	private JTextField rong;

	public GD_ChonGhe(GD_Menu menu, GD_phim gd_phim) {
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		phimDAO = new Phim_Dao();
		LayMaPhim = gd_phim.getMaPhimDuocChon();
//		LayMaPhim = DataManager.getInstance().getMaPhim();
//		System.out.println("ma phim:" + LayMaPhim);
//		if (LayMaPhim == null || LayMaPhim.isEmpty()) {
//		    System.err.println("Mã phim không hợp lệ: " + LayMaPhim);
//		    return; // Hoặc xử lý lỗi phù hợp
//		}

		
		phimduocchon = phimDAO.getPhimByMaPhim(LayMaPhim);
		
		MaLichChieu = LichChieuPhim_DAO.getMaLichChieuByMaPhim(LayMaPhim);
		MaPhong = LichChieuPhim_DAO.getMaPhongByMaLichChieu(MaLichChieu);
		Phong phong = Phong_DAO.getPhongByMaPhong(MaPhong);
		
		danhsachghe = gheDAO.getGheList(MaLichChieu);
		Ghe = new Ghe[danhsachghe.size()];
		
		 // Biến lưu tiền của phim
        Price =  phimduocchon.getGiave(); // Giá mỗi ghế
		
		//panel 1
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel1.setBackground(new Color(225, 214, 196));
		panel1.setBounds(0, 0, 885, 600);
		add(panel1);
		panel1.setLayout(null);
		
		lblManHinhChinh = new JLabel("Màn Hình Chính");
		lblManHinhChinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblManHinhChinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblManHinhChinh.setBounds(295, 0, 300, 40);
		panel1.add(lblManHinhChinh);
//--------------------------------------------------------------------------------------------------------------------------------------------------------
		//hàng 1
		btnA01 = new JButton();
		btnA01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA01.setBounds(30, 80, 55, 50);
		panel1.add(btnA01);
		
		btnA02 = new JButton();
		btnA02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA02.setBounds(115, 80, 55, 50);
		panel1.add(btnA02);
		
		btnA03 = new JButton();
		btnA03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA03.setBounds(200, 80, 55, 50);
		panel1.add(btnA03);
		
		btnA04 = new JButton();
		btnA04.setBounds(285, 80, 55, 50);
		btnA04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		panel1.add(btnA04);
		
		btnA05 = new JButton();
		btnA05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA05.setBounds(370, 80, 55, 50);
		panel1.add(btnA05);
		
		btnA06 = new JButton();
		btnA06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA06.setBounds(455, 80, 55, 50);
		panel1.add(btnA06);
		
		btnA07 = new JButton();
		btnA07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA07.setBounds(540, 80, 55, 50);
		panel1.add(btnA07);
		
		btnA08 = new JButton();
		btnA08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA08.setBounds(625, 80, 55, 50);
		panel1.add(btnA08);
		
		btnA09 = new JButton();
		btnA09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA09.setBounds(710, 80, 55, 50);
		panel1.add(btnA09);
		
		btnA10 = new JButton();
		btnA10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA10.setBounds(795, 80, 55, 50);
		panel1.add(btnA10);
		
		//hàng 2
		btnB01 = new JButton();
		btnB01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB01.setBounds(30, 160, 55, 50);
		panel1.add(btnB01);
		
		btnB02 = new JButton();
		btnB02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB02.setBounds(115, 160, 55, 50);
		panel1.add(btnB02);
		
		btnB03 = new JButton();
		btnB03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB03.setBounds(200, 160, 55, 50);
		panel1.add(btnB03);
		
		btnB04 = new JButton();
		btnB04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB04.setBounds(285, 160, 55, 50);
		panel1.add(btnB04);
		
		btnB05 = new JButton();
		btnB05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB05.setBounds(370, 160, 55, 50);
		panel1.add(btnB05);
		
		JButton btnB06 = new JButton();
		btnB06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB06.setBounds(455, 160, 55, 50);
		panel1.add(btnB06);
		
		btnB07 = new JButton();
		btnB07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB07.setBounds(540, 160, 55, 50);
		panel1.add(btnB07);
		
		btnB08 = new JButton();
		btnB08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB08.setBounds(625, 160, 55, 50);
		panel1.add(btnB08);
		
		btnB09 = new JButton();
		btnB09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB09.setBounds(710, 160, 55, 50);
		panel1.add(btnB09);
		
		btnB10 = new JButton();
		btnB10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB10.setBounds(795, 160, 55, 50);
		panel1.add(btnB10);
		
		//hàng 3
		btnC01 = new JButton();
		btnC01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC01.setBounds(30, 245, 55, 50);
		panel1.add(btnC01);
		
		btnC02 = new JButton();
		btnC02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC02.setBounds(115, 245, 55, 50);
		panel1.add(btnC02);
		
		btnC03 = new JButton();
		btnC03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC03.setBounds(200, 245, 55, 50);
		panel1.add(btnC03);
		
		btnC04 = new JButton();
		btnC04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC04.setBounds(285, 245, 55, 50);
		panel1.add(btnC04);
		
		btnC05 = new JButton();
		btnC05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC05.setBounds(370, 245, 55, 50);
		panel1.add(btnC05);
		
		btnC06 = new JButton();
		btnC06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC06.setBounds(455, 245, 55, 50);
		panel1.add(btnC06);
		
		btnC07 = new JButton();
		btnC07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC07.setBounds(540, 245, 55, 50);
		panel1.add(btnC07);
		
		btnC08 = new JButton();
		btnC08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC08.setBounds(625, 245, 55, 50);
		panel1.add(btnC08);
		
		btnC09 = new JButton();
		btnC09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC09.setBounds(710, 245, 55, 50);
		panel1.add(btnC09);
		
		btnC10 = new JButton();
		btnC10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC10.setBounds(795, 245, 55, 50);
		panel1.add(btnC10);
		
		//hàng 4
		btnD01 = new JButton();
		btnD01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD01.setBounds(30, 330, 55, 50);
		panel1.add(btnD01);
		
		btnD02 = new JButton();
		btnD02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD02.setBounds(115, 330, 55, 50);
		panel1.add(btnD02);
		
		btnD03 = new JButton();
		btnD03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD03.setBounds(200, 330, 55, 50);
		panel1.add(btnD03);
		
		btnD04 = new JButton();
		btnD04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD04.setBounds(285, 330, 55, 50);
		panel1.add(btnD04);
		
		btnD05 = new JButton();
		btnD05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD05.setBounds(370, 330, 55, 50);
		panel1.add(btnD05);
		
		btnD06 = new JButton();
		btnD06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD06.setBounds(455, 330, 55, 50);
		panel1.add(btnD06);
		
		btnD07 = new JButton();
		btnD07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD07.setBounds(540, 330, 55, 50);
		panel1.add(btnD07);
		
		btnD08 = new JButton();
		btnD08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD08.setBounds(625, 330, 55, 50);
		panel1.add(btnD08);
		
		btnD09 = new JButton();
		btnD09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD09.setBounds(710, 330, 55, 50);
		panel1.add(btnD09);
		
		btnD10 = new JButton();
		btnD10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD10.setBounds(795, 330, 55, 50);
		panel1.add(btnD10);
		
		//hàng 5
		btnE01 = new JButton();
		btnE01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE01.setBounds(30, 415, 55, 50);
		panel1.add(btnE01);
		
		btnE02 = new JButton();
		btnE02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE02.setBounds(115, 415, 55, 50);
		panel1.add(btnE02);
		
		btnE03 = new JButton();
		btnE03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE03.setBounds(200, 415, 55, 50);
		panel1.add(btnE03);
		
		btnE04 = new JButton();
		btnE04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE04.setBounds(285, 415, 55, 50);
		panel1.add(btnE04);
		
		btnE05 = new JButton();
		btnE05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE05.setBounds(370, 415, 55, 50);
		panel1.add(btnE05);
		
		btnE06 = new JButton();
		btnE06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE06.setBounds(455, 415, 55, 50);
		panel1.add(btnE06);
		
		btnE07 = new JButton();
		btnE07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE07.setBounds(540, 415, 55, 50);
		panel1.add(btnE07);
		
		btnE08 = new JButton();
		btnE08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE08.setBounds(625, 415, 55, 50);
		panel1.add(btnE08);
		
		btnE09 = new JButton();
		btnE09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE09.setBounds(710, 415, 55, 50);
		panel1.add(btnE09);
		
		btnE10 = new JButton();
		btnE10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE10.setBounds(795, 415, 55, 50);
		panel1.add(btnE10);
//--------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//thông báo ghế 
		labelTrong = new JLabel();
		labelTrong.setOpaque(true);
		labelTrong.setBackground(new Color(227, 47, 47));
		labelTrong.setBounds(20, 520, 55, 50);
		panel1.add(labelTrong);
		
		labelDaChon = new JLabel();
		labelDaChon.setOpaque(true);
		labelDaChon.setBackground(new Color(113, 101, 101));
		labelDaChon.setBounds(220, 520, 55, 50);
		panel1.add(labelDaChon);
		
		labelDangChon = new JLabel();
		labelDangChon.setOpaque(true);
		labelDangChon.setBackground(new Color(226, 194, 112));
		labelDangChon.setBounds(420, 520, 55, 50);
		panel1.add(labelDangChon);
		
		lblGheTrong = new JLabel("Ghế trống");
		lblGheTrong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGheTrong.setBounds(80, 520, 110, 50);
		panel1.add(lblGheTrong );
		
		lblDaChon = new JLabel("Đã chọn");
		lblDaChon.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblDaChon.setBounds(280, 520, 110, 50);
		panel1.add(lblDaChon);
		
		lblDangChon = new JLabel("Đang chọn");
		lblDangChon.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblDangChon.setBounds(480, 520, 110, 50);
		panel1.add(lblDangChon);
		
		lblGioChieu = new JLabel("Giờ Chiếu:");
		lblGioChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblGioChieu.setBounds(670, 530, 70, 30);
		panel1.add(lblGioChieu);
		
		txtGioChieu = new JTextField();
		txtGioChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGioChieu.setVisible(true);
		txtGioChieu.setBackground(new Color(225, 214, 196));
		txtGioChieu.setBorder(null);
		txtGioChieu.setEditable(false);
		txtGioChieu.setBounds(740, 530, 90, 30);
		txtGioChieu.setText(phimduocchon.getGioChieu());
		panel1.add(txtGioChieu);
//---------------------------------------------------------------------------------------------------------------------------------------------------------

		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel2.setBackground(new Color(225, 214, 196));
		panel2.setBounds(885, 0, 355, 330);
		add(panel2);
		panel2.setLayout(null);
		
		lblThongTinVe = new JLabel("Thông Tin Vé");
		lblThongTinVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinVe.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblThongTinVe.setBounds(120, 10, 135, 30);
		panel2.add(lblThongTinVe);
		
		lblMaPhim = new JLabel("Mã Phim:");
		lblMaPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblMaPhim.setBounds(30, 55, 90, 25);
		panel2.add(lblMaPhim);
		
		lblTenPhim = new JLabel("Tên Phim:");
		lblTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTenPhim.setBounds(30, 100, 90, 25);
		panel2.add(lblTenPhim);
		
		JLabel lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblThoiGian.setBounds(30, 145, 90, 25);
		panel2.add(lblThoiGian);
		
		lblPhong = new JLabel("Phòng:");
		lblPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblPhong.setBounds(30, 190, 70, 25);
		panel2.add(lblPhong);
		
		lblTongTien1 = new JLabel("Tổng Tiền:");
		lblTongTien1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien1.setBounds(30, 235, 90, 25);
		panel2.add(lblTongTien1);
		
		lblGhe = new JLabel("Ghế:");
		lblGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGhe.setBounds(180, 190, 40, 25);
		panel2.add(lblGhe);
		
		txtMaPhim = new JTextField();
		txtMaPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtMaPhim.setBackground(new Color(225, 214, 196));
		txtMaPhim.setBorder(null);
		txtMaPhim.setEditable(false);
		txtMaPhim.setBounds(120, 55, 200, 25);
		txtMaPhim.setText(phimduocchon.getMaPhim());
		panel2.add(txtMaPhim);
		
		txtTenPhim = new JTextField();
		txtTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenPhim.setVisible(true);
		txtTenPhim.setBackground(new Color(225, 214, 196));
		txtTenPhim.setBorder(null);
		txtTenPhim.setEditable(false);
		txtTenPhim.setBounds(120, 100, 200, 25);
		txtTenPhim.setText(phimduocchon.getTenPhim());
		panel2.add(txtTenPhim);
		
		txtThoiGian = new JTextField();
		txtThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtThoiGian.setVisible(true);
		txtThoiGian.setBackground(new Color(225, 214, 196));
		txtThoiGian.setBorder(null);
		txtThoiGian.setEditable(false);
		txtThoiGian.setBounds(120, 145, 200, 25);
		txtThoiGian.setText(String.valueOf(phimduocchon.getThoiLuong())+" phút");
		panel2.add(txtThoiGian);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtPhong.setVisible(true);
		txtPhong.setEditable(false);
		txtPhong.setBackground(new Color(225, 214, 196));
		txtPhong.setBorder(null);
		txtPhong.setBounds(100, 190, 60, 25);
		txtPhong.setText(phong.getTenPhong());
		panel2.add(txtPhong);
		
		txtGhe = new JTextField();
		txtGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGhe.setVisible(true);
		txtGhe.setEditable(false);
		txtGhe.setBackground(new Color(225, 214, 196));
		txtGhe.setBorder(null);
		txtGhe.setBounds(220, 190, 120, 25);
		panel2.add(txtGhe);
		
		txtTongTien1 = new JTextField();
		txtTongTien1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien1.setVisible(true);
		txtTongTien1.setEditable(false);
		txtTongTien1.setBackground(new Color(225, 214, 196));
		txtTongTien1.setBorder(null);
		txtTongTien1.setBounds(120, 235, 200, 25);
		panel2.add(txtTongTien1);
		
		//panel 3
		panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel3.setBackground(new Color(225, 214, 196));
		panel3.setBounds(885, 330, 355, 270);
		add(panel3);
		panel3.setLayout(null);
		
		//hàng đầu
		txtSDT1 = new JTextField();
		txtSDT1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT1.setBounds(15, 40, 150, 25);
		txtSDT1.setBackground(new Color(225, 214, 196));
		panel3.add(txtSDT1);
		setPlaceholder(txtSDT1,"Nhập số điện thoại");
//		String makhachhang = txtSDT1.getText();
//		
//		KhachHang khachhang = KhachHang_DAO.getKhachHangByMaKH(makhachhang);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnTim.setBackground(new Color(79, 143, 66));
		btnTim.setBounds(180, 40, 60, 25);
		panel3.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Lấy mã khách hàng từ JTextField tại thời điểm nhấn nút
		        makhachhang = txtSDT1.getText();  // Lấy giá trị từ JTextField
		        KhachHang khachhang = KhachHang_DAO.getKhachHangByMaKH(makhachhang);  // Gọi hàm lấy thông tin khách hàng
		        
		        // Kiểm tra nếu khách hàng tồn tại thì hiển thị thông tin
		        if (khachhang != null) {
		            txtTenKH.setText(khachhang.getHoTenKH());
		            txtSDT2.setText(khachhang.getMaKH());
		            cboSex.setSelectedItem(khachhang.isGioiTinh() ? "Nam" : "Nữ"); // Hiển thị giới tính
		        } 
		        else {
		        	JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!");
		        	txtTenKH.setText("");
		            txtSDT2.setText("");
		            cboSex.getSelectedItem().equals("Nam");
		        }
		   }
		});

		// hàng 2
		txtTenKH = new JTextField("");
		txtTenKH.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenKH.setBounds(15, 80, 130, 25);
		txtTenKH.setBackground(new Color(225, 214, 196));
		panel3.add(txtTenKH);
		setPlaceholder(txtTenKH,"Tên Khách Hàng");
		
		txtSDT2 = new JTextField("");
		txtSDT2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT2.setBackground(new Color(225, 214, 196));
		txtSDT2.setBounds(150, 80, 130, 25);
		panel3.add(txtSDT2);
		setPlaceholder(txtSDT2,"SĐT Khách Hàng");
		
		String[] sex = {"Nam","Nữ"};
		cboSex = new JComboBox(sex);
		cboSex.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		cboSex.setBackground(new Color(225, 214, 196));
		cboSex.setBounds(285, 80, 65, 25);
		panel3.add(cboSex);
		
		// hàng 3
		btnHuy = new JButton("Hủy Bỏ");
		btnHuy.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnHuy.setBackground(new Color(227, 47, 47));
		btnHuy.setBounds(50, 235, 105, 30);
		panel3.add(btnHuy);
		
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.chaneToGD_phim();;
			}
		});
		
		btnDat = new JButton("Đặt Vé");
		btnDat.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDat.setBackground(new Color(53, 220, 20));
		btnDat.setBounds(205, 235, 105, 30);
		panel3.add(btnDat);
		
		btnDat.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Lấy số điện thoại
		    	String maKH = txtSDT2.getText().trim(); // Lấy số điện thoại đã nhập, và loại bỏ khoảng trắng thừa
		    	if (maKH.isEmpty() || maKH.equals("Nhập số điện thoại")) {
		    	    JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại hợp lệ.");
		    	    return;  // Dừng nếu không có giá trị hợp lệ
		    	}

		        String tenKH = txtTenKH.getText();  // Lấy tên khách hàng
		        boolean gioiTinh = cboSex.getSelectedItem().equals("Nam");  // true nếu là Nam, false nếu là Nữ

		        KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		        boolean success = khachHangDAO.saveKhachHang(maKH, tenKH, gioiTinh);

		        if (success) {
		            JOptionPane.showMessageDialog(null, "Lưu khách hàng thành công!");
		        }
		        
		        if (txtGhe.getText() == null || txtGhe.getText().trim().isEmpty() ||
		        	txtTongTien1.getText() == null || txtTongTien1.getText().trim().isEmpty() ||
		        	txtTongTien2.getText() == null || txtTongTien2.getText().trim().isEmpty() ||
		        	txtTenKH.getText() == null || txtTenKH.getText().trim().isEmpty() ||
		        	txtSDT2.getText() == null || txtSDT2.getText().trim().isEmpty() ||
		        	txtTienThua.getText() == null || txtTienThua.getText().trim().isEmpty()) {
		        	 JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");  // Thông b
		        }else {
		        	menu.changeToGD_TTHD();
		        }
		    }  
		});

		lblThanhToan = new JLabel("Thanh Toán");
		lblThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhToan.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblThanhToan.setBounds(120, 10, 135, 30);
		panel3.add(lblThanhToan);
		
		lblTongTien2 = new JLabel("Tổng tiền:");
		lblTongTien2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien2.setBounds(15, 120, 100, 25);
		panel3.add(lblTongTien2);
		
		lblTienKhachDua = new JLabel("Tiền Khách Đưa:");
		lblTienKhachDua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTienKhachDua.setBounds(15, 160, 120, 25);
		panel3.add(lblTienKhachDua);
		
		lblTienThua = new JLabel("Tiền Thừa");
		lblTienThua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTienThua.setBounds(15, 200, 100, 25);
		panel3.add(lblTienThua);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTienKhachDua.setBounds(135, 160, 200, 25);
		txtTienKhachDua.setBackground(new Color(225, 214, 196));
		panel3.add(txtTienKhachDua);
		
		txtTongTien2 = new JTextField();
		txtTongTien2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien2.setBackground(new Color(225, 214 ,196));
		txtTongTien2.setBorder(null);
		txtTongTien2.setEditable(false);
		txtTongTien2.setBounds(135, 120, 200, 25);
		panel3.add(txtTongTien2);
		
		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTienThua.setBackground(new Color(225, 214 ,196));
		txtTienThua.setBorder(null);
		txtTienThua.setEditable(false);
		txtTienThua.setBounds(135, 200, 200, 25);
		txtTienThua.setBorder(null);
		panel3.add(txtTienThua);
		
		JButton[] danhsachnutButton = {
				btnA01,btnA02,btnA03,btnA04,btnA05,btnA06,btnA07,btnA08,btnA09,btnA10,
				btnB01,btnB02,btnB03,btnB04,btnB05,btnB06,btnB07,btnB08,btnB09,btnB10,
				btnC01,btnC02,btnC03,btnC04,btnC05,btnC06,btnC07,btnC08,btnC09,btnC10,
				btnD01,btnD02,btnD03,btnD04,btnD05,btnD06,btnD07,btnD08,btnD09,btnD10,
				btnE01,btnE02,btnE03,btnE04,btnE05,btnE06,btnE07,btnE08,btnE09,btnE10};
		for(int i= 0; i<danhsachghe.size();i++) {
			Ghe ghe = danhsachghe.get(i); // Lấy thông tin từng ghế
			if(ghe.isTrangThai()==false){
				danhsachnutButton[i].setText(ghe.getSoGhe()); 
				danhsachnutButton[i].setBackground(new Color(227, 47 ,47));
				danhsachnutButton[i].setEnabled(true); // Bật nút để người dùng có thể chọn
			} else {
				danhsachnutButton[i].setText(ghe.getSoGhe());
		        danhsachnutButton[i].setEnabled(false);
		        danhsachnutButton[i].setBackground(new Color(113, 101, 101));
			}
		   
		}
		
		//khởi tạo danh sách để lưu ghế
		selectedSeats = new ArrayList<>();
		
		
		for(JButton button : danhsachnutButton) {
			
			button.addActionListener(new ActionListener() {
				private boolean isSelected = false; //trang thai nut
				@Override
				public void actionPerformed(ActionEvent e) {
					seatName = button.getText(); // lấy tên ghế
					
					if (!isSelected) {
                        button.setBackground(new Color(226, 194, 112)); // Đổi màu khi chọn
                        selectedSeats.add(seatName); // thêm ghế vào danh sách
                        Count++;
                    } else {
                        button.setBackground(new Color(227, 47 ,47)); // Trả về màu gốc
                        selectedSeats.remove(seatName); //xóa ghế khỏi danh sách
                        Count--;
                    }
                    isSelected = !isSelected; // Đảo trạng thái
                    
                    //Cập nhật Textfield ghế
                    txtGhe.setText(String.join(",", selectedSeats));
                    gia = Count * Price;
                    txtTongTien1.setText(Double.toString(gia));
                    txtTongTien2.setText(Double.toString(gia));
                    
				}
			});
		}
		txtTienKhachDua.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TinhTienKhachDua();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TinhTienKhachDua();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				TinhTienKhachDua();
			}
			
			//hàm tính số tiền còn lại
			private void TinhTienKhachDua() {
				 String inputText = txtTienKhachDua.getText().trim(); 
				 // Kiểm tra xem văn bản có phải là số hợp lệ không
				 if (inputText.isEmpty()) {
	                    txtTienThua.setText("");  // Nếu rỗng, không hiển thị gì
	                    return;
	             }
				 try {
					// Kiểm tra nếu chuỗi là một số hợp lệ
	                double inputAmount = Double.parseDouble(inputText);
	                
					// tính số tiền còn lại
					remainAmount = inputAmount - gia;
					
					// Hiển thị kết quả trong JTextField kết quả với 2 chữ số thập phân
                    txtTienThua.setText(String.format("%.2f", remainAmount)); 
				 } catch(Exception e) {
					 JOptionPane.showMessageDialog(null, "Nhập sai! Vui lòng nhập lại");
				 	}
				}
			});
	}


	// Hàm setPlaceholder cho JTextField
    public static void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
    public String returnMaKH() {
    	return makhachhang;
    }
    public Phim returnPhim() {
    	return phimduocchon;
    }
    public Double returnPrice() {
    	return gia;
    }
    public String returnGhe() {
        String gheDaChon = String.join(", ", selectedSeats);  // Tạo chuỗi từ danh sách ghế
        return gheDaChon;  // Trả về chuỗi
    }
    public ArrayList<String> getSelectedSeats() {
        return selectedSeats;
    }
}
