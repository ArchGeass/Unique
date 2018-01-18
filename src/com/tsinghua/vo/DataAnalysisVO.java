package com.tsinghua.vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tsinghua.analysis.model.DataAnalysis;

import net.sf.json.JSONObject;

public class DataAnalysisVO {

	/* 数据主键 */
	private String daId;

	/* 屏幕分辨率(长) */
	private String screenResolutionLong;

	/* 屏幕分辨率(宽) */
	private String screenResolutionWidth;

	/* 视频清晰度(360/480/7201080,无单位) */
	private String videoClarity;

	/* 视频编码格式,如h.264 */
	private String videoCodingFormat;

	/* 视频码率=视频文件大小/视频总时长(kb/s) */
	private String videoBitrate;

	/* 初始缓冲延时=视频开始播放的时间-用户点击播放按钮的时间(毫秒) */
	private String bufferingDelay;

	/* 初始缓冲阶段的峰值速率，单位kb/s */
	private String videoPeakRate;

	/* 视频总卡顿次数 */
	private String videoKaNum;

	/* 所有卡顿的时长之和(毫秒) */
	private String videoKaTotalTime;

	/* 卡顿总时长/视频总时长(百分比) */
	private String kaDurationProportion;

	/* 卡顿1时长=卡顿结束时间点-卡顿开始时间点(毫秒) */
	private String kaDurationLongOne;

	/* 时间1点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointOne;

	/* 卡顿2时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongTwo;

	/* 时间2点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointTwo;

	/* 卡顿3时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongThree;

	/* 时间3点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointThree;

	/* 卡顿4时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongFour;

	/* 时间4点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointFour;

	/* 卡顿5时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongFive;

	/* 时间5点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointFive;

	/* 卡顿6时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongSix;

	/* 时间6点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointSix;

	/* 卡顿7时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongSeven;

	/* 时间7点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointSeven;

	/* 卡顿8时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongEight;

	/* 时间8点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointEight;

	/* 卡顿9时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongNine;

	/* 时间9点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointNine;

	/* 卡顿10时长=卡顿结束时间点-卡顿开始时间点（毫秒） */
	private String kaDurationLongTen;

	/* 时间10点=当前卡顿的时间点-开始播放的时间（秒） */
	private String kaDurationLongPointTen;

	/* 视频源总时长，单位秒 */
	private String videoTotalTime;

	/* 视频播放时长=结束播放的时间点-点击播放的时间点(秒) */
	private String videoPlayTotalTime;

	/* 全程阶段的峰值速率，下载量每秒（kb/s） */
	private String videoAllPeakRate;

	/* 视频平均下载速率=总下载量/视频播放时长(kb/s) */
	private String videoAveragePeakRate;

	/* 手机环境光照强度 */
	private String lightIntensity;

	/* 手机屏幕亮度 */
	private String phoneScreenBrightness;

	/* 手机放置状态,1表示竖屏,2表示横屏 */
	private String phonePlaceState;

	/* 信噪比 */
	private String environmentalNoise;

	/* 1表示wifi，2表示4G 3表示3G 默认是0 */
	private String networkType;

	/* 开始播放时的手机电量百分比 */
	private String phoneElectricStart;

	/* 播放结束时的手机电量百分比 */
	private String phoneElectricEnd;

	/* 信号强度 */
	private String signalStrength;

	/* 手机型号 */
	private String phoneVersion;

	/* 操作系统 */
	private String operatingSystem;

	/* GPS经度1 */
	private String gpsLongitudeOne;

	/* GPS纬度1 */
	private String gpsLatitudeOne;

	/* GPS经度2 */
	private String gpsLongitudeTwo;

	/* GPS纬度2 */
	private String gpsLatitudeTwo;

	/* GPS经度3 */
	private String gpsLongitudeThree;

	/* GPS纬度3 */
	private String gpsLatitudeThree;

	/* GPS经度4 */
	private String gpsLongitudeFour;

	/* GPS纬度4 */
	private String gpsLatitudeFour;

	/* GPS经度5 */
	private String gpsLongitudeFive;

	/* GPS纬度5 */
	private String gpsLatitudeFive;

	/* 重力感应数据=X/Y/Z轴的加速度 每秒取值 */
	private String accelerometerData;

