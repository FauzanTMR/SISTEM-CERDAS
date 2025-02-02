package com.darskhandev.nassdek.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.darskhandev.nassdek.R;

public final class FragmentClassfierBinding implements ViewBinding {
    public final Button btnDetect;
    public final FrameLayout imagePicker;
    public final ImageView imgPreview;
    public final LinearLayout layoutResult;
    private final ScrollView rootView;
    public final TextView txtResult;

    private FragmentClassfierBinding(ScrollView scrollView, Button button, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = scrollView;
        this.btnDetect = button;
        this.imagePicker = frameLayout;
        this.imgPreview = imageView;
        this.layoutResult = linearLayout;
        this.txtResult = textView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentClassfierBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentClassfierBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_classfier, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentClassfierBinding bind(View view) {
        int i = R.id.btnDetect;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.imagePicker;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.imgPreview;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.layoutResult;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.txtResult;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new FragmentClassfierBinding((ScrollView) view, button, frameLayout, imageView, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
