<!DOCTYPE html>
<html>
<head>
	<#include "/common/common-trade-h5.ftl"/>
    <title>交易详情</title>
</head>
<body class="tradeDetail">

<#if (success!true)==true>

<#if fundEntrustInfo??>
<section class="formInfo">
	<ul>
		<li>交易类型：
			<span>
			<#if ((fundEntrustInfo.ywdm)!"") == "022">
				申购 
			<#elseif ((fundEntrustInfo.ywdm)!"") == "024">
				赎回
			<#elseif ((fundEntrustInfo.ywdm)!"") == "029">
				分红设置
			</#if>
			</span>
		</li>
		<li>基金名称：
			<span>
				${fundEntrustInfo.cpmc!""}
			</span>
		</li>
		<li>收费方式：
			<span>
				<#if (fundEntrustInfo.sffs == "1")!false>
					 前端收费
				<#elseif (fundEntrustInfo.sffs == "2")!false>
					后端收费
				<#else>
					--
				</#if>
			</span>
		</li>
		<#if ((fundEntrustInfo.ywdm)!"") == "022">
		<li>申购金额：
			<span>
				${(fundEntrustInfo.wtje?string("0.00"))!"--"}
			</span>
		</li>
		<#elseif ((fundEntrustInfo.ywdm)!"") == "024">
		<li>赎回份额：
			<span>
				${(fundEntrustInfo.wtfe?string("0.00"))!"--"}
			</span>
		</li>
		<#elseif ((fundEntrustInfo.ywdm)!"") == "029">
		<li>分红方式：
			<span>
				<#if ((fundEntrustInfo.fhfs)!"") == '1'>
				红利转投
				<#elseif ((fundEntrustInfo.fhfs)!"") == '2'>
				现金分红
				<#elseif ((fundEntrustInfo.fhfs)!"") == '0'>
				 未设置
				</#if>
			</span>
		</li>
		</#if>

		<#if ((fundEntrustInfo.ywdm)!"") == "022" || ((fundEntrustInfo.ywdm)!"") == "024">
			<#if fundEntrustInfo.zffs??>
			<li class="clearfix">
				<#if fundEntrustInfo.zffs=='2'>
				<div class="fl lineH38">支付方式：</div>
				<div class="clearfix bank-info">
					<#--<i class="fl sprite-bank-${bankInfo.imageName!''}"></i>
					<div>
						<span>${fundEntrustInfo.bankName!""}</span><br>
						<span class="bank-num">尾号（${(fundEntrustInfo.bankCardCode?substring(fundEntrustInfo.bankCardCode?length-4, fundEntrustInfo.bankCardCode?length))!''}）</span>
					</div>-->
				</div>
				<#else>
					支付方式：
					<span>
						余额账户
					</span>
				</#if>
			</li>
			</#if>
		</#if>
		<li>交易状态：
			<span>
				<#if (fundEntrustInfo.wtzt == 0)!false>
					订单已受理
				<#elseif (fundEntrustInfo.wtzt == -1)!false>
					处理失败
				<#elseif (fundEntrustInfo.wtzt == -2)!false>
					清算失败
				<#elseif (fundEntrustInfo.wtzt == -3)!false>
					结算失败
				<#elseif (fundEntrustInfo.wtzt == -4)!false>
					本地撤单失败	
				<#elseif (fundEntrustInfo.wtzt == 1)!false>
					订单确认中
				<#elseif (fundEntrustInfo.wtzt == 2)!false>
					订单确认成功
				<#elseif (fundEntrustInfo.wtzt == 3)!false>
					交易完成
				<#elseif (fundEntrustInfo.wtzt == 4)!false>
					部分成交
				<#elseif (fundEntrustInfo.wtzt == 5)!false>
					未到款
				<#elseif (fundEntrustInfo.wtzt == 6)!false>
					申请撤单
				<#elseif (fundEntrustInfo.wtzt == 7)!false>
					撤单成功
				<#elseif (fundEntrustInfo.wtzt == 8)!false>
					部分撤单
				<#elseif (fundEntrustInfo.wtzt == 9)!false>
					退款成功
				<#elseif (fundEntrustInfo.wtzt == 10)!false>
					划款登记
				<#elseif (fundEntrustInfo.wtzt == 11)!false>
					退款登记
				<#elseif (fundEntrustInfo.wtzt == 12)!false>
					已清算
				<#elseif (fundEntrustInfo.wtzt == 13)!false>
					已结算
				</#if>
			</span>
		</li>
	</ul>
</section>
<section class="formChose">
	<input type="hidden" id="backUrl" name="backUrl" value="${backUrl!''}" />
	<a href="${backUrl!''}" class="btn-primary hbec-btn">返回</a>
</section>
</#if>

<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>
