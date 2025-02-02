package com.darskhandev.nassdek.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.darskhandev.nassdek.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public final class ActivityMainBinding implements ViewBinding {
    public final BottomNavigationView bottomNavigationView;
    public final ConstraintLayout main;
    public final FragmentContainerView navHostFragment;
    private final ConstraintLayout rootView;

    private ActivityMainBinding(ConstraintLayout constraintLayout, BottomNavigationView bottomNavigationView2, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.bottomNavigationView = bottomNavigationView2;
        this.main = constraintLayout2;
        this.navHostFragment = fragmentContainerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.bottomNavigationView;
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) ViewBindings.findChildViewById(view, i);
        if (bottomNavigationView2 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.nav_host_fragment;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i2);
            if (fragmentContainerView != null) {
                return new ActivityMainBinding(constraintLayout, bottomNavigationView2, constraintLayout, fragmentContainerView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
