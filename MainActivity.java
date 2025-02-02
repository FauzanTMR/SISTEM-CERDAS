package com.darskhandev.nassdek;

import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.darskhandev.nassdek.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/darskhandev/nassdek/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/darskhandev/nassdek/databinding/ActivityMainBinding;", "getBinding", "()Lcom/darskhandev/nassdek/databinding/ActivityMainBinding;", "binding$delegate", "Lkotlin/Lazy;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navController$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupUi", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends AppCompatActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new MainActivity$binding$2(this));
    private final Lazy navController$delegate = LazyKt.lazy(new MainActivity$navController$2(this));

    private final NavController getNavController() {
        return (NavController) this.navController$delegate.getValue();
    }

    private final ActivityMainBinding getBinding() {
        return (ActivityMainBinding) this.binding$delegate.getValue();
    }

    private final void setupUi() {
        BottomNavigationView bottomNavigationView = getBinding().bottomNavigationView;
        Intrinsics.checkNotNullExpressionValue(bottomNavigationView, "bottomNavigationView");
        NavigationUI.setupWithNavController((NavigationBarView) bottomNavigationView, getNavController());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        setContentView((View) getBinding().getRoot());
        setupUi();
    }
}
