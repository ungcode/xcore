package com.ws.core.interceptors;

/**
 * CommonInterceptor should be used to handle all global cutting edge concerns
 * of the application.
 */

import com.ws.core.util.XcoreLogger;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Common
public class CommonInterceptor
{
	private static Long START_TIME = 0L;
	private static Long END_TIME = 0L;

	@AroundInvoke
	public Object commonTaks(InvocationContext ctx) throws Exception
	{
        final String TAG = "CommonInterceptor.commonTaks";

		Object result = duration( ctx );
		XcoreLogger.info(TAG, " Duration: " + END_TIME.toString());

		return result;


}

    private Object duration( InvocationContext ctx )
        throws Exception
    {
        START_TIME = System.currentTimeMillis();
		Object result = ctx.proceed();
		END_TIME = System.currentTimeMillis() - START_TIME;
        return result;
    }
}
