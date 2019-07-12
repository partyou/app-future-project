<!DOCTYPE html>
<html>
<head>
    <title>卖基金</title>
	<#include "/common/common-trade-h5.ftl"/>
	<#include "/common/errorMessage.ftl"/>
</head>
<body class="confirmSell">

<#if (success!true)==true>

<section class="formInfo">
	<ul>
		<li>交易类型：<span>赎回</span></li>
		<li>基金名称：<span>${(otcEntrustInfo.cpmc)!""}</span></li>
		<li>赎回份额：<span>${(otcEntrustInfo.wtfe!0)?string('#,##0.00')}</span>份</li>
		<li class="clearfix">
			<div class="fl lineH38">资金返还：</div>
			<div class="clearfix bank-info">
				<div class="col-xs-2 bankLogo"><i class="sprite-bank-${(signInfo.signingBankInfo.imageName)!''}"></i></div>
	            <div class="col-xs-6 bankInfo">${signInfo.signingBankInfo.yhmc!''}（尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''}）<br><span>单笔上限${signInfo.signingBankInfo.dbed/10000}万<#if signInfo.signingBankInfo.dred?? && signInfo.signingBankInfo.dred!=0>，每日上限${signInfo.signingBankInfo.dred/10000}万</#if>。</span></div>
	            <div class="col-xs-1 iconGo"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></div>
			</div>
		</li>
		<li class="groupsBox">
			<label>交易密码</label>
			<div class="groupBox">
				<input type="hidden" id="password">
				<input novalidate="novalidate" for="password" class="password" data-value="" type="tel" placeholder="请输入6位数字交易密码"/>
				<div class="groupError"></div>
			</div>
		</li>
	</ul>
</section>
<section class="formChose">
	<a class="btn-primary hbec-btn" id="confirmSell">确认下单</a>
	<form id="confirmSellForm" >
		<input type="hidden" id="cpdm" name="cpdm" value="${(otcEntrustInfo.cpdm)!""}" />
		<input type="hidden" id="wtfe" name="wtfe" value="${(otcEntrustInfo.wtfe!0)?c}" />
		<input type="hidden" id="jymm" name="jymm" value="" />
	</form>
</section>


<script type="text/javascript">
	var flag=0;
	$(document).ready(function(){
		var obj2JJ = {
			events: function(){
				$("#confirmSell").on("touchend",function(e){
					var password=$("#password").val();
					var pwdErrorBox = $("#password").siblings(".groupError");
					$("#jymm").val(password);
					
					var transactionPassword=$("#jymm").val();
					if($.trim(transactionPassword).length == 0){
						pwdErrorBox.html("请输入6位（数字）交易密码！");
						return;
					} else if (!/^[0-9]{6}$/.test(transactionPassword)){
						pwdErrorBox.html("请输入6位（数字）交易密码！");
						return;
					}
					pwdErrorBox.html("");
					if(flag==1){
						return;
					}
					flag=1;
					var url="${globalPrefix}/fund/trade/sellFundOrderSubmit.do";
					var data=$("#confirmSellForm").serialize();
					$.ajaxFn({
				      type:"post",
				      dataType:"json",
				      url: url,
				      data: data,
				      success: function(data){
				        if(data.success){
				        	sellFundSuccess(data);
						}else{
							toErrorView('${globalPrefix}/fund/trade/sellFundFail.htm',data.result);
						}
				      },
				      error:function(){
				      	flag=0;
				      }
				    });
				});
			}
		}
		obj2JJ.events();
	});
	
	function sellFundSuccess(data){
		var entrustId=data.result.wth;
		if(entrustId==null){
			entrustId="";
		}
		window.location.href = "${globalPrefix}/fund/trade/sellFundSuccess.htm?wth="+entrustId;
	}
	
</script>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>