<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="/views/common/header.jsp" %>
    
    <!-- bradcam_area  -->
     <div class="bradcam_area bradcam_bg_2">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="bradcam_text text-center">
                            <h3>How to Contact Us</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/ bradcam_area  -->
  <!-- ================ contact section start ================= -->
  <section class="contact-section section_padding">
    <div class="container">
      <div class="d-none d-sm-block mb-5 pb-4">
        <div id="map" style="height: 480px;"></div>
        <script>
          function initMap() {
            var uluru = {lat: -25.363, lng: 131.044};
            var grayStyles = [
              {
                featureType: "all",
                stylers: [
                  { saturation: -90 },
                  { lightness: 50 }
                ]
              },
              {elementType: 'labels.text.fill', stylers: [{color: '#ccdee9'}]}
            ];
            var map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: -31.197, lng: 150.744},
              zoom: 9,
              styles: grayStyles,
              scrollwheel:  false
            });
          }
          
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDpfS1oRGreGSBU5HHjMmQ3o5NLw7VdJ6I&callback=initMap"></script>
        
      </div>


      <div class="row">
        <div class="col-lg-8">
            <div class="col-8">
                <h2 class="contact-title">찾아오시는 길</h2>
            </div>
          <form class="form-contact contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
            <div class="row">
              <div class="col-8">
                <div class="form-group">
                    <p>
                        상단의 지도는 KH정보교육원 강남 1관으로,
                        <br>
                        하단에 찾아 오시는 길을 안내해드리도록 하겠습니다.
                    </p>   
                </div>
              </div>
              <table class="table table-striped table-hover">
                  <tr>
                    <td>주소</td>
                    <td>서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F, 3F, 4F(T: 1544-9970 / F: 070-8290-2889)</td>
                  </tr>
                  <tr>
                    <td>버스</td>
                    <td>
                        역삼역.포스코P&S타워 정류장
                        <br>
                        지선 146 / 740 / 341 / 360   &  간선 1100 / 1700 / 2000 / 7007 / 8001
                    </td>
                  </tr>
                  <tr>
                    <td>지하철</td>
                    <td>지하철 2호선 역삼역 3번출구 100m</td>
                  </tr>
              </table>
              <img src="/Goal_In/resources/img/company.jpg">
              <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th colspan="2"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>교육시설</td>
                            <td>강의실 / 프로젝트룸 / 세미나실 <br>  
                                상담실 / 취업상담실</td>
                        </tr>
                    <tr>
                        <td>기타시설</td>
                            <td>
                                휴게실 / 행정시설지원(FAX, 프린트, Scan)
                        </td>
                    </tr>
                    <tr>
                        <td>2F</td>
                        <td>강의실(A,B,C) / 인포데스크 / 교원연구실 / 취업지원센터 / 교육개발본부</td>
                    </tr>
                    <tr>
                        <td>3F</td>
                        <td>강의실(G,H,I) / 원장실 / 경영지원사업본부 / 프로젝트룸</td>
                    </tr>
                    <tr>
                        <td>4F</td>
                        <td>강의실(Q,R,S) / 회의실 / 입학상담실</td>
                    </tr>
                </tbody>
            </table>
          </form>
        </div>
      </div>




        <div class="col-lg-4">
          <div class="sidebar">
            <div class="widget_info">
                <div class="dividerHeading">
                    <h4>
                        <span>
                            사이트 관리자 연락처
                        </span>
                    </h4>
                </div>
            </div>
          </div>
          <p>
            만약 사이트에 오류가 있을 경우, 
            이쪽으로 연락 주신다면 말씀하시는 사항에 대해 신속하게 대처해 드리겠습니다. 
            항상 좋은 하루 되시기 바랍니다. 감사합니다.
          </p>
          <br />
          <ul class="widget_info_contact">
            <li>
                
                <p style="font-size: 15px;">
                <i class="fa fa-map-marker"></i>&nbsp;&nbsp;
                    <strong style="font-weight: bold;">Address : </strong><br />
                    서울 강남구 테헤란로 14길 6 남도빌딩 2F  
                </p>
                <br />
            </li>
            <li>
                <p>
                <i class="fa fa-user"></i>&nbsp;&nbsp;
                    <strong style="font-weight:bold">Phone</strong>
                    : <br />
                    T) 1544-9970<br>
                    F) 070-8290-2889
                </p>
                <br />
            </li>
            <li>
                
                <p>
                <i class="fa fa-envelope"></i>&nbsp;&nbsp;
                    <strong style="font-weight:bold">Email</strong>
                    : 
                    <br>
                    jeonghunY@gmail.com
                </p>
                <br />
            </li>
            <li>
                
                <p>
                <i class="fa fa-globe"></i>&nbsp;
                    <strong style="font-weight:bold">Web</strong>
                    : 
                    <br>
                    <a href="https://www.iei.or.kr/main/main.kh" 
                    data-placement="bottom" data-toggle="tooltip" 
                    title="" data-original-title="https://www.iei.or.kr/main/main.kh">
                    https://www.iei.or.kr/main/main.kh</a>
                    
                </p>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>
  <!-- ================ contact section end ================= -->
    
    <%@ include file="/views/common/footer.jsp" %>