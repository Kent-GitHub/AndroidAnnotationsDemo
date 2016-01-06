//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.h.typesafe_sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.kent.androidannotationsdemo.R.id;
import com.kent.androidannotationsdemo.R.layout;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class HSecActivity_
    extends HSecActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.hsec_layout);
    }

    private void init_(Bundle savedInstanceState) {
        defaultPrefs = new DefaultPrefs_(this);
        applicationPrefs = new ApplicationPrefs_(this);
        activityPrefs = new ActivityPrefs_(this);
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static HSecActivity_.IntentBuilder_ intent(Context context) {
        return new HSecActivity_.IntentBuilder_(context);
    }

    public static HSecActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new HSecActivity_.IntentBuilder_(fragment);
    }

    public static HSecActivity_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new HSecActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        tv = ((TextView) hasViews.findViewById(id.h_sec_tv));
        {
            View view = hasViews.findViewById(id.h_sec_btn_actyPrefs);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        HSecActivity_.this.onClick(view);
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.h_sec_btn_defaultPrefs);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        HSecActivity_.this.onClick(view);
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.h_sec_btn_applicationPrefs);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        HSecActivity_.this.onClick(view);
                    }

                }
                );
            }
        }
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<HSecActivity_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, HSecActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), HSecActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), HSecActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                        fragment_.startActivityForResult(intent, requestCode, lastOptions);
                    } else {
                        fragment_.startActivityForResult(intent, requestCode);
                    }
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, lastOptions);
                        } else {
                            context.startActivity(intent);
                        }
                    }
                }
            }
        }

    }

}
