<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 창</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	
	
	<!-- <div class="row" style="padding:200px;">
		<div class="card mx-auto" style="max-width: 540px;">
		  <div class="row no-gutters">
		    <div class="col-md-4">
		      <img style="width : 100%; height : 100%;" class="card-img" src="https://m.media-amazon.com/images/I/51tMKDJTKcL.jpg"/>
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		        <h5 class="card-title">제품명 : <span id="pname">장난감</span></h5>
		        <p class="card-text">가격 : <span id="price">30000</span></p>
		        <p class="card-text">수량 : <input type="number" min="1" max="10" id="quan"/></p>
		       	<button class="btn btn-primary" id="payBtn">결제하기</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div> -->
	
	<!-- team_area  -->
    <div class="team_area" style="background:white">
            <div class="container">
                    <div class="row">
                            <div class="col-xl-12">
                                <div class="section_title mb-40 text-center">
                                    <h3 style="margin-top: 100px;">
                                       	포인트 충전하기
                                    </h3>
                                    <p>To charge Point</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/coin.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(5000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>5000point 충전하기</h3>
                                        <p id="amount">5000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/coins.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(10000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>10,000point 충전하기</h3>
                                        <p id="amount">10,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/money4.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(30000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>30,000point 충전하기</h3>
                                        <p id="amount">30,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/money1.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(50000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>50,000point 충전하기</h3>
                                        <p id="amount">50,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/money2.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(100000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>100,000point 충전하기</h3>
                                        <p id="amount">100,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/money3.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(300000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>300,000point 충전하기</h3>
                                        <p id="amount">300,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/atm.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(500000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>500,000point 충전하기</h3>
                                        <p id="amount">500,000</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6">
                                <div class="single_team">
                                    <div class="team_thumb">
                                        <img src="/Goal_In/resources/img/team/money5.png" alt="">
                                        <div class="social_link">
                                                <ul>
                                                    <li>
                                                    	<button class="btn btn-primary payBtn" style="display:contents" onclick="payment(100000)">결제하기</button>
                                                    </li>
                                                </ul>
                                            </div>
                                    </div>
                                    <div class="team_info text-center">
                                        <h3>1,000,000point 충전하기</h3>
                                        <p id="amount">1,000,000</p>
                                    </div>
                                </div>
                            </div>
                        </div>
            </div>
        </div>
    <!-- /team_area  -->
	
	
	<%@ include file="/views/common/footer.jsp" %>
	<script type="text/javascript"
		src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>
		var IMP = window.IMP; // 생략가능

		$(function() {
			IMP.init('imp59359567');
		}); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		
		function payment(price){
			// 문서 로딩될 때 바로 호출
				IMP.request_pay({
					pg : 'kakao',
				    pay_method : 'card',
				    merchant_uid : 'merchant_' + new Date().getTime(),
					name : '충전금액 :' + price,
					amount : price,
					buyer_id : '<%= m.getUserid() %>',
					buyer_name : '<%= m.getUsername() %>',
					buyer_tel : '<%= m.getPhone() %>',

				}, function(rsp) {
					if (rsp.success) {
						//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
						$.ajax({
							url : "/Goal_In/pointPay.do", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
							type : 'POST',
							dataType : 'json',
							data : {
								quan : price,
								imp_uid : rsp.imp_uid,
								pay_method : rsp.pay_method,
								price : rsp.paid_amount,
								status : rsp.status,
								title : rsp.name,
								pg_tid : rsp.pg_tid,
								buyer_name : rsp.buyer_name,
								paid_at : rsp.paid_at,
								receipt_url : rsp.receipt_url
							//기타 필요한 데이터가 있으면 추가 전달
							}
						});
						location.href="/Goal_In/pInsert.po?pay_method="+rsp.pay_method
								+ /* "&amount=" + $('#amount').val() + */ "&price="+ price
								+"&date=" + new Date().format('yyyy-MM-dd HH:mm:ss') +"&price="+rsp.paid_amount;
					} else {
						var msg = '결제에 실패하였습니다.';
						msg += '\n에러내용 : ' + rsp.error_msg;
						alert(msg);
						location.href="/Goal_In/views/iamport/pay.jsp";
					}
				});
		};
		
		Date.prototype.format = function (f) {

		    if (!this.valueOf()) return " ";



		    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

		    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];

		    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

		    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

		    var d = this;



		    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {

		        switch ($1) {

		            case "yyyy": return d.getFullYear(); // 년 (4자리)

		            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)

		            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)

		            case "dd": return d.getDate().zf(2); // 일 (2자리)

		            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)

		            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)

		            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)

		            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)

		            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)

		            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)

		            case "mm": return d.getMinutes().zf(2); // 분 (2자리)

		            case "ss": return d.getSeconds().zf(2); // 초 (2자리)

		            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분

		            default: return $1;

		        }

		    });

		};

		String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };

		String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };

		Number.prototype.zf = function (len) { return this.toString().zf(len); };
	</script>
</body>
</html>