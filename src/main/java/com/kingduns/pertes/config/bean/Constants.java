package com.kingduns.pertes.config.bean;

/**
 * 静态常量类
 * @see 定义全局使用的静态常量
 * @author 宋德彬
 * @version 1.0
 */
public class Constants {
	
    /** 登陆状态-成功 */
    public final static String LOGINUSER_SUCCESS                            = "0001";
    /** 登陆状态-失败 */
    public final static String LOGINUSER_FAILURE                            = "0002";
    /** 登陆状态-用户失效 */
    public final static String INVALIDATION_USERDATE                        = "0003";
    /** 登陆状态-密码失效 */
    public final static String INVALIDATION_PASSDATE                        = "0004";
    /** 登陆状态-用户锁定 */
    public final static String LOGINUSER_LOCK                               = "0005";
    /** 登陆状态-用户类型 */
    public final static String LOGINUSER_TYPE                               = "0006";
    /** 登陆用户对象 */
    public final static String LOGINUSEROBJECT                              = "userobject";

    public final static String SALT 										= "43538dbef8eab1af4c4e71c6283bc963";
    /**
     * 分页最小条数
     */
    public final static Integer MINLIMIT 										=1;
    /**
     * 分页最大条数
     */
    public final static Integer MAXLIMIT 										=200;
    
    /**
     * 远程调用数据地址
     */
   // public final static String HPROSE_URL									= "http://10.0.31.121:12880/api/stationDataApiServer";
    
  
}
