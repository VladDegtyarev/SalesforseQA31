package steps;

import dto.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.AccountPage;
import pages.NewAccountModal;

public class AccountStep {
    AccountListPage accountListPage;
    NewAccountModal newAccountModal;
    AccountPage accountPage;

    public AccountStep(WebDriver driver){
        accountListPage= new AccountListPage(driver);
        accountPage= new AccountPage(driver);
        newAccountModal= new NewAccountModal(driver);
    }

    public void createAccount(Account account){
        accountListPage.open()
                .clickNew()
                .isPageOpen()
                .createAccount(account)
                .saveAccount()
                .checkAccount("","");
    }
}
