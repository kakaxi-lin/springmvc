package yk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import yk.po.Who;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
		//�����ajax���÷�������һ��@ResponseBody��������
		@RequestMapping("/testAjax")
		public @ResponseBody String testAjax(String wname){ 
			System.out.println("wname..."+wname); 
			List<Who> list = new ArrayList<Who>();
			list.add(new Who("1","����"));
			list.add(new Who("2","������"));
			Gson gson=new Gson();
			String g = gson.toJson("s");
			return g;
		}

}
