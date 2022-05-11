package com.traview.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traview.vo.PostVO;

@Repository
public class PostDAO {
	
	protected  Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.traview.post.";
	
	public int insertPost(PostVO PostVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertPost", PostVO);
	}

	public int updatePost(PostVO PostVO) {
		return sqlSession.update(NAMESPACE + "updatePost", PostVO);
	}

	public int deletePost(PostVO PostVO) throws Exception {
		return sqlSession.delete(NAMESPACE + "deletePost", PostVO);
	}
	
	public PostVO selectPost(PostVO PostVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectPost", PostVO);
	}

	public List<PostVO> selectPostList(PostVO PostVO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectPostList", PostVO);
	}
	
}
