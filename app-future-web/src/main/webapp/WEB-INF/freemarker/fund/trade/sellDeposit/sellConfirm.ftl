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
		<li>基金名称：<span>${(fundEntrustInfo.fundShortName)!""}</span></li>
		<li>赎回份额：<span>${(fundEntrustInfo.entrustShare!0)?string('#,##0.00')}</span>份</li>
		<li class="clearfix">
			<#if fundEntrustInfo.capitalChannel=='2'>
				<div class="fl lineH38">资金返还：</div>
				<div class="clearfix bank-info">
					<i class="fl <#if bankInfo??>sprite-bank-${(bankInfo.imageName)!''}</#if>"></i>
					<div>
						<span>${(bankInfo.bankName)!""}</span><br>
						<span class="bank-num">尾号（${(esbBankAccountInfo.yhcgzh?substring(esbBankAccountInfo.yhcgzh?length-4, esbBankAccountInfo.yhcgzh?length))!''}）</span>
					</div>
				</div>
			<#else>资金返还：<span>余额账户</span></#if>
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
		<input type="hidden" id="fundShortName" name="fundShortName" value="${(fundEntrustInfo.fundShortName)!''}" />
		<input type="hidden" id="fundCode" name="fundCode" value="${(fundEntrustInfo.fundCode)!''}" />
		<input type="hidden" id="taCode" name="taCode" value="${(fundEntrustInfo.taCode)!''}" />
		<input type="hidden" id="entrustShare" name="entrustShare" value="${(fundEntrustInfo.entrustShare!0)?c}" />
		<input type="hidden" id="bankName" name="bankName" value="${(bankInfo.bankName)!''}" />
		<input type="hidden" id="imageName" name="imageName" value="${(bankInfo.imageName)!''}" />
		<input type="hidden" id="bankCardCode" name="bankCardCode" value="${(esbBankAccountInfo.yhcgzh)!''}" />
		<input type="hidden" id="bankCode" name="bankCode" value="${(esbBankAccountInfo.yhdm)!''}" />
		<input type="hidden" id="transactionPassword" name="transactionPassword" value="" />
		<input type="hidden" id="capitalChannel" name="capitalChannel" value="${(fundEntrustInfo.capitalChannel)!''}" />
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
					$("#transactionPassword").val(password);
					
					var transactionPassword=$("#transactionPassword").val();
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
					var url="/fund/trade/sellDeposit/sellFundOrderSubmit.do";
					var data=$("#confirmSellForm").serialize();
					$.ajaxFn({
				      type:"post",
				      dataType:"json",
				      url: "${globalPrefix}"+url,
				      data: data,
				      success: function(data){
				        if(data.success){
				        	sellFundSuccess(data);
						}else{
							toErrorView('${globalPrefix}/fund/trade/sellDeposit/sellFundFail.htm',data.result);
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
		var entrustId=data.result.entrustId;
		if(entrustId==null){
			entrustId="";
		}
		window.location.href = "${globalPrefix}"+"/fund/trade/sellDeposit/sellFundSuccess.htm?tradeDate="+entrustId;
	}
	
</script>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>