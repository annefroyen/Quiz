package com.example.quiz;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;



import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class AddActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dialogTest() {

        onView(withId(R.id.databaseButton)).perform(click());
        onView(withId(R.id.databaseButton)).perform(click());

        onView(withId(R.id.addButton)).perform(click());
        //onView(withId(R.id.captureButton).perform(click());


    }


}