package com.example.forcesales;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.TestHelper.IssueTrackerHelper;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */



public class IssueTrackerInstrumentedTest {
    // Note, It does seen possible to pass a custom intent, but my current
    // method allows me to access the management variable.
    // https://stackoverflow.com/a/30198750/5988706
    IssueTrackerHelper issue_tracker_helper;

    @Rule
    public ActivityTestRule<IssueTrackerHelper> activityRule =
            new ActivityTestRule<>(IssueTrackerHelper.class);

    @Test
    public void testAddIssueTracker() {
        onView(withId(R.id.manage_list_add)).perform(click()); // click() activates the onClickListener.
        onView(withId(R.id.report_issue_title)).perform(typeText("This is a title")); // typeText sets the virtual keyboard to type what is written on the argument.
        onView(withId(R.id.report_issue_description)).perform(typeText("This is a description"));

        for (int i = 0; i < 3; i++) {
            onView(withId(R.id.report_issue_select_person_next)).perform(click());
        }

        onView(withId(R.id.report_issue_submit)).perform(click());
        pressBack();

        issue_tracker_helper = activityRule.getActivity(); // If you have variables in your class that you want to assess, this is probably the best (and only?) way to access it.
        assertThat(issue_tracker_helper.management.getIssueTracker().size(), is(5)); // http://junit.sourceforge.net/javadoc/org/junit/Assert.html
    }
}
