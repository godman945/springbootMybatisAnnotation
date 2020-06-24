$(document).ready(function(){
	
console.log("DDD");		


let app = new Vue({
    el: '#loginDiv',/*定義Vue作用範圍，el指的是element*/
    data: {
        user: { 
        	account: "",
        	pd:""
        },
        message: '',
        loginResult:"" //登入結果
    },
    methods: { 
        loginFunc: function () {
            let obj = this;
            $.ajax({
	            url: "checkLogin",
	            data: obj.user ,
	            type:"POST",
				dataType:"JSON",
	            success: function (response) {
	             //   vm.loginResult=text;
	            	console.log(response);
	            	obj.message = response;
	            },
				error: function(response) {
					alert("系統繁忙，請稍後再試！");
				}
        	});
            
            
            console.log(obj);
            console.log(obj.user);
            console.log(obj.user.account);
            console.log(obj.user.pd);
        }
    }
});//end new Vue


});
