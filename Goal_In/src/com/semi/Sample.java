package com.semi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
// 이름 생성기
public class Sample {  // 실행은 Ctrl + F11 후 Java Application으로!

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Random rndNumber = new Random();
		
		StringBuilder stb = new StringBuilder();
		// 회원 리스트
		// 이걸로 1000개 까지!
		for (int i = 1; i < 1001; i++) {
			// 랜덤 이름
			String rndName = randomHangulName();
			// 랜덤 날짜
			String rndDate = sdf.format(900000000000L + Math.random() * 550000000000L);  
			/*
			System.out.printf("INSERT INTO MEMBER VALUES ("+i+","
					+ " 'test"+i+"', '7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==', '%s', 'test"+i+"@example.com', '%s', '" + (i % 3 == 0  ? "M" : "F") + "', NULL, SYSDATE"
					+ ", 1, 'N');\n", rndName, rndDate);
			*/
			stb.append(String.format("INSERT INTO MEMBER VALUES ("+i+","
					+ " 'toast"+i+"', '7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==', '%s', 'test"+i+"@example.com', '%s', '" + (i % 3 == 0  ? "M" : "F") + "', NULL, SYSDATE"
					+ ", 1, 'N');\n", rndName, rndDate));
		}
		
		// 게시글 샘플
		for (int i = 1; i < 1301; i++) {
			// 랜덤 날짜
			String rndDate = sdf.format(910000000000L + Math.random() * 550000000000L);
			// 작성자 랜덤
			int writerNo = rndNumber.nextInt(1000) + 1;  // 1번부터 1000번까지 중 랜덤한 숫자
			
			stb.append(String.format("INSERT INTO BOARD VALUES ("+i+", 1, " + writerNo + ", '테스트 글입니다. " + i + "', 0, '%s', DEFAULT);\n", rndDate));
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("test.sql"))) {
			
			bw.append(stb.toString());
			
		} catch(Exception e) {
			
		}
		
	}
	
	// https://koreanname.me/ 참조
	public static String randomHangulName() {
		// 성씨 100개
		List<String> lastName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황",
				"안", "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성",
				"차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함",
				"변", "염", "양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명",
				"기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구",
				"용");
		// 이름 100개
		List<String> firstName = Arrays.asList("민준", "서준", "예준", "도윤", "주원", "시우", "지후", "지호", "하준", "준서", "준우", "현우", "지훈",
				"도현", "건우", "우진", "민재", "현준", "선우", "서진", "연우", "정우", "유준", "승현", "준혁", "승우", "지환", "승민", "시윤", "지우",
				"민성", "유찬", "준영", "진우", "시후", "은우", "지원", "윤우", "수현", "동현", "재윤", "민규", "시현", "태윤", "재원", "민우", "재민",
				"은찬", "한결", "윤호", "시원", "민찬", "성민", "수호", "성현", "준호", "승준", "현서", "재현", "시온", "지성", "태민", "태현", "민혁",
				"예성", "민호", "지안", "하율", "우빈", "성준", "지율", "정민", "규민", "윤성", "지한", "민석", "이준", "지민", "준", "준수", "서우",
				"은호", "이안", "은성", "예찬", "윤재", "율", "하람", "태양", "준희", "준성", "하진", "현수", "도훈", "승원", "정현", "지완", "건",
				"강민", "승호", "서연", "서윤", "지우", "서현", "민서", "하은", "하윤", "윤서", "지민", "지유", "채원", "지윤", "은서", "수아", "다은",
				"예은", "수빈", "예원", "지아", "소율", "지원", "예린", "소윤", "유진", "시은", "채은", "가은", "서영", "지안", "민지", "하린", "윤아",
				"예진", "수민", "유나", "수연", "연우", "예서", "시연", "예나", "주아", "연서", "서아", "현서", "다연", "다인", "하율", "아인", "서은",
				"서진", "유빈", "수현", "하연", "채윤", "서율", "예지", "유주", "지율", "시아", "서우", "나윤", "다현", "민주", "지은", "아린", "윤지",
				"나연", "시현", "예빈", "소연", "지현", "소은", "사랑", "혜원", "지수", "은채", "주하", "서하", "승아", "나은", "서희", "나현", "아윤",
				"민아", "세은", "소민", "채린", "하영", "도연", "다윤", "채아", "아영", "규리", "지연", "예림", "가윤", "세아", "태희", "민채", "유정");
		Collections.shuffle(lastName);
		Collections.shuffle(firstName);
		return lastName.get(0) + firstName.get(0);
	}
}
