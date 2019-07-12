<div id="pagebar">
		<input type="hidden" id="url" value="${url}"/>
		<input type="hidden" id="page" value="1"/>
		<input type="hidden" id="size" value="${size!10}"/>
		<style type="text/css">
		.ui-layout{
			position: fixed;
		}
		</style>
		<script type="text/javascript">
			/**
			 * 分页请求列表下一页数据
			 *	参数1：要追加显示数据到指定位置的class,必传
			 */
			function toPageNext(grid){
				var page = Number($("#page").val())+1;
				toPage(grid,page);
			}
			/**
			 * 分页请求列表数据
			 *	参数1：要追加显示数据到指定位置的class,必传
			 *	参数2：第几页，如果不传，则默认1，否则取传入参数
			 */
			function toPage(){
				var argsLen = arguments.length;
				var $dg ;
				if(argsLen>0){
					//scrollEvent(arguments[0]);
					$dg = $("."+arguments[0]);
				}else{
					$.alert("分页入参不能为空！");return;
				}
				var page = argsLen>1?arguments[1]:$("#page").val();
				var pageData = {
					page : page,
					size : $("#size").val(),
				};
				/*var fields =$("#pagebar form").serializeArray(); // 自动序列化表单元素为JSON对象
				$.each( fields, function(i, field){
					pageData[field.name] = field.value; // 设置查询参数
				});*/
				$.hideLoading();
				$.showLoading();
				$.ajax({
			      type:"post",
			      dataType:"html",
			      url: "${globalPrefix}"+$("#url").val(),
			      data: pageData,
			      success: function(data){
			      	$.hideLoading();
			      	if(data){
				        $dg.append(data);
				        $("#page").val(page);
			        }else{
			        	 $dg.append('<li style="text-align:center;display: block;">没有更多记录了！</li>');
			        }
			      },
			      error: function(){
			      	$.hideLoading();
			      	$.alert("查询失败，请下拉重试");
			      }
			    });
		    }
			function scrollInit(className){
				var interval = null; // 定时器  
				document.onscroll = function() {
				    if (interval == null) // 未发起时，启动定时器，1秒1执行  
				    interval = setInterval(function(){
				    	if ($(window).scrollTop()>=$(document).height()-$(window).height()) {
					        clearInterval(interval);
					        interval = null;
					        toPageNext(className);
					    }
				    }, 1000);
				}
				toPage(className);
			}
		    /*
		    function scrollEvent(args){
		    	$(window).scroll(function(){ 
				    var scrollH = parseInt($(window).scrollTop())
				    				+parseInt(document.documentElement.clientHeight),docH = parseInt($(document).height());
				    if(scrollH >= docH-50){
				        toPageNext(args);
				        window.scrollTo(0,parseInt($(window).scrollTop())+150);
				    }
				 });
		    }
		    */
		</script>
</div>