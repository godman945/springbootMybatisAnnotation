$(document).ready(function(){
	alert('fileUpload N EW')
	
	
	
	$("#BessieTestPage").click(function (event) {
		alert('bessieTestPage new')
		

		alert('bessieTestPage int	' )
		$.ajax({
			url: "BessieTestPage",
			type:"post",
			dataType : "json",
			data:{
				 "BESSIE": 1,
				 "ALEX": 2
			},
			success: function (data) {

		            console.log("SUCCESS : "+ JSON.stringify(data));
		            console.log("status "+data.status )
		            
		            alert('success success success')
		
		        },
		        error: function (e) {
		        	
		        	 alert('error error error')

		            console.log("ERROR : "+  JSON.stringify(e));

		        }
		});
    });
});

/*
$(function(){
	$("#BessieTestPage").click(function (event) {
		
		alert('bessieTestPage int	' )
		$.ajax({
			//url: "BessieTestPage",
			url: "BessieTestPage",
			
			data:{
				 "BESSIE": 1,
				 "ALEX": 2
			},
			type:"post",
			dataType:"json",
			success:function(response, status){
				alert('success')
			},
			error: function(xtl) {
				alert("系統繁忙，請稍後再試！");
			}
		});
    });
	
	 
  })
  */
  


//方法1
$(function(){
	$("#btnSubmit").click(function (event) {

        //ajax提交的話她會一直重新run程式直到回傳,你可以將此行註解使用開發者工具看一下console就知道了
        //event.preventDefault();

        uploadFile();
    });
	
	 uploadFile = function() {
	    // 取得form
	    var form = $('#UploadForm')[0]; //取得HTML中第一個form id為UploadForm

	    var data = new FormData(form); //將form內的所有訊息打包成FormData object

	
	    $("#btnSubmit").prop("disabled", true);

	    alert("post checkLogin checkLogin")
	    
	    $.ajax({
	        type: "POST",               //使用POST傳輸,檔案上傳只能用POST
	        enctype: 'multipart/form-data', //將資料加密傳輸 檔案上傳一定要有的屬性
	        //url: "/api/upload/multi", //要傳輸對應的接口
	       url: "upload", //要傳輸對應的接口
	        //url: "/checkLogin", //要傳輸對應的接口
	        data: data,         //要傳輸的資料,我們將form 內upload打包成data
	        processData: false, //防止jquery將data變成query String
	        contentType: false, 
	        cache: false,  //不做快取
	        async : false, //設為同步
	        timeout: 1000000, //設定傳輸的timeout,時間內沒完成則中斷
	        success: function (data) {

	            $("#result").text(data);//填入提示訊息到result標籤內
	            console.log("SUCCESS : ", data);
	            $("#btnSubmit").prop("disabled", false);
	            
	            
	            alert('success success success')
	
	        },
	        error: function (e) {
	        	
	        	 alert('error error error')

	            $("#result").text(e.responseText); //填入提示訊息到result標籤內
	            console.log("ERROR : ", e);
	            $("#btnSubmit").prop("disabled", false);

	        }
	    })
	}
	 
  })

  
  
  //方法2
$(function(){
	$("#btnSubmit2").click(function (event) {

        //ajax提交的話她會一直重新run程式直到回傳,你可以將此行註解使用開發者工具看一下console就知道了
        //event.preventDefault();

        uploadFile();
    });
	
	 uploadFile = function() {
	    // 取得form
	    var form = $('#UploadForm2')[0]; //取得HTML中第一個form id為UploadForm

	    var data = new FormData(form); //將form內的所有訊息打包成FormData object

	
	    $("#btnSubmit2").prop("disabled", true);

	    alert("post checkLogin checkLogin")
	    
	    $.ajax({
	        type: "POST",               //使用POST傳輸,檔案上傳只能用POST
	        enctype: 'multipart/form-data', //將資料加密傳輸 檔案上傳一定要有的屬性
	        //url: "/api/upload/multi", //要傳輸對應的接口
	       url: "uploadToClassPath", //要傳輸對應的接口
	        //url: "/checkLogin", //要傳輸對應的接口
	        data: data,         //要傳輸的資料,我們將form 內upload打包成data
	        processData: false, //防止jquery將data變成query String
	        contentType: false, 
	        cache: false,  //不做快取
	        async : false, //設為同步
	        timeout: 1000000, //設定傳輸的timeout,時間內沒完成則中斷
	        success: function (data) {

	            $("#result").text(data);//填入提示訊息到result標籤內
	            console.log("SUCCESS : ", data);
	            $("#btnSubmit2").prop("disabled", false);
	            
	            
	            alert('success success success')
	
	        },
	        error: function (e) {
	        	
	        	 alert('error error error')

	            $("#result").text(e.responseText); //填入提示訊息到result標籤內
	            console.log("ERROR : ", e);
	            $("#btnSubmit2").prop("disabled", false);

	        }
	    })
	}
	 
  })