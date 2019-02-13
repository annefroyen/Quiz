package com.example.quiz;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.test.filters.LargeTest;

import com.example.quiz.Database.App;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertTrue;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class DatabaseActivityTest {

    @Rule
    public ActivityTestRule<DatabaseActivity> mActivityRule = new ActivityTestRule<>(DatabaseActivity.class);


    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        mBd = Room.inMemoryDatabaseBuilder(context, TestDatabase.class).build();
        mUserDao = mDb.getUserDao();
    }


    @Test
    public void deleteTest() {

        List<Person> list = ((App)getApplicationContext()).getOurDAO().getAll();

        //delete person
        onView(withId(R.id.deleteButton)).perform(click());

        //make sure person is not in the database
        Person m = ((App)mMockContext).getOurDAO().findByName(newPerson);
        assertTrue( m==null);

        //make sure the number of registered people are correct
        newList = ((App)mMockContext).getOurDAO().getAll();
        assertTrue(list.size() == newList.size()-1);

    }

}