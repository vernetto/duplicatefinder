package org.pierre.duplicatefinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScanItem {
	String filename;
	long size;
	String md5;
	long touchdate;

	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public long getTouchdate() {
		return touchdate;
	}
	@Override
	public String toString() {
		return "ScanItem [filename=" + filename + ", size=" + size + ", md5=" + md5 + ", touchdate=" + getTouchdateAsString() + "]";
	}
	public void setTouchdate(long touchdate) {
		this.touchdate = touchdate;
	}
	
	public String getTouchdateAsString() {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(getTouchdate());
		return format.format(date);
	}
}
