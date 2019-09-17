function load(){
	$('#referrer').val(document.referrer);
	/*alert($('#text').val());
	alert($('#pwd').val());
	var data = $('#text').val();
	seajs.use('./js/encrypt', function (encrypt) {
	var key = encrypt.getAesKey();
	var aesdata = encrypt.encrypt(data, key);
	alert("key:" + key);
	alert("data:" + aesdata);
	//先解密
	var rsDataArr = aesdata.split(String.fromCharCode(29));
	var data1 = (rsDataArr[1] || "").replace(/\r/g,"").replace(/\n/g,"").replace(/ +/g,"");
    alert("解密后:" + encrypt.aesDecrypt(data1,key));
	});*/
	$.ajax({
		//几个参数需要注意一下
	    type: "POST",//方法类型
	    dataType: "json",//预期服务器返回的数据类型
	    url: "/pertes/rsat/user/queryUser" ,//url
	    data: $('#form1').serialize(),
	    success: function (result) {
	        console.log(result);//打印服务端返回的数据(调试用)
	        if (result.code == 1) {
	        	location.href = "/pertes/index";
	        };
	        if (result.code == 0) {
	            alert(result.msg);
	            location.href = "/pertes/login";
	        };
	    },
	    error : function() {
	        alert("异常！");
	    }
	});
}

function register(){
	location.href = "/pertes/register";
}
