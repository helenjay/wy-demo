package com.wy.utils;

public class ConstantData {
	//案事件已取回
	public static final String INCIDENT_GET_BACKED ="2";
	//案事件取回中
	public static final String INCIDENT_GET_BACKING ="1";
	
	//案事件的审核状态（未提交）
	public static final int INCIDENT_AUDIT_UNSUBMIT=1;
	
	public static final int INVALID_ORG_ID = -1;
	/*
	 * 组织用户
	 */
	// 管理员
	public final static int USER_MANAGER = 1;

	// 普通用户
	public final static int USER_COMMON_USER = 0;

	// 超级管理员
	public final static String USER_SUPER_MANAGER = "admin";

	// KB
	public final static String FILE_KB = "KB";

	// MB
	public final static String FILE_MB = "MB";

	// GB
	public final static String FILE_GB = "GB";
	public static String DATE_FORMAT_TEMP = "yyyy-MM-dd HH:mm:ss";
	public static final String SEQUENCE = "0001";
	public static final String IMAGE = "4";
	public static final String VIDEO = "1";
	public static final String PERSON = "01";
	public static final String CAR = "02";
	public static final String EXHIBIT = "03";
	public static final String SCENE = "04";
	public static final String MOVING = "05";
	public static final String REST = "99";
	public static final String MANUAL_SEQUENCE = "01";
	public static final int VIDEO_HEIGHT = 1000;
	public static final int VIDEO_WIDTH = 1000;
	/** 人 */
	public static final String PERSON_TYPE = "1";
	/** 车 */
	public static final String CAR_TYPE = "2";
	/** 物 */
	public static final String EXHIBIT_TYPE = "3";
	/** 场景 */
	public static final String SCENE_TYPE = "4";
	/** 场景 */
	public static final String MOVING_TYPE = "5";
	/** 场景 */
	public static final String REST_TYPE = "6";

	public static final String properName = "preset";

	// 根目录ID
	public final static String USER_ROOT_ID = "0";

	public final static int STATUS_DISABLE = 0;

	public final static int STATUS_ENABLE = 1;

	public final static int STATUS_DELETE = 2;

	// 图片暂存表中的status：3（临时数据非暂存结果）4.（暂存结果）
	public final static int STATUS_HANDLE = 3;

	public final static int STATUS_TEMP_STORAGE = 4;

    //默认格式抓图格式
    public final static String DEFAULT_SCREENSHOT_FORMAT = "jpg";

	/******************************* 报文公共部分 ****************************/
	/** 报文根结点 */
	public final static String MSG_ROOT = "message";

	/** 报文头结点 */
	public final static String MSG_HEAD = "head";

	/** 报文体结点 */
	public final static String MSG_BODY = "body";

	/** 服务版本号 */
	public final static String MSG_VSERSION = "version";

	/** 服务版本值 */
	public final static String MSG_VSERSION_VALUE = "1.0";

	/** 服务类型 */
	public final static String MSG_SERVICE_TYPE = "serviceType";

	/** 服务类型值 */
	public final static String MSG_SERVICE_TYPE_VALUE = "AuthenService";

	/** 报文体 认证方式 */
	public final static String MSG_AUTH_MODE = "authMode";

	/** 报文体 证书认证方式 */
	public final static String MSG_AUTH_MODE_CERT_VALUE = "cert";

	/** 报文体 口令认证方式 */
	public final static String MSG_AUTH_MODE_PASSWORD_VALUE = "password";

	/** 报文体 属性集 */
	public static final String MSG_ATTRIBUTES = "attributes";

	/** 报文体 属性 */
	public final static String MSG_ATTRIBUTE = "attr";

	/** 报文体 属性名 */
	public final static String MSG_NAME = "name";

	/** 报文体 属性空间 */
	public final static String MSG_NAMESPACE = "namespace";
	/*********************************************************************/

	/******************************* 请求报文 ****************************/
	/** 报文体 应用ID */
	public final static String MSG_APPID = "appId";

