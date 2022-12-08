package com.yevheniibakhmat.at_pz1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UiTests {
    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun viewShouldContainResultTextView(){
        onView(withId(R.id.result)).check(matches(withText("0")))
    }

    @Test
    fun viewShouldContainExpressionTextView(){
        onView(withId(R.id.expression)).check(matches(withText("0")))
    }

    @Test
    fun viewShouldContainAllTheButtons(){
        onView(withId(R.id.plus)).check(matches(withText("+")))
        onView(withId(R.id.minus)).check(matches(withText("-")))
        onView(withId(R.id.multiply)).check(matches(withText("*")))
        onView(withId(R.id.divide)).check(matches(withText("/")))
        onView(withId(R.id.equals)).check(matches(withText("=")))
        onView(withId(R.id.clear)).check(matches(withText("C")))
        onView(withId(R.id.zero)).check(matches(withText("0")))
        onView(withId(R.id.one)).check(matches(withText("1")))
        onView(withId(R.id.two)).check(matches(withText("2")))
        onView(withId(R.id.three)).check(matches(withText("3")))
        onView(withId(R.id.four)).check(matches(withText("4")))
        onView(withId(R.id.five)).check(matches(withText("5")))
        onView(withId(R.id.six)).check(matches(withText("6")))
        onView(withId(R.id.seven)).check(matches(withText("7")))
        onView(withId(R.id.eight)).check(matches(withText("8")))
        onView(withId(R.id.nine)).check(matches(withText("9")))
    }



    @Test
    fun shouldCalculateExpression(){
        onView(withId(R.id.one)).perform(click())
        onView(withId(R.id.expression)).check(matches(withText("1")))
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.expression)).check(matches(withText("1+")))
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.expression)).check(matches(withText("1+2")))
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("3")))
    }

    @Test
    fun shouldCalculateExpressionWithDot(){
        onView(withId(R.id.one)).perform(click())
        onView(withId(R.id.dot)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.dot)).perform(click())
        onView(withId(R.id.three)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("3.5")))
    }
}