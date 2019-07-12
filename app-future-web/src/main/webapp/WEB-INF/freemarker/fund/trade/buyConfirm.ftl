<!DOCTYPE html>
<html>
<head>
    <title>买基金</title>
	<#include "/common/common-trade-h5.ftl"/>
	<#include "/common/errorMessage.ftl"/>
</head>
<body class="confirmBuy">
<#if (success!true)==true>
<#assign tradeType="申购">
<section class="formInfo">
	<ul>
		<form id="orderForm">
			<li>交易类型：<span>${tradeType}</span></li>
			<li>基金名称：<span>${(product.cpmc)!""}</span></li>
			<li>收费方式：<span><#if product.sffs ??><#if product.sffs == 1>前端收费<#elseif product.sffs == 2>后端收费<#elseif product.sffs == 4>C类收费</#if></#if></span></li>
			<li>${tradeType}金额：<span>${(otcProductBaseInfo.wtje!"")?string("0.00")}元</span></li>
			<li>${tradeType}费率：<#if entrustInfo.fundRates?? && (entrustInfo.fundRates != 0)><span class="font-die">${entrustInfo.fundRates*100}%</span></#if><span class="font-lv"><#if entrustInfo.fundRatesDiscount?? && (entrustInfo.fundRatesDiscount != 0)>${entrustInfo.fundRatesDiscount*100}%<#else>免费</#if></span></li>
			<li>预估手续费：<span><#if entrustInfo.fundFeeBase?? && (entrustInfo.fundFeeBase != 0)><span class="font-die">${entrustInfo.fundFeeBase?string("0.00")}元</span><font color="red">${entrustInfo.fundFeeDiscount?string("0.00")}</font>元</span><#else><font color="red">0 元</font></#if></li>
			<li>
				<div style="overflow:hidden;">
				<div style="width:25%;float:left;clear:both;line-height:96px;">支付银行：</div>
				<div style="width:70%;float:right;padding-top:30px;">
				<#if signInfoList?? && signInfoList?size gt 0>
	            <#list signInfoList as signInfo>
	            <#if signInfo_index = 0>
	                <a href="${globalPrefix}/fund/trade/choseBankCard.htm?yhkh=${(signInfo.yhkh)!''}&cpdm=${product.cpdm!''}&wtje=${(otcProductBaseInfo.wtje!"")?string("0.00")}" title="选择支付银行卡">
	                    <div style="float:left;" class="col-xs-2 bankLogo"><i class="sprite-bank-${(signInfo.signingBankInfo.imageName)!''}"></i></div>
	                    <div style="float:left;"class="col-xs-6 bankInfo"><#if signInfo.signingBankInfo??>${signInfo.signingBankInfo.yhmc!''}</#if>（尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''}）<br><span><#if signInfo.signingBankInfo.dbed?? && (signInfo.signingBankInfo.dbed>0)>单笔上限${signInfo.signingBankInfo.dbed/10000}万</#if><#if signInfo.signingBankInfo.dred?? && (signInfo.signingBankInfo.dred>0)>，每日上限${signInfo.signingBankInfo.dred/10000}万</#if>。</span></div>
	                    <div style="float:left;"class="col-xs-1 iconGo"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></div>
	                    <input type="hidden" id="yhkh" name="yhkh" value="${(signInfo.yhkh)!''}">
	                </a>
	            </#if>    
	            </#list>    
	            <#else>
	                <a href="${configs.get('hbec.apps.account.url')}/auth/quickbind/kh/index.htm?referrer=${globalPrefix}/otc/trade/buyView.htm&fundCode=${product.cpdm!''}" title="添加支付银行卡">
	                    <div class="col-xs-8 bankGoAdd"><span class="glyphicon glyphicon-plus"></span>添加支付银行卡</div>
	                    <div class="col-xs-1 iconGo"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></div>
	                </a>
	            </#if>
				</div>
				</div>
			</li>
			<li class="groupsBox">
				<label>交易密码</label>
				<div class="groupBox">
					<input type="hidden" id="transactionPassword" name="jymm">
					<input for="transactionPassword" data-value="" class="password" type="tel" placeholder="请输入6位数字交易密码" novalidate="novalidate"/>
					<div class="groupError"></div>
				</div>
			</li>
			<input name="cpdm" type="hidden" value="${(product.cpdm)!''}"/>
			<input name="jgdm" type="hidden" value="${(jgdm.cpdm)!''}"/>
			<input name="wtje" id="wtje" type="hidden" value="${((otcProductBaseInfo.wtje)!"")?c}"/>
		</form>
	</ul>
</section>
<section class="formChose">
	<div class="btn-primary hbec-btn active" id="buySubmit">确认下单</div>
</section>
<script type="text/javascript">
	$(document).ready(function(){
		var order = {
			init: function(){
				var thiss = this;
				$("#buySubmit").on("touchend",function(){
					if( !$(this).hasClass("active") ){
						return;
					}
					thiss.submitCheck();
				});
				$("form").submit(function(){
					if( !$("#buySubmit").hasClass("active") ){
						return;
					}
					thiss.submitCheck();
					return false;
				});
			},
			transPswCheck: function(T){
				var Tv = T.val();
				var Flag = true;
				if(Tv == ""){
					T.siblings(".groupError").html("请输入6位（数字）交易密码！");
					Flag = false;
				}else if(!/^[0-9]{6}$/.test(Tv)){
					T.siblings(".groupError").html("请输入6位（数字）交易密码！");
					Flag = false;
				}else{
					T.siblings(".groupError").html("");
				}
				return Flag;
			},
			submit: function(){
				$.ajaxFn({
			        type : "POST",
			        url : "${globalPrefix}/fund/trade/buyFundOrder.do",
			        data: $("#orderForm").serialize(),
			        dataType: "json",
			        error : function(){
			        	$("#buySubmit").addClass("active");
			        	$.alert({msg:"买入失败！",modal:true});
			        },
			        success: function(data){
						if(data.success){
			        		window.location.href ="${globalPrefix}/fund/trade/buySuccess.htm?wth="+ data.result.wth;
			        	}else{
			        		$("#buySubmit").addClass("active");
			        		toErrorView('${globalPrefix}/fund/trade/buyFundFail.htm',data.result);
			        	}
			        }
			    });
			},
			submitCheck: function(){
				var yhkh=$("#yhkh").val();
				if(yhkh==null || yhkh=='' || yhkh=='undefined'){
                    $.alert("请先完成支付银行卡的绑定！");
                    return false;
                }
			
				if(this.transPswCheck($("#transactionPassword"))){
					var thiss = this;
					$("#buySubmit").removeClass("active");
					thiss.submit();
				}
			}
		};
		order.init();
	});
</script>
<#else>
    <#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>