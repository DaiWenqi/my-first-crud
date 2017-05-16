package com.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dao.UserDao;
import com.springmvc.entities.User;
import com.springmvc.service.UserService;


@Controller
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/** 
	    * @Title: addPage 
	    * @Description: 用户添加页面 
	    * @param mm 
	    * @return    参数 
	    */ 
	@RequestMapping(value="/addpage")
	public String addUser(ModelMap mm){
		logger.error("ddddddddddd");
		logger.info("2222");
		logger.warn("3333");
		return "/Register";
	}
	
	/** 
	    * @Title: Regiseter 
	    * @Description: 用户添加操作 
	    * @param request 
	    * @param response 
	    * @param user 
	    * @throws IOException 
	    * @throws ServletException    参数 
	    */
	@RequestMapping(value="register")
	public void Register (HttpServletRequest request,HttpServletResponse response,User user)throws IOException, ServletException{
		int result = 0;
		if(user != null){
			result = userService.addUser(user);
		}
		
		if (result >0) 
        { 
            logger.info("注册成功..");
            response.sendRedirect(request.getContextPath()+"/allUser");
        } else{
        	logger.error("注册失败");
        }
	}
	
	/** 
	    * @Title: listUser 
	    * @Description: 列表显示所有用户 
	    * @param mm 
	    * @return    参数 
	    */ 
	@RequestMapping("/allUser")
	public String listUser(ModelMap mm) {
		List<User> list = userService.getUserList();
		mm.put("list", list);
		return "/UserList";
	}
	/**
	* @Title: updateUser 
    * @Description: 更新用户信息 
    * @param request 
    * @param response 
    * @param user 
    * @throws Exception    参数 
    */
	@RequestMapping("/updateUser")
	public void updateUser(HttpServletRequest request,HttpServletResponse response,User user)throws Exception{
		int result = userService.updateUser(user);
		if(result > 0){
			logger.info("更新用户数据成功");
			response.sendRedirect(request.getContextPath()+"/allUser");
		}else{
			logger.error("更新数据失败");
		}
	}
	
	/** 
	    * @Title: editUser 
	    * @Description: 用户信息编辑页面 
	    * @param id 
	    * @param mm 
	    * @return    参数 
	    */ 
	    @RequestMapping("editUser")
	    public String editUser(String id, ModelMap mm) 
	    { 
	        User user = userService.getUser(Integer.parseInt(id)); 
	        mm.put("user", user);
	        return "/Register";
	    }
	
	/** 
	    * @Title: deleteUserById 
	    * @Description: 删除一条用户记录 
	    * @param request 
	    * @param response 
	    * @param id 
	    * @throws Exception    参数 
	    */ 
	@RequestMapping("deleteUser")
    public void deleteUserById(HttpServletRequest request, HttpServletResponse response,String id) throws Exception 
    { 
        int result = userService.deleteUser(Integer.parseInt(id));
        if (result >0) 
        { 
            logger.info("删除用户数据成功..");
            response.sendRedirect(request.getContextPath()+"/allUser");

        } 
        else
        { 
            logger.error("删除用户数据失败..");
            request.getRequestDispatcher("/500").forward(request, response);

        } 
    }
}
