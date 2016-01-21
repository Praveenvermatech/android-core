package com.ncr.dna.bean;

public class NewsDetails {

	private int imageId;
    private String title;
    private String desc;
    private String imageDesc;
       
    public NewsDetails(int imageId, String title, String desc, String imageDesc) {
		super();
		this.imageId = imageId;
		this.title = title;
		this.desc = desc;
		this.imageDesc=imageDesc;
	}
	public String getImageDesc() {
		return imageDesc;
	}
	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}
	public int getImageId() {
		return imageId;
	}
	public String getTitle() {
		return title;
	}
	public String getDesc() {
		return desc;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "NewsDetails [title=" + title
				+ ", desc=" + desc + "]";
	}
}
