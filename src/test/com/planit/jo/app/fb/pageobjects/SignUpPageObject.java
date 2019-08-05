package com.planit.jo.app.fb.pageobjects;

import com.planit.jo.framework.webutil.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObject {

    @FindBy(name = "firstname")
    @CacheLookup
    public WebElement txtFirstName;

    @FindBy(name = "lastname")
    @CacheLookup
    public WebElement txtSurname;

    @FindBy(name = "reg_email__")
    @CacheLookup
    public WebElement txtEmail;

    @FindBy(name = "websubmit")
    @CacheLookup
    public WebElement btnSignUp;

    @FindBy(name = "reg_email_confirmation__")
    @CacheLookup
    public WebElement txtReEnterEmail;

    @FindBy(name = "reg_passwd__")
    @CacheLookup
    public WebElement txtPassword;

    @FindBy(name = "birthday_day")
    @CacheLookup
    public WebElement cmbBirthDay;

    @FindBy(name = "birthday_month")
    @CacheLookup
    public WebElement cmbBirthMonth;

    @FindBy(name = "birthday_year")
    @CacheLookup
    public WebElement cmbBirthYear;

    @FindBy(xpath = "//input[@name='sex']")
    @CacheLookup
    public WebElement rdbGender;

    @FindBy(xpath = "//label[contains(text(),'Female')]/preceding-sibling::input[@name='sex']")
    @CacheLookup
    public WebElement rdbFemale;

    @FindBy(xpath = "//label[contains(text(),'Male')]/preceding-sibling::input[@name='sex']")
    @CacheLookup
    public WebElement rdbMale;

    @FindBy(xpath = "//label[contains(text(),'Custom')]/preceding-sibling::input[@name='sex']")
    @CacheLookup
    public WebElement rdbCustom;

    @FindBy(name = "preferred_pronoun")
    @CacheLookup
    public WebElement cmbCustomGenderPronoun;

    @FindBy(name = "custom_gender")
    @CacheLookup
    public WebElement txtCustomGender;

    public SignUpPageObject(BrowserManager browserManager) {
        PageFactory.initElements(browserManager.getDriver(), this);
    }

}
