1. 401 Unauthorized 해결을 위한 Security 설정
2. JPA연결
3. Entity 생성

---

1. Security Config 파일 생성

기본적인 Web 보안을 활성화 하겠다는 의미
```java
@EnableWebSecurity
```

추가적인 설정을 위해서 `WebSercurityConfugurer`를 implement 하거나
`WebSercurityConfigAdaptor`를 extends 하는 방법이 있음.

