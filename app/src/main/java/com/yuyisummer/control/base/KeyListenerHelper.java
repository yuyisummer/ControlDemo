package com.yuyisummer.control.base;

import android.util.Log;
import android.view.KeyEvent;

import com.yuyisummer.control.api.IKeyDownAction;
import com.yuyisummer.control.api.impl.BaseKeyDownAction;


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
 * 2021/3/18 : Create KeyListenerHelper.java
 * -----------------------------------------------------------------
 */
public class KeyListenerHelper {
    private static final String TAG = "KeyListenerHelper";

    public static  KeyListenerHelper INSTANCE = new  KeyListenerHelper();
    public IKeyDownAction mDownAction = new BaseKeyDownAction();

    /*顺序保存按下的键值*/
    public int[] saveDown = new int[300];
    /*已保存的长度*/
    public int downLength = 0;

    long firstDownTime = 0;
    boolean used = false;

    public static boolean check(int keyCode, KeyEvent event) {
        return INSTANCE.onCheck(keyCode,event);
    }

    public static void setAction(IKeyDownAction keyAction) {
        INSTANCE.mDownAction = keyAction;
    }

    /**
     * @param keyCode
     * @param event
     * @return true:按键值已消费 false：继续传递事件
     */
    public synchronized boolean onCheck(int keyCode, KeyEvent event) {
        /*上一次用的按钮已经被消费了，或者当前时间与前一个按键的时间间隔大于3000*/
        if (used || (System.currentTimeMillis() - firstDownTime) > 3000 || (downLength > 300)) {
            /*上一次用的按钮已经被消费了，或者当前时间与前一个按键的时间间隔大于3000*/
            downLength = 0;
        }
        saveDown[downLength++] = keyCode;
        used = false;

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                /*拦截返回键*/
                used = mDownAction.back();
                break;
            case KeyEvent.KEYCODE_F4:
                /*连续按下F1、F2、F3、F4*/
                if (downLength >= 4
                        && saveDown[downLength - 2] == KeyEvent.KEYCODE_F3
                        && saveDown[downLength - 3] == KeyEvent.KEYCODE_F2
                        && saveDown[downLength - 4] == KeyEvent.KEYCODE_F1) {

                    used = mDownAction.exitApp();

                    Log.i(TAG,"exit app, [state]:" + used);
                    if (used) {
                        break;
                    }
                }
                break;
        }

        Log.i(TAG, "[used]:"+used);
        if (used) {
            /*已经消费了按键功能*/
            for (int length = downLength - 1; length >= 0; length--) {
                /*重置数据*/
                saveDown[length] = 0;
            }
            downLength = 0;
        } else {
            /*记录时间*/
            firstDownTime = System.currentTimeMillis();
        }
        return used;
    }

}
