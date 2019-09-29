package com.kingduns.pertes.config.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 配置session监听器
 * @author Administrator
 *
 */
public class ShiroSessionListener implements SessionListener {

	/**
     * 统计在线人数
     * juc包下线程安全自增
     */
    private final AtomicInteger sessionCount = new AtomicInteger(0);
    
    /**
     * 会话创建触发
     */
	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();// 在线人数加一
	}

	/**
	 * 退出会话触发
	 */
	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();// 在线人数减一
	}

	/**
	 * 会话过期触发
	 */
	@Override
	public void onExpiration(Session session) {
        sessionCount.decrementAndGet();// 在线人数减一
	}

	/**
	 * 获取在线人数
	 * @return
	 */
	public AtomicInteger getSessionCount() {
		 return sessionCount;
	}
}