	/* 全程瞬时下载速率=每3s的下载量(kb) */
	private String instanDownloadSpeed;

	/* 用户对视频清晰度的评分(5:非常好，4：良好，3：一般，2：较差，1：无法容忍) */
	private String userScore;

	/* 数据的入库时间 */
	private Date saveDate;

	/* 电话号码 */
	private String userTel;

	/* 用户对视频播放等待时间的评分(5：无法察觉到缓冲，4：缓冲时间很短，3：缓冲时间长度一般，2：缓冲时间较长，1：缓冲时间过长无法容忍) */
	private String Eloading;

	/*
	 * 用户对流畅度的评分(5:毫无卡顿，4：略有卡顿但不影响观看，3：有卡顿对观看造成一定影响，2：有卡顿对观看造成较大影响，1：卡顿过多无法容忍)
	 */
	private String Estalling;

	/* 用户对整体视频服务的综合评分(5:非常好，4：良好，3：一般，2：较差，1：无法容忍) */
	private String EvMos;

	/* 小区标识 */
	private String cid;

	/* 位置区编码 */
	private String lac;

	/* 用户场景 */
	private String userScene;

	/* 视频源服务器的IP地址 */
	private String videoServerIp;

	/* 视频源服务器的实际地理位置 */
	private String videoServerLocation;

	/* 国家/地区 */
	private String country;

	/* 省份 */
	private String province;

	/* 城市 */
	private String city;

	/* 地址 */
	private String address;

	/* 手机内部IP */
	private String ueInternalIp;

	/* 环境光照对视频观看的影响程度(5：无影响，4：较小影响，3：有一定影响，2：较大影响，1：极大影响） */
	private String elight;

	/* 用户对运动状态的反馈(:4：静止不动，3：偶尔走动，2：持续走动，1：交通工具上) */
	private String estate;

	/* 公共陆地移动网络 */
	private String plmn;

	/* 国际移动用户识别码 */
	private String imsi;

	/* 移动设备国际身份码 */
	private String udid;

	/* 移动国家码 */
	private String mcc;

	/* 移动网络号码 */
	private String mnc;

	/* 无线蜂窝网络场强(dbm) */
	private String cellSignalStrength;

	/* 信号干扰噪声比：接收到的有用信号的强度与接收到的干扰信号（噪声和干扰）的强度 */
	private String sinr;

	/* Ping 512B，终端到视频服务器的平均环回时延。是视频文件解析，以及初始缓冲峰值速率的决定因素之一 */
	private String pingAvgRtt;

	/* 运营商名称 */
	private String carrier;

	/* null_value */
//	private String lcid;

	/* 基站标识 */
	private String enodebId;

	/* 播放方式 */
	private String playWay;

	/* 视频开始播放的时间 */
	private Date startTime;

	/* 视频长度 */
	private String videoSize;

	/* 视频大小 */
	private String videoName;

	/* 请求服务器时延 */
	private String userBufferTime;

	/* 用户对预测分数的建议 */
	private String scoreSuggest;

	/* 是否在历史记录展示,0否,1是 */
	private String display;

	public String getDaId() {
		return daId;
	}

	public String getScreenResolutionLong() {
		return screenResolutionLong;
	}

	public String getScreenResolutionWidth() {
		return screenResolutionWidth;
	}

	public String getVideoClarity() {
		return videoClarity;
	}

	public String getVideoCodingFormat() {
		return videoCodingFormat;
	}

	public String getVideoBitrate() {
		return videoBitrate;
	}

	public String getBufferingDelay() {
		return bufferingDelay;
	}

	public String getVideoPeakRate() {
		return videoPeakRate;
	}

	public String getVideoKaNum() {
		return videoKaNum;
	}

	public String getVideoKaTotalTime() {
		return videoKaTotalTime;
	}

	public String getKaDurationProportion() {
		return kaDurationProportion;
	}

	public String getKaDurationLongOne() {
		return kaDurationLongOne;
	}

	public String getKaDurationLongPointOne() {
		return kaDurationLongPointOne;
	}

	public String getKaDurationLongTwo() {
		return kaDurationLongTwo;
	}

	public String getKaDurationLongPointTwo() {
		return kaDurationLongPointTwo;
	}

	public String getKaDurationLongThree() {
		return kaDurationLongThree;
	}

