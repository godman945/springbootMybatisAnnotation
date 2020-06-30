package com.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import freemarker.template.utility.StringUtil;

@Controller
public class RestApiController {
	
//	
//	@RequestMapping("/index")
//	public String index(@RequestParam(value="name", required=false) String name, Model model) {
//		
//		
//		
//		
//		return "redirect:/index.html";
//		
////		List<String> list = new ArrayList<String>();
////		list.add("ALEX");
////		list.add("ALEX9");
////		System.out.println(list);
////		model.addAttribute("user", list);
////		return "redirect:/index2?alex=9999";
////		return "redirect:/err404";
//	}
	
//	@RequestMapping(value = "/index2")
//	public String showInfo2(Model model) {
//		
//		System.out.println(model);
//		
//		return "base.layout/index2";
//	}
	
	@RequestMapping(value = "/login",method = { RequestMethod.POST, RequestMethod.GET })
	public String login(Model model) {
		
		System.out.println(model);
		
		return "base.layout/index2";
	}
	
	
	
	
	@RequestMapping(value = "/checkLogin")
//	@ResponseBody
	public String checkLogin(@RequestParam(value="account", required=false) String account,@RequestParam(value="pd", required=false) String pd, RedirectAttributes redirectAttributes) {
		System.out.println("account:"+account);
		System.out.println("pd:"+pd);
		
		return "redirect:/login";
		
//		JSONObject result = new JSONObject();
//		result.put("message", "驗證正確");
//		result.put("status", "success");
//		
//		if(account == null || account == "") {
//			result.put("message", "帳號不可為空");
//			result.put("status", "fail");
//		}else if(!account.equals("alex")) {
//			result.put("message", "帳號錯誤");
//			result.put("status", "fail");
//		}else if(pd == null || pd == "") {
//			result.put("message", "密碼不可為空");
//			result.put("status", "fail");
//		}else if(!pd.equals("alex")) {
//			result.put("message", "密碼錯誤");
//			result.put("status", "fail");
//		}
//		
//		RedirectView redirectTarget = new RedirectView();
//		redirectTarget.setContextRelative(true);
//		redirectTarget.setUrl("login");
//		if(result.get("status").equals("fail")) {
//			redirectAttributes.addAttribute("result", result.toString());
////			return redirectTarget;
//			return "redirect:/index.html";
//		}
//		
//		
//		redirectAttributes.addAttribute("result", result.toString());
//		return "redirect:/login";
////		return redirectTarget;
		
	}
}
