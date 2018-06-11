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
     
    	
    	var columns = ["ID","USERNAME","AGE","DEPARTNAME"];
          $('#userTable').dataTable({ 
              
        	  
            
        	  pageLength: 3,
              pagingType : "full_numbers",
              bPaginate: true,
              bLengthChange: true,
              lengthMenu : [ [ 1, 3, 5, 10], [ 1, 3, 5, 10] ],
              responsive: true,
              bAutoWidth: false,
              processing: true,
              ordering: true,
              bServerSide: true,
              searching: false,
              sAjaxSource : "/dataTable/myAjaxTable3",
              sServerMethod: "POST",
              columns : [
                  {data: "id"},
                  {data: "userName"},
                  {data: "age"},
                  {data: "departName"}
              ],
              

             

  
    }); 
          
    });           
    </script>
 
</head>
<body>

<table id="userTable" class="table table-striped table-bordered table-hover" > 
    <thead> 
        <tr> 
            <th>id</th> 
            <th>userName</th> 
            <th>age</th>
            <th>departName</th> 

        </tr> 
    </thead> 

</table> 

</body>
</html>







<body> 




</body>