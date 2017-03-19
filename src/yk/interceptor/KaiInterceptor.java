package yk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class KaiInterceptor implements HandlerInterceptor{

	@Override
	//最后执行！！！一般用于释放资源
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("最后执行！！！一般用于释放资源...");
	}

	@Override
	//controller执行之后，生成视图之前执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("controller执行之后，生成视图之前执行...");
	}

	@Override
	//controller之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截...");
		//匹配重定向 特定页面  (一般用filter,可以过滤jsp)
		/*String url="/k.html";
		System.out.println("url..."+url);
		System.out.println("ServletPath..."+request.getServletPath());
		if(url.equals(request.getServletPath())){
			System.out.println("一樣");
			System.out.println("1111111");
			return true;
		}else{
			
		}
		response.sendRedirect("k.html");*/
		//继续执行    return false  停止执行
		return false;
	}

}