	/** 访问控制 */
	public final static String MSG_ACCESS_CONTROL = "accessControl";

	public final static String MSG_ACCESS_CONTROL_TRUE = "true";

	public final static String MSG_ACCESS_CONTROL_FALSE = "false";

	/** 报文体 认证结点 */
	public final static String MSG_AUTH = "authen";

	/** 报文体 认证凭据 */
	public final static String MSG_AUTHCREDENTIAL = "authCredential";

	/** 报文体 客户端结点 */
	public final static String MSG_CLIENT_INFO = "clientInfo";

	/** 报文体 客户端结点 */
	public final static String MSG_CLIENT_IP = "clientIP";

	/** 报文体 detach认证请求包 */
	public final static String MSG_DETACH = "detach";

	/** 报文体 原文 */
	public final static String MSG_ORIGINAL = "original";

	/** 报文体 用户名 */
	public final static String MSG_USERNAME = "username";

	/** 报文体 口令 */
	public final static String MSG_PASSWORD = "password";

	/** 报文体 属性类型 */
	public final static String MSG_ATTRIBUTE_TYPE = "attributeType";

	/** 指定属性 */
	public final static String MSG_ATTRIBUTE_TYPE_PORTION = "portion";
	/*********************************************************************/

	/******************************* 响应报文 ****************************/
	/** 报文体 认证结果集状态 */
	public final static String MSG_MESSAGE_STATE = "messageState";

	/** 响应报文消息码 */
	public final static String MSG_MESSAGE_CODE = "messageCode";

	/** 响应报文消息描述 */
	public final static String MSG_MESSAGE_DESC = "messageDesc";

	/** 报文体 认证结果集 */
	public final static String MSG_AUTH_RESULT_SET = "authResultSet";

	/** 报文体 认证结果 */
	public final static String MSG_AUTH_RESULT = "authResult";

	/** 报文体 认证结果状态 */
	public final static String MSG_SUCCESS = "success";

	/** 报文体 认证错误码 */
	public final static String MSG_AUTH_MESSSAGE_CODE = "authMessageCode";

	/** 报文体 认证错误描述 */
	public final static String MSG_AUTH_MESSSAGE_DESC = "authMessageDesc";
	/*********************************************************************/

	// 显示信息
	public final static String MSG_SUCCESS_INFO = "成功";
	public final static String MSG_SUCCESS_SAVE = "保存成功";
	public final static String MSG_SUCCESS_EDIT = "编辑成功";
	public final static String MSG_SUCCESS_BACKED = "已取回";
	public final static String MSG_SUCCESS_SELECT = "选择重大案件类别成功!";
	public final static String MSG_SUCCESS_SMART_MARK = "智能标注成功";
	public final static String MSG_SUCCESS_FILE_UPLOAD = "文件上传成功";
	public final static String MSG_SUCCESS_INFO_MODIFY = "修改成功";
	public final static String MSG_SUCCESS_IMAGE_GET = "获取图片成功";
	public final static String MSG_SUCCESS_INFO_RESTORE = "恢复成功！";
	public final static String MSG_SUCCESS_INFO_COMPETE_DELETE = "彻底删除成功！";
	public final static String MSG_SUCCESS_INFO_DELETE = "删除成功！";
	
