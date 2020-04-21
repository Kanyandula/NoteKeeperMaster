package com.ephraim.me.notekeeper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest{
    @Rule
   @JvmField
    val itemsActivity = ActivityTestRule(ItemsActivity::class.java)

     @Test
    fun selectNoteAfterNavigationDrawerChange(){
         onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
       //  onView(withId(R.id.nav_home)).perform(NavigationViewActions.navigateTo(R.id.nav_home))

         val coursePosition = 0
         onView(withId(R.id.listItems)).perform(
             RecyclerViewActions.actionOnItemAtPosition<NoteRecyclerAdapter.ViewHolder>(coursePosition, click())
         )
    }

}