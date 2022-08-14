package com.github.note.o10Annotation;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        MyService service = enhanceByAnnotation();

        service.queryDatabase(1);
        service.provideHttpService("abc");
        service.noLog();
    }

    private static MyService enhanceByAnnotation() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        return new ByteBuddy().subclass(MyService.class).method(new FilterWithAnnotationLogMatcher()).intercept(
                MethodDelegation.to(LoggerInterceptor.class)).make().load(
                Main.class.getClassLoader()).getLoaded().getConstructor().newInstance();
    }

    static class FilterWithAnnotationLogMatcher implements ElementMatcher<MethodDescription> {

        @Override
        public boolean matches(MethodDescription target) {
            List<String> methodsWithLog = Stream.of(MyService.class.getMethods()).filter(
                    FilterWithAnnotationLogMatcher::isAnnotatedWithLog).map(Method::getName).collect(
                    Collectors.toList());
            return methodsWithLog.contains(target.getName());
        }

        private static boolean isAnnotatedWithLog(Method method) {
            return method.getAnnotation(Log.class) != null;
        }
    }

    public static class LoggerInterceptor {
        public static void log(@SuperCall Callable<Void> zuper) throws Exception {
            System.out.println("Start!");
            try {
                zuper.call();
            } finally {
                System.out.println("End!");
                System.out.println("---------------");
            }
        }
    }
}