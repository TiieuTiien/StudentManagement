package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField jTextFieldMaThiSinhTimKiem;
	private JTable table;
	public JTextField textFieldMaTS;
	public JTextField textFieldHoTen;
	public JTextField textFieldNgaySinh;
	public JTextField textFieldMon1;
	public JTextField textFieldMon2;
	public JTextField textFieldMon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox jComboBoxQueQuan;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public JComboBox jComboBoxTim;
	public JLabel jLabelMaThiSinhTimKiem;
	public SimpleDateFormat DateFor =  new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);

		ActionListener action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setForeground(Color.BLACK);
		menuFile.addActionListener(action);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setForeground(Color.BLACK);
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me...");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelQueQuan = new JLabel("Quê quán");
		jLabelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelQueQuan.setBounds(10, 11, 64, 20);
		contentPane.add(jLabelQueQuan);

		jTextFieldMaThiSinhTimKiem = new JTextField();
		jTextFieldMaThiSinhTimKiem.setColumns(10);
		jTextFieldMaThiSinhTimKiem.setBounds(300, 12, 140, 20);
		contentPane.add(jTextFieldMaThiSinhTimKiem);

		JButton jButtonTim = new JButton("Tìm");
		jButtonTim.addActionListener(action);
		jButtonTim.setBounds(455, 12, 75, 20);
		contentPane.add(jButtonTim);

		JButton jButtonHuyTim = new JButton("Huỷ tìm");
		jButtonHuyTim.addActionListener(action);
		jButtonHuyTim.setBounds(540, 12, 75, 20);
		contentPane.add(jButtonHuyTim);

		jComboBoxTim = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDST();
		jComboBoxTim.addItem("");
		for (Tinh tinh : listTinh) {
			jComboBoxTim.addItem(tinh.getTenTinh());
		}
		jComboBoxTim.setBounds(84, 12, 140, 20);
		contentPane.add(jComboBoxTim);

		JSeparator sprt1 = new JSeparator();
		sprt1.setBounds(10, 50, 600, 2);
		contentPane.add(sprt1);

		JLabel jLabelDanhSachThiSinh = new JLabel("Danh sách thí sinh");
		jLabelDanhSachThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelDanhSachThiSinh.setBounds(10, 60, 104, 20);
		contentPane.add(jLabelDanhSachThiSinh);

		jLabelMaThiSinhTimKiem = new JLabel("Mã thí sinh");
		jLabelMaThiSinhTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelMaThiSinhTimKiem.setBounds(234, 11, 66, 20);
		contentPane.add(jLabelMaThiSinhTimKiem);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));

		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 91, 600, 120);
		contentPane.add(scrollPane);

		JSeparator sprt2 = new JSeparator();
		sprt2.setBounds(10, 222, 600, 2);
		contentPane.add(sprt2);

		JLabel jLabelThongTinThiSinh = new JLabel("Thông tin thí sinh");
		jLabelThongTinThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelThongTinThiSinh.setBounds(10, 235, 104, 20);
		contentPane.add(jLabelThongTinThiSinh);

		JLabel jLabelMaThiSinh = new JLabel("Mã thí sinh:");
		jLabelMaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelMaThiSinh.setBounds(10, 266, 75, 20);
		contentPane.add(jLabelMaThiSinh);

		JLabel jLabelHoVaTen = new JLabel("Họ và tên:");
		jLabelHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelHoVaTen.setBounds(10, 297, 75, 20);
		contentPane.add(jLabelHoVaTen);

		JLabel jLableQueQuan = new JLabel("Quê quán:");
		jLableQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLableQueQuan.setBounds(10, 328, 75, 20);
		contentPane.add(jLableQueQuan);

		JLabel jLabelNgaySinh = new JLabel("Ngày sinh:");
		jLabelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelNgaySinh.setBounds(10, 359, 75, 20);
		contentPane.add(jLabelNgaySinh);

		JLabel jLabelMon1 = new JLabel("Môn 1");
		jLabelMon1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelMon1.setBounds(290, 266, 75, 20);
		contentPane.add(jLabelMon1);

		JLabel jLabelMon2 = new JLabel("Môn 2");
		jLabelMon2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelMon2.setBounds(290, 297, 75, 20);
		contentPane.add(jLabelMon2);

		JLabel jLabelMon3 = new JLabel("Môn 3");
		jLabelMon3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelMon3.setBounds(290, 328, 75, 20);
		contentPane.add(jLabelMon3);

		jComboBoxQueQuan = new JComboBox();
		jComboBoxQueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			jComboBoxQueQuan.addItem(tinh.getTenTinh());
		}
		jComboBoxQueQuan.setBounds(95, 329, 140, 20);
		contentPane.add(jComboBoxQueQuan);

		JLabel jLabelGioiTnh = new JLabel("Giới tính:");
		jLabelGioiTnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelGioiTnh.setBounds(290, 359, 75, 20);
		contentPane.add(jLabelGioiTnh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(375, 359, 50, 23);
		contentPane.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(445, 359, 50, 23);
		contentPane.add(rdbtnNu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtnNam);
		btn_gioiTinh.add(rdbtnNu);

		JButton jButtonThem = new JButton("Thêm");
		jButtonThem.addActionListener(action);
		jButtonThem.setBounds(10, 403, 90, 20);
		contentPane.add(jButtonThem);

		JButton jButtonXoa = new JButton("Xoá");
		jButtonXoa.addActionListener(action);
		jButtonXoa.setBounds(110, 403, 90, 20);
		contentPane.add(jButtonXoa);

		JButton jButtonCapNhat = new JButton("Cập nhật");
		jButtonCapNhat.addActionListener(action);
		jButtonCapNhat.setBounds(210, 403, 90, 20);
		contentPane.add(jButtonCapNhat);

		JButton jButtonLuu = new JButton("Lưu");
		jButtonLuu.addActionListener(action);
		jButtonLuu.setBounds(425, 403, 90, 20);
		contentPane.add(jButtonLuu);

		JButton jButtonHuyBo = new JButton("Huỷ bỏ");
		jButtonHuyBo.addActionListener(action);
		jButtonHuyBo.setBounds(525, 403, 90, 20);
		contentPane.add(jButtonHuyBo);

		JSeparator sprt3 = new JSeparator();
		sprt3.setBounds(10, 390, 600, 2);
		contentPane.add(sprt3);

		textFieldMaTS = new JTextField();
		textFieldMaTS.setColumns(10);
		textFieldMaTS.setBounds(95, 266, 140, 20);
		contentPane.add(textFieldMaTS);

		textFieldHoTen = new JTextField();
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBounds(95, 298, 140, 20);
		contentPane.add(textFieldHoTen);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(95, 360, 140, 20);
		contentPane.add(textFieldNgaySinh);

		textFieldMon1 = new JTextField();
		textFieldMon1.setColumns(10);
		textFieldMon1.setBounds(375, 267, 140, 20);
		contentPane.add(textFieldMon1);

		textFieldMon2 = new JTextField();
		textFieldMon2.setColumns(10);
		textFieldMon2.setBounds(375, 298, 140, 20);
		contentPane.add(textFieldMon2);

		textFieldMon3 = new JTextField();
		textFieldMon3.setColumns(10);
		textFieldMon3.setBounds(375, 329, 140, 20);
		contentPane.add(textFieldMon3);
		this.setVisible(true);
	}

	public void xoaForm() {
		textFieldMaTS.setText("");
		textFieldHoTen.setText("");
		textFieldNgaySinh.setText("");
		textFieldMon1.setText("");
		textFieldMon2.setText("");
		textFieldMon3.setText("");
		jComboBoxQueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		model_table.addRow(new Object[] { 
				ts.getMaThiSinh() + "", 
				ts.getTenThiSinh(), 
				ts.getQueQuan().getTenTinh(),
				DateFor.format(ts.getNgaySinh()), 
				(ts.isGioiTinh() ? "Nam" : "Nữ"), 
				ts.getDiemMon1() + "",
				ts.getDiemMon2() + "", 
				ts.getDiemMon3() + "" }
		);
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(DateFor.format(ts.getNgaySinh()) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		// Lay du lieu
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByName(model_table.getValueAt(i_row, 2) + "");
		Date ngaySinh = new Date(model_table.getValueAt(i_row, 3) + "");
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textFieldMaTS.setText(ts.getMaThiSinh() + "");
		this.textFieldHoTen.setText(ts.getTenThiSinh() + "");
		this.jComboBoxQueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		this.textFieldNgaySinh.setText(DateFor.format(ts.getNgaySinh()));
		if (ts.isGioiTinh()) {
			rdbtnNam.setSelected(true);
		} else {
			rdbtnNu.setSelected(true);
		}
		this.textFieldMon1.setText(ts.getDiemMon1() + "");
		this.textFieldMon2.setText(ts.getDiemMon2() + "");
		this.textFieldMon3.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.remove(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThem() {
		// Lay du lieu
		int maThiSinh = Integer.valueOf(this.textFieldMaTS.getText());
		String tenThiSinh = this.textFieldHoTen.getText();
		int queQuan = this.jComboBoxQueQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textFieldNgaySinh.getText());
		boolean gioiTinh = true;
		if (this.rdbtnNam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtnNu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textFieldMon1.getText());
		float diemMon2 = Float.valueOf(this.textFieldMon2.getText());
		float diemMon3 = Float.valueOf(this.textFieldMon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);

	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		// Thuc hien tim kiem
		int queQuan = this.jComboBoxTim.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.jTextFieldMaThiSinhTimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0) {
				break;
			}else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0", "About me...", JOptionPane.PLAIN_MESSAGE);
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this, 
				"Bạn có chắc chắn thoát khỏi chương trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	
	public void saveFile(String filePath) {
		try {
			this.model.setTenFile(filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		
	}
	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}
}



