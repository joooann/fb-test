package com.planit.jo.app.fb.models;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Creates Facebook Account Creation example test data
 */
public class AccountCreationMother {

    public AccountCreation build() {
        Faker fakeDataGenerator = new Faker();

        AccountCreation accountCreationObj = new AccountCreation();

        Calendar birthdayCal = Calendar.getInstance();
        Date birthday = fakeDataGenerator.date().birthday();
        birthdayCal.setTime(birthday);

        String[] gender = new String[]{"Female", "Male", "Custom"};

        String[] customGenderPronoun = new String[]{"She: \"Wish her a happy birthday!\"",
                "He: \"Wish him a happy birthday!\"",
                "They: \"Wish them a happy birthday!\""};

        String[] customGender = new String[]{fakeDataGenerator.lorem().word(), ""};

        accountCreationObj.setFirstName(fakeDataGenerator.name().firstName());
        accountCreationObj.setSurname(fakeDataGenerator.name().lastName());
        accountCreationObj.setEmail(fakeDataGenerator.internet().emailAddress());
        accountCreationObj.setPassword(fakeDataGenerator.internet().password());
        accountCreationObj.setBirthDay(Integer.toString(birthdayCal.get(Calendar.DAY_OF_MONTH)));
        accountCreationObj.setBirthMonth((new SimpleDateFormat("MMM")).format(birthday));
        accountCreationObj.setBirthYear(Integer.toString(birthdayCal.get(Calendar.YEAR)));
        accountCreationObj.setGender(fakeDataGenerator.options().nextElement(gender));
        accountCreationObj.setCustomGenderPronoun(fakeDataGenerator.options().nextElement(customGenderPronoun));
        accountCreationObj.setCustomGender(fakeDataGenerator.options().nextElement(customGender));

        return accountCreationObj;
    }
}
