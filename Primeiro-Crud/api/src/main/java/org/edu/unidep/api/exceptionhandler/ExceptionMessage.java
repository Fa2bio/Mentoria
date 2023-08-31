package org.edu.unidep.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.Set;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ExceptionMessage {

	@Schema(description = "Timestamp",example = "2023-08-30T17:23:12.168518997")
	private LocalDateTime timeStamp;
	
	@Schema(description = "Type",example = "ClienteNaoEncontradoException")
	private String type;
	
	@Schema(description = "User Message",example = "Não foi possível encontrar o cliente de id 1")
	private String userMessage;
	
	@Schema(description = "fieldErrors")
	private Set<FieldError> fieldErrors;
	
	public static class FieldError{
		
		@Schema(description = "Name Field", example = "cpf")
		private String nameField;
		
		@Schema(description = "fieldErrors", example = "O CPF Informado Deve Ser Válido De Acordo Com As Normas Da Receita Federal Brasileira")
		private String userMessage;
		
		public FieldError(String nameField, String userMessage) {
			this.nameField = nameField;
			this.userMessage = userMessage;
		}

		public String getNameField() {
			return nameField;
		}

		public void setNameField(String nameField) {
			this.nameField = nameField;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}
		
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Set<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Set<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
