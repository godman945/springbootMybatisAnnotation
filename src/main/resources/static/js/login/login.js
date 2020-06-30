$(document).ready(function(){
	
	
	
var modal = document.getElementById('id01');
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}

});

/* 控制登入區塊 START*/
var loginSubmitController = function($scope){
	$scope.submit = function(){
		if($scope.account == undefined){
			$scope.message='帳號不可為空';
		}else if($scope.pd == undefined){
			$scope.message='密碼不可為空';
		}else{
			$scope.message='';
			
//			var formData = new FormData();
//        	formData.append("account", $scope.account);
//        	formData.append("pd", $scope.pd);
			
			
			
		}
		
	}
};

/* 控制登入區塊 END */