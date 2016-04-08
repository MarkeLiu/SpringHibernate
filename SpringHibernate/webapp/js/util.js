$.extend($.fn.validatebox.defaults.rules, {
	    pwd: {
	        validator: function(value, param){
	        	//alert(param);
	        	var value2=$(param[0]).val();
	            return value == value2;
	        },
	        message: '俩次输入的密码不一致！'
	    }
});