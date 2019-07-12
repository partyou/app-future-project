<#-- 对数字类型格式化，正数为红色，负数为绿色 -->
<#function formatData num fm>
	<#local result = "" />
	<#if num?? && (num?string != "--") && (num?string != "0")>
		<#local numb = (num?c)?number />
		<#if numb lt 0>
			<#local result = "<font color='green'>"+num?string(fm)+"</font>" />
		<#elseif numb gt 0>
			<#local result = "<font color='red'>+"+num?string(fm)+"</font>" />
		</#if>
	<#else>	
		<#local result = num />
	</#if>
	<#return result>
</#function>