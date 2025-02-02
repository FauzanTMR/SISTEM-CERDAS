package com.darskhandev.nassdek.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.darskhandev.nassdek.R;

public final class FragmentAboutBinding implements ViewBinding {
    public final ImageView imageView;
    private final FrameLayout rootView;

    private FragmentAboutBinding(FrameLayout frameLayout, ImageView imageView2) {
        this.rootView = frameLayout;
        this.imageView = imageView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAboutBinding bind(View view) {
        int i = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView2 != null) {
            return new FragmentAboutBinding((FrameLayout) view, imageView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
