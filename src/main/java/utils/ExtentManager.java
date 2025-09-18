package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    public class ExtentTestManager {
        private static final ThreadLocal<ExtentTest> tl = new ThreadLocal<>();

        public static void set(ExtentTest test) { tl.set(test); }
        public static ExtentTest get() { return tl.get(); }
        public static void remove() { tl.remove(); }
    }

}
