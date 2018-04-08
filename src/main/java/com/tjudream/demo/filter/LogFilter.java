package com.tjudream.demo.filter;

import com.tjudream.demo.util.RandomUtils;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("logfilter");
		String logid = "logid_" + System.currentTimeMillis() + RandomUtils.generateMixString(10);
		MDC.put("logid", logid);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		MDC.clear();
	}

}