	public String getKaDurationLongPointThree() {
		return kaDurationLongPointThree;
	}

	public String getKaDurationLongFour() {
		return kaDurationLongFour;
	}

	public String getKaDurationLongPointFour() {
		return kaDurationLongPointFour;
	}

	public String getKaDurationLongFive() {
		return kaDurationLongFive;
	}

	public String getKaDurationLongPointFive() {
		return kaDurationLongPointFive;
	}

	public String getKaDurationLongSix() {
		return kaDurationLongSix;
	}

	public String getKaDurationLongPointSix() {
		return kaDurationLongPointSix;
	}

	public String getKaDurationLongSeven() {
		return kaDurationLongSeven;
	}

	public String getKaDurationLongPointSeven() {
		return kaDurationLongPointSeven;
	}

	public String getKaDurationLongEight() {
		return kaDurationLongEight;
	}

	public String getKaDurationLongPointEight() {
		return kaDurationLongPointEight;
	}

	public String getKaDurationLongNine() {
		return kaDurationLongNine;
	}

	public String getKaDurationLongPointNine() {
		return kaDurationLongPointNine;
	}

	public String getKaDurationLongTen() {
		return kaDurationLongTen;
	}

	public String getKaDurationLongPointTen() {
		return kaDurationLongPointTen;
	}

	public String getVideoTotalTime() {
		return videoTotalTime;
	}

	public String getVideoPlayTotalTime() {
		return videoPlayTotalTime;
	}

	public String getVideoAllPeakRate() {
		return videoAllPeakRate;
	}

	public String getVideoAveragePeakRate() {
		return videoAveragePeakRate;
	}

	public String getLightIntensity() {
		return lightIntensity;
	}

	public String getPhoneScreenBrightness() {
		return phoneScreenBrightness;
	}

	public String getPhonePlaceState() {
		return phonePlaceState;
	}

	public String getEnvironmentalNoise() {
		return environmentalNoise;
	}

	public String getNetworkType() {
		return networkType;
	}

	public String getPhoneElectricStart() {
		return phoneElectricStart;
	}

	public String getPhoneElectricEnd() {
		return phoneElectricEnd;
	}

	public String getSignalStrength() {
		return signalStrength;
	}

