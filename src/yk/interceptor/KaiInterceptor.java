package yk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class KaiInterceptor implements HandlerInterceptor{

	@Override
	//���ִ�У�����һ�������ͷ���Դ
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("���ִ�У�����һ�������ͷ���Դ...");
	}

	@Override
	//controllerִ��֮��������ͼ֮ǰִ��
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("controllerִ��֮��������ͼ֮ǰִ��...");
	}

	@Override
	//controller֮ǰִ��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����...");
		//ƥ���ض��� �ض�ҳ��  (һ����filter,���Թ���jsp)
		/*String url="/k.html";
		System.out.println("url..."+url);
		System.out.println("ServletPath..."+request.getServletPath());
		if(url.equals(request.getServletPath())){
			System.out.println("һ��");
			System.out.println("1111111");
			return true;
		}else{
			
		}
		response.sendRedirect("k.html");*/
		//����ִ��    return false  ִֹͣ��
		return false;
	}

}
