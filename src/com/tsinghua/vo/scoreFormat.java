package com.tsinghua.vo;

public class scoreFormat {

	public static String vMOSFormat(String vMos){
		Double score = Double.valueOf(vMos);
		if (score < 1) {
			return "1";
		}
		if (score > 5) {
			return "5";
		}
		return score.toString();
	}
}
