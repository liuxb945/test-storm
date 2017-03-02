<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=7"/>
		<link rel="icon" href="${base}/webresources/shop/img/ly.ico"/>
		<title>商品详情 价格|图片|批发|报价|规格 - 猎鹰工品</title>
		<link rel="stylesheet" href="${base}/webresources/shop/css/common.css" />
		<link rel="stylesheet" href="${base}/webresources/shop/css/header.css" />
		<link rel="stylesheet" href="${base}/webresources/shop/css/footer.css" />
		<link rel="stylesheet" href="${base}/webresources/shop/css/menu.css"/>
		<link rel="stylesheet" href="${base}/static/css/rmdLayer.css" />
		<link rel="stylesheet" href="${base}/webresources/shop/css/DetailPages.css" />
		<link rel="stylesheet" href="${base}/webresources/shop/css/suspendframe.css" />
		<script type="text/javascript" src="${base}/webresources/shop/js/jquery.js"></script>
		<script type="text/javascript" src="${base}/static/js/feedback.js"></script>
		<meta name="description" content="">
		<meta name="Keywords" content="">
	</head>

	<body>
		[#--头文件--]
		[#include "header.ftl" /]
		[#--导航--]
		[#include "menu.ftl"/]
		<input type="hidden" id="basepath" value="${base}"/>
		<!--放大镜-->
		<div class="remProduct">
			<p class="remProductClf">
				<a href="${base}${category.indexpath}">${category.indexname}</a>
					&nbsp;&nbsp;>&nbsp;&nbsp;
				<a href="${base}${category.rootpath}">${category.rootname}</a>
					&nbsp;&nbsp;>&nbsp;&nbsp;
				<a href="${base}${category.parentpath}">${category.parentname}</a>
					&nbsp;&nbsp;>&nbsp;&nbsp;
				<a href="${base}${category.childpath}">${category.childname}</a>
					&nbsp;&nbsp;>&nbsp;&nbsp;
				<a href="#">${goods.pname}</a>
			</p>
			<div class="remProductImg clearfix">
				
				<div class="box">
					<div class="tb-booth tb-pic tb-s310">
						<a href="${goods.imgurl}"><img src="${goods.imgurl}" alt="${goods.pname}" rel="${goods.imgurl}${goods.watermark}" class="jqzoom" /></a>
					</div>
					<a href="javascript:;" class="left"></a>
					<div class="imgmune">
						<ul class="tb-thumb" id="thumblist">
							[#list goods.photolists as photo]
							<li>
								<div class="tb-pic">
									<a href="javascript:;">
										<img src="${photo.photourl}" mid="${photo.photourl}" big="${photo.photourl}${goods.watermark}">	
									</a>
								</div>
								<div class="suborder"></div>
							</li>
							[/#list]
						</ul>
					</div>
					<a href="javascript:;" class="right"></a>
				</div>
				[#--修改4-29--]
				<div class="remProductImgR">
					<p class="commodName">${goods.pname}</p>
					<p class="commodDcb">${goods.subname}</p>
					<div class="commodPrice">
						<div style="padding: 20px 0 0 10px;" class="minAndmax" >
							<label id="code_${goods.code}">价&emsp;&nbsp;&nbsp;&nbsp;格：</label>
							[#if goods.status==1]
								[#if goods.maxprice = goods.minprice]
									<span>￥${goods.minprice?string('0.00')}</span>
								[#else]
									<span>￥${goods.minprice?string('0.00')}~${goods.maxprice?string('0.00')}</span>
								[/#if]
								[#-- [#if goods.mincprice??]
									<b>促</b>
								[/#if] --]
							[#else]
							<span style="color: #e4e4e4;font-size: 18px;width: 96px;height: 30px;line-height: 30px;text-align: center;border: 1px dashed #e4e4e4;display:inline-block;">已下架</span>
							[/#if]
							[#--[#if goods.maxcprice ?? && goods.mincprice ??]
								[#if goods.maxcprice = goods.mincprice]
									<span>￥${goods.mincprice}</span>
									<b>促</b>
								[#else]
									<span>￥${goods.mincprice}~${goods.maxcprice}</span>
									<b>促</b>
								[/#if]
							[#else]
								
							[/#if]
							--]
						</div>
						<div class="btn-certified">
							<p>通过企业认证，享受折扣！</p>
							<p id="YNapprove">
								<a href="${base}/login" class="noApprove">立刻认证 ></a>
								<!-- <a href="" class="yesApprove">企业认证会员</a>
								<a href="" class="failedApprove">未通过审核</a> -->
							</p>
						</div>
					</div>
					<div class="commod_goods_info clearfix">
						<div class="commod_goods_l">
							<p class="commodBrand">品&emsp;&nbsp;&nbsp;&nbsp;牌：<a target="_blank" href="${base}/searchBrand/${goods.brandid}/"><span>${goods.brandname}</span></a></p>
							<p class="commodPay">支付方式：<span>公司转账</span>|<span>支付宝</span>|<span>银联在线</span></p>
							<p class="commodPhone">咨询电话：<span>400-138-5558</span></p>
							<p class="commodCtock">库&nbsp;存&nbsp;量&nbsp;：
							[#if goods.status==1]
								<span class="repSpanYes">有货</span>
								[#else]
								<span class="repSpanNo">无货</span>
							[/#if]
							</p>
							
						</div>
						<div class="commod_goods_r">
							<p>猎鹰工品特色</p>
							<a href="" class="details_advert1">广告一</a>
							<a href="" class="details_advert2">广告二</a>
							<a href="" class="details_advert3">广告三</a>
							<a href="" class="details_advert4">广告四</a>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<!--加入购物车-->
		<div class="commodList">
			<div class="tables">
        		<div class="tabcont" id="skutabcont">
            		<table id="skutb">
						<thead>
							<tr>
								[#--固定列--]
								<td>商品编码</td>
								<td>规格型号</td>
								[#--动态列--]
								[#list specificationItems as item]
									<td>${item.itemname}</td>
								[/#list]
								[#--固定列--]
								
								<td class="scollcolumn">包装数量</td>
								<td class="scollcolumn"><span style="display: block">起批量</span></td>
								<td class="scollcolumn">单价</td>
                    			<td class="scollcolumn commodListWeird" style=""><span style="display: block">采购数量</span></td>
							</tr>
						</thead>
						<tbody>
							[#list saleLists as productSaleInfo]
							<tr data-parice="${productSaleInfo.prefprice}" data-cheapPrice="${productSaleInfo.promotionprice}" data-memberprice="" data-baseid="${productSaleInfo.baseid}" class="price_${productSaleInfo.code} strTrEach" id="saleInfoBaseId" >
								<td><a target="_blank" href="${base}/product/code-${productSaleInfo.code}/" class="productCode" id="c_${productSaleInfo.code}">${productSaleInfo.code}</a></td>[#-- 商品编码 --]
								<td>${productSaleInfo.spec}</td>[#-- 规格型号 --]
								[#list productSaleInfo.propertyList as property]
								[#if property.goodstypepropertyvalue != null && property.goodstypepropertyvalue != ""]
									<td>${property.goodstypepropertyvalue}</td>
								[#else]
									<td>${property.propertyvalue}</td>
								[/#if]
								[/#list]
								<td  class="scollcolumn">${productSaleInfo.packnum}[#-- 包装数量 --]
									[#if productSaleInfo.packunitName??]
										<span>${productSaleInfo.packunitName}</span>
									[/#if]
									</td>
									
								[#if goods.status==1][#-- 起售数量 --]
									[#if productSaleInfo.status==1]
										<td class="scollcolumn">
											${productSaleInfo.startnum}
										[#if productSaleInfo.tpkunitid1Name??]
											<i>${productSaleInfo.tpkunitid1Name}</i>
										[/#if]
										</td>
									[#else]
										<td class="scollcolumn">---</td>
									[/#if]
								[#else]
									<td class="scollcolumn">---</td>
								[/#if]
										
								<td class="parice scollcolumn">
										
										[#if productSaleInfo.status==1]
										<div class="p_${productSaleInfo.code} mt8"><strong class="sellingPrice">￥<i id="p_${productSaleInfo.code}">${productSaleInfo.prefprice?string('0.00')}</i>
											[#if productSaleInfo.tpkunitid1Name??]
												/${productSaleInfo.tpkunitid1Name}
											[/#if]
										</strong></div>
										[#else]
										<td class="scollcolumn"><span class="stopSell">已停售</span></td>
										[/#if]
								</td>
								[#-- [#if goods.status==1]
									[#if productSaleInfo.status==1]
										<td class="idsch">￥<span></span>
										[#if productSaleInfo.tpkunitid1Name??]
											/${productSaleInfo.tpkunitid1Name}
										[/#if]
										</td>
										
										<td class="idscSpanh">￥<span></span>
										[#if productSaleInfo.tpkunitid1Name??]
											/${productSaleInfo.tpkunitid1Name}
										[/#if] 
										</td>
									[#else]
										<td><span class="stopSell">已停售</span></td>
									[/#if]
									
								[#else]
									<td><span class="stopSell">已停售</span></td>
								[/#if] --]
								
								
								
								[#if goods.status==1][#-- 购买数量 --]
									[#if productSaleInfo.status==1]
										<td class="scollcolumn commodListWeird" style="min-width: 120px; text-align: center; ">
											<div class="cotrl">
												<span class="add"></span>
												<input class="telbox" type="text" id="${productSaleInfo.id}" value="0"/>
												<span class="lost"></span>
												<i class="icon-de" ></i>
											</div>
										</td>
									[/#if]
								[/#if]
							</tr>
							[/#list]
						</tbody>
					</table>
					</div>
				</div>
				<div class="commodJoinCarbox">
				[#if goods.status==1]
						<a href="javascript:;" class="commodJoinCar"> <span>加入购物车</span></a>
					[#else]
						<a href="javascript:;" class="commodJoinCarNo"> <span>加入购物车</span></a>
					[/#if]
				</div>
			</div>
			
			<div class="buycar_fix">
				<h5><span id="titsum"></span>种商品加入购物车<a href="javascript:;" class="close"></a></h5>
				[#--<img src="${base}/webresources/shop/img/lins/27.jpg" /> --]
				<img src="${goods.pimg}" alt="${goods.pname}"/></a> 

				<p class="top_p">已选商品：<span id="sum"></span>件</p>
				<p>优惠总金额：<strong>￥</strong><span id="sumparice"></span></p>
				<p>实付款：<strong>￥</strong><span id="realPayPrice"></span></p>
				<p class="pBookOrder">
					<a href="javascript:closebubox();" class="contniu">继续购买</a>
					<a href="javascript:bookOrder();" class="gobuy">去结算</a>
				</p>
			</div>
		</div>
		<!--详情-->
		<div class="detailsBox clearfix">
			<div class="detLokedLkd">
				<div class="detLokedLkdSum">
					<b>看了又看</b>
					<div class="detLokedBox" id="detLokedBox">
						<div class="box">
							<ul class="list">
								[#list seeGoodsInfoList as product]
								<li>
									<a href="${base}/product/id-${product.id}/" title="${product.pname}" target="_blank">
										<img width="168" height="176" src="${product.pimg}" alt="${product.pname}" />
										<p>${product.pname}</p>
										<div class="clearfix"><label id="likePrice_${product.id}" class="normalP" >价格:</label><span class="rmb">￥</span><span class="likeId" id="like_${product.id}">${product.pprice}</span></div>
										<i></i>
									</a>
								</li>
								[/#list]
							</ul>
						</div>
					</div>
				</div>
				<div class="detCorrltion">
					<p>相关分类</p>
					<ul>
						[#list seeGoodsInfoList as category]
						<li><a href="${base}/category/child/${category.categoryid}/">${category.categoryname}</a></li>
						[/#list]
					</ul>
				</div>
			</div>
			<div class="detReferral">
				[#--   <div class="detReferralHead">
					<i></i>
					<p>商品介绍</p>
				</div> --]
				<div class="detReferralHead">
					<ul class="clearfix">
						<li class="active"><a href="#goods_argument">商品参数</a></li>
						<li><a href="#goods_detail">商品详情</a></li>
					</ul>
				</div>
				<div class="tabbar"></div>
				<div class="detReferralBody">
					<div class="detParameter clearfix" id="goods_argument">
						<p class="active">商品参数</p>
						<span></span>
					</div>
					<div class="detParameterT">
						<ul>
							[#if goods.producingarea != null && goods.producingarea != ""]
								<li>产地：${goods.producingarea}</li>
							[/#if]
							[#list paramterList as paramter]
							<li>
								${paramter.name}：${paramter.propertyselectvalue!paramter.propertyvalue}
							</li>
							[/#list]
							[#if goods.setupbookurl != null && goods.setupbookurl != ""]
								<li>安装说明书：<a href="${goods.setupbookurl}">点击下载文档</a></li>
							[/#if]
						</ul>
					</div>
					<div class="detParameter clearfix" id="goods_detail">
						<p>商品详情</p>
						<span></span>
					</div>
					<div class="detPreliminary">
						<span id="capid">${goodsDetail.url!'暂无商品详情'}</span>
					</div>
					
				</div>
			</div>
		</div>
		<div class="rmdToTop" id="rmdToTop">
			<a id="aUdesk" class="serverce"><i></i><span>在线客服<!-- <em></em> --></span></a>
    		<a href="${base}/cart" class="buycar"><i></i><span>购物车<!-- <em></em> --></span></a>
    		<a href="${base}/quick-order" class="nimble"><i></i><span>快捷下单<!-- <em></em> --></span></a>
    		<a href="${base}/account/profile" class="membercenter"><i></i><span>会员中心<!-- <em></em> --></span></a>
    		<a class="feedback"><i></i><span>意见反馈<!-- <em></em> --></span></a>
    		<a href="javascript:;" class="back_top" id="back_top"><i></i><span>返回顶部<!-- <em></em> --></span></a>
		</div>
		<!--尾部-->
		<div id="footer"></div>       
        <script type="text/javascript" src="${base}/webresources/shop/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="${base}/webresources/shop/js/login.js"></script>
		<script type="text/javascript" src="${base}/webresources/shop/js/cxscroll.js"></script>
		<script type="text/javascript" src="${base}/static/js/getcartcount.js"></script>
		<script type="text/javascript" src="${base}/static/js/layer/layer.js"></script>
		<script type="text/javascript" src="${base}/static/js/common.js"></script>
		<script  type="text/javascript">
		$(function() {
			$('#footer').load('${cmsurlfooter}');
			//获取购物车数量，用于购物车显示
			getcartcount('${base}/');
		});
		/* layer新皮肤*/
		layer.config({
    		extend: ['skin/myskin/style.css'], //加载您的扩展样式
    		skin: 'layer-ext-uniPay'
		});
		
		//tabbar 吸顶效果
		$(".detReferral .detReferralHead li").click(function(){
			$(this).addClass("active").siblings("li").removeClass("active");
			
			var href = $(this).find("a").attr("href");
			var otherHref = $(this).siblings("li").find("a").attr("href");
			//console.log(href);
			//console.log(otherHref);
			$(href).find("p").addClass("active");
			$(otherHref).find("p").removeClass("active");
		})
		
		DetailsTabFix();
		Onscroll();
		
		//绑定方法
		function Onscroll(){
			$(window).bind("scroll",function(){
				DetailsTabFix();
			});
		}
		function DetailsTabFix(){
			var scrooltop=$(window).scrollTop();
			//var aa=$(".detailsBox").scrollTop();
			//var aa=$('.detailsBox').offset().top;
			var headH1=$(".rmdHead").height();
			var headH2=$(".rmdSeek").height();
			var headH3=$(".rmdClassify").height();
			var menuH=$(".remProduct").height();
			var tableH=$(".commodList").height();
			var tableMt=30;
			var tableMb=40;
			
			var fixNavTop=headH1+headH2+headH3+menuH+tableH+tableMt+tableMb;
			//console.log(fixNavTop);
			if(scrooltop>fixNavTop){
				$(".tabbar").show();
				$(".detReferralHead").addClass("tab_fixed");
			}else{
				$(".tabbar").hide();
				$(".detReferralHead").removeClass("tab_fixed");
			}
			
		}
		
		//左侧滚动
		/*$('#detLokedBox').cxScroll({
			step:1,
			direction: 'top',
			time: 5000,
			auto:false
		});*/
		
		var goodsId = $("#saleInfoBaseId").attr("data-baseid");
		
		var code = "";
		$(".productCode").each(function(){
			   var pcode=$(this).attr("id").split("c_");
			    if(pcode!='undefined' && pcode!='' ){
			    code+=pcode;
			    }
			    
			})
		var likeGoodsId='';
		$(".likeId").each(function(){
		   var lId=$(this).attr("id").split("like_");
		    if(lId!='undefined' && lId!='' ){
		    likeGoodsId+=lId;
		    }
		})	
	//判断用户是否登录
			[#--goodPrice[0],商品编码
				goodPrice[1],是否有促销价
				goodPrice[2],折扣价
				goodPrice[3],原价
				goodPrice[4],计量单位
				goodPrice[5],状态--]
			$.ajax({
				dataType:'json',
				url:'${base}/tmember/companyIdSession.do',
				success(companyId){
		        if(companyId>0){
		        	//认证通过显示会员价
		        	$("a").remove(".noApprove");
					var aa = '<a href="${base}/account/certify" class="yesApprove">企业认证会员</a>';
					$("#YNapprove").prepend(aa);
					$(".commodPrice .minAndmax label").text("会 员 价 ：");
					//动态获取促销价或者会员价											
				$.ajax({
					dataType:'json',
					type:'POST',
					data:{goodsId:goodsId},
					url:'${base}/shop/discount/spuDiscountPrice.do',
					success:function(result){
						var pcode =code.split(",");
						pcode.splice(0,1);
						var arr=result.split(",");
						var buf = [];
						for(var i=0;i<arr.length;i++){
							var goodPrice=arr[i].split("|");
							if(goodPrice[5] == 1){
								if(goodPrice[2]!=null){
									buf.push(goodPrice[2]*100);
									var cheapHtml = "";
										if( pcode[i] == goodPrice[0] && goodPrice[1] !='null') {
										 cheapHtml="<span class='chu'>促</span><strong class='saleChu'><del>￥"+goodPrice[3]+"</del>/"+goodPrice[4]+"</strong>";
										}
										if(cheapHtml!=""){
											cheapHtml+="<p class='sellingPrice'>￥<i id='p_"+goodPrice[0]+"'>"+goodPrice[2]+"</i>/"+goodPrice[4]+"</p>";
										}else{
											cheapHtml="<p class='sellingPrice' style='float: none;margin-top: -6px;'>￥<i id='p_"+goodPrice[0]+"'>"+goodPrice[2]+"</i>/"+goodPrice[4]+"</p>";
										}
										$(".tables table td.parice").find(".p_"+goodPrice[0]).html(cheapHtml);
									}
								}
							}
							var maxprice=(Math.max.apply(null, buf)/100).toFixed(2);
							var minprice=(Math.min.apply(null, buf)/100).toFixed(2);
							if(buf.length == 0){
								$(".commodPrice .minAndmax span").text("已下架");
							}else if(maxprice == minprice){
								$(".commodPrice .minAndmax span").text("￥"+maxprice);
							}else{
								$(".commodPrice .minAndmax span").text("￥"+minprice+"~"+maxprice);
							}
						}	
					});
				$.ajax({
						dataType:'json',
						type:'POST',
						async:false,
						data:{likeGoodsId:likeGoodsId},
						url:'/rmdfront/shop/discount/likePrice',
						success:function(result){
								var gId =likeGoodsId.split(",");
								//移除数组中第一个空元素
								gId.splice(0,1);
								var arr=result.split(",");
								console.log(arr);
								for(var i=0;i<arr.length;i++){
									var goodPrice=arr[i].split("=");
									for(var k=0;k<goodPrice.length;k++){
									if(gId[i]==goodPrice[0]){
									//显示新的会员价
									$("#like_"+goodPrice[0]).text(goodPrice[1]);
									//登陆后修改价格描述
								    $("#likePrice_"+goodPrice[0]).removeClass("normalP");
									$("#likePrice_"+goodPrice[0]).attr("class","memberP").text("会员价:");
									  }
									}
								}	
							}
						});
    		}else{
    			//未认证的用户
					$("a").remove(".noApprove");
					var aa = '<a href="${base}/account/certify" class="failedApprove">企业认证</a>';
					$("#YNapprove").prepend(aa);
				}
			}
		});
			//未登录状态下动态显示促销价（如果有促销价的话）
			$.ajax({
					dataType:'json',
					type:'POST',
					data:{goodsId:goodsId},
					url:'${base}/shop/discount/spuDiscountPrice.do',
					success:function(result){
						var pcode =code.split(",");
						pcode.splice(0,1);
						var arr=result.split(",");
						var buf = [];
						for(var i=0;i<arr.length;i++){
							var goodPrice=arr[i].split("|");
							if(goodPrice[5] == 1){
								if(goodPrice[2]!=null){
									var cheapHtml = "";
										if( pcode[i] == goodPrice[0] && goodPrice[1] !='null') {
										 	cheapHtml="<span class='chu'>促</span><strong class='saleChu'><del>￥"+goodPrice[3]+"</del>/"+goodPrice[4]+"</strong>";
										}
										if(cheapHtml!=""){
											buf.push(goodPrice[1]*100);
											cheapHtml+="<p class='sellingPrice'>￥<i id='p_"+goodPrice[0]+"'>"+goodPrice[1]+"</i>/"+goodPrice[4]+"</p>";
										}else{
											buf.push(goodPrice[3]*100);
											cheapHtml="<p class='sellingPrice' style='float: none;margin-top: -6px;'>￥<i id='p_"+goodPrice[0]+"'>"+goodPrice[3]+"</i>/"+goodPrice[4]+"</p>";
										}
										$(".tables table td.parice").find(".p_"+goodPrice[0]).html(cheapHtml);
									}
								}
							}
							var maxprice=(Math.max.apply(null, buf)/100).toFixed(2);
							var minprice=(Math.min.apply(null, buf)/100).toFixed(2);
							if(buf.length == 0){
								$(".commodPrice .minAndmax span").text("已下架");
							}else if(maxprice == minprice){
								$(".commodPrice .minAndmax span").text("￥"+maxprice);
							}else{
								$(".commodPrice .minAndmax span").text("￥"+minprice+"~"+maxprice);
							}
						}	
					});						
										
		function addToCart(){
			var totalNumberOfGoods = 0;
			$(".telbox").each(function(){
				var goodsNum = parseInt($(this).val());
					if(goodsNum > 0){
						totalNumberOfGoods = totalNumberOfGoods + goodsNum;
						addGoods($(this).prop("id"), goodsNum);
					}
			});
			return totalNumberOfGoods;
		}
		
		function addGoods(tgoodssaleinfoId, goodsNum){ 
			var userId="2";
		 	$.ajax({
				type:"post",
				url:"${base}/backstage/tshopping/inserTShopping.do",
				data:{"userId":userId,"numbers":goodsNum,"tgoodssaleinfoId":tgoodssaleinfoId},
				success:function (data){
					if(data=="true"){
						//window.location.href="${base}/views/car/selectCar.jsp";
					}else{
						layer.open({
		            		type: 1, //page层
		            		area: ['620px', '240px'],
		            		title: '  ',
		            		shade: 0.5, //遮罩透明度
		            		moveType: 1, //拖拽风格，0是默认，1是传统拖动
		            		shift: 1, //0-6的动画形式，-1不开启
		            		time:6000,
		            		content: '<p class="pContent pContent1"><i></i>加入购物车失败！</p>'
		        		});
					}
				}
		 	});
		 }
		 
		 function bookOrder(){
		 	window.location.href="${base}/cart";
			$(".telbox").each(function(){
				var currentValue = parseInt($(this).val());
				$(this).val(0);
			})
		 }
		 
		function escape2Html(str) {
			var arrEntities={'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'};
			return str.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
		}
		
		$('#capid').html(escape2Html($('#capid').text()));
			
		$(document).ready(function(){
			var loginurl="${base}/shop/login/loginStatus.do";
			var bUrl="${base}";
		    loginStatus(loginurl,bUrl);
			//放大镜
			//$(".jqzoom").imagezoom();
			$("#thumblist li").eq(0).attr("class","tb-selected");
			$("#thumblist li").hover(function(){
				$(this).addClass("tb-selected").siblings().removeClass("tb-selected");
				$(".jqzoom").attr('src',$(this).find("img").attr("mid"));
				$(".jqzoom").attr('rel',$(this).find("img").attr("big"));
			});
			//tab
			var listsum = $("#thumblist li").length;
			$(".box .right").click(function(){
				var mleft = parseInt($("#thumblist").css("margin-left"));
				if(listsum>5&&mleft>-60*(listsum-5)){
					$("#thumblist").animate({"margin-left":(parseInt(mleft)-60)+"px"},400);
				}
			})
			$(".box .left").click(function(){
				var mleft = $("#thumblist").css("margin-left");
				if(listsum>5&&parseInt(mleft)<0){
					$("#thumblist").animate({"margin-left":(parseInt(mleft)+60)+"px"},400);
				}
			})								
		})	
			//计算价格
		$(".commodJoinCar").click(function(){
				var aaa = addToCart();
				if(aaa == 0) {
					layer.open({
		            	type: 1, //page层
		            	area: ['620px', '240px'],
		            	title: '  ',
		            	shade: 0.5, //遮罩透明度
		            	moveType: 1, //拖拽风格，0是默认，1是传统拖动
		            	shift: 1, //0-6的动画形式，-1不开启
		            	time:6000,
		            	content: '<p class="pContent pContent1"><i></i>请勾选商品数量！</p>'
		        	});
					return;
				}
				$(".buycar_fix").show();
				mathparice();
		})
		//关闭弹窗
		function closebubox(){
			$(".buycar_fix").hide();
			$(".telbox").each(function(){
				var currentValue = parseInt($(this).val());
				$(this).val(0);
			})
		}
		//价格计算
		function mathparice(){
			var raceSum=0;//种类数量
			var sum=0,//购买数量
			sumParice=0,
			cheapPrice=0,//促销价
			memberParice=0;//会员价
			sellingPrice=0;//销售价
				$(".telbox").each(function(){
				if($(this).val()!=""&&$(this).val()!="0"){
					sum+=parseInt($(this).val());
					if(parseInt($(this).val()) > 0){
						raceSum+=1;
					}
					sumParice+=parseInt($(this).val())* parseFloat($(this).parent("div").parent("td").parent("tr").attr("data-parice"));
					var cheap = $(this).parent("div").parent("td").siblings().find("p").find("i").text();
					if(cheap>0){
						cheapPrice+=parseInt($(this).val())* parseFloat(cheap);
					}else{
						cheapPrice+=parseInt($(this).parent("div").parent("td").siblings().find("p").find("i").text());
					}
				}
				if(sumParice.toFixed(2) == cheapPrice.toFixed(2)){
					$("#sumparice").html("0.00");
					$("#realPayPrice").html(toDecimal2(cheapPrice.toFixed(2)));
				}else{
					$("#sumparice").html(toDecimal2(sumParice.toFixed(2) - cheapPrice.toFixed(2)));
					$("#realPayPrice").html(toDecimal2(cheapPrice.toFixed(2)));
				}
			})
			$("#titsum").html(raceSum);
			$("#sum").html(sum);
		}
		$(".buycar_fix .close").click(function(){
			closebubox();
		})
		$(".buycar_fix .contniu").click(function(){
			closebubox();
		})
		//table 加减
		$(".cotrl .lost").click(function(){
			var inputd=$(this).siblings(".telbox");
			if(inputd.val()!="" && inputd.val() <99999){
				var oldsum=inputd.val();
				oldsum++;
				inputd.val(oldsum);
			}
		})
		$(".cotrl .add").click(function(){
			var inputd=$(this).siblings(".telbox");
			if(inputd.val()!=""){
				var oldsum=inputd.val();
				if(oldsum>1)
					oldsum--;
					inputd.val(oldsum);
				}
		})
		
				
		//menu
		$(".rmdCarouselList li").hover(function(){
			$(this).addClass("active");
			$(this).find(".li_detail").show();
		},function(){
			$(this).removeClass("active");
			$(this).find(".li_detail").hide();
		})
		//menu_alert
		$("#menu").hover(function(){
			var menu = $(".rmdCarouselList");
			menu.show();
			$(".centerBox ").mouseleave(function(){
				$(".rmdCarouselList").hide();
			})
		});
		//ajax异步获取折扣价---动态计算按行
		//1前端判断是否登录 是获取memberid，后台通过会员id查到会员组 测试用
		//var memberid=1;
		//2获取商品基本信息ID,后台通赤商品ID查到折扣方案
		var goodsbaseid=${goods.id};
		//3通过折扣方案和会员组查找会员折扣率(默认游客登录 进来看不到折扣价,只有会员才能看到)
		/*$.ajax({
			dataType:'json',
			type:'post',
			data:{memberid:memberid,goodsbaseid:goodsbaseid},
			url:'${base}/shop/discount/discountPrice.do',
			success:function(map){
					var flag = map.flag;
					var strSpan = map.strSpan;
					[#--  alert(flag+"-----"+strSpan);--]
					if(flag==1){
						var arr = strSpan.split(",");
						$("#skutb_tableData table tbody .strTrEach").each(function(i,e){
							$(this).find(".idsch span").text(arr[i]);
						})
						$("#skutb_tableColumn table tbody .strTrEach").each(function(i,e){
								$(this).find(".idsch span").text(arr[i]);
						})
					}else{
						var arr = strSpan.split(",");
						$("#skutb_tableData table tbody .strTrEach").each(function(i,e){
								$(this).find(".idsch span").text(arr[i]);
						})
						$("#skutb_tableColumn table tbody .strTrEach").each(function(i,e){
								$(this).find(".idsch span").text(arr[i]);
						})
					}
				}
		});*/
		//点击“选择规格型号”按钮，弹出提示语“请选择一件商品”，3s后提示语消失，在给第一行数据加上鼠标选中样式
		/*$(".commodModel").click(function() {
			layer.open({
		           type: 1, //page层
		           area: ['620px', '240px'],
		           title: '  ',
		           shade: 0.5, //遮罩透明度
		           moveType: 1, //拖拽风格，0是默认，1是传统拖动
		           shift: 1, //0-6的动画形式，-1不开启
		           time:6000,
		           content: '<p class="pContent">请选一种商品</p>'
		    });
			var oTable=document.getElementById("tableSale"); 
			var bTable = oTable.tBodies[0];
			bTable.style.backgroundColor="#ffe9d9";
		});*/
				
		//采购数量,默认值为0， 只接受正数，设置最大值99999，最小值0， 不符合的输入给出提示，自动恢复默认值
		$(".telbox").bind("blur" , function() {
			var currentValue = $(this).val();
			if(!new RegExp(validateRegExp.buyNumberDeil).test(currentValue)) {
				layer.open({
            		type: 1, //page层
            		area: ['620px', '240px'],
            		title: '  ',
            		shade: 0.5, //遮罩透明度
            		moveType: 1, //拖拽风格，0是默认，1是传统拖动
            		shift: 1, //0-6的动画形式，-1不开启
            		time:6000,
            		content: '<p class="pContent pContent1"><i></i>请输入1~99999的购买量</p>'
        		});
				$(this).val(0);
			}else if(parseInt(currentValue) < 0) {
				layer.open({
            		type: 1, //page层
            		area: ['620px', '240px'],
            		title: '  ',
            		shade: 0.5, //遮罩透明度
            		moveType: 1, //拖拽风格，0是默认，1是传统拖动
            		shift: 1, //0-6的动画形式，-1不开启
            		time:6000,
            		content: '<p class="pContent pContent1"><i></i>请输入1~99999的购买量</p>'
        		});
				$(this).val(0);
			}else if(parseInt(currentValue) > 99999) {
				layer.open({
            		type: 1, //page层
            		area: ['620px', '240px'],
            		title: '  ',
            		shade: 0.5, //遮罩透明度
            		moveType: 1, //拖拽风格，0是默认，1是传统拖动
            		shift: 1, //0-6的动画形式，-1不开启
            		time:6000,
            		content: '<p class="pContent pContent1"><i></i>请输入1~99999的购买量</p>'
        		});
				$(this).val(99999);
			}					
		});
		//规格型号hover状态
		 $('.commodList tr').hover(function(){
			//给鼠标获得本身加样式
			$(this).addClass('active');
			
			//清除第一行样式
			var oTable=document.getElementById("skutb"); 
			var bTable = oTable.tBodies[0];
			bTable.style.backgroundColor="#fff";
		},function(){
			$(this).removeClass('active');
		})
		//规格型号table
	    var bStrike = true;
	    //qCloneAcion();
	    function qCloneAcion() {
	        $('#skutb_tableColumnClone tbody').html(skubody.html());
	        $('#skutb_tableColumnClone tbody').css({
	        	"background-color" : "#EFEFEF",
	        	"position" : "absolute",
	        	"right" : "-2px"
	        	});
	        $('#skutb_tableColumnClone tr td').each(function() {
	            if (!$(this).hasClass("scollcolumn")) {
	                $(this).hide();
	            }
	        });
	        $('#skutb_tableLayout').height($('#skutb_tableData').height());
	        $('#skutabcont').height($('#skutb_tableData').height());
	    }
	    function FixTable(TableID, FixColumnNumber, width, height) {
	        if ($("#" + TableID + "_tableLayout").length != 0) {
	            $("#" + TableID + "_tableLayout").before($("#" + TableID));
	            $("#" + TableID + "_tableLayout").empty();
	        } else {
	            $("#" + TableID).after("<div id='" + TableID + "_tableLayout' style='overflow:hidden;margin:0 auto;height:" + height + "px; width:" + width + "px;'></div>");
	        }
	        $('<div id="' + TableID + '_tableFix"></div>' + '<div id="' + TableID + '_tableHead"></div>' + '<div id="' + TableID + '_tableColumn"></div>' + '<div id="' + TableID + '_tableData"></div>').appendTo("#" + TableID + "_tableLayout");
	        var oldtable = $("#" + TableID);
	        var tableFixClone = oldtable.clone(true);
	        tableFixClone.attr("id", TableID + "_tableFixClone");
	        $("#" + TableID + "_tableFix").append(tableFixClone);
	        var tableHeadClone = oldtable.clone(true);
	        tableHeadClone.attr("id", TableID + "_tableHeadClone");
	        $("#" + TableID + "_tableHead").append(tableHeadClone);
	        var tableColumnClone = oldtable.clone(true);
	        tableColumnClone.attr("id", TableID + "_tableColumnClone");
	        $("#" + TableID + "_tableColumn").append(tableColumnClone);
	        $("#" + TableID + "_tableData").append(oldtable);
	        $("#" + TableID + "_tableLayout table").each(function() {
	            $(this).css("margin", "0");
	        });
	        var HeadHeight = $("#" + TableID + "_tableHead thead").height();
	        HeadHeight += 1;
	        $("#" + TableID + "_tableHead").css("height", HeadHeight);
	        $("#" + TableID + "_tableFix").css("height", HeadHeight);
	        var ColumnsWidth = 0;
	        var ColumnsNumber = 0;
	        $("#" + TableID + "_tableColumn tr:last td:lt(" + FixColumnNumber + ")").each(function() {
	            ColumnsWidth += $(this).outerWidth(true);
	            ColumnsNumber++;
	        });
	        ColumnsWidth += 1;
	        /*if ($.browser.msie) {
	            switch ($.browser.version) {
	                case "7.0":
	                    if (ColumnsNumber >= 3)
	                        ColumnsWidth--;
	                    break;
	                case "8.0":
	                    if (ColumnsNumber >= 2)
	                        ColumnsWidth--;
	                    break;
	            }
	        }*/
	        $("#" + TableID + "_tableColumn").css("width", ColumnsWidth);
	        $("#" + TableID + "_tableFix").css("width", ColumnsWidth);
	        $("#" + TableID + "_tableData").scroll(function() {
	            $("#" + TableID + "_tableHead").scrollLeft($("#" + TableID + "_tableData").scrollLeft());
	            $("#" + TableID + "_tableColumn").scrollTop($("#" + TableID + "_tableData").scrollTop());
	        });
	        $("#" + TableID + "_tableFix").css({
	            "overflow" : "hidden",
	            "position" : "relative",
	            "z-index" : "50"
	        });
	        $("#skutb_tableColumnClone").css("background-color", "#EFEFEF");
	        $("#skutb_tableFixClone").css("background-color", "#EFEFEF");
	        $("#" + TableID + "_tableHead").css({
	            "overflow" : "hidden",
	            "width" : width - 17,
	            "position" : "relative",
	            "z-index" : "45",
	            "background-color" : "#EFEFEF"
	        });
	        $("#" + TableID + "_tableColumn").css({
	            "overflow" : "hidden",
	            "height" : height - 17,
	            "position" : "relative",
	            "z-index" : "40"
	        });
	        $("#" + TableID + "_tableData").css({
	            "overflow" : "scroll",
	            "width" : width,
	            "height" : height,
	            "position" : "relative",
	            "z-index" : "35"
	        });
	        if ($("#" + TableID + "_tableHead").width() > $("#" + TableID + "_tableFix table").width()) {
	            $("#" + TableID + "_tableHead").css("width", $("#" + TableID + "_tableFix table").width());
	            $("#" + TableID + "_tableData").css("width", $("#" + TableID + "_tableFix table").width() + 17);
	        }
	        if ($("#" + TableID + "_tableColumn").height() > $("#" + TableID + "_tableColumn table").height()) {
	            $("#" + TableID + "_tableColumn").css("height", $("#" + TableID + "_tableColumn table").height());
	            $("#" + TableID + "_tableData").css("height", $("#" + TableID + "_tableColumn table").height() + 17);
	        }
	        $("#" + TableID + "_tableFix").offset($("#" + TableID + "_tableLayout").offset());
	        $("#" + TableID + "_tableHead").offset($("#" + TableID + "_tableLayout").offset());
	        $("#" + TableID + "_tableColumn").offset($("#" + TableID + "_tableLayout").offset());
	        $("#" + TableID + "_tableData").offset($("#" + TableID + "_tableLayout").offset());
	        if(bStrike){
	            $("#" + TableID + "_tableFix").css({"left":"579px" ,"width":"602px"});
	            $("#" + TableID + "_tableColumn").css({"left":"579px" ,"width":"602px"});
	        }else{
	            $("#" + TableID + "_tableFix").css({"left":"559px" ,"width":"424px"});
	            $("#" + TableID + "_tableColumn").css({"left":"559px" ,"width":"424px"});
	        }
	    }
	    var hei = $(".tabcont").height()+17;
	    FixTable("skutb", 4, 1198,hei);
	    $('#skutb_tableData').width(1198);
	    $('#skutb_tableHead').width(1181);
	    $('#skutb_tableFixClone tr:eq(0) td').each(function() {
	        if (!$(this).hasClass("scollcolumn")) {
	            $(this).hide();
	        }
	       // $('#skutb_tableFixClone tr:eq(1) td div').remove();
	       //$("#skutb_tableFix table tr td a").remove();
	
	        $('#skutb_tableColumnClone tr td').each(function() {
	            if (!$(this).hasClass("scollcolumn")) {
	                $(this).hide();
	            }
	        });
	    });
		$('#skutb_tableLayout').height($('#skutb_tableData').height());
		$('#skutabcont').height($('#skutb_tableData').height());
		var a=$('#skutb_tableLayout').height();
		var b=$('#skutabcont').height();
		
		/*
		test
		*/
		console.log("skutb_tableLayout"+a)
		console.log("skutabcont"+b)
		console.log($('#skutb_tableData').height()+17)
		
		
		$(".icon-de").click(function(){
			$(this).siblings(".telbox").val("0");
		})
		
		
		
		
	</script>
	<script type="text/javascript" src="${base}/static/js/customerOne.js"></script>
	
	</body>
</html>
