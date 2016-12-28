package com.ipcalculator;

public class Convertor {

	public Convertor() {
	}
	
	public long decMaskToLong(int mask){
		long bits = 0;
		bits = 0xffffffff ^ (1 << 32 - mask) - 1;
		return bits;
	}
	
	public String decMaskToSubnet(int mask){
		long bits = decMaskToLong(mask);
		String subnetMask = String.format("%d.%d.%d.%d", (bits & 0x0000000000ff000000L) >> 24,
				(bits & 0x0000000000ff0000) >> 16,
				(bits & 0x0000000000ff00) >> 8,
				bits & 0xff);
		return subnetMask;
	}

}
