package com.traview.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traview.vo.PostVO;

import common.vo.ResultVO;

@Controller
public class PostController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private PostService postService;

	@ResponseBody 
	@RequestMapping(value = "/post/insertPost", method = RequestMethod.POST)
	public ResultVO<PostVO> post_insertPost(@RequestBody PostVO postVO, HttpServletRequest req, HttpServletResponse res) {

		ResultVO<PostVO> resultVO = new ResultVO<PostVO>();
		try {
			resultVO.setErrorCode(postService.insertPost(postVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}
	
	@ResponseBody 
	@RequestMapping(value = "/post/updatePost", method = RequestMethod.POST)
	public ResultVO<PostVO> post_updatePost(@RequestBody PostVO postVO, HttpServletRequest req, HttpServletResponse res) {

		ResultVO<PostVO> resultVO = new ResultVO<PostVO>();
		try {
			resultVO.setErrorCode(postService.updatePost(postVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}
	
	@ResponseBody 
	@RequestMapping(value = "/post/deletePost", method = RequestMethod.POST)
	public ResultVO<PostVO> post_deletePost(@RequestBody PostVO postVO, HttpServletRequest req, HttpServletResponse res) {

		ResultVO<PostVO> resultVO = new ResultVO<PostVO>();
		try {
			resultVO.setErrorCode(postService.deletePost(postVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/post/selectPost", method = RequestMethod.POST)
	public ResultVO<PostVO> post_selectPost(@RequestBody PostVO postVO, HttpServletRequest req, HttpServletResponse res) {

		ResultVO<PostVO> resultVO = new ResultVO<PostVO>();
		try {
			resultVO.setData(postService.selectPost(postVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/post/selectPostList", method = RequestMethod.POST)
	public ResultVO<PostVO> post_selectPostList(@RequestBody PostVO postVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(postVO.toString());
		ResultVO<PostVO> resultVO = new ResultVO<PostVO>();
		try {
			resultVO.setDataList(postService.selectPostList(postVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}
	
}