	public String getPhoneVersion() {
		return phoneVersion;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public String getGpsLongitudeOne() {
		return gpsLongitudeOne;
	}

	public String getGpsLatitudeOne() {
		return gpsLatitudeOne;
	}

	public String getGpsLongitudeTwo() {
		return gpsLongitudeTwo;
	}

	public String getGpsLatitudeTwo() {
		return gpsLatitudeTwo;
	}

	public String getGpsLongitudeThree() {
		return gpsLongitudeThree;
	}

	public String getGpsLatitudeThree() {
		return gpsLatitudeThree;
	}

	public String getGpsLongitudeFour() {
		return gpsLongitudeFour;
	}

	public String getGpsLatitudeFour() {
		return gpsLatitudeFour;
	}

	public String getGpsLongitudeFive() {
		return gpsLongitudeFive;
	}

	public String getGpsLatitudeFive() {
		return gpsLatitudeFive;
	}

	public String getAccelerometerData() {
		return accelerometerData;
	}

	public String getInstanDownloadSpeed() {
		return instanDownloadSpeed;
	}

	public String getUserScore() {
		return userScore;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public String getUserTel() {
		return userTel;
	}

	public String getEloading() {
		return Eloading;
	}

	public String getEstalling() {
		return Estalling;
	}

	public String getEvMos() {
		return EvMos;
	}

	public String getCid() {
		return cid;
	}

	public String getLac() {
		return lac;
	}

	public String getUserScene() {
		return userScene;
	}

	public String getVideoServerIp() {
		return videoServerIp;
	}

	public String getVideoServerLocation() {
		return videoServerLocation;
	}

	public String getCountry() {
		return country;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getUeInternalIp() {
		return ueInternalIp;
	}

	public String getElight() {
		return elight;
	}

	public String getEstate() {
		return estate;
	}

	public String getPlmn() {
		return plmn;
	}

	public String getImsi() {
		return imsi;
	}

	public String getUdid() {
		return udid;
	}

	public String getMcc() {
		return mcc;
	}

	public String getMnc() {
		return mnc;
	}

	public String getCellSignalStrength() {
		return cellSignalStrength;
	}

	public String getSinr() {
		return sinr;
	}

	public String getPingAvgRtt() {
		return pingAvgRtt;
	}

	public String getCarrier() {
		return carrier;
	}

	public String getEnodebId() {
		return enodebId;
	}

	public String getPlayWay() {
		return playWay;
	}

	public Date getStartTime() {
		return startTime;
	}

	public String getVideoSize() {
		return videoSize;
	}

	public String getVideoName() {
		return videoName;
	}

	public String getUserBufferTime() {
		return userBufferTime;
	}

	public String getScoreSuggest() {
		return scoreSuggest;
	}

	public String getDisplay() {
		return display;
	}

	DataAnalysisVO() {
	}

	public DataAnalysisVO(String param) throws ParseException {
		JSONObject obj = JSONObject.fromObject(param);
		screenResolutionLong = obj.getString("screenResolutionLong");
		screenResolutionWidth = obj.getString("screenResolutionWidth");
		videoClarity = obj.getString("videoClarity");
		videoCodingFormat = obj.getString("videoCodingFormat");
		videoBitrate = obj.getString("videoBitrate");
		bufferingDelay = obj.getString("bufferingDelay");
		videoPeakRate = obj.getString("videoPeakRate");
		videoKaNum = obj.getString("videoKaNum");
		videoKaTotalTime = obj.getString("videoKaTotalTime");
		kaDurationProportion = obj.getString("kaDurationProportion");
		kaDurationLongOne = obj.getString("kaDurationLongOne");
		kaDurationLongPointOne = obj.getString("kaDurationLongPointOne");
		kaDurationLongTwo = obj.getString("kaDurationLongTwo");
		kaDurationLongPointTwo = obj.getString("kaDurationLongPointTwo");
		kaDurationLongThree = obj.getString("kaDurationLongThree");
		kaDurationLongPointThree = obj.getString("kaDurationLongPointThree");
		kaDurationLongFour = obj.getString("kaDurationLongFour");
		kaDurationLongPointFour = obj.getString("kaDurationLongPointFour");
		kaDurationLongFive = obj.getString("kaDurationLongFive");
		kaDurationLongPointFive = obj.getString("kaDurationLongPointFive");
		kaDurationLongSix = obj.getString("kaDurationLongSix");
		kaDurationLongPointSix = obj.getString("kaDurationLongPointSix");
		kaDurationLongSeven = obj.getString("kaDurationLongSeven");
		kaDurationLongPointSeven = obj.getString("kaDurationLongPointSeven");
		kaDurationLongEight = obj.getString("kaDurationLongEight");
		kaDurationLongPointEight = obj.getString("kaDurationLongPointEight");
		kaDurationLongNine = obj.getString("kaDurationLongNine");
		kaDurationLongPointNine = obj.getString("kaDurationLongPointNine");
		kaDurationLongTen = obj.getString("kaDurationLongTen");
		kaDurationLongPointTen = obj.getString("kaDurationLongPointTen");
		videoTotalTime = obj.getString("videoTotalTime");
		videoPlayTotalTime = obj.getString("videoPlayTotalTime");
		videoAllPeakRate = obj.getString("videoAllPeakRate");
		videoAveragePeakRate = obj.getString("videoAveragePeakRate");
		lightIntensity = obj.getString("lightIntensity");
		phoneScreenBrightness = obj.getString("phoneScreenBrightness");
		phonePlaceState = obj.getString("phonePlaceState");
		environmentalNoise = obj.getString("environmentalNoise");
		networkType = obj.getString("networkType");
		phoneElectricStart = obj.getString("phoneElectricStart");
		phoneElectricEnd = obj.getString("phoneElectricEnd");
		signalStrength = obj.getString("signalStrength");
		phoneVersion = obj.getString("phoneVersion");
		operatingSystem = obj.getString("operatingSystem");
		gpsLongitudeOne = obj.getString("gpsLongitudeOne");
		gpsLatitudeOne = obj.getString("gpsLatitudeOne");
		gpsLongitudeTwo = obj.getString("gpsLongitudeTwo");
		gpsLatitudeTwo = obj.getString("gpsLatitudeTwo");
		gpsLongitudeThree = obj.getString("gpsLongitudeThree");
		gpsLatitudeThree = obj.getString("gpsLatitudeThree");
		gpsLongitudeFour = obj.getString("gpsLongitudeFour");
		gpsLatitudeFour = obj.getString("gpsLatitudeFour");
		gpsLongitudeFive = obj.getString("gpsLongitudeFive");
		gpsLatitudeFive = obj.getString("gpsLatitudeFive");
		accelerometerData = obj.getString("accelerometerData");
		instanDownloadSpeed = obj.getString("instanDownloadSpeed");
		userScore = obj.getString("userScore");
		saveDate = new Date();
		userTel = obj.getString("PhoneNum");
		Eloading = obj.getString("Eloading");
		Estalling = obj.getString("Estalling");
		EvMos = obj.getString("EvMos");
		cid = obj.getString("Cid");
		lac = obj.getString("Lac");
		userScene = obj.getString("userScene");
		videoServerIp = obj.getString("VideoServerIP");
		videoServerLocation = obj.getString("VideoServerLocation");
		country = obj.getString("Country");
		province = obj.getString("Province");
		city = obj.getString("City");
		address = obj.getString("Address");
		ueInternalIp = obj.getString("UEInternalIP");
		elight = obj.getString("Elight");
		estate = obj.getString("Estate");
		plmn = obj.getString("PLMN");
		imsi = obj.getString("IMSI");
		udid = obj.getString("UDID");
		mcc = obj.getString("MCC");
		mnc = obj.getString("MNC");
		cellSignalStrength = obj.getString("CellSignalStrength");
		sinr = obj.getString("SINR");
		pingAvgRtt = obj.getString("PingAvgRTT");
		carrier = obj.getString("Carrier");
		enodebId = obj.getString("ENodeBID");
		playWay = obj.getString("PlayWay");
		String videoStartTime = obj.getString("videoStartTime");
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime = fmt.parse(videoStartTime);
		videoSize = obj.getString("videoSize");
		videoName = obj.getString("videoName");
		userBufferTime = obj.getString("userBufferTime");
	}

	public DataAnalysis saveModel(DataAnalysisVO vo) {
		DataAnalysis analysisData = new DataAnalysis();
		analysisData.setScreenResolutionLong(vo.getScreenResolutionLong());
		analysisData.setScreenResolutionWidth(vo.getScreenResolutionWidth());
		analysisData.setVideoClarity(vo.getVideoClarity());
		analysisData.setVideoCodingFormat(vo.getVideoCodingFormat());
		analysisData.setVideoBitrate(vo.getVideoBitrate());
		analysisData.setBufferingDelay(vo.getBufferingDelay());
		analysisData.setVideoPeakRate(vo.getVideoPeakRate());
		analysisData.setVideoKaNum(vo.getVideoKaNum());
		analysisData.setVideoKaTotalTime(vo.getVideoKaTotalTime());
		analysisData.setKaDurationProportion(vo.getKaDurationProportion());
		analysisData.setKaDurationLongOne(vo.getKaDurationLongOne());
		analysisData.setKaDurationLongPointOne(vo.getKaDurationLongPointOne());
		analysisData.setKaDurationLongTwo(vo.getKaDurationLongTwo());
		analysisData.setKaDurationLongPointTwo(vo.getKaDurationLongPointTwo());
		analysisData.setKaDurationLongThree(vo.getKaDurationLongThree());
		analysisData.setKaDurationLongPointThree(vo.getKaDurationLongPointThree());
		analysisData.setKaDurationLongFour(vo.getKaDurationLongFour());
		analysisData.setKaDurationLongPointFour(vo.getKaDurationLongPointFour());
		analysisData.setKaDurationLongFive(vo.getKaDurationLongFive());
		analysisData.setKaDurationLongPointFive(vo.getKaDurationLongPointFive());
		analysisData.setKaDurationLongSix(vo.getKaDurationLongSix());
		analysisData.setKaDurationLongPointSix(vo.getKaDurationLongPointSix());
		analysisData.setKaDurationLongSeven(vo.getKaDurationLongSeven());
		analysisData.setKaDurationLongPointSeven(vo.getKaDurationLongPointSeven());
		analysisData.setKaDurationLongEight(vo.getKaDurationLongEight());
		analysisData.setKaDurationLongPointEight(vo.getKaDurationLongPointEight());
		analysisData.setKaDurationLongNine(vo.getKaDurationLongNine());
		analysisData.setKaDurationLongPointNine(vo.getKaDurationLongPointNine());
		analysisData.setKaDurationLongTen(vo.getKaDurationLongTen());
		analysisData.setKaDurationLongPointTen(vo.getKaDurationLongPointTen());
		analysisData.setVideoTotalTime(vo.getVideoTotalTime());
		analysisData.setVideoPlayTotalTime(vo.getVideoPlayTotalTime());
		analysisData.setVideoAllPeakRate(vo.getVideoAllPeakRate());
		analysisData.setVideoAveragePeakRate(vo.getVideoAveragePeakRate());
		analysisData.setLightIntensity(vo.getLightIntensity());
		analysisData.setPhoneScreenBrightness(vo.getPhoneScreenBrightness());
		analysisData.setPhonePlaceState(vo.getPhonePlaceState());
		analysisData.setEnvironmentalNoise(vo.getEnvironmentalNoise());
		analysisData.setNetworkType(vo.getNetworkType());
		analysisData.setPhoneElectricStart(vo.getPhoneElectricStart());
		analysisData.setPhoneElectricEnd(vo.getPhoneElectricEnd());
		analysisData.setSignalStrength(vo.getSignalStrength());
		analysisData.setPhoneVersion(vo.getPhoneVersion());
		analysisData.setOperatingSystem(vo.getOperatingSystem());
		analysisData.setGpsLongitudeOne(vo.getGpsLongitudeOne());
		analysisData.setGpsLatitudeOne(vo.getGpsLatitudeOne());
		analysisData.setGpsLongitudeTwo(vo.getGpsLongitudeTwo());
		analysisData.setGpsLatitudeTwo(vo.getGpsLatitudeTwo());
		analysisData.setGpsLongitudeThree(vo.getGpsLongitudeThree());
		analysisData.setGpsLatitudeThree(vo.getGpsLatitudeThree());
		analysisData.setGpsLongitudeFour(vo.getGpsLongitudeFour());
		analysisData.setGpsLatitudeFour(vo.getGpsLatitudeFour());
		analysisData.setGpsLongitudeFive(vo.getGpsLongitudeFive());
		analysisData.setGpsLatitudeFive(vo.getGpsLatitudeFive());
		analysisData.setAccelerometerData(vo.getAccelerometerData());
		analysisData.setInstanDownloadSpeed(vo.getInstanDownloadSpeed());
		analysisData.setUserScore(vo.getUserScore());
		analysisData.setSaveDate(vo.getSaveDate());
		analysisData.setUserTel(vo.getUserTel());
		analysisData.setEloading(vo.getEloading());
		analysisData.setEstalling(vo.getEstalling());
		analysisData.setEvMos(vo.getEvMos());
		analysisData.setCid(vo.getCid());
		analysisData.setLac(vo.getLac());
		analysisData.setUserScene(vo.getUserScene());
		analysisData.setVideoServerIp(vo.getVideoServerIp());
		analysisData.setVideoServerLocation(vo.getVideoServerLocation());
		analysisData.setCountry(vo.getCountry());
		analysisData.setProvince(vo.getProvince());
		analysisData.setCity(vo.getCity());
		analysisData.setAddress(vo.getAddress());
		analysisData.setUeInternalIp(vo.getUeInternalIp());
		analysisData.setElight(vo.getElight());
		analysisData.setEstate(vo.getEstate());
		analysisData.setPlmn(vo.getPlmn());
		analysisData.setImsi(vo.getImsi());
		analysisData.setUdid(vo.getUdid());
		analysisData.setMcc(vo.getMcc());
		analysisData.setMnc(vo.getMnc());
		analysisData.setCellSignalStrength(vo.getCellSignalStrength());
		analysisData.setSinr(vo.getSinr());
		analysisData.setPingAvgRtt(vo.getPingAvgRtt());
		analysisData.setCarrier(vo.getCarrier());
		analysisData.setEnodebId(vo.getEnodebId());
		analysisData.setPlayWay(vo.getPlayWay());
		analysisData.setStartTime(vo.getStartTime());
		analysisData.setVideoSize(vo.getVideoSize());
		analysisData.setVideoName(vo.getVideoName());
		analysisData.setUserBufferTime(vo.getUserBufferTime());
		return analysisData;
	}
}
