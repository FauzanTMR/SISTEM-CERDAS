package com.darskhandev.nassdek.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.darskhandev.nassdek.R;

public final class FragmentHomeBinding implements ViewBinding {
    private final FrameLayout rootView;

    private FragmentHomeBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHomeBinding bind(View view) {
        if (view != null) {
            return new FragmentHomeBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
