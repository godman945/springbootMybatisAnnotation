package com.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.utility.StringUtil;

@Controller
public class RestApiController {
	
	
	@RequestMapping("/index")
	public String index(@RequestParam(value="name", required=false) String name, Model model) {
		
		
		
		
		return "redirect:/index.html";
		
//		List<String> list = new ArrayList<String>();
//		list.add("ALEX");
//		list.add("ALEX9");
//		System.out.println(list);
//		model.addAttribute("user", list);
//		return "redirect:/index2?alex=9999";
//		return "redirect:/err404";
	}
	
	@RequestMapping("/index2")
	public String showInfo2(Model model) {
		
		System.out.println(model);
		
		return "base.layout/index2";
	}
	
	
	@RequestMapping("/checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam(value="account", required=false) String account,@RequestParam(value="pd", required=false) String pd, Model model) {
		System.out.println(account);
		System.out.println(pd);
		JSONObject result = new JSONObject();
		if(account == null || account == "") {
			result.put("result", "帳號不可為空");
			return result.toString();
		}
		
		if(!account.equals("alex")) {
			result.put("result", "帳號錯誤");
			return result.toString();
		}
		
		if(pd == null || pd == "") {
			result.put("result", "密碼不可為空");
			return result.toString();
		}
		
		if(!pd.equals("alex")) {
			result.put("result", "密碼錯誤");
			return result.toString();
		}
		
		result.put("result", "驗證OK");
        return result.toString();
	}
}
