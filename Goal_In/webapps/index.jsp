<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="views/common/header.jsp" %>

    <%@ include file="views/common/searchBar.jsp" %>
    
    <!-- slider_area_end -->



    <div class="explorer_europe"></div>
    
    <div class="popular_catagory_area">
        <div class="container-fluid" style="padding-right: 0px; padding-left: 0px;">
            <div class="row">
                
                <div class="col-xl-12">
                    <div class="section_title mb-60 text-center">
                        <p>Top 10</p>
                        <h3 style="padding-bottom: 0px;">
                            Most Popular Goal-In
                        </h3>
                        <a style="color: black;">가장 인기 있는 Top 10</a>
                    </div>
                </div>
            </div>
            <!-- Swiper -->
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">

                    <div class="swiper-container">
                            <div class="swiper-wrapper">
                                <!-- 원본
                                <div class="swiper-slide">
                                    <div class="single_catagory">
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/img/newGoal/hometraining.jpg" alt="">
                                        </div>
                                        <div class="hover_overlay">
                                            <div class="hover_inner">
                                                    <a href="Listings.html"><h4>하루 1시간 홈트레이닝</h4></a>
                                                <span>205 starters</span>
                                            </div>
                                        </div>
                                    </div> 
                                </div> -->
                        	</div>      
                        <div class="swiper-button-next"></div>
                        <div class="swiper-button-prev"></div>
                    </div>
                </div>
              <div class="col-1"></div>
            </div>
         </div>
      </div>
            
    <div class="explorer_europe"></div>
    <div class="explorer_europe"></div>

	<script>
		// top-N 분석
		$(function() { // 즉석 실행 함수
			$.ajax({
				url : '/Goal_In/top10.do',
				type : 'get',
				success : function(list) {
					// console.log(list);
					
					var $swiper_con = $('.swiper-container>.swiper-wrapper')[0];
					
					for(var i in list) {
						var html = 	
				                        '<div class="swiper-slide">' +
				                        '<div class="single_catagory">' +
				                            '<div class="thumb">' +
				                                '<img src="/Goal_In/resources/enrollFiles/' + list[i].gimg + '" alt="">' +
				                            '</div>' +
				                            '<div class="hover_overlay">' +
				                                '<div class="hover_inner">' +
				                                        '<a href="/Goal_In/gsol.go?gno=' + list[i].gno + '"><h4>' + list[i].goalname + '</h4></a>' +
				                                    '<span>' + list[i].startdate + '~'+ list[i].enddate + '</span>' +
				                                '</div>' +
				                            '</div>' +
				                        '</div>'+
				                    '</div>' +
				            	'</div>';				            	
            			$swiper_con.append($(html)[0]);
					}
					
					swiper = new Swiper('.swiper-container', {
				        slidesPerView: 5,
				        direction: getDirection(),
				        effect: 'coverflow',
				        centeredSlides: true,
				        slidesPerView: 'auto',
				        autoplay: {
				            delay: 2500,
				            disableOnInteraction: false,
				        },
				        navigation: {
				            nextEl: '.swiper-button-next',
				            prevEl: '.swiper-button-prev',
				        },
				        on: {
				            resize: function () {
				            swiper.changeDirection(getDirection());
				            }
				        }
				        });

				        function getDirection() {
				        var windowWidth = window.innerWidth;
				        var direction = window.innerWidth <= 760 ? 'vertical' : 'horizontal';

				        return direction;
				    }
				        
				}, error : function() {
					alert("게시글 top 10 조회 실패");
				}
			});
		});
		
	</script>



    <div class="explorer_europe">
        <div class="container">
            <div class="explorer_wrap">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-md-4">
                        <h3>New Goal-In</h3>
                        <a>신규 업데이트 Goal-In</a>
                    </div>
                    <div class="col-xl-6 col-md-8">
                        <div class="explorer_tab">
                            <nav>
                                <div class="nav" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab"
                                        href="생활습관" role="tab" aria-controls="nav-home"
                                        aria-selected="true">생활습관</a>
                                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
                                        href="식단" role="tab" aria-controls="nav-profile"
                                        aria-selected="false">식단</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
                                        href="유산소" role="tab" aria-controls="nav-contact"
                                        aria-selected="false">유산소</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab2" data-toggle="tab"
                                        href="웨이트" role="tab" aria-controls="nav-contact"
                                        aria-selected="false">웨이트</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab3" data-toggle="tab"
                                        href="스트레칭" role="tab" aria-controls="nav-contact"
                                        aria-selected="false">스트레칭</a>
                                </div>
                            </nav>

                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <div class="row">
                        
                    </div>
                </div>
              </div>
            </div>
        </div>
	<script>
	    $(function() { // 즉석 실행 함수
	    	$.ajax({
				url : '/Goal_In/selectList.go',
				type : 'get',
				data : { gcategory : '생활습관' },
				success : function(list) {
					console.log(list);
					
					var $tab_content = $('.tab-content>.tab-pane.fade.show.active>.row')[0];
					
					for(var i in list) {
						var html = '<div class="col-xl-3 col-lg-3 col-md-4">' + 
			                       '<div class="single_explorer">' + 
			                       '<div class="thumb">' + 
			                           '<img src="/Goal_In/resources/enrollFiles/' + list[i].gimg + '" alt="">' + 
			                       '</div>' + 
			                       '<div class="explorer_bottom d-flex">' + 
			                           '<div class="explorer_info">' + 
			                               '<h3><img src="/Goal_In/resources/img/newGoal/tick1.png" alt="">' + 
			                                   '<a href="/Goal_In//gsol.go?gno=' + list[i].gno + '">' + list[i].goalname + '</a>' + 
			                               '</h3>' + 
			                               '<img src="/Goal_In/resources/img/newGoal/money.png" alt=""> ' + list[i].gspoint + 
			                               '<ul>' + 
			                                   '<li> <img src="/Goal_In/resources/img/newGoal/calendar1.png" alt="">' + 
			                                   		list[i].startdate + '~'+ list[i].enddate + '</li>' + 
			                                   '<li><img src="/Goal_In/resources/img/newGoal/avatar.png" alt="">'+ list[i].gcurrnum + '</li>' + 
			                               '</ul>' + 
			                          '</div>' + 
			                       '</div>' + 
			                   '</div>' + 
			               '</div>';
			               console.log($('.tab-content>.tab-pane fade show active>.row')[0]);
	        			$tab_content.append($(html)[0]);
					}
				}
			});
	    
	    	$('.nav-item.nav-link').on('click', function(){
	    		$.ajax({
					url : '/Goal_In/selectList.go',
					type : 'get',
					data : { gcategory : $(this).attr('href') },
					success : function(list) {
						console.log(list);
						
						var $tab_content = $('.tab-content>.tab-pane.fade.show.active>.row')[0];
						$($tab_content).empty();
						
						for(var i in list) {
							var html = '<div class="col-xl-3 col-lg-3 col-md-4">' + 
				                       '<div class="single_explorer">' + 
				                       '<div class="thumb">' + 
				                           '<img src="/Goal_In/resources/enrollFiles/' + list[i].gimg + '" alt="">' + 
				                       '</div>' + 
				                       '<div class="explorer_bottom d-flex">' + 
				                           '<div class="explorer_info">' + 
				                               '<h3><img src="/Goal_In/resources/img/newGoal/tick1.png" alt="">' + 
				                                   '<a href="/Goal_In//gsol.go?gno=' + list[i].gno + '">' + list[i].goalname + '</a>' + 
				                               '</h3>' + 
				                               '<img src="/Goal_In/resources/img/newGoal/money.png" alt=""> ' + list[i].gspoint + 
				                               '<ul>' + 
				                                   '<li> <img src="/Goal_In/resources/img/newGoal/calendar1.png" alt="">' + 
				                                   		list[i].startdate + '~'+ list[i].enddate + '</li>' + 
				                                   '<li><img src="/Goal_In/resources/img/newGoal/avatar.png" alt="">'+ list[i].gcurrnum + '</li>' + 
				                               '</ul>' + 
				                          '</div>' + 
				                       '</div>' + 
				                   '</div>' + 
				               '</div>';
				               console.log($('.tab-content>.tab-pane fade show active>.row')[0]);
		        			$tab_content.append($(html)[0]);
						}
					}
				});
	    	});
	    });
    </script>


    <!-- sprayed_area  -->
    <div class="sprayed_area overlay" style="padding-top:120px; padding-bottom:120px;">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="text text-center">
                        <h3>Let's start Goal-In with Us </h3>
                        <p>꿈을 품고 뭔가 할 수 있다면 사소한 성공부터 시작하라.<br> 성공에 익숙해지면 무슨 목표이든 할 수 있다는 자신감이 생긴다.</p>
                        <%if ( m == null ) { %>
                        <a href=href="void(0);" onclick="alert('회원전용 서비스입니다.');return false" class="boxed-btn2">Add Your Goal</a>
                        <%}else{ %>
                        <a href="/Goal_In/views/goal/goalEnroll.jsp" class="boxed-btn2">Add Your Goal</a>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ sprayed_area end  -->

    <!-- testimonial_area  -->
    <div class="testimonial_area  ">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title mb-60 text-center">
                        <p>Reviews</p>
                        <h3 style="padding-bottom: 0px;">
                            What our Mates Says
                        </h3>
                        <a>실제 도전자들의 후기</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <div class="testmonial_active owl-carousel">
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p>작심 3일로 끝나던 운동계획을 
				                                      계속 유지할 수 있도록 도와준 Goal-In!! <br>
				                                      덕분에 올 여름은 비키니 도전합니다 ㅎㅂㅎ)/
				                                      제 다이어트도 골인입니다!!</p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/gal.PNG" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">조성아</h3>
                                    <!-- <span>비정상 1</span> -->
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p>역시 의지는 돈으로 사는게 제 맛이죠!</p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/pow.png" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">안예진</h3>
                                    <!-- <span>비정상 2</span> -->
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p>
				                                    오!! 너무 유익한 페이지네요 <br> 
				                                    강제적인 동기 부여로 자신이 정한 목표에 좀 더 쉽게 도달할 수 있게 해줍니다. <br> 
				                                    많은 사람들이 이용했으면 좋겠네요 번창하세요!
                                </p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/soon.PNG" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">황창현</h3>
                                    <!-- <span>비정상 3</span> -->
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p> 
				                                    매년 생각만하고 실행에 옮기는데 어려움이있었는데 <br> 
				                                    이 사이트를 만나고 보다 즐겁게 도전하는 제모습을 보고 많이 달라졌다고 느꼈습니다.
                                </p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/cho.png" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">조은성</h3>
                                    <!-- <span>노예 1</span> -->
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p>이 골인을 사용하므로써 어느정도 저의 생활습관을 고칠 수 있었고 <br />
                                	그 목표를 달성했을 때의 성취감은 이루 다 말할 수 없습니다. <br />
                                	다른 분들도 어서 시작해보세요. 소소한 행복이 생깁니다.</p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/kwan.png" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">조현민</h3>
                                    <!-- <span>유일한 정상</span> -->
                                </div>
                            </div>
                        </div>
                        <div class="single_carousel">
                            <div class="single_testmonial text-center">
                                <div class="quote">
                                    <img src="/Goal_In/resources/img/svg_icon/quote.svg" alt="">
                                </div>
                                <p>저같이 의지박약인 사람에게는 골인이 도움이 많이됩니다. <br />
                                	골 100개 해보는게 목표에요.</p>
                                <div class="testmonial_author">
                                    <div class="thumb" style="margin-left: 529px;">
                                        <img src="/Goal_In/resources/img/bee.png" alt="">
                                    </div>
                                    <h3 style="margin-top: 30px;">황하용</h3>
                                    <!-- <span>노예 3</span> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /testimonial_area  -->

	<%@ include file="views/common/footer.jsp" %>
