<!DOCTYPE html>
<html>
<head>
    <title>交易明细</title>
    <#include "/common/common-trade-h5.ftl"/>
</head>
<body class="tradeDetailList">
<#if (success!true)==true>
	<#setting number_format="0.00">
	<header class="header">${fundShortName!""}<span><#if fundShortName??>（${fundCode!""}）</#if></span></header>
	<article class="article">
		<#if fundEntrustInfoList?? && (fundEntrustInfoList?size gt 0)>
			<#list (fundEntrustInfoList) as fund>
				<#if fund.ywdm == "020" || fund.ywdm == "022" || fund.ywdm == "024" || fund.ywdm == "029">
				<ul>
					<li class="clearfix li1">
						<h2 class="fl">
							<#if fund.ywdm == "020" || fund.ywdm == "022">
								买入
							<#elseif fund.ywdm == "024">
								卖出
							<#elseif fund.ywdm == "029">
								分红设置
							</#if>
						</h2>
						<div class="fr">
							<p>交易状态</p>
							<p class="col-red">
								<#if (fund.wtzt == 0)!false>
									订单已受理
								<#elseif (fund.wtzt == -1)!false>
									处理失败
								<#elseif (fund.wtzt == -2)!false>
									清算失败
								<#elseif (fund.wtzt == -3)!false>
									结算失败
								<#elseif (fund.wtzt == -4)!false>
									本地撤单失败	
								<#elseif (fund.wtzt == 1)!false>
									订单确认中
								<#elseif (fund.wtzt == 2)!false>
									订单确认成功
								<#elseif (fund.wtzt == 3)!false>
									交易完成
								<#elseif (fund.wtzt == 4)!false>
									部分成交
								<#elseif (fund.wtzt == 5)!false>
									未到款
								<#elseif (fund.wtzt == 6)!false>
									申请撤单
								<#elseif (fund.wtzt == 7)!false>
									撤单成功
								<#elseif (fund.wtzt == 8)!false>
									部分撤单
								<#elseif (fund.wtzt == 9)!false>
									退款成功
								<#elseif (fund.wtzt == 10)!false>
									划款登记
								<#elseif (fund.wtzt == 11)!false>
									退款登记
								<#elseif (fund.wtzt == 12)!false>
									已清算
								<#elseif (fund.wtzt == 13)!false>
									已结算
								<#else>
									--
								</#if>
							</p>
						</div>
					</li>
					<li class="clearfix">
						<h4 class="fl">
							<#if fund.ywdm == "020" || fund.ywdm == "022">
								申购金额（元）
							<#elseif fund.ywdm == "024">
								赎回份额（份）
							<#elseif fund.ywdm == "029">
								修改分红为
							</#if>
						</h4>
						<h4 class="fr">下单时间</h4>
					</li>
					<li class="clearfix">
						<h3 class="fl">
							<#if fund.ywdm == "020" || fund.ywdm == "022">
								${fund.wtje!"--"}
							<#elseif fund.ywdm == "024">
								${fund.wtfe!"--"}
							<#elseif fund.ywdm == "029">
								<#if (fund.fhfs == '1')>
									红利转投
								<#elseif (fund.fhfs == '2')>
									现金分红
								<#elseif (fund.fhfs == '0')>
								 	未设置
								</#if>
							</#if>
						</h3>
						<h3 class="fr">
							<#if (fund.wtrq)??>
								${((fund.wtrq!nullShow)?c)?substring(0,4)}-${((fund.wtrq!nullShow)?c)?substring(4,6)}-${((fund.wtrq!nullShow)?c)?substring(6,8)}
								<br/>
								${fund.wtsj!''}
							</#if>
						</h3>
					</li>
				</ul>
				</#if>
			</#list>
		<#else>	
			<div class="tipsError">未查到交易明细</div>
		</#if> 
	</article>
<#else>
    <#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>