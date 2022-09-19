const togglesidebar = () =>{
	
  if ($(".sidebar").is(":visible")){
    //true
    $(".sidebar").css("dispaly","none");
    $(".content").css("margin-left","0%");
    
  }else{
     $(".sidebar").css("dispaly","block");
    $(".content").css("margin-left","20%");
    
    
    }
  };