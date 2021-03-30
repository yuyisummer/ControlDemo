package com.yuyisummer.control.base;

import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.yuyisummer.control.api.IKeyDownAction;
import com.yuyisummer.control.api.impl.BaseKeyDownAction;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2011-2021, by your Signway, All rights reserved.
 * -----------------------------------------------------------------
 *
 * ProjectName: ControlDemo
 *
 * Author: yuyisummer
 *
 * Email: jh.yu@Signway.cn
 *
 * Description:
 *
 * -----------------------------------------------------------------
 * 2021/3/30 : Create BaseActivity.java
 * -----------------------------------------------------------------
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        /*界面变更按键事件*/
        KeyListenerHelper.setAction(getKeyAction());

    }

    public IKeyDownAction getKeyAction() {
        return new BaseKeyDownAction();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*重定向键值事件*/
        if (KeyListenerHelper.check(keyCode, event)) {
            return true;
        }
        /*按键未消费，继续处理*/
        return super.onKeyDown(keyCode, event);
    }


}
