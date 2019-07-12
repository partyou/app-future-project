<!DOCTYPE html>
<html>
<head>
    <#include "/common/common-h5-otc.ftl"/>
    <title>选择银行卡</title>
</head>
<body class="choseBankCard">
	<#if signInfoList??>
	<#list signInfoList as signInfo>
    <a href="${globalPrefix}/fund/trade/buyConfirm.htm?yhkh=${signInfo.yhkh!''}&cpdm=${cpdm!''}&wtje=${wtje!''}" title="">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-xs-1">
                    <div class="cicle">
                        <span <#if yhkh?? && yhkh != signInfo.yhkh>style="display:none;"</#if> class="glyphicon glyphicon-ok"></span>
                    </div>
                </div>
                <div class="col-xs-3 bankIcons"><i class="sprite-bank-${(signInfo.signingBankInfo.imageName)!''}"></i></div>
                <div class="col-xs-8 bankIntrude">${signInfo.signingBankInfo.yhmc!''}（尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''}）<br><span>单笔上限${signInfo.signingBankInfo.dbed/10000}万<#if signInfo.signingBankInfo.dred??  && signInfo.signingBankInfo.dred!=0>，每日上限${signInfo.signingBankInfo.dred/10000}万</#if>。</span></div>
            </div>
        </div>
    </a>
  	</#list> 
  	</#if>
    <div class="container-fluid">
        <div class="row-fluid">
            <a class="col-xs-12 goBank" href="${configs.get('hbec.apps.account.url')}/auth/quickbind/kh/index.htm?referrer=${globalPrefix}/fund/trade/buyView.htm&fundCode=${cpdm!''}"><span class="glyphicon glyphicon-plus"></span>添加支付银行卡</a>
        </div>
    </div>
<#include "/_inc_commons.ftl" />
</body>
</html>