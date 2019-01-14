package cn.zjs.bwcx.daoImpl;

import cn.zjs.bwcx.dao.Sell;

public class Vendor implements Sell{

	@Override
	public void sell() {
		System.out.println("In sell method"); 
	}

	@Override
	public void ad() {
		System.out.println("ad method");
	}
	
}
