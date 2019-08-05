package com.planit.jo.app.fb.suites;

import com.planit.jo.app.fb.models.AccountCreation;
import com.planit.jo.app.fb.models.AccountCreationMother;
import com.planit.jo.app.fb.pages.AccountCreationFlow;
import com.planit.jo.framework.webutil.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest extends BaseTest {

    private AccountCreationFlow accountCreationFlow;
    private AccountCreation accountCreation;

    @BeforeMethod
    public void beforeSuite() {
        accountCreation = new AccountCreationMother().build(); // Randomly generate ALL values
        accountCreationFlow = new AccountCreationFlow(getBrowserManager(), accountCreation);
    }

    @Test
    public void completingSignUpFormCreatesAccount() {
        accountCreationFlow.userFillsUpSignUpForm();
        accountCreationFlow.userSubmitsForm();

        assertThat(accountCreationFlow.nextPageShouldVerifyAccount()).isEqualTo(true);
    }
}
