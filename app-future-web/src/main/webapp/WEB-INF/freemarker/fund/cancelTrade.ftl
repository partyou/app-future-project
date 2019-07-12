<!DOCTYPE html>
<html>
<head>
    
    <title>撤单</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<link rel="stylesheet" href="//10.0.30.115/hbec/projects/licai/fundTrans/1.0.0/fundTrans.min.css"/>
<#if (success!true)==true>
<#if fundEntrustInfo??>

<form id="cancelForm" name="cancelForm" >
	<input type="hidden" id="backUrl" name="backUrl" value="${backUrl!''}" />
	<input type="hidden" id="wth" name="wth" value="${((fundEntrustInfo.wth)!'0')?c}" />
	<input type="hidden" id="jgdm" name="jgdm" value="${(fundEntrustInfo.jgdm)!''}" />
	<input type="hidden" id="wtrq" name="wtrq" value="${((fundEntrustInfo.wtrq)!'0')?c}" />
	<input type="hidden" id="jymm" name="jymm" >
	<input type="hidden" id="cpdm" name="cpdm" value="${((fundEntrustInfo.cpdm)!'')}" />
	<input type="hidden" id="ywdm" name="ywdm" value="${((fundEntrustInfo.ywdm)!'')}" />
</form>
	<section class="bg-gray">
  	<ul class="list-group col-2 ft-list">
    <li class="list-group-row"><span class="list-group-item">基金名称：</span><span class="list-group-item">${(fundEntrustInfo.cpmc)!""} (${fundEntrustInfo.cpdm!""})</span></li>
    <li class="list-group-row"><span class="list-group-item">业务类型：</span><span class="list-group-item">
    					<#if ((fundEntrustInfo.ywdm)!"") == "022">申购
						<#elseif ((fundEntrustInfo.ywdm)!"") == "024">赎回
						<#elseif ((fundEntrustInfo.ywdm)!"") == "029">分红设置
						</#if></span></li>
    <li class="list-group-row"><span class="list-group-item">申请时间：</span><span class="list-group-item">${((fundEntrustInfo.wtrq!nullShow)?c)?substring(0,4)}-${((fundEntrustInfo.wtrq!nullShow)?c)?substring(4,6)}-${((fundEntrustInfo.wtrq!nullShow)?c)?substring(6,8)} ${fundEntrustInfo.wtsj!''}</span></li>
    <#if ((fundEntrustInfo.ywdm)!"") == "022">
    <li class="list-group-row"><span class="list-group-item">委托金额：</span><span class="list-group-item">
    	${(fundEntrustInfo.wtje?string("0.00"))!"--"}
    </span></li>
    <#elseif ((fundEntrustInfo.ywdm)!"") == "024">
    <li class="list-group-row"><span class="list-group-item">申请份额：</span><span class="list-group-item">${(fundEntrustInfo.wtfe?string("0.00"))!"--"}</span>
    </li>
    <#elseif ((fundEntrustInfo.ywdm)!"") == "029">
    <li class="list-group-row"><span class="list-group-item">分红方式：</span><span class="list-group-item">
    						<#if ((fundEntrustInfo.fhfs)!"") == "1">红利转投
							<#elseif ((fundEntrustInfo.fhfs)!"") == "2">现金分红
							<#elseif ((fundEntrustInfo.fhfs)!"") == "0">未设置</#if>
    </span></li>
    </#if>
    <li class="list-group-row"><span class="list-group-item">回款银行：</span><span class="list-group-item">${yhmc!''}(${(yhkh?substring(yhkh?length-4, yhkh?length))!''})</span></li>
  </ul>
  <div class="hb-btn-group">
    <a href="#" class="btn btn-primary" id="btnSubmit">确认撤单</a>
  </div>
</section>
<div id="payModal" class="modal">
  <div class="modal-mask">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-hotspot" data-dismiss="modal"></div>
        <div class="modal-header">
          <a href="#" class="close"></a>
          <div class="modal-title">请输入交易密码</div>
        </div>
        <div class="modal-body">
          <h3 id="amount" class="text-center">交易撤单</h3>
          <input type="password" id="mpwd" name="mpwd" data-provider="hb-tradePwd" />
          <div id="errorMsg" class="error-msg"></div>
          <div class="text-center">回款银行：${yhmc!''}(${(yhkh?substring(yhkh?length-4, yhkh?length))!''})</div>
        </div>
      </div>
    </div>
  </div>
</div>
</#if>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
	<script type="text/javascript" data-hb-js="hbec-trade-h5/1.0.0/js/transcancel"></script>
	<#include "/_inc_commons.ftl" />
</body>
</html>