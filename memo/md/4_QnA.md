# record SpringRequest가 생성되는 시점은 언젤까?
- Controller에 @RequiredArgsConstructor 이므로 Controller 생성 시점과 같을까?
  - 이게 정답이라고 생각함 또한
    - record 2개가 있었고 2개마다 생성되고 이용되는 용도가 달라서 헷갈렸음.

  
# Service레이어와 Repository를 왜 자꾸 인터페이스로 한번 감싸는 걸까?
  - SignUp은 서비스라고 하기엔 @Service가 안 붙었는데도 Service라고 할 수 있는걸까? 그냥 로직을 처리하는 레이어라고 하면 되는걸까?
    - 근데 Service Layer가 로직을 처리하는 Layer가 아닌가?
  - UserRepository가 Service Layer고 UserJpaRepository가 Persistence Layer가 되는거 같다!

UserController > 

signUp.signUp(SignupRequest request) >

**_SignUpUsecase (interface)_** >

**_signUp(SignupRequest request) (override)_** >

repository.signUp(UserRepository.format(request.username, request.nickname, request.password)) >

**_UserRepository (interface)_** >

**_signUp(SignupRequest request) (override)_** >

save()


# SignUp Interface 에서 왜 SignupRequest 를 한번 더 만드는 걸까?

```java
@Override
public User signUp(SignupRequest request){
    return  repository.signUp(UserRepository.format(request.username, request.nickname, request.password));
}
```

# SignUp에도 record SignupRequest가 하나 있고 UserRepository에도 record SignupRequest가 있다. 왜 굳이 2개여야 할까?
- class 마다 record를 만들 경우
  - 아래처럼 data를 직접 가져다 쓰는게 가능
  - String str = request.username;
- 하나의 record로 만들었을 경우 
  - getter 메소드를 통해서만 data에 접근이 가능
    - 아래처럼 메소드 명만 username이지 사실 getUsername 과 다를게 없음 
      - `request.username()`
      - 근게 그게 문제가 있나..? getter를 사용하고 싶지 않았던 걸까 주니님은?

  

# JPA를 자꾸 안 좋다고 말했는데 왤까?
- JPA를 사용 해야하는 이유
  - 객체 지향 모델과 RDBMS 간의 연결성이 좋음
    - 객체가 곧 RDBMS에 바로 들어가니까?
- JPA가 별로인 이유

