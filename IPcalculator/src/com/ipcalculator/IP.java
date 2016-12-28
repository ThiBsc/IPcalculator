package com.ipcalculator;

public class IP {
	
	private String strIP;
	private String[] valIP;
	private Convertor convertor;

	public IP(String ip) {
		strIP = ip;
		valIP = strIP.split(".");
		convertor = new Convertor();
	}
	
	public String decMaskToIpForm(int mask){
		return convertor.decMaskToSubnet(mask);
	}

}
