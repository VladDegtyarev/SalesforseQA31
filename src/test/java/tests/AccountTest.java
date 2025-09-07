package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    @Test
    public void checkCreateAccount() throws InterruptedException {
        Account accountGenerate= AccountFactory.getAccount("Warm","Apparel","High","Maybe");

        Account accountBuilder= Account.builder()
                .name("test")
                .fax("1323")
                .city("Minsk")
                .phone("324343")
                .street("ss")
                .rating("Cold")
                .zipCode("13435").build();

        Account account = new Account("test", "+353323", "65675", "Cold",
                "Cold", "Apparel", "ss", "Minsk", "434353",
                "High", "12", "Maybe");
        loginPage.open()
                .isPageOpen()
                .login("tborodich@tms.sandbox","Password003!")
                .isPageOpen();
        accountListPage.open()
                .clickNew()
                .open()
                .isPageOpen()
                .createAccount(account)
                .saveAccount()
                .checkAccount("Mi", "+353323");

        /*loginPage.open();
        loginPage.login();
        newAccountModal.open();
        newAccountModal.createAccount("Mi", "+353323", "65675", "Cold",
                "Cold", "Apparel", "ss", "Minsk", "434353",
                "High", "12", "Maybe");
        accountPage.checkAccount("Mi", "+353323");*/
    }
}
