package m.vita.module.logging;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class Logging {


    private static String LOG_TAG = "vita-logging";

    private static String getFormattedLog(final Context mContext, StackTraceElement ste, String preFix, String postFix) {
        String classPath = LogUtil.getLastToken(ste.getClassName(), ".");
        String method = ste.getMethodName();

        String log = new StringBuffer().append(preFix).append(classPath).append("::").append(method).append(postFix).toString();
        return log;
    }

    public static String getFormattedLog(Context mContext, String log) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[2];
        return getFormattedLog(mContext, ste, "", "> " + log);
    }

    public static String getFormmatedTag(Context mContext) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[2];
        return getFormattedLog(mContext, ste, LOG_TAG, "");
    }

    // verbose
    public static void v(Context mContext) {
        try {
            if(LogUtil.isDebug(mContext)) {
                Log.v(LOG_TAG, getFormattedLog(mContext, ""));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void v(Context mContext, String str) {
        try {
            if(LogUtil.isDebug(mContext)) {
                Log.v(LOG_TAG, getFormattedLog(mContext, str));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void v(Context mContext, String str, Exception e) {
        try {
            if(LogUtil.isDebug(mContext)) {
                Log.v(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void v(Context mContext, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.v(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void v(Context mContext, String preFix, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                if (!TextUtils.isEmpty(preFix)) {
                    sb.append("[").append(preFix).append("] ");
                }
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.v(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // info
    public static void i(Context mContext) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.i(LOG_TAG, getFormattedLog(mContext, ""));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void i(Context mContext, String str) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.i(LOG_TAG, getFormattedLog(mContext, str));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void i(Context mContext, String str, Exception e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.i(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void i(Context mContext, Object... objects) {
        try {
            if (Log.isLoggable(LOG_TAG, Log.INFO) || LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.i(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void i(Context mContext, String priFix, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                if (TextUtils.isEmpty(priFix)) {
                    sb.append("[").append(priFix).append("] ");
                }
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.i(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // warning

    public static void w(Context mContext) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.w(LOG_TAG, getFormattedLog(mContext,""));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void w(Context mContext, String str) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.w(LOG_TAG, getFormattedLog(mContext, str));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void w(Context mContext, Exception e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.w(getFormattedLog(mContext,""), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void w(Context mContext, String str, Exception e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.w(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void w(Context mContext, String str, Throwable e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.w(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void w(Context mContext, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                for(Object obj : objects) {
                    sb.append(obj);
                }
                Log.w(LOG_TAG, getFormmatedTag(mContext));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void pw(Context mContext, String preFix, Object... objects) {
        try {
            StringBuffer sb = new StringBuffer();
            if ((!TextUtils.isEmpty(preFix))) {
                sb.append("[").append(preFix).append("] ");
            }
            for (Object obj : objects) {
                sb.append(obj);
            }
            Log.w(LOG_TAG, getFormattedLog(mContext, sb.toString()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // debug
    public static void d(Context mContext) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.d(LOG_TAG, getFormattedLog(mContext, ""));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void d(Context mContext, String str) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.d(LOG_TAG, getFormattedLog(mContext, str));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void d(Context mContext, String str, Exception e) {
        try {
            Log.d(LOG_TAG, getFormattedLog(mContext, str), e);
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void d(Context mContext, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.d(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void d(Context mContext, String preFix, Object... objects) {
        try {
            if (LogUtil.isDebug(mContext)) {
                StringBuffer sb = new StringBuffer();
                if (!TextUtils.isEmpty(preFix)) {
                    sb.append("[").append(preFix).append("] ");
                }
                for (Object obj : objects) {
                    sb.append(obj);
                }
                Log.d(LOG_TAG, getFormattedLog(mContext, sb.toString()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // error

    public static void e(Context mContext, String str) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.e(LOG_TAG, getFormattedLog(mContext, str));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void e(Context mContext, String str, Exception e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.e(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    public static void e(Context mContext, String str, Throwable e) {
        try {
            if (LogUtil.isDebug(mContext)) {
                Log.e(LOG_TAG, getFormattedLog(mContext, str), e);
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

}
