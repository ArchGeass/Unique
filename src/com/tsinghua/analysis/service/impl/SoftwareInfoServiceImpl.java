package com.tsinghua.analysis.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import com.tsinghua.analysis.service.ISoftwareInfoService;
import com.tsinghua.utils.ResultJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://softwareInfoService.service.analysis.tsinghua.com/", name = "ISoftwareInfoService", serviceName = "ISoftwareInfoService")
public class SoftwareInfoServiceImpl implements ISoftwareInfoService {

	private static Logger logger = Logger.getLogger(SoftwareInfoServiceImpl.class);

//	@Autowired
//	private ISoftwareInfoDao iSoftwareInfoDao;

	@WebResult(name = "return", targetNamespace = "http://softwareInfoService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String getInfo(String param) {
		JSONObject obj = JSONObject.fromObject(JSONArray.fromObject(param).getString(0));
		String mark = obj.getString("mark");
//		SoftwareInfo info = new SoftwareInfo();
		//改用读文件的方式
		String classpath = Thread.currentThread().getContextClassLoader().getResource("").toString();
		String path = classpath.substring(classpath.length() - (classpath.length() - 5), classpath.length() - 8)
				+ "config/softinfo.properties";// -5为linux;-6为windows
		JSONObject resultJson = new JSONObject();
		String info = "";
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			Properties prop = new Properties();
			prop.load(in);
			if(mark.equals("1")){
				info = prop.getProperty("information");
			}else{
				info = prop.getProperty("description");
			}
			resultJson.put("info", info);
//			info = iSoftwareInfoDao.selectByPrimaryKey(Integer.parseInt(mark));
//			SoftwareInfoVO infoVo = new SoftwareInfoVO(info.getMessage());
//			resultJson = infoVo.toJson(infoVo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
