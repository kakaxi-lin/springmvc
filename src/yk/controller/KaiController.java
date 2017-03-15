package yk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yk.po.Who;
import yk.service.KaiService;
@Controller
@RequestMapping("/kai")
public class KaiController {
	@Resource
	private KaiService ks;
	public void setKs(KaiService ks) {
		this.ks = ks;
	}
	//1.ModelAndView 方式，可以直接用下列方式替换
	@RequestMapping("/zj")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter1...");
		ks.marryWho();
		return new ModelAndView("../k.html");
	}
	
	//2.参数传递获取
	@RequestMapping(params="method=marry")
	//传参数  参数名称直接对应页面参数名称就可以
	//http://localhost:8080/springmvc/kai?method=marry&she=xxx
	public String marry(String she){
		System.out.println("marry..."+she);
		return "index.jsp";
	}
	
	
	@RequestMapping(params="method=marry1")
	//传对象属性  页面参数符合对象属性，自动匹配
	//http://localhost:8080/springmvc/kai?method=marry1&wname=xxx
	public String marry1(Who who){
		System.out.println("marry1..."+who.getWname());
		return "index.jsp";
	}
	//3.HttpServletRequest ModelMap获取
	@RequestMapping(params="method=marry2")
	//可以直接从spring中获取 request对象，ModelMap map也可以获取，作用域等同request
	//传对象属性  页面参数符合对象属性，自动匹配
	//http://localhost:8080/springmvc/kai?method=marry2&wname=xxx
	public String marry2(Who who,HttpServletRequest request){
		System.out.println("marry2..."+who.getWname());
		request.setAttribute("k", "kaige");
		return "k.jsp";
	}
	//4.重定向 redirect
	//默认的跳转时forward方式
	//http://localhost:8080/springmvc/kai?method=redirect
	@RequestMapping(params="method=redirect")
	public String redirect(){
		System.out.println("redirect...");
		return "redirect:k.jsp";
	}
}
