package aliev.dev.operations.processors;

import aliev.dev.account.AccountService;
import aliev.dev.operations.ConsoleOperationType;
import aliev.dev.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountTransferProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final AccountService accountService;

    public AccountTransferProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }


    @Override
    public void processOperation() {
        System.out.println("Enter source account id:");
        int fromAccountId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter destination account id:");
        int toAccountId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter amount to transfer:");
        int amountToTransfer = Integer.parseInt(scanner.nextLine());

        accountService.transfer(fromAccountId, toAccountId, amountToTransfer);
        System.out.println(
                "Successfully transfered %s from accountId %s to accountId %s"
                .formatted(amountToTransfer, fromAccountId, toAccountId));

    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }
}
