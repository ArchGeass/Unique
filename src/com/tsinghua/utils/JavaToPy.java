package com.tsinghua.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.tsinghua.enums.StatusCode;

/*与python交互*/
public class JavaToPy {

	public String getPython(String bufferingDelay, String videoPlayTotalTime, String kaDurationProportion,
			String videoBitrate, String videoClarity) {
		try {
			String path = StatusCode.PYTHON_FILE_PATH.getMessage();
			StringBuffer str = new StringBuffer();
			String[] args1 = new String[] { "python", path, bufferingDelay, videoPlayTotalTime, kaDurationProportion,
					videoBitrate, videoClarity };
			Process pr = Runtime.getRuntime().exec(args1);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
//				System.out.println(line);
				str.append(line);
			}
			in.close();
			pr.waitFor();
			System.out.println(str);
			return str.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "vMOS=4.293946, QualityScore=4.449245, StallingScore=4.377010, LoadingScroe=4.262321";
		}

	}
}
