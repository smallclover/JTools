package cn.jtools.db;

import java.util.ArrayList;

public class Test_DB {
	
	public static void main(String[] args) {
		ParseConfig pc = new ParseConfig();
		ArrayList<ConnectionParam> list =  pc.readConfig();
		ConnectionParam cp = list.get(0);
		System.out.println(cp.getDriver());
		System.out.println(cp.getType());
	}
}
