<!DOCTYPE html>
<html>
<head>
    <title>卖基金</title>
	<#include "/common/common-trade-h5.ftl"/>
</head>
<body class="sellFund">

<#if (success!true)==true>
<header class="header">${(fundInfo.fundShortName)!""}<span>（${(fundInfo.fundCode)!""}）</span></header>
<section class="formInfo">
	<ul>
		<li class="clearfix">可卖份额：
			<div class="fr"><span class="col-red">${(fundInfo.fundCanUseNum!0)?string('#,##0.00')}</span>份</div>
		</li>
		<li class="payBoxs">
			<p class="fontL">资金返回到</p>
			<div class="payBox clearfix" id="payBox">
				<div class="payWay fl active" id="capitalAccount">
					<p class="errorMsg">余额不足</p>
					<p class="h1">余额账户</p>
					<p class="h2">余额${(capitalAccountInfo.usableValue!0)?string('#,##0.00')}元</p>
				</div>
				<div class="payWay fr" id="bankAccount">
					<div class="clearfix bank-info mgt15">
						<i <#if bankInfo??>class="sprite-bank-${(bankInfo.imageName)!''}"</#if>></i>
						<div>
							<span>${(bankInfo.bankName)!""}</span><br>
							<span class="bank-num">尾号（${(esbBankAccountInfo.yhcgzh?substring(esbBankAccountInfo.yhcgzh?length-4, esbBankAccountInfo.yhcgzh?length))!''}）</span>
						</div>
					</div>
				</div>
			</div>
		</li>
		<li class="accountBox groupsBox">
			<label>卖出份额</label>
			<div class="groupBox">
				<form id="sellFundForm" name="sellFundForm" action="${globalPrefix}/fund/trade/sellDeposit/sellFundOrder.htm" method="post">
					<input id="entrustShare" novalidate="novalidate" name="entrustShare" type="number" placeholder="<#if (fundInfo.fristRansomMinAmount!0?c)==0>>0<#else>≥${fundInfo.fristRansomMinAmount?c}</#if>元">份<a id="redeemAll" class="redeemAll" >全部赎回</a>
					<input type="hidden" id="fundShortName" name="fundShortName" value="${(fundInfo.fundShortName)!''}" />
					<input type="hidden" id="fundCode" name="fundCode" value="${(fundInfo.fundCode)!''}" />
					<input type="hidden" id="taCode" name="taCode" value="${(fundInfo.taCode)!''}" />
					<input type="hidden" id="bankName" name="bankName" value="${(bankInfo.bankName)!''}" />
					<input type="hidden" id="imageName" name="imageName" value="${(bankInfo.imageName)!''}" />
					<input type="hidden" id="yhcgzh" name="yhcgzh" value="${(esbBankAccountInfo.yhcgzh)!''}" />
					<input type="hidden" id="yhdm" name="yhdm" value="${(esbBankAccountInfo.yhdm)!''}" />
					<input type="hidden" id="capitalChannel" name="capitalChannel" value="1" />
				</form>
				
				<input type="hidden" id="fundCanUseNum" name="fundCanUseNum" value="<#if fundInfo??>${(fundInfo.fundCanUseNum!0)?c}</#if>" />
				<input type="hidden" id="positionMinAmount" name="positionMinAmount" value="<#if fundInfo??>${(fundInfo.positionMinAmount!0)?c}</#if>" />
				<input type="hidden" id="fristRansomMinAmount" name="fristRansomMinAmount" value="<#if fundInfo??>${(fundInfo.fristRansomMinAmount!0)?c}</#if>" />
				<div class="groupError"></div>
			</div>
		</li>
	</ul>
</section>
<section class="formChose">
	<a class="btn-primary hbec-btn" id="btnTonext">下一步</a>
</section>

<script type="text/javascript">
	$(document).ready(function(){
		var obj2JJ = {
			init: function(){
				setTimeout(function(){
					$("body").scrollTop(0);
				},51);
				this.events();
			},
			events: function(){
				var payWays = $("#payBox .payWay");
				payWays.on("touchend",function(e){
					if( $("#payBox .gray").length > 0){
						return;
					}
					var T = $(e.currentTarget);
					if(!T.hasClass("active")){
						payWays.removeClass("active");
						T.addClass("active");
					}
					var id=T.attr('id');
					if(id=='capitalAccount'){
						$("#capitalChannel").val("1");
					}else{
						$("#capitalChannel").val("2");
					}
				});
				$("#redeemAll").on("touchend",function(e){
					var fundCanUseNum=$("#fundCanUseNum").val();
					$("#entrustShare").val(fundCanUseNum);
				});
				
				function checkForm(e){

					var fundCanUseNum=$("#fundCanUseNum").val();
					var entrustShare=$("#entrustShare").val();
					var positionMinAmount=$("#positionMinAmount").val();
					var pwdErrorBox = $("#sellFundForm").siblings(".groupError");
					
					var fristRansomMinAmount=$("#fristRansomMinAmount").val();
										 
					//输入份额为空提示
					if(typeof(entrustShare) == "undefined" || entrustShare == ""){
						pwdErrorBox.html("输入份额不能为空或非法字符！");
						return false;
					}
					//输入份额不正确，提示
					if(typeof(entrustShare) != "undefined" && entrustShare != "" && !/^[0-9]+(\.[0-9]{1,2})?$/.test(entrustShare)){
						pwdErrorBox.html("请输入正确的卖出份额！");
						return false;
					}
					//赎回份额不能小于fristRansomMinAmount
					if(entrustShare == 0){
						pwdErrorBox.html("卖出份额不能为0！");
						return false;
					}
					
					if(Number(entrustShare)<Number(fristRansomMinAmount)){
						if(Number(fristRansomMinAmount)<=Number(fundCanUseNum)){
							pwdErrorBox.html("最低赎回份额不能低于"+fristRansomMinAmount+"份，建议全额赎回");
							return;
						}
					}
					
					if( (entrustShare - fundCanUseNum) > 0 ){//输入份额大于可用份额，提示
						pwdErrorBox.html("输入份额大于可用份额，可用份额为"+fundCanUseNum);
						return false;
					}
					
					if(0<(fundCanUseNum-entrustShare) && (fundCanUseNum-entrustShare) < positionMinAmount ){//赎回后份额低于个人赎回底线，不可赎回
						pwdErrorBox.html("剩余持仓将低于最低持有份额" + positionMinAmount + "份，建议全额赎回");
						return false;
					}
					pwdErrorBox.html("");
					$("#btnTonext").attr("disabled", true);
					$("#sellFundForm").submit();
				}
				$("#btnTonext").on("touchend",function(e){
					checkForm(e);
				});
				$("form").submit(function(e){
					if( $("#btnTonext").attr("disabled") == "true" || $("#btnTonext").attr("disabled") == "disabled" ) {
		                return;
		            }
					checkForm(e);
					return false;
				});
			}
		}
		obj2JJ.init();
	});
	
	
	
</script>

<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>