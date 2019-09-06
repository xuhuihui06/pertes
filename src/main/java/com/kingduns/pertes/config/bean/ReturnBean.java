package com.kingduns.pertes.config.bean;

import java.io.Serializable;

/**
 * 前后台交互信息
 * @author Nebor
 *
 */
public class ReturnBean<T> implements Serializable{

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int NO_PERMISSION = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态
	 */
	private  int code = SUCCESS;
	
	/**
	 * 提示信息
	 */
	private String msg = "success";
	
	/**
	 * 其他数据
	 */
	private T data;

	public ReturnBean() {
		super();
	}

	public ReturnBean(String msg, T data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	public ReturnBean(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReturnBean [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
