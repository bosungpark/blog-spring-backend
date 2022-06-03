package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

//    DummyControllerTest가 메모리에 로드될 때, userRepository 역시 로딩시켜준다. -> 의존성 주입(DI)
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }

        return "삭제되었습니다. id:"+id;
    }

//    @Transactional: 더티체킹. 트랜젝션이 걸리면 함수 종료시에 자동 커밋이 된다. 즉, save 없이 update를 할 수 있게 해준다.
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id = " + id);
        System.out.println("password = " + requestUser.getPassword());
        System.out.println("email = " + requestUser.getEmail());

        User user= userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패했습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        return user;
    }

    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

//    한 페이지 당, 2건의 데이터 리턴
//    http://localhost:8000/blog/dummy/user?page=페이지 입력
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUsers= userRepository.findAll(pageable);
        List<User> users= pagingUsers.getContent();
        return users;
    }

    // {id} 주소로 파라미터를 전달 받을 수 있다.
    //@PathVariable int id
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){

//        방법1: 반환타입 수정-> Optional<User>: null값이 되면 문제가 생길 수 있다. 만약 null이라면 null을 반환한다.
//        Optional<User> user=userRepository.findById(id);

        User user=userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 사용자가 없습니다.");
            }
        });
//        요청: 웹브라우저
//        user 객체= 자바 오브젝트
//        변환(웹브라우저가 이해할 수 있는 데이터) -> json
//        스프링부트= MessageConverter가 자동작동. 자바 오브젝트 리턴 시, Jackson을 통해 json 타입으로 변환.
        return user;
    }

    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email){ //key=value 값을 받는다
    public String join(User user){
//        System.out.println("id = " + user.getId());
//        System.out.println("username = " + user.getUsername());
//        System.out.println("password = " + user.getPassword());
//        System.out.println("email = " + user.getEmail());
//        System.out.println("roll = " + user.getRole());
//        System.out.println("createDate = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
