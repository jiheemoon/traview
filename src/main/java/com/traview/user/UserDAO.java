package com.traview.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traview.vo.UserVO;

@Repository
public class UserDAO {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.traview.user.";
	
	public int insertUser(UserVO userVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertUser", userVO);
	}

	public int updateUser(UserVO userVO) {
		return sqlSession.update(NAMESPACE + "updateUser", userVO);
	}

	public int deleteUser(UserVO userVO) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteUser", userVO);
	}
	
	public UserVO selectUser(UserVO userVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectUser", userVO);
	}

	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectUserList", userVO);
	}

	
}
