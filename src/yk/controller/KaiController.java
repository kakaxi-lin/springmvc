package yk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// 1.ModelAndView ��ʽ������ֱ�������з�ʽ�滻
	@RequestMapping("/zj")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter1...");
		ks.marryWho();
		return new ModelAndView("../k.html");
	}

	// 2.�������ݻ�ȡ
	@RequestMapping("/marry")
	// ������ ��������ֱ�Ӷ�Ӧҳ��������ƾͿ���
	// http://localhost:8080/springmvc/kai/marry?she=xxx
	public String marry(String she) {
		System.out.println("marry..." + she);
		return "../index.jsp";
	}

	@RequestMapping("/marry1")
	// ���������� ҳ��������϶������ԣ��Զ�ƥ��
	// http://localhost:8080/springmvc/kai/marry1?wname=xxx
	public String marry1(Who who) {
		System.out.println("marry1..." + who.getWname());
		return "../index.jsp";
	}

	// 3.HttpServletRequest ModelMap��ȡ
	@RequestMapping("/marry2")
	// ����ֱ�Ӵ�spring�л�ȡ request����ModelMap mapҲ���Ի�ȡ���������ͬrequest
	// ���������� ҳ��������϶������ԣ��Զ�ƥ��
	// http://localhost:8080/springmvc/kai/marry2?wname=xxx
	public String marry2(Who who, HttpServletRequest request) {
		System.out.println("marry2..." + who.getWname());
		request.setAttribute("k", "kaige");
		return "../k.jsp";
	}

	// 4.�ض��� redirect
	// Ĭ�ϵ���תʱforward��ʽ
	// http://localhost:8080/springmvc/kai/redirect
	@RequestMapping("/redirect")
	public String redirect() {
		System.out.println("redirect...");
		return "redirect:../k.jsp";
	}

	// 5.ajax����
	// �����ajax���÷�������һ��@ResponseBody��������
	//����jackson����jar��  �����κζ�������
	//http://localhost:8080/springmvc/kai/testAjax
	@RequestMapping(value="/testAjax")
	public @ResponseBody List<Who> testAjax(String wname) {
		System.out.println("wname..." + wname);
		List<Who> list = new ArrayList<Who>();
		list.add(new Who("1", "Сӣ"));
		list.add(new Who("2", "����"));
		return list;
	}
}
