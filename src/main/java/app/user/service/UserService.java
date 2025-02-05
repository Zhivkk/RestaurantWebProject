package app.user.service;

import app.exception.DomainException;

import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;

import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import app.web.dto.UserEditRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginRequest loginRequest) {

        Optional<User> optionUser = userRepository.findByUsername(loginRequest.getUsername());
        if (optionUser.isEmpty()) {//Ако няма такъв регистриран потребител
            throw new DomainException("Username or password are incorrect.");
        }

        User user = optionUser.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {//Сравнява паролата от ДТО с тази от базата данни
            throw new DomainException("Username or password are incorrect.");
        }

        return user;
    }

    @Transactional //Изпълняват се или всички операции в метода или нищо не се изпълнява
    public void register(RegisterRequest registerRequest) {//Чете информацията от registerRequest DTO

        Optional<User> optionUser = userRepository.findByUsername(registerRequest.getUsername());
        if (optionUser.isPresent()) { //Ако има вече потребител с този username не може да го регистрира
            throw new DomainException("Username [%s] already exist.".formatted(registerRequest.getUsername()));
        }
        //Ако няма потребител с този username може да го регистрира
        User user = userRepository.save(initializeUser(registerRequest));

        //Добавя log.info (извиква се с анотацията @Slf4j)
        log.info("Successfully create new user account for username [%s] and id [%s]".formatted(user.getUsername(), user.getId()));

    }

    public void editUserDetails(UUID userId, UserEditRequest userEditRequest) {

        User user = getById(userId);

        user.setFirstName(userEditRequest.getFirstName());
        user.setLastName(userEditRequest.getLastName());
        user.setEmail(userEditRequest.getEmail());
        user.setProfilePicture(userEditRequest.getProfilePicture());

        userRepository.save(user);
    }

    private User initializeUser(RegisterRequest registerRequest) {//Създава нов потребител на база на информацията от ДТО

        return User.builder() //Извиква се с анотацията @Builder. Конструира нов user
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))//Енкодира паролата към UUID
                .role(UserRole.USER)
                .isActive(true)
                .country(registerRequest.getCountry())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new DomainException("User with id [%s] does not exist.".formatted(id)));
    }

    public void switchStatus(UUID userId) {
        User user = getById(userId);

        // НАЧИН 1:
//        if (user.isActive()){
//            user.setActive(false);
//        } else {
//            user.setActive(true);
//        }

        // false -> true
        // true -> false
        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    public void switchRole(UUID userId) {

        User user = getById(userId);

        if (user.getRole() == UserRole.USER) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.USER);
        }

        userRepository.save(user);
    }
}
