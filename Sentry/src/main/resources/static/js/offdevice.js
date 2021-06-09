function offdevice(){
	 $.ajax({
	    url: "offDevice",
	    success: function (data){
            console.log("success");
       		},
	       error: function (e){
	         console.log(e);
	      }
		})
      
}