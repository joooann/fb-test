package com.planit.jo.app.fb.pages;

import com.planit.jo.app.fb.models.AccountCreation;
import com.planit.jo.app.fb.pageobjects.SignUpPageObject;
import com.planit.jo.framework.webutil.BrowserManager;
import com.planit.jo.framework.webutil.WebDriverActions;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationFlow {

    private SignUpPageObject signUpPageObject;
    private BrowserManager browserManager;
    private AccountCreation accountCreation;

    public AccountCreationFlow(BrowserManager browserManager, AccountCreation accountCreation) {
        this.signUpPageObject = new SignUpPageObject(browserManager);
        this.browserManager = browserManager;
        this.accountCreation = accountCreation;
    }

    public void userFillsUpSignUpForm() {
        if (accountCreation.getFirstName() != null)
            signUpPageObject.txtFirstName.sendKeys(accountCreation.getFirstName());

        if (accountCreation.getSurname() != null)
            signUpPageObject.txtSurname.sendKeys(accountCreation.getSurname());

        if (accountCreation.getEmail() != null) {
            signUpPageObject.txtEmail.sendKeys(accountCreation.getEmail());
            signUpPageObject.txtReEnterEmail.sendKeys(accountCreation.getEmail());
        }

        if (accountCreation.getPassword() != null)
            signUpPageObject.txtPassword.sendKeys(accountCreation.getPassword());

        if (accountCreation.getBirthDay() != null)
            new Select(signUpPageObject.cmbBirthDay).selectByVisibleText(accountCreation.getBirthDay());

        if (accountCreation.getBirthMonth() != null)
            new Select(signUpPageObject.cmbBirthMonth).selectByVisibleText(accountCreation.getBirthMonth());

        if (accountCreation.getBirthYear() != null)
            new Select(signUpPageObject.cmbBirthYear).selectByVisibleText(accountCreation.getBirthYear());


        if (accountCreation.getGender() != null && accountCreation.getGender().equals("Female")) {
            signUpPageObject.rdbFemale.click();
        } else if (accountCreation.getGender().equals("Male")) {
            signUpPageObject.rdbMale.click();
        } else if (accountCreation.getGender().equals("Custom")) {
            signUpPageObject.rdbCustom.click();
            new Select(signUpPageObject.cmbCustomGenderPronoun).selectByVisibleText(accountCreation.getCustomGenderPronoun());
            signUpPageObject.txtCustomGender.sendKeys(accountCreation.getCustomGender());
        }
    }

    public void userSubmitsForm() {
        signUpPageObject.btnSignUp.click();
    }

    public boolean nextPageShouldVerifyAccount() {
        return new WebDriverActions().pageShouldContainText(browserManager.getDriver(),
                "Let us know that this email address belongs to you. Enter the code from the email sent to " + accountCreation.getEmail() + ".");
    }

}
