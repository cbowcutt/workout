package com.example.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CollapseButtonView extends AppCompatButton {
    public CollapseButtonView(@NonNull Context context) {
        super(context);
    }

    public CollapseButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CollapseButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private View collapsableView;

    public void setCollapsableView(View view) {
        this.collapsableView = view;
    }

    public View getCollapsableView() {
        return collapsableView;
    }

    public void collapse() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.collapsableView.getLayoutParams();
        params.height = 0;
        this.collapsableView.setLayoutParams(params);
    }
}