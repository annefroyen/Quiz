package com.example.quiz;

import android.support.test.filters.LargeTest;

import com.example.quiz.Database.App;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class AddActivityTest {

    @Rule
    public ActivityTestRule<AddActivity> mActivityRule = new ActivityTestRule<>(AddActivity.class);

    @Test
    public void addTest() {

        List<Person> list = (App)mMockContext.getOurDAO().getAll();

        //add Person
        onView(withId(R.id.editName)).perform((typeText("New Person")));
        onView(withId(R.id.captureButton)).perform(click());
        //get image from gallery
        onView(withId(R.id.saveButton)).perform(click());

        //make sure the person is in the database
        Person n = ((App)mMockContext).getOurDAO().findByName(newPerson);
        assertTrue(n!=null);

        //make sure the number of registered people are correct
        List<Person> newList = (App)mMockContext.getOurDAO().getAll();
        assertTrue(list.size()+1 == newList.size());

    }

}