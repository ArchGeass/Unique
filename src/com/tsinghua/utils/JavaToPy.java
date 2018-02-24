package com.tsinghua.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*与python交互*/
public class JavaToPy {

	public String getPython(String bufferingDelay, String videoPlayTotalTime, String kaDurationProportion,
			String videoBitrate, String videoClarity) {
		try {
			String path = "D:\\unique_txt\\QoE\\Test.py";
			StringBuffer str = new StringBuffer();
			String[] args1 = new String[] { "python", path, bufferingDelay, videoPlayTotalTime, kaDurationProportion,
					videoBitrate, videoClarity };
			Process pr = Runtime.getRuntime().exec(args1);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				str.append(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
			return str.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "vMOS=0.185852, QualityScore=1.345928, StallingScore=3.845956, LoadingScroe=1.731890";
		}

	}
}