	public final static String MSG_FAILD_INFO = "失败";
	public final static String MSG_FAILD_GET_IMAGE_ADDR = "获取图片地址失败";
	public final static String MSG_FAILD_SELECT = "选择重大案件类别失败!";
	public final static String SUB_CONFIG_FAIL = "下级服务配置出问题";
	public final static String MSG_FAILD_SMART_MARK = "智能标注失败";
	public final static String MSG_FAILD_IMAGE_JUDGE_SELECT = "查询研判信息失败";
	public final static String MSG_FAILD_IMAGE_GET = "获取图片失败";
	public final static String MSG_FAILD_INFO_RESTORE = "恢复失败！";
	public final static String MSG_FAILD_FILE_SAVE = "保存文件失败!";
	public final static String MSG_FAILD_INFO_COMPETE_DELETE = "彻底删除失败！";
	public final static String MSG_FAILD_INFO_RESTORE_PARENT_DELETE = "恢复失败！父组织被删除！";
	public final static String MSG_FAILD_INFO_RESTORE_ROLE_DELETE = "恢复失败！角色被删除！";
	public final static String MSG_FAILD_INFO_RESTORE_SAME_NAME = "恢复失败！重名！";
	public final static String MSG_FAILD_INFO_ADD_SAME_NAME = "添加失败！重名！";
	public final static String MSG_FAILD_INFO_ADD_SAME_IDCARD_NUMBER = "添加失败！重名！";
	public final static String MSG_FAILD_INFO_ADD = "添加失败！没有相应权限！";
	public final static String MSG_FAILD_INFO_COMPETE_DELETE_RESOURCE = "彻底删除失败！请先删除或转移组织下的资源！";
	public final static String MSG_FAILD_INFO_NO_PERMISSION = "没有该操作权限！";
	public final static String MSG_FAILD_INFO_NO_FILE = "文件不存在！";
	
	public final static String MSG_INFO_IS_SYSTEM_ADMIN = "该用户为系统管理员，不能添加！";
	public final static String MSG_INFO_NOT_DELETE_ITSELF = "自己不能删除自己";
	public final static String MSG_INFO_ADD_FAILD_INVALID_SCORE = "请重新设置比分！";
	public final static String MSG_INFO_USER_BEDELETED = "用户已被删除!";
	public final static String MSG_INFO_NOT_EXIST_RESOURCE = "该资源不存在！";
	public final static String MSG_INFO_EXIST_CLOUD_DIRECTORY_NAME = "该文件名已经存在！";

    public final static String MSG_STRUCTURED_RESOURCE_IN_LIBRARY = "结构化信息原视图资源位于视图库,已被删除！";

    public final static String MSG_NOT_HAVE_THUMBNAIL_MARK = "没有缩略图,无法保存!";
    public final static String MSG_RESOURCE_IMAGE_MISS = "原始图片丢失，无法保存!";
    public final static String MSG_UPLOAD_SUCCESS = "图片上传云空间成功!";
    public final static String MSG_UPLOAD_FAILED = "图片上传云空间失败!";
    public final static String MSG_IMAGE_MARK_NO_NULL = "图片不能为空!";

    public final static String MSG_NOT_HAVE_THUMBNAIL = "没有缩略图，无法保存!";
	public final static String MSG_MISS_RESOURCE_IMG = "原始图片丢失，无法保存!";
	public static final String VITURAL_ORG_GROUP_HEAD = "vorg_";


    /**********万解登陆地址********/
    public final static String MD_LOGIN_PATH = "api/Login";
    /**********万解登陆用户名标识********/
    public final static String MD_LOGIN_USERNAME = "username";
    /**********万解登陆密码标识********/
    public final static String MD_LOGIN_PASSWORD = "password";
    /**********万解登陆地址********/
    public final static String MD_GETWINDOWCOUNT = "api/GetWindowCount";
    /**********万解上墙地址********/
    public final static String MD_ADDSTREAM = "api/";
    /**********万解设置布局地址********/
    public final static String MD_SETLAYOUT = "api/SetLayout";
    /**********万解设置布局屏幕通道编号********/
    public final static String MD_SETLAYOUT_SCREEN = "screen";
    /**********万解设置布局方式2X2等********/
    public final static String MD_SETLAYOUT_LAYOUT = "layout";
    /**********万解下墙地址********/
    public final static String MD_DELETESTREAM = "api/";
    /**********通道屏幕第几个分屏********/
    public final static String MD_WINDOWS = "windows";
	//手动报警类型标识
	public static final int VA_EVENT_MANUAL = 33554432;
}
