package aliev.dev.operations.processors;

import aliev.dev.operations.ConsoleOperationType;
import aliev.dev.operations.OperationCommandProcessor;
import aliev.dev.user.User;
import aliev.dev.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowAllUsersProcessor implements OperationCommandProcessor {

    private final UserService userService;

    public ShowAllUsersProcessor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        List<User> users = userService.getAllUsers();
        System.out.println("List of all users:");
        users.forEach(System.out::println); //( user-> sout(user) )
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.SHOW_ALL_USERS;
    }
}
