package org.edu.unidep.api.dto.modelmapper.model;

public class LivroResumoModel {

	private String isbn;
	private VolumeInfoModel volumeInfo;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public VolumeInfoModel getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(VolumeInfoModel volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
}
