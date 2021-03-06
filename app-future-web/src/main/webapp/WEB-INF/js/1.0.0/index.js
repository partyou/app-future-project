/**
 */
define('index',function() {
	var app = {
		init : function() {
			this.renderUI();
			this.bindUI();
			// 数据请求URL
			this.dataUrl = globalPrefix + '/news/index.html';
			// 数据类型
			this.dataType = 1;
			// 各个Tab的排序方式
			this.sortTypes = {
				'1' : '1',
				'2' : '1',
				'3' : '1',
				'4' : '1',
				'5' : '1',
				'6' : '1',
				'7' : '1',
				'8' : '1',
				'9' : '1',
				'10' : '1'
			};
			this.logic.loadMore();
		},
		renderUI : function() {
			this.menuItemWidth = $('.fundRank-header li:eq(1)').outerWidth(true);
		},
		bindUI : function() {
			$(window).bind('scroll', this.logic.windowScroll);
			$('.fundRank').delegate('.rate', 'click', this.logic.showFilterModal);
			$('.fundRank').delegate('.type-item', 'click', this.logic.sortResource);
			$('.scrollTop').bind('click', this.logic.ScrollTop);
			$('.fundRank').delegate('.type-bg', 'click', this.logic.hideSort);
			/* $(window).bind('touchstart', this.logic.canScroll); */
			TouchSlide({
				// 需要滑动效果的dom节点
				slideCell : '#slider',
				// 滑动完成后的回调
				endFun : function(idx) {
					$('.item-fixed').empty();
					$('.type-main,.type-bg').hide();
					$(".rate").removeClass('arrow');
					$(document).off('touchmove', app.logic.preventTouchMove);
					if (app.dataType !== idx + 1) {
						$('.hd li:eq(' + idx + ')').trigger('click');
					}
					var $target = $('.bd li');
					$target.eq(idx).css('height', 'auto').siblings().css('height', "1px");
					$('body').scrollTop(0);
					var scrollLeft = 0;
					if (idx > 2) {
						scrollLeft = (idx - 2) * app.menuItemWidth;
					}
					// 滚动栏目
					$('.fundRank-header').animate({
						scrollLeft : scrollLeft
					}, 100, 'swing');
				}
			});
		},
		logic : {
			getRequestUrl : function(dataType) {
				return app.dataUrl + '?dataType=' + dataType + "&sortType=" + app.sortTypes[dataType];
			},
			hideSort : function() {
				$(".rate").removeClass('arrow');
				$(document).off('touchmove', app.logic.preventTouchMove);
				$('.type-main,.type-bg').hide();
			},
			sortResource : function() {
				$('.item-fixed').empty();
				$('.type-main,.type-bg').hide();
				$(".rate").removeClass('arrow');
				$(document).off('touchmove', app.logic.preventTouchMove);
				var sortType = $(this).data('type');
				var $active = $(this).index();
				var $html = $(this).html();
				var $idx = null;
				$('.hd li').each(function(idx) {
					if ($(this).hasClass('on')) {
						$idx = idx;
					}
				});
				// 重置分页组件中的pageNo
				app.pagination.pageNo[app.dataType - 1] = 2;
				// 保存各个Tab的排序方式
				app.sortTypes[app.dataType] = sortType;
				app.pagination.url = app.logic.getRequestUrl(app.dataType);
				HB.ajax.get(app.logic.getRequestUrl(app.dataType), function(res) {
					var $target = $('.bd li');
					$('body').scrollTop(0);
					if ($active === 5) {
						$target.eq($idx).find('.rate').html("成立以来");
					} else {
						$target.eq($idx).find('.rate').html($html);
					}
					$target.eq($idx).find('.type-item').eq($active).addClass("active").siblings().removeClass('active');
					$target.eq($idx).find(".fundRank-item").remove();
					$(res).insertBefore($target.find('.hb-load-more'));
				}, {
					dataType : 'html',
					loading : false
				});
			},
			ScrollTop : function() {
				$('body').scrollTop(0);
			},
			windowScroll : function() {
				$('.hd li').each(function(idx) {
					if ($(this).get(0).className === 'on') {
						var top = $(window).scrollTop();
						var $top = $('.item-banner').height();
						if (top > 0) {
							$(".scrollTop").show();
						} else {
							$(".scrollTop").hide();
						}
						if (top > $top) {
							$('.item-fixed').html($('.bd li').eq(idx).find('.item-title').html()).addClass('border-top border-bottom');
						} else {
							$('.item-fixed').empty().removeClass('border-top border-bottom');
						}
					}
				});
			},
			preventTouchMove : function(e) {
				e.preventDefault();
		        return false;
			},

			showFilterModal : function() {
				var $main = $(this).parent().find('.type-main,.type-bg');
				if ($main.is(":hidden")) {
					$main.show();
					$(".rate").addClass('arrow');
					$(document).on('touchmove', app.logic.preventTouchMove);
					/*
					 * $('html, body').css({ position: 'fixed', top: 0, left: 0,
					 * height: '100%' });
					 */
				} else {
					$main.hide();
					$(".rate").removeClass('arrow');
					$(document).off('touchmove', app.logic.preventTouchMove);
				}
			},
			canScroll : function(evt) {
				var $target = evt.target;
				if ($target.className.toString().indexOf('type-item') == -1) {
					$(document).on('touchmove', app.logic.preventTouchMove);
				}
			},
			// 分页处理
			loadMore : function() {
				var $container = $('.bd li');
				var reqUrl = this.getRequestUrl(1, 1);
				app.pagination = HB.more.init(reqUrl, $container, {
					// 多个tab的选取器
					tabs : '.hd li',
					async : true,
					startPageNo : 2,
					// 切换tab时的回调
					switchTab : function(idx) {
						app.dataType = idx + 1;
						this.url = app.logic.getRequestUrl(idx + 1);
					},
					success : function(res) {
						if (res) {
							var $list = $container.eq(this.selectedTab);
							$(res).insertBefore($list.find('.hb-load-more'));
						}
					},
					hasMore : function(idx) {
						return $container.eq(idx).find('.fundRank-item').length > 10;
					},
					noMore : function(res) {
						return $(res).filter('.fundRank-item').length < 10;
					}
				});
			}
		}
	};
	return app;
});