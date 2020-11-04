package com.fileupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/upload",method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles,@RequestParam("test") String test){
	
		System.out.println("OKOKOK - 貝絲成功 uploadFileMulti  new new");
		
		System.out.println("test ： "+test);
		
		
	    // 取得檔案名稱
	    String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
	            .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
	
	    if (StringUtils.isEmpty(uploadedFileName)) {
	        return new ResponseEntity("請選擇檔案!", HttpStatus.OK);
	    }
	
	    try {
	
	        saveUploadedFiles(Arrays.asList(uploadfiles));
	
	    } catch (IOException e) {
	    	System.out.println("exception : "+e);
	    	
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

            String UPLOADED_FOLDER = "D:/BessieFile/";
            
           // Resource resource = resourceLoader.getResource("classpath:/templates/");

            byte[] bytes = file.getBytes();
            //Path path = Paths.get(".//upload//" + file.getOriginalFilename());
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }
	
    
    
    
  @RequestMapping(value = "/BessieTestPage",method = { RequestMethod.POST, RequestMethod.GET })
  //  @PostMapping("/BessieTestPage")
	@ResponseBody
	public Map BessieTestPage(@RequestParam("BESSIE") int BESSIE,@RequestParam("ALEX") int ALEX){
	  Map<String, Object> mapResult = new HashMap<>();
	  
	    try {
	    	System.out.println(	"BESSIE : "+BESSIE);
			System.out.println("ALEX : "+ALEX);
	        mapResult.put("status", true);
	        
	
	    } catch (Exception e) {
	    	System.out.println("exception : "+e);
	    	 mapResult.put("status", false);
	        return mapResult;
	    }
	    return mapResult;
	}

    
    
    
    
    
	
	
}
