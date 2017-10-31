package com.mmskowron.loginapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by MMS on 2017-10-29.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private final String username = "MarcinSkowron";
    private final String password = "1234";
    EditText name;

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void T1_isDisplayed(){

        onView(withId(R.id.textView)).check(matches(isDisplayed()));

    }

    @Test
    public void T2_sendText() throws InterruptedException {

        onView(withId(R.id.nameEditText))
                .perform(clearText()
                        ,typeText(username)
                        ,closeSoftKeyboard());
        onView(withId(R.id.passwordEditText))
                .perform(clearText()
                        ,typeText(password)
                        ,closeSoftKeyboard());
        //name = name.findViewById(R.id.nameEditText);
        //String currentUserName = name.getText().toString();
        //Log.i("username", currentUserName);
        Log.i("username2", "aaaaaaaaaaaaa");

        onView(withText("LOG IN"))
                .check(matches(isDisplayed()))
                .perform(click());

    }
}
