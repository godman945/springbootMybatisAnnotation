package com.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FileDownloadController {


    @Value ( "${file.upload.root.dir}" )
    String fileUploadRootDir;

    

    @GetMapping("/download/{fileName}")
    @ResponseBody
    public ResponseEntity<Object> downloadFile(@PathVariable(name = "fileName") String fileName) throws FileNotFoundException {
    	ResponseEntity<Object> responseEntity = null;
    	try {
	        File file = new File ( fileUploadRootDir+fileName);
	        
	        InputStreamResource resource = new InputStreamResource ( new FileInputStream ( file ) );
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.add ( "Content-Disposition",String.format("attachment;filename=\"%s",new String(fileName.getBytes("UTF-8"), "ISO-8859-1")));
	        headers.add ( "Cache-Control","no-cache,no-store,must-revalidate" );
	        headers.add ( "Pragma","no-cache" );
	        headers.add ( "Expires","0" );
	
	        responseEntity = ResponseEntity.ok()
	                .headers ( headers )
	                .contentLength ( file.length ())
	                .contentType(MediaType.parseMediaType ( "application/pdf" ))//application/txt
	                .body(resource);
    	}catch(Exception e){
    		System.out.println("error :"+e.getMessage());
    	}

        return responseEntity;
    }



}


