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
	//1.ModelAndView ��ʽ������ֱ�������з�ʽ�滻
	@RequestMapping("/zj")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter1...");
		ks.marryWho();
		return new ModelAndView("../k.html");
	}
	
	//2.�������ݻ�ȡ
	@RequestMapping(params="method=marry")
	//������  ��������ֱ�Ӷ�Ӧҳ��������ƾͿ���
	//http://localhost:8080/springmvc/kai?method=marry&she=xxx
	public String marry(String she){
		System.out.println("marry..."+she);
		return "index.jsp";
	}
	
	
	@RequestMapping(params="method=marry1")
	//����������  ҳ��������϶������ԣ��Զ�ƥ��
	//http://localhost:8080/springmvc/kai?method=marry1&wname=xxx
	public String marry1(Who who){
		System.out.println("marry1..."+who.getWname());
		return "index.jsp";
	}
	//3.HttpServletRequest ModelMap��ȡ
	@RequestMapping(params="method=marry2")
	//����ֱ�Ӵ�spring�л�ȡ request����ModelMap mapҲ���Ի�ȡ���������ͬrequest
	//����������  ҳ��������϶������ԣ��Զ�ƥ��
	//http://localhost:8080/springmvc/kai?method=marry2&wname=xxx
	public String marry2(Who who,HttpServletRequest request){
		System.out.println("marry2..."+who.getWname());
		request.setAttribute("k", "kaige");
		return "k.jsp";
	}
	//4.�ض��� redirect
	//Ĭ�ϵ���תʱforward��ʽ
	//http://localhost:8080/springmvc/kai?method=redirect
	@RequestMapping(params="method=redirect")
	public String redirect(){
		System.out.println("redirect...");
		return "redirect:k.jsp";
	}
}
