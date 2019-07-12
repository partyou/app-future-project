<!DOCTYPE html>
<html>
<head>
	<#include "/common/common-h5.ftl"/>
    <title>优惠券列表</title>
    <script>
    function queryAppointStatue(cpdm){
		var state = true;
		$.ajax({
	        type : "POST",
	        url : "/otc/queryAppointStatue.do",
	        data: {cpdm:cpdm},
	        dataType: "json",
	        async: false,
	        error : function(data){},
	        success: function(data){
	        	if(data.success){
		        	if(data.result.count>0){
		        		state = false;
		        		$.alert("您已预约过该产品，不可以重复预约！");
		        	}
	        	}else{
	        		state = false;
	        		$.alert(data.result);
	        	}
	        }
	    });
	    return state;
	}
	function trade_click(cpdm,id){
        if (!cpdm) {
            $.alert("产品代码或产品类型不能为空！"); return;
        }
    	if(queryAppointStatue(cpdm)){
    		$("#cpdm").val(cpdm);
    		$("#appoint").submit();
    	}
    }
    </script>
</head>
<body>
	<section class="bg-gray">
    <div class="list-group col-3 ft-text-dl">
		    <dl class="list-group-row tit">
		      <dt class="list-group-item">获得时间</dt>
		      <dt class="list-group-item">券卡编号</dt>
		      <dt class="list-group-item" style="text-align: right;">使用状态</dt>
		    </dl>
		    <!--三方支付基金-->  
		    <#if cardList?? && cardList?size gt 0>
        		<#list (cardList) as card>
				    <dl class="list-group-row arrow">
				      <dd class="list-group-item col1">
				        <h3>${(card.createTime?string('yyyy-MM-dd'))!"--"}</h3>
				      </dd>
				      <dd class="list-group-item col2">
				        <h2 class="number">${card.cardNum!"--"}</h2>
				      </dd>
				      	<dd class="red list-group-item number col3">
				      		<#if card.cardStatus=='1'>未使用<#else>已使用</#if>
				      	</dd>
				    </dl>
				    
				    <!--下拉手风琴-->
				    <div class="ss-fund-detail">
				      <dl class="ss-fund-c">
				        <dd><span class="label">有效期：</span>
				        	<span>${(card.validEndDate?string('yyyy-MM-dd'))!"--"}</span></dd>
				        <dd><span class="label">面值：</span>${(card.cardMoney!0)?string("#,##0.00")}元</dd>
				      </dl>
				      <#if card.cardStatus=='1'>
					      <dl class="ss-fund-c">
					        <dd><a href="${globalPrefix}/card/usedCard.html?cardNum=${card.cardNum!""}" class="btn btn-line">立即使用</a></dd>
					      </dl>
				      </#if>
				    </div>		    
				</#list>	      		
	    <#else>
	    	<div style="text-align:center;padding:30px 0;border-bottom:1px solid #d3d3d3;">暂无优惠券信息，敬请期待！</div>
    	</#if>
	</section>
	<script type="text/javascript" data-hb-js="js/1.0.0/index"></script>
</body>
</html>
