package cn.zjs.bwcx.daoImpl;

import cn.zjs.bwcx.dao.CalculateLog;

public class CalculateLogImpl implements CalculateLog {

	@Override
	public int add(int i, int j) {
		return i + j;
	} 

	@Override
	public int sub(int i, int j) {
		return i-j;
	}

	@Override
	public int mul(int i, int j) {
		return i*j;
	}



	@Override
	public int div(int i, int j) {
		return i/j;
	}

}
