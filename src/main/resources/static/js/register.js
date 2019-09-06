function register(){
	if ($("input[name='accountNum']").val() == "") {
        alert("账号不能为空");
        return false;
    }
    else if ($("input[name='password']").val() == "") {
        alert("密码不能为空");

        return false;
    }
    else {
    	$('#referrer').val(document.referrer);
		$.ajax({
			//几个参数需要注意一下
		    type: "POST",//方法类型
		    dataType: "json",//预期服务器返回的数据类型
		    url: "/pertes/rsat/user/addUser" ,//url
		    data: $('#adduser').serialize(),
		    success: function (result) {
		        console.log(result);//打印服务端返回的数据(调试用)
		        if (result.code == 1) {
		        	location.href = "/pertes/index";
		        };
		        if (result.code == 0) {
		            alert("登录失败，账号或密码错误");
		            location.href = "/pertes/login";
		        };
		    },
		    error : function() {
		        alert("异常！");
		    }
		});
    }
}
