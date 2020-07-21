package com.accp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Dztable;
import com.accp.domain.Users;
import com.accp.service.TbbillService;

@Controller
@RequestMapping("/TbbillController")
public class TbbillController {
	
	@Autowired
	TbbillService service=null;
	//id查询用户信息
	@RequestMapping("/findByid")
	@ResponseBody
	public Users findByid(Integer id) {
		return service.findByid(id);
	}
	//用户修改
	@RequestMapping("/updateUser")
	@ResponseBody
	public Integer updateUser(@RequestBody Users user) {
		return service.updateUser(user);
	}

	//用户新增 并新增地址
	@RequestMapping("/userInsers")
	@ResponseBody
	public Integer userInsers(@RequestBody Users user) {
		return service.userInsers(user);
	}
	//修改 新增 地址时 找到时为修改  未找到时为新增
	@RequestMapping("/inupdz")
	@ResponseBody
	public Integer inupdz(@RequestBody Users user) {
		return service.inupdz(user);
	}
	//进入页面
	@RequestMapping("/doindex")
	public String doindex() {
		return "create";
	}
	//查询地址
	@RequestMapping("/findByDz")
	@ResponseBody
	public Dztable findByDz() {
		return service.findByDz();
	}
}
