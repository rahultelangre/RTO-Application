package com.rto.resources.rest.ExceptionHandler;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * this class is used to provide error response when the Exception occured in rest api
 * @author SatishKumar
 *
 */

@XmlRootElement(name = "api-erorr")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiError {

	@XmlElement(name="error-code")
	private Integer errorCode;
	@XmlElement(name="error-msg")
	private String errorMsg;
	private Date date;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
