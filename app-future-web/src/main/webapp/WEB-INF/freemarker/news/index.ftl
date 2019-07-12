<!DOCTYPE html>
<html>
<head>
	<#assign staticPrefix="http://localhost:8080/testFreemarker">
	<#assign globalPrefix="http://localhost:8080/testFreemarker">
<script type="text/javascript">
  window.HB = {}, HB.global = {},
  //静态资源服务器的地址,eg://static.touker.com/hbec
  HB.staticPrefix = '${staticPrefix}/',
  //本地资源的地址,eg://10.0.31.109/hbec
  HB.localStaticPrefix = '//127.0.0.1:80/',
  //系统运行环境,eg:local,prod
  HB.env = "prod";
  var isLogin = "{session.isLogined()?c}";
</script>
	<script src="${staticPrefix}/hbec/common/vendor/require-2.1.20.min.js" 
		data-main="${staticPrefix}/hbec/common/h5/1.0.0/js/hbec"></script>
	<link rel="stylesheet" href="../css/1.0.0/mall.css"/>
	<link rel="stylesheet" href="../css/1.0.0/index.css"/>
    <title>新闻首页</title>
</head>
<body>
<div class="homepage">
	<!--头部-->
	<header class="header_bg">
		<span class="header-txt">新闻头条</span>
	</header>
	<!--导航栏-->
	<div class="top_nav">
	    <div class="top_menu_bar">
	      <!--  <div class="top_menu_more">
	            <a href="#" class="more_btn" id="navs_toggle"><i class="iconfont icon-jiahao1"></i></a>
	        </div> -->
	        <div class="top_menu_list">
                <ul>
                	<#if newsChannelsList??>
	                <#list newsChannelsList as channels>
	                    <li class="fundRank fundRank-header li <#if channels.channelPriority=='1'>on</#if>">
	                    <a data-target="${channels.channelsId?c}">${channels.channelsName!''}</a>
	                    </li>
	                </#list>
                  	</#if>
                </ul>
	        </div>
	    </div>
	</div>
	<!--内容-->
	<button id="contentBtn">Click me</button>
    <p id="messagebox"></p>
</div>
<script type="text/javascript" src="../js/1.0.0/index.js"></script>
</body>
</html>
