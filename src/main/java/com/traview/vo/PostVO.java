package com.traview.vo;

import org.springframework.stereotype.Component;

import common.vo.AbstractVO;

@Component
public class PostVO extends AbstractVO {
	
	/* 게시글 고유번호 */
	private int postSeq;
	/* 게시글 분류ID */
	private int postInfoId;
	/* 게시글 제목 */
	private String postTitle;
	/* 게시글 내용 */
	private String postContents;
	/* 게시글 설명 */
	private String postDescription;
	/* 공지글 여부 */
	private String isMain;
	/* 생성일 */
	private String createDate;
	/* 생성자 */
	private String createUser;
	/* 수정일 */
	private String updateDate;
	/* 수정자 */
	private String updateUser;
	/* 사용여부 */
	private String useYn;
	
	public int getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}
	public int getPostInfoId() {
		return postInfoId;
	}
	public void setPostInfoId(int postInfoId) {
		this.postInfoId = postInfoId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}
