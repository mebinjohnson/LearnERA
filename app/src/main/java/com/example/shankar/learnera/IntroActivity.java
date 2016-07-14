package com.example.shankar.learnera;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

/**
 * Created by Prejith on 7/13/2016.
 */

public class IntroActivity extends com.heinrichreimersoftware.materialintro.app.IntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setFullscreen(true);
        super.onCreate(savedInstanceState);



        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_welcome, R.style.Theme_Intro)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_attendance, R.style.Theme_Intro)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_marks, R.style.Theme_Intro)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_points, R.style.Theme_Intro)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_contact, R.style.Theme_Intro)
                .build());

        //TODO: Make custom fragment for login button
        /** addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_intro_contact, R.style.Theme_Intro)
                .build());
         **/
    }
}