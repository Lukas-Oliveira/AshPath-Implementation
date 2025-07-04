package com.pdsc.ashpath.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pdsc.ashpath.selenium.utils.FormErrors;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginNecrotomist_EmailField() {
        loginPage.setEmail("1");
        loginPage.isEmailMsgPresent(FormErrors.EMAIL_INVALID_MSG);

        loginPage.setEmail("franz@gmail.com");
        loginPage.isEmailMsgHidden();
    }

    @Test
    void loginNecrotomist_PasswordField() {
        loginPage.setPassword("1");
        loginPage.isPasswordMsgPresent(FormErrors.PASSWORD_MIN_LENGTH_MSG);

        loginPage.setPassword("invalidpwd");
        loginPage.isPasswordMsgPresent(FormErrors.PASSWORD_PATTERN_MSG);

        loginPage.setPassword(validPwd);
        loginPage.isPasswordMsgHidden();
    }

    @Test
    public void loginNecrotomist_Success() {
        var homePage = loginPage
                .logIntoApp("helmuth@yahoo.com", validPwd);

        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void loginNecrotomist_Error() {
        loginPage.logIntoApp("helmuth@yahoo.com", invalidPwd);

        Assert.assertTrue(loginPage.isErrorMsgPresent(FormErrors.UNAUTHORIZED_MSG));
    }

    @Test
    public void loginAdmin_Success() {
        var homePage = loginPage
                .logIntoApp("mohg.silva@gmail.com", validPwd);

        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void loginAdmin_Error() {
        loginPage
                .logIntoApp("mohg.silva@gmail.com", invalidPwd);

        Assert.assertTrue(loginPage.isErrorMsgPresent(FormErrors.UNAUTHORIZED_MSG));
    }

    @Test
    public void loginViewer_Success() {
        var homePage = loginPage
                .logIntoApp("jakubfarobek@yahoo.com", validPwd);

        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void loginViewer_Error() {
        loginPage
                .logIntoApp("jakubfarobek@yahoo.com", invalidPwd);

        Assert.assertTrue(loginPage.isErrorMsgPresent(FormErrors.UNAUTHORIZED_MSG));
    }

    @Test
    public void loginPendingAccount_Error() {
        loginPage
                .logIntoApp("bayle@yahoo.com", validPwd);

        Assert.assertTrue(loginPage.isErrorMsgPresent(FormErrors.PENDING_APPROVAL_MSG));
    }
}
