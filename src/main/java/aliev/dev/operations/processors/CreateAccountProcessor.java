package aliev.dev.operations.processors;

import aliev.dev.account.AccountService;
import aliev.dev.operations.ConsoleOperationType;
import aliev.dev.operations.OperationCommandProcessor;
import aliev.dev.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateAccountProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final UserService userService;
    private final AccountService accountService;

    public CreateAccountProcessor(
            Scanner scanner,
            UserService userService,
            AccountService accountService
    ) {
        this.scanner = scanner;
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter the user id for which to create an account:");
        int userId = Integer.parseInt(scanner.nextLine());   //парсит со строки в интегер


        var user = userService.findUserById(userId)
                .orElseThrow(()->new IllegalArgumentException("No such user with id=%s"
                        .formatted(userId)));

        var account = accountService.createAccount(user);
        user.getAccountList().add(account);

        System.out.println("New account created with Id:%s for user:%s"
                .formatted(account.getId(), user.getLogin()));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CREATE;
    }
}
