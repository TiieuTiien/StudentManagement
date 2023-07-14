package model;

import java.util.ArrayList;
import java.util.Arrays;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	
	public void remove(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		int i;
		for(i = 0; i < this.dsThiSinh.size(); i++) {
			if(this.dsThiSinh.get(i).getMaThiSinh() == thiSinh.getMaThiSinh()){
				this.dsThiSinh.remove(i);
				break;
			}
		}
		this.dsThiSinh.add(i, thiSinh);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh())
				return true;
		}
		return false;
	}
}
