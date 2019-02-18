package com.example.quiz;

import android.app.Activity;
import android.content.Context;
import android.support.test.filters.LargeTest;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.quiz.Database.App;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class QuizActivityTest {

    @Rule
    public ActivityTestRule<QuizActivity> mActivityRule = new ActivityTestRule<>(QuizActivity.class);

    @Test
    public void correctAnswerTest() throws InterruptedException {
        QuizActivity activity  =  mActivityRule.getActivity();
        String correct =   activity.getCorrect_answer();
        onView(withId(R.id.et_answer)).perform((typeText(correct))).perform(closeSoftKeyboard());
        Thread.sleep(250);
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.tv_score)).check(matches(hasValueEqualTo("1/1")));
    }

    @Test
    public void incorrectAnswerTest() throws InterruptedException {
        onView(withId(R.id.et_answer)).perform((typeText("incorrect"))).perform(closeSoftKeyboard());
        Thread.sleep(250);
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.tv_score)).check(matches(hasValueEqualTo("0/1")));
    }

    Matcher<View> hasValueEqualTo(final String content) {

        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(org.hamcrest.Description description) {

            }


            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextView) && !(view instanceof EditText)) {
                    return false;
                }
                if (view != null) {
                    String text;
                    if (view instanceof TextView) {
                        text = ((TextView) view).getText().toString();
                    } else {
                        text = ((EditText) view).getText().toString();
                    }
                    return (text.equalsIgnoreCase(content));
                }
                return false;
            }
        };
    }



}