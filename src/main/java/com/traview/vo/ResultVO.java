package com.traview.vo;

import org.springframework.stereotype.Component;

@Component
public class ResultVO {

	/* 결과코드 */
	private int resultCode;
	/* 결과문자 */
	private String resultStr;
	/* 에러문자 */
	private int errorCode;
	/* 에러문자 */
	private String errorStr;
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorStr() {
		return errorStr;
	}
	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}
}
