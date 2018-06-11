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
     
          $('#userTable').dataTable({ 
           pageLength: 10, 
            
                bPaginate: true, 
                bLengthChange: true, 
                lengthMenu : [ [ 3, 5, 10, -1 ], [ 3, 5, 10, "All" ] ], 
                bAutoWidth: false, 
                processing: true, 
                ordering: true, 
                serverSide: true, 
                searching: true,  
                ajax : { 
                    "url":"/dataTable/myAjaxTable2", 
                    "type":"POST", 
                    dataType : "json"
                     
                }, 
                columns : [ 
                    {data: "id"}, 
                    {data: "departName"}, 
                    {data: "remark"}
                    
                    
                    
                ], 
               

            });  
             

  
    }); 
    </script>
 
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

</body>
</html>







<body> 




</body>