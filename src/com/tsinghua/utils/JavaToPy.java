package com.tsinghua.utils;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/*与python交互*/
public class JavaToPy {

	@SuppressWarnings("resource")
	public String getPython(String screenResolutionLong, String videoCodingFormat, String videoBitrate, String bufferingDelay, String kaDurationProportion, String videoTotalTime, String videoPlayTotalTime, String userBufferTime){
		StringBuffer str = new StringBuffer();
		str.append(screenResolutionLong);//屏幕分辨率(长)
		str.append(",");
		str.append(videoCodingFormat);//视频编码格式,如h.264
		str.append(",");
		str.append(videoBitrate);//视频码率
		str.append(",");
		str.append(bufferingDelay);//初始缓冲延时
		str.append(",");
		str.append(kaDurationProportion);//卡顿总时长/视频总时长(百分比)
		str.append(",");
		str.append(videoTotalTime);//视频源总时长
		str.append(",");
		str.append(videoPlayTotalTime);//视频播放时长
		str.append(",");
		str.append(userBufferTime);//请求服务器时延
		String args = new String(str);
		PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("D://java/py3.py");
        PyFunction func = (PyFunction) interpreter.get("py3", PyFunction.class);
        PyObject pyobj = func.__call__(new PyString(args));
        return pyobj.toString();
	}
}
