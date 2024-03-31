package com.ws.core.interceptors;

import com.ws.core.util.XcoreLogger;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Timed
public class CommonInterceptor
{
	private static Long START_TIME = 0L;
	private static Long END_TIME = 0L;

	@AroundInvoke
	public Object timeInvocation(InvocationContext ctx) throws Exception
	{
		final String TAG = "CommonInterceptor.timeInvocation";

		START_TIME = System.currentTimeMillis();
		Object result = ctx.proceed();
		END_TIME = System.currentTimeMillis() - START_TIME;
		XcoreLogger.info(TAG, " Duration: " + END_TIME.toString());

		return result;


}
}
