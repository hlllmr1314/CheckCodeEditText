package com.haley.checkcodeview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by huanglei on 6/25/16.
 */
public class CheckCodeEditText extends LinearLayout {

    private LinearLayout checkCodeLinear;
    private EditText checkCodeEdit;
    private TextView code1;
    private TextView code2;
    private TextView code3;
    private TextView code4;
    private ArrayList<TextView> codeViews = new ArrayList<>();

    public CheckCodeEditText(Context context) {
        super(context);
        init();
    }

    public CheckCodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckCodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CheckCodeEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        inflate(getContext(), R.layout.check_code_layout, this);
        this.checkCodeLinear = (LinearLayout) findViewById(R.id.checkcode_linear);
        this.checkCodeEdit = (EditText) findViewById(R.id.checkcode_edit);
        this.code1 = (TextView) findViewById(R.id.codeOne);
        this.code2 = (TextView) findViewById(R.id.codeTow);
        this.code3 = (TextView) findViewById(R.id.codeThree);
        this.code4 = (TextView) findViewById(R.id.codeFour);

        this.codeViews.clear();
        this.codeViews.add(code1);
        this.codeViews.add(code2);
        this.codeViews.add(code3);
        this.codeViews.add(code4);

        this.checkCodeLinear.setOnClickListener(onClickListener);
        this.checkCodeEdit.addTextChangedListener(textWatcher);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == checkCodeLinear.getId()) {
                Context context = v.getContext();
                InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    };

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            for (int j = 0; j < codeViews.size(); j++) {
                codeViews.get(j).setText("");
            }
            for (int j = 0; j < s.length() && j < codeViews.size(); j++) {
                codeViews.get(j).setText(s.charAt(j) + "");
            }

            if (codeViews.size() > 0 && s.length() == codeViews.size()) {
                if (listener != null)
                    listener.finish();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public String getText() {
        return this.checkCodeEdit.getText().toString();
    }

    private CheckCodeCompleteListener listener;

    public void addCompleteListener(CheckCodeCompleteListener listener) {
        this.listener = listener;
    }

}
