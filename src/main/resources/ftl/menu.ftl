<div class="rmdClassify">
	<div class="center">

		<div class="centerBox">
			<h3  class="hactive" id="menu">全部商品分类</h3>
			<ul class="rmdCarouselList clearfix">
				[#--1级分类显示15行--]
				[#list tgoodsCategories as rootGood]
				<li><a href="${base}/category/root/${rootGood.id}/">${rootGood.categoryname}</a><i></i>
					<div class="li_detail">
							[#--2级商品分类显示默认10行--]
							[#list rootGood.children as parentGood]
							<dl>
								<dt><a href="${base}/category/parent/${parentGood.id}/">${parentGood.categoryname}</a></dt>
								<dd>
								[#--3级商品分类显示默认10行--]
										[#list parentGood.children as childrenGood]
											<em><a href="${base}/category/child/${childrenGood.id}/">${childrenGood.categoryname}</a></em>
										[/#list]
								</dd>
							</dl>
						[/#list]
					</div>
				</li>
				[/#list]
			</ul>
		</div>
		<div class="r_time">
			<h4><a href="${base}/index.html">首页</a></h4>
			<span></span>
			<h4><a href="${base}/category/root/21/">阀门管件专区</a></h4>
			<span></span>
			<h4><a href="${base}/category/root/1/">卫浴洁具专区</a></h4>
			<span></span>
			<h4><a href="${base}/category/root/2/">五金工具专区</a></h4>
			<span></span>
			<h4><a target="_blank" href="${base}/cooperation/getProvinceList.do">招商加盟专区</a></h4>
		</div>
		
	</div>
</div>