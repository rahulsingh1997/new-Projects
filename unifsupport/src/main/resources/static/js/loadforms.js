function openpage(id){
	var url = $("#"+id).attr("rm");
	$('#replace_div').html("<div class='w3-container' style='margin-left:100px;margin-top:20px; width: 100%; text-align: center'><i class='fa fa-spinner fa-pulse' style='font-size: 70px; color: grey;'></i></div>");
	$('#replace_div').load(url);
	tablinks=document.getElementsByClassName("abcd");
	for(i=0;i<tablinks.length;i++){
		tablinks[i].className=tablinks[i].className.replace("w3-theme-l3","");
	}
	$("#"+id).addClass("w3-theme-l3");
}

