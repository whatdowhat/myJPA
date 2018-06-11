<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/> 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script> 
<script> 
    $(document).ready(function(){ 
    	

  
    }); 
    
    function myAjax(){
    	alert('test');
      	$.ajax({ 

      		
    		url : '/tom', 
    		type : 'post', 
    		success : function(result){ 
			
    		console.dir(result); 
    		alert('success!'); 
    		alert(result.my);

    		}, 

    		error : function(jqXHR,status,err){ 

    		alert('fail ::'+status+'::'+err+':::'+jqXHR); 
    		console.dir(jqXHR); 
    		console.dir(err); 

    		} 

    	});
    	  
      }  
        
    </script>
</head>
<body>
<h1> come here </h1>



 
</head>
<body>

<table id="userTable" > 
    <thead> 
        <tr> 
            <th>id</th> 
            <th>departName</th> 
            <th>remark</th>
           

        </tr> 
    </thead> 
    <!-- tbody ��洹� ���� ����. --> 
</table> 

<input type="button" onclick="myAjax()" value="click this"> 

</body>
</html>