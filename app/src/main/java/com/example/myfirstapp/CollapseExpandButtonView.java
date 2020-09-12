package com.example.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CollapseExpandButtonView extends AppCompatButton {

    public CollapseExpandButtonView(@NonNull Context context) {
        super(context);
    }
    public CollapseExpandButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CollapseExpandButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private View collapsableView;

    public void setCollapsableView(View view) {
        this.collapsableView = view;
    }

    public View getCollapsableView() {
        return collapsableView;
    }

    public void toggle() {
        if (this.isCollapsed()) {
            this.expand();
        }
        else {
            this.collapse();
        }
    }

    private boolean isCollapsed() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.collapsableView.getLayoutParams();
        if (params.height == 0) {
            return true;
        }
        return false;
    }

    public void collapse() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.collapsableView.getLayoutParams();
        params.height = 0;
        this.collapsableView.setLayoutParams(params);
    }

    public void expand() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.collapsableView.getLayoutParams();
        params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        this.collapsableView.setLayoutParams(params);
    }
}