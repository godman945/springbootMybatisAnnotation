package com.fileupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

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
public class FileUploadController2 {
	
	@RequestMapping(value = "/uploadToClassPath",method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	 public String uploads(@RequestParam("files") MultipartFile[] uploadFiles, HttpServletRequest request,@RequestParam("test") String test) {
		
		
        //1，对文件数组做判空操作
        if (uploadFiles == null || uploadFiles.length < 1) {
            return "文件不能为空";
        }
        //2，定义文件的存储路径,
        String realPath = request.getServletContext().getRealPath("/uploadFile/");
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }
        try {
            String filePathS = "";
            //3，遍历文件数组，一个个上传
            for (int i = 0; i < uploadFiles.length; i++) {
                MultipartFile uploadFile = uploadFiles[i];
                String filename = uploadFile.getOriginalFilename();
                //服务端保存的文件对象
                File fileServer = new File(dir,filename);
                System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
                //2，实现上传
                uploadFile.transferTo(fileServer);
                String filePath = request.getScheme() + "://" +
                        request.getServerName() + ":"
                        + request.getServerPort()
                        + "/uploadFile/" + filename;
                filePathS = filePathS + "\n" + filePath;
            }
            //4，返回可供访问的网络路径
            return filePathS;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

	
	
	
	
	
	
	
	/*
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
    
	*/
    
    
    
    
    
	
	
}
