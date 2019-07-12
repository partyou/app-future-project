<meta name="keywords" content="登录、我的帐户、我的资产、持仓详情、交易记录、基金定投、资金划转、分红设置" />
<meta name="description" content="帐户前端包括的功能有登录、我的帐户、我的资产、持仓详情、交易记录、基金定投、资金划转、分红设置以及基金理财开户和股票开户等。">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<#assign staticPrefix="http://localhost:8080/testFreemarker">
<#assign globalPrefix="http://localhost:8080/testFreemarker">
<link rel="shortcut icon" type="image/x-icon" href="//static.touker.com/hbec/favicon.ico"/>
<meta content="yes" name="apple-mobile-web-app-capable">
<!-- 全屏显示 -->
<meta content="yes" name="apple-touch-fullscreen">
<!-- 全屏显示 -->
<meta content="telephone=no,email=no" name="format-detection">
<!-- 不启用电话，邮件 -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<!-- 以原始大小显示，并不允许缩放 -->
<meta name="format-detection" content="address=no"/>
<!-- 不启用地址 -->
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<!-- 在web app应用下状态条（屏幕顶部条）的颜色为黑色 -->
<meta name="apple-mobile-web-app-capable" content="yes"/>
<!-- 网站开启对web app程序的支持 -->
<meta name="mobile-web-app-capable" content="yes"/>
<!-- 删除默认的苹果工具栏和菜单栏 -->
<meta name="apple-touch-fullscreen" content="yes"/>
<!-- 添加到主屏幕“后，全屏显示 -->
<meta name="full-screen" content="yes"/>
<!-- 全屏显示 -->
<link rel="stylesheet" href="${staticPrefix}/hbec/common/h5/1.0.0/css/hbec.min.css"/>
<link rel="stylesheet" href="${staticPrefix}/css/1.0.0/fundTrans.min.css" />
<link rel="stylesheet" href="${staticPrefix}/css/1.0.0/otc.min.css"/>
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
<script>
//若原生头部最右侧需要显示按钮则使用
//titleBarDefault.buttonId = "linkNext";
//若返回按钮需要跳转到制定页面则使用，参数直接拼到后面
//titleBarDefault.backURL = document.referrer;
//是否显示关闭按钮 默认是false不显示
//titleBarDefault.cacelBarButton = true;
</script>
<#assign nullShow="--"/>
