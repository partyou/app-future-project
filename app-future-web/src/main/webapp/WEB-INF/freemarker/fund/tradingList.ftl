<!DOCTYPE html>
<html>
<head>
    <title>交易列表</title>
	<#include "/common/common-h5.ftl"/>
	<script>
		titleBarDefault.backURL = "${globalPrefix}/fund/fundHold.htm";
	</script>
</head>

<body >
<#if (success!true)==true>
	<section class="bg-gray">
	<#if partionByYearMap?? && (partionByYearMap?size gt 0)>
		<div class="tl-panel">
			<#list partionByYearMap?keys as yearKey>
				<div class="panel-head">${yearKey}年</div>
					<div class="panel-body">
						<ul class="tree-group">
							<#assign entrustList=partionByYearMap[yearKey]>
							<#list entrustList as entrustInfo>
								<li class="tree-group-item" data-itemId="${entrustInfo_index}"  >
									<div class="tl-group-date">
										<p>
											<#if (entrustInfo.wtrq)??>
												${((entrustInfo.wtrq!nullShow)?c)?substring(4,6)}-${((entrustInfo.wtrq!nullShow)?c)?substring(6,8)}
											<#else>
												--
											</#if>
										</p>
										<span>${entrustInfo.wtsj!""}</span>
									</div>
									<#if !entrustInfo_has_next>
										<div class="tl-group-progress last"></div>
									<#else>
										<div class="tl-group-progress"></div>
									</#if>
									<div class="tl-group-list">
										<#if ((entrustInfo.ywdm)!"") == "022">
											<a href="${globalPrefix}/fund/buyDetail.htm?id=${(entrustInfo.wth!0)?c}&backUrl=${globalPrefix}/fund/tradingList.htm">
										<#elseif ((entrustInfo.ywdm)!"") == "024">
											<a href="${globalPrefix}/fund/sellDetail.htm?id=${(entrustInfo.wth!0)?c}&backUrl=${globalPrefix}/fund/tradingList.htm">
										<#elseif ((entrustInfo.ywdm)!"") == "029">
											<a href="${globalPrefix}/fund/shareSetDetail.htm?id=${(entrustInfo.wth!0)?c}&backUrl=${globalPrefix}/fund/tradingList.htm">
										<#else>
											<a>
										</#if>
											<ul class="list-group col-2">
												<li class="list-group-row"><span class="list-group-item">基金名称：</span><span
													class="list-group-item">${entrustInfo.cpmc!""}&nbsp;(${entrustInfo.cpdm!""})</span></li>
												<li class="list-group-row"><span class="list-group-item">业务类型：</span>
													<span class="list-group-item">
														<#if ((entrustInfo.ywdm)!"") == "022">
															申购&nbsp;${(entrustInfo.wtje?string("0.00"))!"--"}元
														<#elseif ((entrustInfo.ywdm)!"") == "024">
															赎回&nbsp;${(entrustInfo.wtfe?string("0.00"))!"--"}份
														<#elseif ((entrustInfo.ywdm)!"") == "029">	
															分红设置&nbsp;
															<#if ((entrustInfo.fhfs)!"") == '1'>
																红利再投
															<#elseif ((entrustInfo.fhfs)!"") == '2'>
																现金分红
															<#elseif ((entrustInfo.fhfs)!"") == '0'>
																未设置	
															</#if>
														</#if>	
													</span>
												</li>
												<li class="list-group-row">
													<span class="list-group-item">交易状态：</span>
													<span class="list-group-item">
															${entrustInfo.wtztDesc!""}
													</span>
												</li>
											</ul>
										</a>
									</div>
								</li>									
							</#list>
						</ul>
					</div>	
			</#list>
		</div>
	<#else>
		<div class="no-chicang">
			<img src="${staticPrefix}/hbec/projects/licai/fundTrans/1.0.0/images/gw.png" />
			<p>暂无交易记录</p>
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