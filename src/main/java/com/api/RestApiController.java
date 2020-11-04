package com.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RestApiController {
	
	/*
	@RequestMapping(value = "/upload",method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles){
	
		System.out.println("貝絲成功 uploadFileMulti");
		
		
	    // 取得檔案名稱
	    String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
	            .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
	
	    if (StringUtils.isEmpty(uploadedFileName)) {
	        return new ResponseEntity("請選擇檔案!", HttpStatus.OK);
	    }
	
	    try {
	
	        saveUploadedFiles(Arrays.asList(uploadfiles));
	
	    } catch (IOException e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	    return new ResponseEntity("成功上傳 - "
	            + uploadedFileName, HttpStatus.OK);
	
	}
	
	//將檔案儲存
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //繼續下一個檔案
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(".//upload//" + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }
    */
	
	
	
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
