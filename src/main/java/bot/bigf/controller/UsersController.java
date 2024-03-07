package bot.bigf.controller;

import bot.bigf.dto.User;
import bot.bigf.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${app.http.bot}")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class UsersController {

    private final UserService userService;

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> getUserList() {
        log.debug("Method - getUserList has been called");
        return userService.getUserList();
    }
}
