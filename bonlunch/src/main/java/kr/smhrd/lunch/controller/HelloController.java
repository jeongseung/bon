package kr.smhrd.lunch.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import kr.smhrd.lunch.BonlunchApplication;
import kr.smhrd.lunch.entity.User;

// 기존 Spring -> 로직을 처리하고 결과를 반환할 때 view 이름 : String
// @controller -> 화면을 반환할 수 있는 component
// 비동기 통신, 화면이 아니라 데이터'만' 반환 받고자 할 때
// @ResponseBody 추가



@RestController// 해당 컨트롤러는 무조건 데이터만 반환하는 컨트롤러
public class HelloController {

    private final BonlunchApplication bonlunchApplication;

    HelloController(BonlunchApplication bonlunchApplication) {
        this.bonlunchApplication = bonlunchApplication;
    }

	//@PathVariable/{id}
	//url의 경로에 포함되어 전달되는 데이터를 변수에 바인딩 하기 위해서 사용
	
	//요청 매핑을 잡을 때
	//GetMapping("/goods_detail/{id}")
	//매개변수를 통해 값을 가지고 올 수 있다
	//메소드명(@Pathvariable("id") int id)
	
	
	//gods_detail/4 서버로 요청

	@GetMapping("/Hello/{id}")
	public ArrayList<User> HelloRest(@PathVariable("id") int id) {
		//데이터를 주로 JSON 객체 형태로 반환
		//data-bind -> 데이터를 map 혹은 list의 형태로 리턴
		// Json 객체 형태로 변환하여 화면(View)에 return
		
		System.out.println("전달 받은 id : " + id);
		//user -> 이름, 나이, 성별
		User user1 = new User("정승우", 29, "남자");
		User user2 = new User("정다훈", 28, "남자");
		User user3 = new User("김수연", 25, "여자");
		User user4 = new User("강윤지", 23, "여자");
		//ArrayList -> 우리 팀원의 데이터를 저장!
		ArrayList<User> userList = new ArrayList();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		//@PathVariable -> url로 넘어온 인덱스에 저장된 팀원을 데이터 형태로 전송
		//데이터 형태로 전송! 0~3까지의 숫자 중에 들어온 숫자에 따라 해당 유저 정보를 리턴
		
		
		return userList;
	}

}
