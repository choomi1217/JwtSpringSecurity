package jwt.security.study.user;

import jwt.security.study.user.repository.User;
import jwt.security.study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

public interface SignUp{
    User signUp(SignUpUsecase.SignupRequest request);

    @RequiredArgsConstructor
    class SignUpUsecase implements SignUp {

        private final UserRepository repository;

        @Override
        public User signUp(SignupRequest request){
            return  repository.signUp(UserRepository.format(request.username, request.nickname, request.password));
        }

        public record SignupRequest(String username, String nickname, String password){
            public SignupRequest{
                if(username.length() > 50 || nickname.length() > 100 || password.length() > 50){
                    throw new IllegalArgumentException("확인");
                }
            }
        }
    }


}

