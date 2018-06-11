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
		
		var table = $('#userTable').dataTable({ 
	              

	            
	        	  pageLength: 3,
	              pagingType : "full_numbers",
	              bPaginate: true,
	              bLengthChange: true,
	              lengthMenu : [ [ 1, 3, 5, 10], [ 1, 3, 5, 10] ],
	              responsive: false,
	              bAutoWidth: false,
	              processing: false,
	              ordering: true,
	              bServerSide: true,
	              searching: true,
	              sAjaxSource : "/dataTable/myAjaxTable4",
	              sServerMethod: "POST",
	              columns : [
	                  {data: "id"},
	                  {data: "userName"},
	                  {data: "age"},
	                  {data: "departName"}
	              ],
	              
	
	              columnDefs: [
	                  {
	                     targets: [0,1,2,3],
	                     className: 'dt-body-center'
	                  }
	               ],



	
	  
		}); 
	          

	    // DataTable
	    var table = $('#userTable').DataTable();
	  
	    $('#searchNameBtn').on( 'click', function () {
	    	
	        table.search($('#searchName').val()).draw();
	        
	    } );
	  

	  $('#userTable_filter').remove();
	  

	  
    });           
    </script>
 
</head>
<body>
<input type="input" id="searchName"><input type="button" id="searchNameBtn" value="search"> 

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