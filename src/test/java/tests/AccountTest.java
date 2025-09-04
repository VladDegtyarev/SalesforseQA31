package tests;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    @Test
    public void checkCreateAccount() throws InterruptedException {
        loginPage.open();
        loginPage.login();
        newAccountModal.open();
        newAccountModal.createAccount("Mi", "+353323", "65675", "Cold",
                "Cold", "Apparel", "ss", "Minsk", "434353",
                "High", "12", "Maybe");
        accountPage.checkAccount("Mi", "+353323");
    }
}
