//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.a.enhanced_components;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kent.androidannotationsdemo.R.id;
import com.kent.androidannotationsdemo.R.layout;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class AActy_
    extends AActy
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.aacty_layout);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        mApplication = MyApplication_.getInstance();
        bean2 = SingletonBean_.getInstance_(this);
        mBean1 = MyBean_.getInstance_(this);
        parentBean = MyBean_.getInstance_(this);
        bean1 = SingletonBean_.getInstance_(this);
        mBean2 = MyBean_.getInstance_(this);
        afterInject();
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

    public static AActy_.IntentBuilder_ intent(Context context) {
        return new AActy_.IntentBuilder_(context);
    }

    public static AActy_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new AActy_.IntentBuilder_(fragment);
    }

    public static AActy_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new AActy_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        mTextView = ((TextView) hasViews.findViewById(id.a_commom_tv));
        viewGroup = ((MyViewGroup) hasViews.findViewById(id.a_viewGroup));
        mLL = ((LinearLayout) hasViews.findViewById(id.a_commom_ll));
        {
            View view = hasViews.findViewById(id.a_fragment_acty);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        AActy_.this.click(view);
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.a_group_setText);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        AActy_.this.click(view);
                    }

                }
                );
            }
        }
        afterViews();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<AActy_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, AActy_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), AActy_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), AActy_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode);
                } else {
                    super.startForResult(requestCode);
                }
            }
        }

    }

}
