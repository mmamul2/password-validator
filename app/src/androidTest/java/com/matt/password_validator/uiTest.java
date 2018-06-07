package com.matt.password_validator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class uiTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void nullTest(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("No password entered")));
    }

    @Test
    public void strongTest(){
        onView(withId(R.id.password)).perform(typeText("123ABCefg$$$"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Strong")));
    }

    @Test
    public void passOneTest(){
        onView(withId(R.id.password)).perform(typeText("abc"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Very Weak")));
    }

    @Test
    public void passTwoTest(){
        onView(withId(R.id.password)).perform(typeText("abcdefghi"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Weak")));
    }

    @Test
    public void passThreeTest(){
        onView(withId(R.id.password)).perform(typeText("abCdefghi"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Not Strong")));
    }

    @Test
    public void passFourTest(){
        onView(withId(R.id.password)).perform(typeText("abCEefghi123"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Not Strong")));
    }
}
