package com.traview.vo;

import org.springframework.stereotype.Component;

@Component
public class ResultVO {

	/* 결과코드 */
	private String resultCode;
	/* 결과문자 */
	private String resultStr;
	/* 에러문자 */
	private String errorCode;
	/* 에러문자 */
	private String errorStr;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorStr() {
		return errorStr;
	}
	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}
}
