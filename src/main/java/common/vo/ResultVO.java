package common.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResultVO <T> extends AbstractVO {

	/* 결과코드 */
	private int resultCode = 1;
	/* 결과문자 */
	private String resultStr;
	/* 에러문자 */
	private int errorCode = 1;
	/* 에러문자 */
	private String errorStr = "성공";
	/* 데이터 */
	private Object data;
	/* 데이터리스트 */
	private List<T> dataList = new ArrayList<T>();
	
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
		if(0 < errorCode) {
			errorStr = "성공";
		} else if(0 > errorCode) {
			errorStr = "실패";
		}
		return errorStr;
	}
	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList.addAll(dataList);
	}
}
