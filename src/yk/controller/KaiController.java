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
	@RequestMapping("/zj")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter1...");
		ks.marryWho();
		return new ModelAndView("../k.html");
	}
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

}
