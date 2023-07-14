package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	public QLSVView view;

	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+actionCommand);
		if(actionCommand.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}else if(actionCommand.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(actionCommand.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
			this.view.model.setLuaChon("Thêm");
		}else if(actionCommand.equals("Xoá")) {
			this.view.thucHienXoa();
		}else if(actionCommand.equals("Huỷ bỏ")) {
			this.view.xoaForm();
		}else if(actionCommand.equals("Tìm")) {
			this.view.thucHienTim();
		}else if(actionCommand.equals("Huỷ tìm")) {
			this.view.thucHienTaiLaiDuLieu();
		}else if(actionCommand.equals("About me...")) {
			this.view.hienThiAbout();
		}else if(actionCommand.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if(actionCommand.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(actionCommand.equals("Open")) {
			this.view.thucHienOpenFile();
		}
	}

}
