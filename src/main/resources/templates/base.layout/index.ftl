<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title></title>
	
</head>
<body>
	
	<h1>hello world</h1>


	 
	 
	 
	 <#if user?exists>
	    <#list user as str>
	 	${str!}
	 	</#list>
	 </#if>
	 
	 
	 
	 
</body>
</html>