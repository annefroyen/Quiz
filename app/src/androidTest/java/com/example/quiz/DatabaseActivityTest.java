package com.example.quiz;

import android.support.test.filters.LargeTest;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class DatabaseActivityTest {

    @Rule
    public ActivityTestRule<DatabaseActivity> mActivityRule = new ActivityTestRule<>(DatabaseActivity.class);


    @Test
    public void deleteTest() {
        DatabaseActivity activity  =  mActivityRule.getActivity();
        String size = activity.getTheSize();
        int s = Integer.parseInt(size);
        int newSize = s-1;
        String newS = Integer.toString(newSize);

        //delete person
        onView(withId(R.id.deleteButton)).perform(click());

        //make sure the number of registered people are correct
        onView(withId(R.id.number)).check(matches(hasValueEqualTo(newS)));

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