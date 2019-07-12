<!DOCTYPE html>
<html>
<head>
    <title>基金持仓</title>
	<#include "/common/common-h5.ftl"/>
	<script>
       titleBarDefault.cacelBarButton = true;
	</script>
</head>

<body>
<#if (success!true)==true>
	<section class="bg-gray">
	  <div class="ft-my-info">
	    <div class="my-info-tit">
	      <p>你好，<span>${realName!""}</span></p>
	      <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-line">交易查询</a>
	    </div>
	    <div class="my-asset">
	      <dl>
	        <dt>基金市值(元)</dt>
	        <dd class="fund">${(totalMarketValue!0)?string("#,##0.00")}</dd>
	      </dl>
	      <dl>
	        <dt>浮动盈亏(元)</dt>
	        <#if totalFloatProfit gt 0 >
	        	<dd class="float">+${(totalFloatProfit!0)?string("#,##0.00")}</dd>
	        <#elseif totalFloatProfit lt 0>
	        	<dd class="float green">${(totalFloatProfit!0)?string("#,##0.00")}</dd>
	        <#else>
	        	<dd class="float">0.00</dd>	
	        </#if>
	      </dl>
	    </div>
	  </div>
	  
	  <!--基金持仓部分-->
	  <#if ((emptyFlag)!"")=="false">
		  <div class="list-group col-3 ft-text-dl">
		    <dl class="list-group-row tit">
		      <dt class="list-group-item">持仓基金简称</dt>
		      <dt class="list-group-item">参考市值(元)</dt>
		      <dt class="list-group-item" style="text-align: right;">浮动盈亏(元)</dt>
		    </dl>
		    
		    <!--三方支付基金-->  
		  	<#if fundList?? && (fundList?size gt 0)>
		  		<#list (fundList) as fund>
				    <dl class="list-group-row arrow">
				      <dd class="list-group-item col1">
				        <h3>${fund.cpmc!""}</h3>
				        <h4>${fund.cpdm!""}</h4>
				      </dd>
				      <dd class="list-group-item col2">
				        <h2 class="number">${(fund.zxsz?string("0.00"))!"--"}</h2>
				        <!--
				        -->
				        <h4>${lastTradeDt!"--"}</h4>
				      </dd>
				      <#if fund.lczsy?? &&  (fund.lczsy gt 0)>
				      	<dd class="red list-group-item number col3">+${(fund.lczsy!0)?string("#,##0.00")}</dd>
				      <#elseif fund.lczsy?? && (fund.lczsy lt 0)>
				      	<dd class="green list-group-item number col3">${(fund.lczsy!0)?string("#,##0.00")}</dd>
				      <#else>
				      	<dd class="red list-group-item number col3">0.00</dd>
				      </#if>
				    </dl>
				    
				    <!--下拉手风琴-->
				    <div class="ss-fund-detail">
				      <dl class="ss-fund-c">
				        <dd><span class="label">持仓份额：</span><span>${(fund.ccsl!0)?string("#,##0.00")}</span></dd>
				        <#if fund.fundEntity.hbecTypeTag?? && fund.fundEntity.hbecTypeTag[0] == '货币型'>
				        	<dd><span class="label">万份收益：</span>${(fund.fundEntity.latest10kAccrual?string("0.0000"))!"--"}</dd>
				        <#else>
				        	<dd><span class="label">最新净值：</span>${(fund.fundEntity.latestNetPresentValue?string("0.0000"))!"--"}</dd>
				        </#if>
				      </dl>
				      <dl class="ss-fund-c">
				        <dd><span class="label">可用份额：</span><span>${(fund.kyfe!0)?string("#,##0.00")}</span></dd>
				        <dd>
				        	<span class="label">分红方式：</span>
				        	<span>
				        		<#if fund.fhfs?? && (fund.fhfs==1)>
				        			红利再投
				        		<#elseif fund.fhfs?? && (fund.fhfs==2)>
				        			现金分红
				        		<#elseif fund.fhfs?? && (fund.fhfs==0)>
				        			未设置
				        		</#if>
				        	</span>
				        	<#if ((fund.fhfsFlag)!"") == "3">
				        		<a href="${globalPrefix}/fund/trade/shareSet.htm?fundCode=${fund.cpdm!''}" class="amend">修改</a>
				        	</#if>
				        </dd>
				      </dl>
				      <dl class="ss-fund-c">
				      	<!--可用份额为0赎回按钮不显示-->
				      	<#if fund.kyfe gt 0>
				      		<dd><a href="${globalPrefix}/fund/trade/sellFund.htm?fundCode=${fund.cpdm!''}" class="btn btn-line">赎回</a></dd>
				      	<#else>
				      		<dd><a class="btn disabled" >赎回</a></dd>
				      	</#if>
				        <dd><a href="${globalPrefix}/fund/trade/buyFund.htm?fundCode=${fund.cpdm!''}" class="btn btn-line">追加购买</a></dd>
				      </dl>
				    </div>		    
				</#list>	      		
		  	</#if>
		  	
		  	<!--三方存管基金-->
		  	<#if fundInfoList?? && (fundInfoList?size gt 0)>
		  		<#list (fundInfoList) as fund>
				    <dl class="list-group-row arrow">
				      <dd class="list-group-item col1">
				        <h3>${fund.fundShortName!""}</h3>
				        <h4>${fund.fundCode!""}</h4>
				      </dd>
				      <dd class="list-group-item col2">
				        <h2 class="number">${(fund.fundMarketValue?string("0.00"))!"--"}</h2>
				        <!--
				        -->
				        <h4>${lastTradeDt!"--"}</h4>
				      </dd>
				      <#if fund.floatProfit?? && (fund.floatProfit > 0)>
				      	<dd class="red list-group-item number col3">+${(fund.floatProfit?string("0.00"))!"--"}</dd>
				      <#elseif fund.floatProfit?? && (fund.floatProfit < 0)>
				      	<dd class="green list-group-item number col3">${(fund.floatProfit?string("0.00"))!"--"}</dd>
				      <#else>
				      	<dd class="red list-group-item number col3">0.00</dd>
				      </#if>
				    </dl>
				    
				    <!--下拉手风琴-->
				    <div class="ss-fund-detail">
				      <dl class="ss-fund-c">
				        <dd><span class="label">持仓份额：</span><span>${(fund.fundNum?string("0.00"))!"--"}</span></dd>
				        <#if fund.fundEntity.hbecTypeTag?? && fund.fundEntity.hbecTypeTag[0] == '货币型'>
				        	<dd><span class="label">万份收益：</span>${(fund.fundEntity.latest10kAccrual?string("0.0000"))!"--"}</dd>
				        <#else>
				        	<dd><span class="label">最新净值：</span>${(fund.fundEntity.latestNetPresentValue?string("0.0000"))!"--"}</dd>
				        </#if>
				      </dl>
				      <dl class="ss-fund-c">
				        <dd><span class="label">可用份额：</span><span>${(fund.fundCanUseNum?string("0.00"))!"--"}</span></dd>
				      </dl>
				      <#if fund.fundCanUseNum gt 0>
					      <dl class="ss-fund-c">
					        <dd><a href="${globalPrefix}/fund/trade/sellDeposit/sellFund.htm?fundCode=${fund.fundCode!''}" class="btn btn-line">赎回</a></dd>
					      </dl>
				      <#else>
					      <dl class="ss-fund-c">
					        <dd><a class="btn disabled" disabled>赎回</a></dd>
					      </dl>				      	
				      </#if>
				    </div>		    
				</#list>	      		
		  	</#if>
		  </div>
	  </#if>
		<#if ((emptyFlag)!"")=="true">
			<div class="no-chicang">
				<img src="${staticPrefix}/hbec/projects/licai/fundTrans/1.0.0/images/gw.png" />
				<p>暂无持仓基金</p>
			</div>
		</#if>
	</section>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<script type="text/javascript" data-hb-js="hbec-trade-h5/1.0.0/js/index"></script>
<#include "/_inc_commons.ftl" />
</body>
</html>