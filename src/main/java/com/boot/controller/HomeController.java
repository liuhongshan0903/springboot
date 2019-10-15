package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.boot.bean.BmsUser;

/**
 * 测试三种不同的resful风格传参方式
 * @author liuhs
 *
 */
@Controller
public class HomeController {
	
	   @Autowired  
	   private String hello; 
	
	/**
	 * boot采用DTO传参测试
	 * @RequestBody 接收对象  返回对象
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/resful")
	public BmsUser testResful(@RequestBody BmsUser dto ){
		String id = dto.getId();
		System.out.println("resful====="+id);
		System.out.println("hello====="+hello);
		
		/*TO  DO QUERY	*/
		BmsUser retDto = new BmsUser();
		retDto.setId(id);
		retDto.setApplyid(hello);
		return retDto;
	}
	
	
	
	
	/**
	 * boot采用PathVariable传参测试
	 * @PathVariable  风格 防止sql注入
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/res/{param}")
	public ModelAndView testResful(@PathVariable  String param){
		ModelAndView view  = new ModelAndView("jsonView");
		System.out.println("resful====="+param);
		view.addObject("result","success");
		return view;
	}
	

	/**
	 * boot采用servlet传统传参测试
	 * @param req
	 * @param res
	 * @param idNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/home")
	public ModelAndView home(@RequestParam(value = "id", required = false) String id ){
		ModelAndView view  = new ModelAndView("jsonView");
		System.out.println("RequestParam====="+id);
		view.addObject("result","success");
		return view;
		
	}
	
}
