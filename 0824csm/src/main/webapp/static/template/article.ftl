<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="/static/home/css/normalize-8.0.0.css" /><link rel="stylesheet" type="text/css" href="/static/home/css/normalize-8.0.0-plus_20181022.css" />
		<link rel="stylesheet" type="text/css" href="/static/home/css/basic(PC)_20190712.css "/>
		
		<script src="/static/home/js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/static/home/css/swiper.min.css "/>
		
		<link rel="stylesheet" type="text/css" href="/static/home/css/header(PC)_20181022.css "/>
		<link rel="stylesheet" type="text/css" href="/static/home/css/footer(PC)_20181022.css "/>
		<link rel="stylesheet" type="text/css" href="/static/home/css/side-bar(PC)_20190515.css "/>
		<link rel="stylesheet" type="text/css" href="/static/home/css/2-up-vertical(PC)_20190509.css "/>
		<link rel="stylesheet" type="text/css" href="/static/home/css/article.css "/>
	</head>
	<body class="flex-box">
		<div class="frame header" id="header_banner"><div class="container" style="background-image: url(/static/home/img/header_ad.png)"><img src="/static/home/img/header_ad.png" style="opacity: 0" /></div></div><div class="frame header" id="header_wx-wb"><div class="panel flex-box"><div>源码时代一家口碑超好IT培训机构</div><div><div class="wx">官方微信</div>|<div class="wb">官方微博</div>|<a target="_blank" href="about-us.html">关于我们</a></div></div></div><div class="frame header" id="header_navigator"><div class="panel flex-box"><div class="logo_n_regions flex-box"><a class="logo" href="index.html"><img src="/static/home/img/header_logo.png" /></a><div class="regions flex-box"><a class="wrapper flex-box activated" style="background-image: url(/static/home/img/header_region_all.png)"><span class="text">全国校区</span></a><div class="splitter"></div><a class="wrapper flex-box" style="background-image: url(/static/home/img/header_region_cd.png)"><span class="text">成都校区</span></a><div class="splitter"></div><a class="wrapper flex-box" style="background-image: url(/static/home/img/header_region_cq.png)"><span class="text">重庆校区</span></a><div class="splitter"></div><a class="wrapper flex-box" style="background-image: url(/static/home/img/header_region_wh.png)"><span class="text">武汉校区</span></a></div></div><div class="motto_n_phone"><img class="motto" src="/static/home/img/header_motto.png" /><div class="phone"><img class="icon" src="/static/home/img/header_phone_icon.png" /><span>028-86261949</span></div></div></div><div class="panel flex-box"><div class="links flex-box"><a target="_blank" href="index.html" class="activated"><div class="text">首页</div></a><a target="_blank" href="courseWeb.html" id="categories-menu-trigger"><div class="text">课程中心</div></a><a target="_blank" href="public-classes.html"><div class="text">免费公开课</div></a><a target="_blank" href="videos.html"><div class="text">视频教程</div></a><a target="_blank" href="teachers.html"><div class="text">师资团队</div></a><a target="_blank" href="works.html"><div class="text">学员作品</div></a><a target="_blank" href="alumns.html"><div class="text">明星学员</div></a><a target="_blank" href="enroll.html"><div class="text">报名流程</div></a><a target="_blank" href=".html"><div class="text">源码社区</div></a></div></div><div id="categories-menu" class="flex-box deactivated"><a class="flex-box" category="java" target="_blank" href=""><div class="text">Java学科</div></a><a class="flex-box" category="python" target="_blank" href=""><div class="text">Python+人工智能学科</div></a><a class="flex-box" category="h5" target="_blank" href=""><div class="text">H5前端学科</div></a><a class="flex-box" category="ui" target="_blank" href=""><div class="text">UI设计学科</div></a><a class="flex-box" category="software-test" target="_blank" href=""><div class="text">软件测试学科</div></a><a class="flex-box" category="php" target="_blank" href=""><div class="text">PHP学科</div></a><a class="flex-box" category="bigdata" target="_blank" href=""><div class="text">大数据学科</div></a></div></div>
		<div class="frame center">
			<div class="container swiper-container" id="banner">
			    <div class="swiper-wrapper">
					<a class="swiper-slide" style="background-image: url(/static/home/img/banner_placeholder_1920x350.png);" target="_blank" href=""></a>
					<a class="swiper-slide" style="background-image: url(/static/home/img/placeholder_1920x350.png);" target="_blank" href=""></a>
			    </div>
				<script>
					$(function() {
						var bannerSwiper = new Swiper ('#banner.swiper-container', {
						 	autoplay: { disableOnInteraction: false },
						    loop: true
					  	});
					  	$("#banner .swiper-slide")
						  	.mouseenter(function() {
						  		bannerSwiper.autoplay.stop();
						  	})
						  	.mouseleave(function() {
						  		bannerSwiper.autoplay.start();
						  	});
					});
				</script>
			</div>
			<div class="container" id="center">
				<div class="panel" id="crumbs"><a target="_blank" href="index.html">首页</a> > <a href="articles.html">公司动态</a> > 源码时代荣膺"回响中国 2017年度特色职业教育品牌"大奖</div>
				<div class="panel">
					<div id="center-right">
						<div class="wrapper minority sticker" id="articles">
							<div class="title-bar flex-box">
								<div class="text">最新教程</div>
								<a class="more" target="_blank" href="javascript:void(0)">更多</a>
							</div>
							<div class="simple-list">
								<a class="li ellipsis-line" target="_blank" href="" title="《超写实刻画》项目作品"></a>
								<a class="li ellipsis-line" target="_blank" href="" title="《响应式金融借贷平台》项目学员作"></a>
	                            <a class="li ellipsis-line" target="_blank" href="" title="《源码生活APP》项目学员作品"></a>
	                            <a class="li ellipsis-line" target="_blank" href="" title="《超市进销存系统》项目学员作品"></a>
								<a class="li ellipsis-line" target="_blank" href="" title="《智慧社区APP》项目学员作品"></a>
								<a class="li ellipsis-line" target="_blank" href="" title="《超写实刻画》项目作品"></a>
								<a class="li ellipsis-line" target="_blank" href="" title="《学生论坛式APP界面设计》项目"></a>
							</div>
						</div>
						<div class="wrapper minority swiper-container" id="ads">
							<div class="swiper-wrapper">
								<a class="swiper-slide" style="background-image: url(/static/home/img/center-right_placeholder_338x107.png)" target="_blank" href=""></a>
								<a class="swiper-slide" style="background-image: url(/static/home/img/center-right_placeholder_338x107.png)" target="_blank" href=""></a>
							</div>
						</div> 
						<div class="wrapper minority" id="starteds">
							<div class="title-bar flex-box">
								<div class="text">开班时间</div>
								<div class="regions" tabs-keel="starteds"><span class="tab active">全部</span><span class="tab">成都</span><span class="tab">重庆</span><span class="tab">武汉</span></div>
							</div>
							<div class="ul">
								<div class="li flex-box" isclassopened="true"><div class="name ellipsis-line" title="Python精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
								<div class="li flex-box" isclassopened="true"><div class="name ellipsis-line" title="Java精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
								<div class="li flex-box" isclassopened="false"><div class="name ellipsis-line" title="UI精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
								<div class="li flex-box" isclassopened="false"><div class="name ellipsis-line" title="H5精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
								<div class="li flex-box" isclassopened="false"><div class="name ellipsis-line" title="软测精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
								<div class="li flex-box" isclassopened="false"><div class="name ellipsis-line" title="PHP精英班"></div><div class="date">2019/01/16</div><a class="entrance" target="_blank" href=""></a></div>
							</div>
							<a class="more" target="_blank" href="javascript:void(0)">更多</a>
						</div>
						<div class="wrapper minority" id="public-classes">
							<div class="title-bar flex-box">
								<div class="text">公开课</div>
							</div>
							<div class="swiper-container">
								<div class="swiper-wrapper">
									<div class="swiper-slide"><div class="class-wrapper">
										<a class="picture" style="background-image: url(/static/home/img/center-right_placeholder_306x204.png)" target="_blank" href=""></a>
										<div class="text-wrapper">
											<div class="name ellipsis-line">超写实图标设计教程XXXXXXCXXXXXXXX</div>
											<div class="teacher">讲师：郝沛羽</div>
											<div class="date">开课时间：2018/11/08</div>
										</div>
									</div></div>
									<div class="swiper-slide"><div class="class-wrapper">
										<a class="picture" style="background-image: url(/static/home/img/center-right_placeholder_306x204.png)" target="_blank" href=""></a>
										<div class="text-wrapper">
											<div class="name ellipsis-line">超写实图标设计教程XXXXXXCXXXXXXXX</div>
											<div class="teacher">讲师：郝沛羽</div>
											<div class="date">开课时间：2018/11/08</div>
										</div>
									</div></div>
								</div>
							</div>
						</div>
						<div class="wrapper minority" id="videos">
							<div class="title-bar flex-box">
								<div class="text">视频教程</div>
							</div>
							<div class="swiper-container">
								<div class="swiper-wrapper">
									<div class="swiper-slide"><div class="video-wrapper">
										<a class="picture" style="background-image: url(/static/home/img/center-right_placeholder_306x204.png)" target="_blank" href=""></a>
										<div class="name ellipsis-line">Django框架之搭建个人博客XXXXXXCXXXXXXXX</div>
									</div></div>
									<div class="swiper-slide"><div class="video-wrapper">
										<a class="picture" style="background-image: url(/static/home/img/center-right_placeholder_306x204.png)" target="_blank" href=""></a>
										<div class="name ellipsis-line">Django框架之搭建个人博客XXXXXXCXXXXXXXX</div>
									</div></div>
								</div>
							</div>
						</div>
					</div>
					<div class="flex-box" id="center-left">
						<div class="wrapper majority article" id="article">
							<div class="info">
								<span><span b>分类: </span>视频教程</span>
								<span><span b>浏览: </span><span id="clickCount">${clickCount}</span></span>
							</div>
							<div class="title">${title}</div>
							<div class="content">
								${content}
							</div>
							<div class="prev_n_next flex-box">
								<a class="prev ellipsis-line" title="《超市进销存系统》项目学员作品作品作品作品作品作品作品作品" target="_blank" href=""></a>
								<a class="next ellipsis-line" title="《超市进销存系统》项目学员作品作品作品作品作品作品作品" target="_blank" href=""></a>
							</div>
						</div>
						<div class="wrapper majority" id="others">
							<div class="title">相关推荐</div>
							<div class="simple-list">
								<a class="li ellipsis-line" title="UI设计学习视频之WEB网页设计" target="_blank" href=""></a>
								<a class="li ellipsis-line" title="全套JavaSE视频教程全套JavaSE视频教程全套JavaSE视频教程" target="_blank" href=""></a>
								<a class="li ellipsis-line" title="UI设计学习视频之网页设计UI设计学习视频之网页设计" target="_blank" href=""></a>
								<a class="li ellipsis-line" title="全套JavaSE入门视频教程全套JavaSE入门视频教程" target="_blank" href=""></a>
								<a class="li ellipsis-line" title="UI设计学习视频之WEB网页设计全套JavaSE入门视频教程全套JavaSE入门视频教程" target="_blank" href=""></a>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="frame footer" id="footer_misc"><div class="container"><div class="panel flex-box" id="footer_services"><div class="wrapper flex-box"><div class="icon" style="background-image: url(/static/home/img/footer_service1_icon.png)"></div><div class="text">课程升级，老学员可免费学习新课程</div></div><div class="wrapper flex-box"><div class="icon" style="background-image: url(/static/home/img/footer_service2_icon.png)"></div><div class="text">老学员工作遇到技术困难，提供技术支持</div></div><div class="wrapper flex-box"><div class="icon" style="background-image: url(/static/home/img/footer_service3_icon.png)"></div><div class="text">学员创业，提供人才技术服务</div></div><div class="wrapper flex-box"><div class="icon" style="background-image: url(/static/home/img/footer_service4_icon.png)"></div><div class="text">全方位就业指导，<br/>无限次推荐就业</div></div></div><div class="panel flex-box a"><div class="flex-box b"><div><a target="_blank" href="">关于我们</a>|<a target="_blank" href="">联系我们</a>|<a target="_blank" href="">校企合作</a>|<a target="_blank" href="">来校路线</a>|<a target="_blank" href="">网站地图</a>|<a target="_blank" href="">源码社区</a></div><div>成都校区：成都市高新区府城大道西段399号天府新谷1号楼6F / 028-86261949</div><div>重庆校区：重庆两江新区华山南路16号重庆互联网学院1号楼314 / 023-63561339</div><div>武汉校区：武汉市东湖新技术开发区华师园北路18号光谷科技港9栋4F / 027-81529608</div></div><div class="splitter"></div><div class="flex-box c"><img src="/static/home/img/wb.png" /><span>微博</span><img src="/static/home/img/wx.png" /><span>微信</span></div></div><div class="panel copyright"><div class="d"><span>邮箱：yuandaima@itsource.cn</span><span>法律顾问：北京京师(成都)律师事务所</span></div><div class="d"><span>®2006-2018成都源代码教育咨询有限公司 版权所有</span><span>蜀ICP备14030149号-1</span><span>蜀公网安备510114990541</span><span>站长统计</span></div></div></div></div>
		<div class="frame flex-box" id="side-bar"><div class="content flex-box"><div class="logo" style="background-image: url(/static/home/img/side-bar_logo.png)"></div><div class="links flex-box"><a class="wrapper" onclick="_hmt.push(['_trackEvent', 'PC_no_右侧栏目', 'click_consult', '右侧栏目_1']);" rel="nofollow" href="https://tb.53kf.com/code/client/d2abbdb2d6a875420ed7ab20394108a8/1" target="_black"><div class="icon" style="background-image: url(/static/home/img/side-bar_seller.png);"></div><div class="text flex-box">在线咨询</div></a><a class="wrapper" onclick="_hmt.push(['_trackEvent', 'PC_no_右侧栏目', 'click_consult', '右侧栏目_2']);" rel="nofollow" href="https://tb.53kf.com/code/client/d2abbdb2d6a875420ed7ab20394108a8/1" target="_black"><div class="icon" style="background-image: url(/static/home/img/side-bar_datas.png);"></div><div class="text flex-box">领取资料</div></a><a class="wrapper" onclick="_hmt.push(['_trackEvent', 'PC_no_右侧栏目', 'click_consult', '右侧栏目_3']);" rel="nofollow" href="https://tb.53kf.com/code/client/d2abbdb2d6a875420ed7ab20394108a8/1" target="_black"><div class="icon" style="background-image: url(/static/home/img/side-bar_jobs.png);"></div><div class="text flex-box">保障就业</div></a><a class="wrapper" onclick="_hmt.push(['_trackEvent', 'PC_no_右侧栏目', 'click_consult', '右侧栏目_4']);" rel="nofollow" href="https://tb.53kf.com/code/client/d2abbdb2d6a875420ed7ab20394108a8/1" target="_black"><div class="icon" style="background-image: url(/static/home/img/side-bar_study.png);"></div><div class="text flex-box">免费试学</div></a><div class="wrapper more"><div class="icon" style="background-image: url(/static/home/img/side-bar_more.png);"></div><div class="text flex-box">了解更多</div></div></div><div id="side-bar_more" class="deactivated"><div class="links flex-box"><a class="wrapper" href="/javaWeb.htm">Java学科</a><a class="wrapper" href="/pythonWeb.htm">Python+<br />人工智能</a><a class="wrapper" href="/hWeb.htm">H5前端学科</a><a class="wrapper" href="/uiWeb.htm">UI设计学科</a><a class="wrapper" href="/qaWeb.htm">软件测试学科</a><a class="wrapper" href="/fsWeb.htm">全栈学科</a><a class="wrapper" href="/phpWeb.htm">PHP学科</a><a class="wrapper" href="/mediaWeb.htm">新媒体+<br>短视频运营</a></div></div></div></div>
	</body>
	<foot>
		<script src="/static/home/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/static/home/js/jquery.waypoints.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/static/home/js/sticky-kit.min.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="/static/home/js/tabsKeel-0.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="/static/home/js/header(PC)_20181022.js" type="text/javascript" charset="utf-8"></script><script src="/static/home/js/side-bar(PC)_20190515.js" type="text/javascript" charset="utf-8"></script>
		<script src="/static/home/js/imagesloaded.pkgd.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/static/home/js/2-up-vertical(PC)_20190509.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			// http://localhost/static/template/1631928249007.html
			// 获取地址栏的地址
			var address = location.href;
			// 获取字符串中最后一个斜杠之后的所有文本
			var url = address.substring(address.lastIndexOf("/")+1);
			$.post("/home/updateClickCount",{"url":url},function(data){
				$("#clickCount").text(data.clickCount);
			}, "json")
		</script>
	</foot>
</html>