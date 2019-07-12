<!DOCTYPE html>
<html>
<head>
	<#include "/common/common-xjb-h5.ftl"/>
    <title>我的资产</title>
    <script>
	//是否显示关闭按钮 默认是false不显示
	titleBarDefault.cacelBarButton = true;
	titleBarDefault.displayLeftBarButtonItem = false;
	</script>
<style type="text/css">
    .otcLayoutBox{
        position: absolute;
        z-index: 1050;
        width: 60%;
        left: 20%;
        top: 10%;
    }
    .layoutBody{
        position: relative;
    }
    .otcLayoutBox img{
        width: 100%;
        display: block;
    }
    .otcLayoutBox .wordsBox{
        width: 100%;
        position: absolute;
        bottom: 35px;
        text-align: center;
    }
    .wordsBox .jlff{
        color: #fbda30;
        font-size: 20px;
        line-height: 1.4;
    }
    .wordsBox .wordsInfo{
        color: #fbda30;
        font-size: 14px;
        margin-top: 10px;
    }
</style>
</head>
<body class="bg-gray">
<div class="xjb-myasset">
    <section>
        <header>
            <ul>
                <li class="cl">
                    <label class="fl">总市值：</label>
                    <p class="fr">0.00元<i class="icons-arrow-r" style="opacity:0"></i></p>
                </li>
                <li class="cl">
                    <label class="fl">可用余额：</label>
                    <a href="#"><p class="fr">0.00元<i class="icons-arrow-r"></i></p></a>
                </li>
                <li class="cl">
                    <label class="fl">在途交易：</label>
                    <a href="#"><p class="fr">0笔<i class="icons-arrow-r"></i></p></a>
                </li>
            </ul>
        </header>
    </section>

    <article class="article">
        <ul>
            <li>
                <h2>现金宝</h2>
                <h2><a class="btn-in" href="#">转入</a>
                    <a class="btn-out" href="#">转出</a>
                    <a href="#">详情<i class="icons-arrow-r-gray"></i></a>
                </h2>

            </li>
            <li>
                <h3>余额（元）</h3>
                <h3>累计收益（元）</h3>
                <h3>昨日预估收益（元）</h3>
            </li>
            <li>
                <h4>0.00</h4>
                <h4 class="red">0.00</h4>
                <h4 class="red">0.00</h4>
            </li>
        </ul>
        <ul>
            <li>
                <h2>基金</h2>
                <h2>
                    <a href="#" id="tradingListLink">详情<i class="icons-arrow-r-gray"></i></a>
                </h2>

            </li>
            <li>
                <h3>市值（元）</h3>
                <h3>持仓基金数</h3>
                <h3>浮动收益（元）</h3>
            </li>
            <li>
                <h4>0.00</h4>
                <h4 class="red">0</h4>
                <h4 class="red">0.00</h4>
            </li>
        </ul>
        <ul>
            <li>
                <h2>闪存宝</h2>
                <h2>
                    <a href="#">详情<i class="icons-arrow-r-gray"></i></a>
                </h2>
            </li>
            <li>
                <h3>市值（元）</h3>
                <h3>累计收益（元）</h3>
                <h3></h3>
            </li>
            <li>
                <h4>0.00</h4>
                <h4 class="red">0.00</h4>
                <h4>
                    <a class="btn-next" href="#">预约下一期</a>
                </h4>
            </li>
        </ul>
    </article>
</div>
<div class="bg-opt"></div>
<div class="otcLayoutBox">
    <div class="layoutBody">
       <img src="${staticPrefix}/hbec-trade-h5/images/xjb/packet.png" alt=""> 
       <div class="wordsBox">
            <p class="jlff">奖励翻番<br>超低费率</p>
            <p class="wordsInfo">理财帐户  隆重上线</p>
        </div>
    </div>
    <div class="form-item">
        <a class="form-btn" href="" >立即赚钱</a>
    </div>
</div>
</body>
<script>
function getParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return (r[2]); return "";
};
$(document).ready(function(){
	$(".form-btn").attr("href",getParam("nextStep"));
});
</script>
<#include "/_inc_commons.ftl" />
</html>