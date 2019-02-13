
package com.example.quiz;

import org.junit.Rule;

//import com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.Test;
import com.example.quiz.Database.App;
import org.junit.Test;
import java.util.List;
import android.content.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

public class ActivityTest {

   // @Mock
    //Context mMockContext;


    //@Rule
    //public ActivityTestRule<AddActivity> mActivityRule = new ActivityTestRule<>(AddActivity.class);


    @Test
    public void addPerson() {
       // onView(withId(R.id.editName)).perform((typeText("Maria")));

       // onView(withId(R.id.add_imageView)).perform(typeText("uri"));

        //.onView(withId(R.id.addButton)).perform(click());
    }

    @Test
    public void deletePerson() {
        //Espresso.onView(withId(R.id.editName)).perform((typeText("Maria")));


       // onView(withId(R.id.editName)).perform(typeText("Steve"));
        // onView(withId(R.id.add_imageView)).perform(typeText("uri"));
        //onView(withId(R.id.deleteButton)).perform(click());
    }


/*
    @Test
    public void PersonTest(){

        List<Person> list = (App)mMockContext.getOurDAO().getAll();

        //add Person
        Person newPerson = new Person("uri", "newPerson");
        (App)mMockContext.getOurDAO().insert(newPerson);

        //make sure the person is in the database
        Person n = ((App)mMockContext).getOurDAO().findByName(newPerson);
        assertTrue(n!=null);

        //make sure the number of registered people are correct
        List<Person> newList = (App)mMockContext.getOurDAO().getAll();
        assertTrue(list.size()+1 == newList.size());

        //make sure person is not in the database
        ((App)mMockContext).getOurDAO().delete(newPerson);
        Person m = ((App)mMockContext).getOurDAO().findByName(newPerson);
        assertTrue( m==null);

        //make sure the number of registered people are correct
        newList = ((App)mMockContext).getOurDAO().getAll();
        assertTrue(list.size() == newList.size());
    }
    */

}
