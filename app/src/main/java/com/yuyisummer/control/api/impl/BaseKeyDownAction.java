package com.yuyisummer.control.api.impl;

import android.content.Intent;
import android.util.Log;

import com.yuyisummer.control.api.IKeyDownAction;


/*
 * -----------------------------------------------------------------
 * Copyright (C) 2011-2021, by your Signway, All rights reserved.
 * -----------------------------------------------------------------
 *
 * ProjectName: yuyisummer_ds_unified
 *
 * Author: yuyisummer
 *
 * Email: jh.yu@Signway.cn
 *
 * Description:
 *
 * -----------------------------------------------------------------
 * 2021/3/18 : Create BaseKeyDownAction.java
 * -----------------------------------------------------------------
 */
public class BaseKeyDownAction implements IKeyDownAction {
    private static final String TAG = "BaseKeyDownAction";
    @Override
    public boolean back() {
        Log.i(TAG, "back");
        /*默认就是不处理的返回键*/
        return false;
    }

    @Override
    public boolean exitApp() {
        Log.i(TAG, "exitApp");
        return true;
    }


}
