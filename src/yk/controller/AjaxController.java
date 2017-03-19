package yk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yk.po.Who;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
		//�����ajax���÷�������һ��@ResponseBody��������
		@RequestMapping(value="/testAjax" )
		public @ResponseBody List<Who> testAjax(String wname){ 
			System.out.println("wname..."+wname); 
			List<Who> list = new ArrayList<Who>();
			list.add(new Who("1","����"));
			list.add(new Who("2","������"));
			return list;
		}

}
