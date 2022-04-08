package com.traview.vo;

import org.springframework.stereotype.Component;

import common.vo.AbstractVO;

@Component
public class UserVO extends AbstractVO {
	
	/* ID */
	private String userId;
	/* password */
	private String userPw;
	/* 이름 */
	private String userNm;
	/* 별명 */
	private String nickname;
	/* 생일 8글자 */
	private String birthday;
	/* 성별 */
	private String gender;
	/* 이메일 */
	private String email;
	/* 휴대번호 */
	private String phone;
	/* 생성일 */
	private String createDate;
	/* 수정일 */
	private String updateDate;
	/* 사용여부 */
	private String useYn;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}
