package com.traview.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traview.vo.PostVO;

@Service("PostService")
public class PostService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    protected PostDAO postDAO;

	public int insertPost(PostVO postVO) throws Exception {
		return postDAO.insertPost(postVO);
	}
	
	public int updatePost(PostVO postVO) throws Exception {
		return postDAO.updatePost(postVO);
	}
	
	public int deletePost(PostVO postVO) throws Exception {
		return postDAO.deletePost(postVO);
	}
	
	public PostVO selectPost(PostVO postVO) throws Exception {
		return postDAO.selectPost(postVO);
	}
	
	public List<PostVO> selectPostList(PostVO PostVO) throws Exception {
		return postDAO.selectPostList(PostVO);
	}
}
