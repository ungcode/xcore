package com.ws.core.interceptors;

import java.lang.reflect.Method;

import com.ws.core.models.Ping;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Timed
public class PingInterceptor {

	private static Long START_TIME = 0L;
	private static Long END_TIME = 0L;

	@AroundInvoke
	public Object timeInvocation(InvocationContext ctx) throws Exception {

		Object result = invoke(ctx);
		

		return result;

	}

	public Object invoke(InvocationContext ctx) throws Exception
	{
		
		
		
		Object result = ctx.proceed();
		if(result instanceof Ping)
		{
			result = (Ping) result;
		}
	
		executionTime(ctx);
		

		return result;
	}

	private void executionTime(InvocationContext ctx)
	{
		
		START_TIME = System.currentTimeMillis();
		
		END_TIME = System.currentTimeMillis() - START_TIME;
		Method method = ctx.getMethod();
		
		String methodName = method.getDeclaringClass().getName() + "." + method.getName();
		
		String duration= "Method '" + methodName + "' took " + END_TIME + " milliseconds to run";
		
		System.out.println("executiontime: "+duration);
	}

}
