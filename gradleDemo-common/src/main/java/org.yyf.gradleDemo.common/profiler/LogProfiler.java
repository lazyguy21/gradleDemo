package org.yyf.gradleDemo.common.profiler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tobi on 16-6-14.
 */
public class LogProfiler {
    public static final ThreadLocal<Set<MethodEntry>> entryStack   = new ThreadLocal<Set<MethodEntry>>(){
        @Override
        protected Set<MethodEntry> initialValue() {
            Set<MethodEntry> methodEntryList = new HashSet<>();
            return methodEntryList;
        }
    };
    public static final class AllThings {
        List<MethodEntry> methodEntryList;

    }
    public static final class MethodEntry {

        private String methodName;
        private Integer invokedTimes=0;
        private Long elapsedSeconds;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MethodEntry that = (MethodEntry) o;

            return methodName.equals(that.methodName);

        }

        @Override
        public int hashCode() {
            return methodName.hashCode();
        }
    }
}
