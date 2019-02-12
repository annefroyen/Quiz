
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

    int  score =0;
    int total = 0;
    String submit;

    @Test
    public void scoreTest(){

        //submit wrong answer
        submit = "chandler";
        boolean n = submit.toLowerCase().equals("joey".toLowerCase());
        if(n){
            score ++;
            total ++;
        }else{
            total++;
        }

        assertTrue(score==0);
        assertTrue(total==1);

        //submit right answer
        boolean m = submit.toLowerCase().equals("chandler".toLowerCase());
        if(m){
            score ++;
            total ++;
        }else{
            total++;
        }

        assertTrue(score==1);
        assertTrue(total==2);

    }
}
