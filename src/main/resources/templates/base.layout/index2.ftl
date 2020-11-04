<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/login/fileuploadbessie.js"></script>
</head>
<body>
     第一支<br>
     
<img src="image/c.jpg"></img>
</body>
</html>


<!--方法1-->
<form method="POST" enctype="multipart/form-data" id="UploadForm">
	<input  type="text"  name="test" value="AlexLoveBessie" /><br> 
     <input type="file" name="files"  multiple="multiple"/>NEW<br/>
     <input type="button" value="Submit" id="btnSubmit"/>
</form>


<!--方法2 uploadToClassPath-->
<form method="POST" enctype="multipart/form-data" id="UploadForm2">
	<input  type="text"  name="test" value="AlexLoveBessie" /><br> 
     <input type="file" name="files" multiple="multiple">OLD<br/>
     <input type="button" value="SubmitNEW" id="btnSubmit2"/>
</form>


<!--方法2 downLoad-->
<a href="download/貝絲_downloadTest.pdf">download</a><br>

<a href="download">download沒帶參數</a>


<div>
	<input type="button" value="Submit" id="BessieTestPage"/>導頁至BessieTestPage<br>
</div>