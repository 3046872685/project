package com.accp.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.DztableMapper;
import com.accp.dao.UsersMapper;
import com.accp.domain.Dztable;
import com.accp.domain.DztableExample;
import com.accp.domain.Users;
import com.accp.domain.UsersExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TbbillService {
	@Autowired
	UsersMapper mapperuser=null;
	@Autowired
	DztableMapper mapperdz=null;
	//id查询用户信息
	public Users findByid(Integer id) {
		DztableExample ex=new DztableExample();
		ex.createCriteria().andUseridEqualTo(id);
		Users user = mapperuser.selectByPrimaryKey(id);
		user.setList(mapperdz.selectByExample(ex));
		List<Dztable> list = mapperdz.selectByExample(null);
		for (Dztable item : list) {
			user.setDz(list.get(list.size()-1));
		}
		return user;
	}
	//用户修改
	public Integer updateUser(Users user) {
		return mapperuser.updateByPrimaryKeySelective(user);
	}
	//用户新增 并新增地址
	public Integer userInsers(Users user) {
		List<Users> listu=mapperuser.selectByExample(null);
		int iok=0;
		for (Users item : listu) {
			System.out.println("原："+item.getId());
			System.out.println("页："+user.getId());
			Integer a= item.getId();
			Integer b=user.getId();
			if(a==b||a.toString().equals(b.toString())) {
				iok=1;
			}
		}
		System.out.println("iok="+iok);
		if(iok==1) {
			return this.updateUser(user);
		}else{
			Integer ujg=mapperuser.insertSelective(user);
			if(ujg>0) {
				for (Dztable item : user.getList()) {
					item.setUserid(user.getId());
					mapperdz.insertSelective(item);
					mapperdz.insertSelective(user.getDz());
				}
			}
		}
		
		return 1;
	}
	//修改 新增 地址时 找到时为修改  未找到时为新增
	public Integer inupdz(Users user) {
		Dztable dz = user.getDz();
		boolean pd=false;
		for (Dztable item : user.getList()) {
			if(item.getDzid().toString().equals(dz.getDzid().toString())) {
				pd=true;
			}
		}
		if(pd) {
			//修改
			return  mapperdz.insertSelective(dz);
		}
		return mapperdz.insertSelective(dz);
	}
	//查询地址
	public Dztable findByDz() {
		List<Dztable> list=mapperdz.selectByExample(null);
		return list.get(list.size()-1);
	}
	
}
