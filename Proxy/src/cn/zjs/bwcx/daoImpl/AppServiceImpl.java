package cn.zjs.bwcx.daoImpl;

import cn.zjs.bwcx.dao.AppService;

public class AppServiceImpl implements AppService{

	@Override
	public boolean createApp(String name) {
		System.out.println("App["+name+"] has been created."); 
		return true;
	}
}
