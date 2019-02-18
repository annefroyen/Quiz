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

import androidx.test.espresso.Espresso;


import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    public ActivityTestRule<DatabaseActivity> dActivityRule = new ActivityTestRule<>(DatabaseActivity.class);


    @Test
    public void addTest() {
/*
         DatabaseActivity activity  =  dActivityRule.getActivity();
         String size = activity.getTheSize();
         int s = Integer.parseInt(size);
         int newSize = s+1;
         String newS = Integer.toString(newSize);

         */
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.editName)).perform((typeText("New Person")));
        onView(withId(R.id.captureButton)).perform(click());

        onView(withId(R.id.saveButton)).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.databaseButton)).perform(click());
        onView(withId(R.id.number));

        onView(withId(R.id.number)).check(matches(hasValueEqualTo("2")));

    }


    //can only be run first time opening the app
    @Test
    public void dialogTest() {
        onView(withId(R.id.ownerDialog)).perform((typeText("Bill Gates")));

        //doesn't work :(
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Preferences")).perform(click());

        onView(withId(R.id.owner)).check(matches(hasValueEqualTo("Bill Gates")));
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

