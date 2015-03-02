package utils;

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import java.net.URL;

/**
 * Copyright © 2006-2014 AboutCoder.COM. All rights reserved.
 * Fabric异常收集处理公共方法
 *
 * @author chenjinlong
 * @datetime 1/26/15 11:41 AM
 * @description
 */
public class FabricHelper {
    /**
     * Fabric开关标识变量
     */
    private static boolean isEnabled = true;

    /**
     * 启动Fabric
     * 建议：该方法一般放置在Application.Create()方法中执行
     *
     * @param context
     */
    public static void start(Context context) {
        if (isEnabled) {
            Fabric.with(context, new Crashlytics());
        }
    }

    /**
     * 检查Fabric是否已被启动
     *
     * @param context
     * @return
     */
    public static boolean isFabricInitialized(Context context) {
        if (Fabric.isInitialized()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检查Fabric是否处于Debug模式下
     *
     * @param context
     * @return
     */
    public static boolean isFabricDebuggable(Context context) {
        if (Fabric.isDebuggable()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询Fabric标志字符串
     * 常见为包名，例如"io.fabric.sdk.android:fabric"
     *
     * @param context
     * @return
     */
    public static String getFabricIdentifier(Context context) {
        if (isEnabled) {
            return Fabric.with(context, new Crashlytics()).getIdentifier();
        } else {
            return null;
        }
    }

    /**
     * 查询Fabric版本号
     *
     * @param context
     * @return
     */
    public static String getFabricVersion(Context context) {
        if (isEnabled) {
            return Fabric.with(context, new Crashlytics()).getVersion();
        } else {
            return null;
        }
    }

    /**
     * 查询Crashlytics标志字符串
     * 常见为包名，例如"com.crashlytics.sdk.android:crashlytics"
     *
     * @return
     */
    public static String getCrashlyticsIdentifier() {
        if (isEnabled) {
            return Crashlytics.getInstance().getIdentifier();
        } else {
            return null;
        }
    }

    /**
     * 查询Crashlytics版本号
     *
     * @return
     */
    public static String getCrashlyticsVersion() {
        if (isEnabled) {
            return Crashlytics.getInstance().getVersion();
        } else {
            return null;
        }
    }

    /**
     * 记录一般日志
     *
     * @param message
     */
    public static void log(String message) {
        if (isEnabled) {
            Crashlytics.log(message);
        }
    }

    /**
     * 记录详细日志
     *
     * @param priority
     * @param tag
     * @param msg
     */
    public static void log(int priority, String tag, String msg) {
        if (isEnabled) {
            Crashlytics.log(priority, tag, msg);
        }
    }

    /**
     * 记录异常
     *
     * @param throwable
     */
    public static void logException(Throwable throwable) {
        if (isEnabled) {
            Crashlytics.logException(throwable);
        }
    }

    /**
     * 设定用户名
     * 备注：只有当FabricHelper.start()执行结束之后方可设置，否则会抛出异常
     *
     * @param userName
     * @see #start
     */
    public static void setUserName(String userName) {
        if (isEnabled) {
            Crashlytics.setUserName(userName);
        }
    }

    /**
     * 设定用户邮箱
     * 备注：只有当FabricHelper.start()执行结束之后方可设置，否则会抛出异常
     *
     * @param email
     * @see #start
     */
    public static void setUserEmail(String email) {
        if (isEnabled) {
            Crashlytics.setUserEmail(email);
        }
    }

    /**
     * 设定用户标志字符串
     * 备注：只有当FabricHelper.start()执行结束之后方可设置，否则会抛出异常
     *
     * @param identifier
     * @see #start
     */
    public static void setUserIdentifier(String identifier) {
        if (isEnabled) {
            Crashlytics.setUserIdentifier(identifier);
        }
    }

    /**
     * 设定键值对数据
     * 备注：只有当FabricHelper.start()执行结束之后方可设置，否则会抛出异常
     *
     * @param key
     * @param value
     * @see #start
     */
    public static void setString(String key, String value) {
        if (isEnabled) {
            Crashlytics.setString(key, value);
        }
    }

    public static void setBool(String key, boolean value) {
        if (isEnabled) {
            Crashlytics.setBool(key, value);
        }
    }

    public static void setDouble(String key, double value) {
        if (isEnabled) {
            Crashlytics.setDouble(key, value);
        }
    }

    public static void setFloat(String key, float value) {
        if (isEnabled) {
            Crashlytics.setFloat(key, value);
        }
    }

    public static void setInt(String key, int value) {
        if (isEnabled) {
            Crashlytics.setInt(key, value);
        }
    }

    public static void setLong(String key, long value) {
        if (isEnabled) {
            Crashlytics.setLong(key, value);
        }
    }

    /**
     * 校验url有效性
     * 备注：在PinningInfoProvider不为null值的情况下进行curl请求并校验url，否则返回false
     * 根据方法getPinningInfoProvider()可以获取Crashlytics.java的private变量pinningInfo
     *
     * @param url
     * @return
     */
    public static boolean verifyPinning(URL url) {
        if (isEnabled) {
            return Crashlytics.getInstance().verifyPinning(url);
        } else {
            return false;
        }
    }
}
