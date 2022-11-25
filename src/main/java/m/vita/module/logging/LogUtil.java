package m.vita.module.logging;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class LogUtil {

    /**
     * Get last token from split string by separator.
     * For example, when given text is "abc/def|ghi/jkl/mno|pqr/stu" and separator is "|", result is "pqr/stu".
     * @param s
     * @param separator
     * @return
     */
    public static String getLastToken(String s, String separator) {
        return s.substring(s.lastIndexOf(separator) + 1);
    }

    /**
     * Get debug flag from boolean by context application info.
     * @param mContext
     * @return isDebug
     */
    public static boolean isDebug(Context mContext) {
        boolean isDebug = false;
        if (0 != (mContext.getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE)) {
            isDebug = true;
        }
        return isDebug;
    }
}
