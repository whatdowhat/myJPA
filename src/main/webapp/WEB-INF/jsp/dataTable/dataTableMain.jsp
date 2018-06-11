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
        
        	  bPaginate: true, 
                bLengthChange: true, 
                bAutoWidth: false, 
                processing: true, 
                ordering: true, 
                serverSide: true, 
                searching: true,  
                processing: true,
                
                bJQueryUI: true,
                ajax : { 
                    "url":"/dataTable/myAjaxTable", 
                    "type":"POST", 
                    dataType : "json"
                     
                }, 
                columns : [ 
                    {data: "id"}, 
                    {data: "userName"}, 
                    {data: "age"},
                    {data: "departName"}
                    
                    
                ], 
               

            });  
             

/*           var table = $('#example').DataTable();
          
          table.columns( '.select-filter' ).every( function () {
              var that = this;
           
              // Create the select list and search operation
              var select = $('<select />')
                  .appendTo(
                      this.footer()
                  )
                  .on( 'change', function () {
                      that
                          .search( $(this).val() )
                          .draw();
                  } );
           
              // Get the search data for the first column and add to the select list
              this
                  .cache( 'search' )
                  .sort()
                  .unique()
                  .each( function ( d ) {
                      select.append( $('<option value="'+d+'">'+d+'</option>') );
                  } );
          } ); */
          
  
    }); 
    </script>
 
</head>
<body>
<input type="text" id="searchName"><input type="button" id="searchNameBtn" value="search">
<table id="userTable" > 
    <thead> 
        <tr> 
            <th>id</th> 
            <th>userName</th> 
            <th>age</th>
            <th>departName</th> 

        </tr> 
    </thead> 
    <!-- tbody 태그 필요 없다. --> 
</table> 

</body>
</html>







<body> 




</body>