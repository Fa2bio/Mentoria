package org.edu.unidep.api.dto.modelmapper.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResumoResponse {
	
	@JsonProperty("volumeInfo")
	private VolumeInfoResumoResponse volumeInfo;

	public VolumeInfoResumoResponse getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(VolumeInfoResumoResponse volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
}
