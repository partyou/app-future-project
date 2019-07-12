<form id="errorMessageForm" name="errorMessageForm" action="" method="post">
	<input type="hidden" id="errorMessage" name="errorMessage" value="" />
</form>


<script type="text/javascript">

	function toErrorView(url,errorMessage){
    	$("#errorMessage").val(errorMessage);
		var theForm=document.getElementById("errorMessageForm");
		theForm.action=url;
		theForm.submit();
	} 
</script>