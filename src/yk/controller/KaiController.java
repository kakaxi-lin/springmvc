package yk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yk.service.KaiService;
@Controller
@RequestMapping("/a")
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
	@RequestMapping("/k")
	public String k(){
		return "../index.jsp";
	}

}
