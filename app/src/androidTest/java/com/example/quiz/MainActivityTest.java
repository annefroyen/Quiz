package com.example.quiz;

import android.support.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dialogTest() {
        onView(withId(R.id.ownerDialog)).perform((typeText("Bill Gates")));
        onView(withId(R.id.databaseButton)).perform(click());
    }

    @Test
    public void addButtonTest(){
        onView(withId(R.id.addButton)).perform(click());
    }

    @Test
    public void quizButtonTest(){
        onView(withId(R.id.quizButton)).perform(click());
    }

    @Test
    public void databaseButtonTest(){
        onView(withId(R.id.databaseButton)).perform(click());
    }


}