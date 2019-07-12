<!DOCTYPE html>
<html>
<head>
	<title>基金超市</title>
	<#include "/common/common-channel-h5.ftl"/>
	<link rel="stylesheet" href="${staticPrefix}/hbec/projects/licai/mall/1.0.5/mall.min.css" id="project_css"/>
<style>
	body{
		background: #fff;
	}
</style>
</head>
<body>
<#if (success!true)==true>
<div class="fundRank" id="slider">
	<#if appList?? && appList?size gt 0>
		<div class="fundRank-headerFix">
			<ul class="fundRank-header hd">
			<#list appList as appFundRankings>
				<#-- 默认选中股票型 -->
				<li <#if appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Stock'> class="on" </#if> 
					<#if (appFundRankings_index % 2) == 0> data-target="/h5/licai/mall/fundRank1" 
					<#else> data-target="/h5/licai/mall/fundRank2" 
					</#if>>
					<P class="state">${appFundRankings.fundtypeName!'--'}</P>
				</li>
			</#list>
			</ul>
			<a href="${globalPrefix}/deposit/channel/fundSearch.htm" class="fundRank-search"></a>
		</div>
		<div class="item-title item-fixed"></div>
		<div class="fundRank-main">
		<div class="fundRank-list">
		<ul class="bd" id="bd">
			<#list appList as appFundRankings>
			<li <#if appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Stock'> data-type="gp" 
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Hybrid'> data-type="hh"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Index'> data-type="zs"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Bond'> data-type="zq"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Monetary'> data-type="hb"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'QDII'> data-type="qd"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'Financing'> data-type="lc"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'CapitalGuaranteed'> data-type="bb"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'ETF'> data-type="etf"
				<#elseif appFundRankings.fundtypeCode?? && appFundRankings.fundtypeCode == 'LOF'> data-type="lof"
				</#if> >
				<div class="item-banner">
					<span class="icon">
						<img src="${appFundRankings.fundImageUrl!''}" >
					</span>
					<span class="desc">
						${appFundRankings.fundDescription!''}
					</span>
				</div>
				<div class="item-title border-bottom">
					<span class="name border-right">基金名称</span>
					<#--货币型或理财型显示万份收益与7日年化-->
					<#if appFundRankings.fundtypeCode?? && (appFundRankings.fundtypeCode == 'Monetary' || appFundRankings.fundtypeCode == 'Financing')>
						<span class="inCome border-right">万份收益</span>
						<span class="rate">7日年化</span>
					<#else>
						<span class="inCome border-right">最新净值</span>
						<span class="rate">日跌幅</span>
					</#if>
					<div class="type-bg"></div>
					<div class="type-main" style="display: block;">
						<#if appFundRankings.fundtypeCode?? && (appFundRankings.fundtypeCode == 'Monetary' || appFundRankings.fundtypeCode == 'Financing')>
							<p class="type-item active" data-type="1">7日年化</p>
						<#else>
							<p class="type-item active" data-type="1">日涨幅</p>
						</#if>
						<p class="type-item" data-type="7">近一周涨幅</p>
						<p class="type-item" data-type="2">近1月涨幅</p>
						<p class="type-item" data-type="3">近3月涨幅</p>
						<p class="type-item" data-type="4">近6月涨幅</p>
						<p class="type-item" data-type="5">近1年涨幅</p>
						<p class="type-item" data-type="8">今年来</p>
						<p class="type-item" data-type="6">成立以来涨幅</p>
					</div>
				</div>
				<#-- 基金列表内容 -->
				
				
			</li>
			</#list>
		</ul>
		</div>
		</div>
	</#if>
<div class="scrollTop"></div>
</div>
<script type="text/javascript" data-hb-js="projects/licai/mall/1.0.5/js/fund_rank"></script>
<script>
/*超链接跳转,由于是<a>标签中再使用<a>标签跳转,故不能使用<a>标签只能用js控制*/
$(function() {
	$('.fundRank').delegate('.codeType', 'click', function() {
		window.location = $(this).data('url');
		e.stopPropagation();
	});
	$('.fundRank').delegate('.fundRank-item', 'click', function() {
		window.location = $(this).data('url');
	});
})
</script>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>
