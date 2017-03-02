<script type="text/javascript" src="${base}/webresources/shop/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	document.getElementById("helpCenter").href='${cmsUrlHelpCenter}'+"cjwt";
});
</script>
			<!-- <div class="rmdtop_advert">
				<a href="javascript:;">
					<img src="${base}/static/img/index_top_advert.jpg" alt=""/>
				</a>
			</div> -->
			<!-- <div style="width:1200px;height:30px;line-height:30px;font-size:12px;color:#fe6000;margin:0 auto">
				<marquee scrollAmount="4" direction=left>猎鹰工品上线内测中，所有订单不发货、不退款。如遇到bug等问题，请邮件ceshi@raymondgroups.com。</marquee>
			</div> -->
			<div class="rmdHead">
				<div class="rmdWcom clearfix">
					<a href="javascript:;">收藏本站</a>
					<!-- <p>欢迎来到猎鹰工品</p> -->
					<ul>
						<li>
							<a id="aRegister" class="alogin" target="_blank"></a>
							<a id="alogin" class="alogin" target="_blank"></a>
						</li>
						<li class="rmdMberCeter">
							<a href="javascript:;">会员中心</a>
							<span></span>
							<div class="rmdNavPop">
							<div></div>
								<div class="rmdNavPopBox">
									<div class="rmdNavPopBoxHed clearfix">
									
									</div>
									<div class="rmdNavPopBoxDts clearfix">
										<div class="rmdNavPopBoxDtsL">
											<a href="${base}/order/pending-payment" target="_blank">待支付订单</a>
											<a href="${base}/order/confirm-delivery" target="_blank">待收货订单</a>
											<!-- <a href="${base}/order/completed" target="_blank">已完成订单</a> --> 
										</div>
										<div class="rmdNavPopBoxDtsL">
											<a href="${base}/service/record"  target="_blank">退/换货</a>
											<a href="${base}/account/profile" target="_blank">设置</a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<i class="rmdWcomcar"></i>
							<a href="${base}/cart"  target="_blank">购物车</a>
						</li>
						<li>
							<a href="${base}/order"  target="_blank">我的订单</a>
							<div class="order_list"></div>
						</li>
						<!-- <li class="rmdMyService">
							<a href="javascript:;">我的客服</a>
							<span></span>
							<div class="rmdNavPop1">
							<div></div>
								<h5>客服电话</h5>
								<div class="rmdNavPop1Phe clearfix">
									<i></i>
									<b>400-138-5558</b>
								</div>
								<div class="rmdNavPopBoxDts clearfix">
									<div class="rmdNavPopBoxDtsL2">
										<a id="aUdesk">在线客服</a>
										<a id="helpCenter" target="_blank">帮助中心</a>
									</div>
									<div class="rmdNavPopBoxDtsL2">
										<a href="${base}/service/record">售后服务</a>
										<a href="${base}/feedback">意见反馈</a>
									</div>
								</div>
							</div>
						</li> -->
						
						<li class="rmdApp">
							<a href="${base}/views/user/appDownload.jsp" target="_blank">获取App</a>
							<span></span>
							<div class="rmdNavPop2">
								<div></div>
								<img alt="" title="app二维码" src="${base}/static/img/APPQR.jpg"/>
								<p>扫码下载App</p>
							</div>
						</li>
						<li>
							<a href="javascript:;"  id="helpCenter"  target="_blank">帮助</a>
						</li>
						<li>
							<i class="rmd_phone"></i>
							<a  href="javascript:;">400-138-5558</a>
						</li>
						
					</ul>
				</div>
			</div>
			<!--logo-->
			<div class="rmdSeek clearfix">
				<div class="rmdLogo">
					<a href="${base}/index.html">猎鹰工品</a>
				</div>
				<div class="rmdSeekDetails">
					<div class="rmdSeekDetailsH clearfix">
						<!--<form id="formkeyword" method="post" action="${base}/search" onsubmit="return keywords.value!='请输入您要搜索的商品名称、品牌、型号、商品编码';">-->
							<div class="rmdSeekDetailsT">
								<i></i>
								<input type="text"   id="keyword" name="keyword" class="rmdSeekDetailsTxt" placeholder="请输入您要搜索的商品名称、品牌、型号、商品编码" onblur="if(this.placeholder==''){ this.placeholder='请输入您要搜索的商品名称、品牌、型号、商品编码';this.style.color='#acacac'}" onfocus="if(this.placeholder=='请输入您要搜索的商品名称、品牌、型号、商品编码'){this.placeholder='';this.style.color='#000'}" value="" />
							</div>
							<input id="search" onclick="search()" type="button" value="搜索"  class="rmdSeekDetailsBtn"/>
						<!--</form>-->
					</div>
					<p>
						<span>热门搜索：</span>
						<a href="${base}/cnSearch?keyword=金幻灯饰">金幻灯饰</a>
						<a href="${base}/cnSearch?keyword=防盗门">防盗门</a>
						<a href="${base}/cnSearch?keyword=面板开关">面板开关</a>
						<a href="${base}/cnSearch?keyword=电钻">电钻</a>
						<a href="${base}/cnSearch?keyword=排插">排插</a>
						<a href="${base}/cnSearch?keyword=安全帽">安全帽</a>
						<a href="${base}/cnSearch?keyword=焊条">焊条</a>
						<a href="${base}/cnSearch?keyword=调和漆">调和漆</a>
						<a href="${base}/cnSearch?keyword=塑铜线">塑铜线</a>
					</p>
				</div>
				<div class="rmdSeekRapid">
					<a href="${base}/quick-order" class="rmdSeekOrders clearfix">
						<i></i>快捷下单
					</a>
					
					<a href="${base}/cart" class="rmdShoppingCar" id="rmdShoppingCar">
						<i></i>购物车
					</a>
				</div>
			</div>

<script type="text/javascript">
//搜索
function search (){
	var keyword = $("#keyword").val();
	if(keyword == ''){
		window.location.href = "${base}/cnSearch";
	}else{
		window.location.href = "${base}/cnSearch?keyword="+keyword;
	};
};
$("#keyword").keypress(function(event){
	if(event.which==13){
		search();
	}
});
</script>