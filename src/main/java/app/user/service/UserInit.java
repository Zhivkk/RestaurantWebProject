package app.user.service;

import app.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements CommandLineRunner { //Изпълнява действие, веднага след запускането на приложението

    private final UserService userService;

    @Autowired
    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!userService.getAllUsers().isEmpty()) { //Проверява да ли съществува някакъв потребител
           return;
        }

        RegisterRequest registerRequest = RegisterRequest.builder()
                //Ако няма никакъв потребител, създава един за целите на тестовете на приложението
                .username("Vik123")
                .password("123123")
                .build();

        userService.register(registerRequest);
    }
}
