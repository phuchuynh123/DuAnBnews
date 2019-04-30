package model.bean;

import java.sql.Timestamp;

public class News {
     private int id;
     private String Name;
     private String Preview;
     private String Detail;
     private int catid;
     private String picture;
     private String namec;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public String getPreview() {
		return Preview;
	}
	public void setPreview(String preview) {
		Preview = preview;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public int getCatid() {
		return catid;
	}
	public void setCat_id(int cat_id) {
		this.catid = catid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getNamec() {
		return namec;
	}
	public void setNamec(String namec) {
		this.namec = namec;
	}
	public News() {
		super();
	}
	public News(int id, String name, String preview, String detail, int cat_id, String picture,String namec) {
		super();
		this.id = id;
		Name = name;
		Preview = preview;
		Detail = detail;
		this.catid = catid;
		this.picture = picture;
		this.namec=namec;
	}
}
