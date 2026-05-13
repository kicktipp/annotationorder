package org.kicktipp.annotationorder;

import org.springframework.aop.interceptor.AsyncExecutionInterceptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StackTraceVerifyer {

    public boolean verify(StackTraceElement[] stackTrace) {
        List<String> executionOrder = new ArrayList<>();
        for (var stackTraceElement : stackTrace) {
            var className = stackTraceElement.getClassName();
            if (className.equals("org.springframework.transaction.interceptor.TransactionInterceptor")) {
                if (!executionOrder.contains("Transactional")) {
                    executionOrder.add("Transactional");
                }
            }
            if (className.equals("org.springframework.transaction.aspectj.AbstractTransactionAspect")) {
                if (!executionOrder.contains("Transactional")) {
                    executionOrder.add("Transactional");
                }
            }
            if (className.equals(AsyncExecutionInterceptor.class.getName())) {
                if (!executionOrder.contains("Async")) {
                    executionOrder.add("Async");
                }
            }
            if (className.equals("org.springframework.scheduling.aspectj.AbstractAsyncExecutionAspect")) {
                if (!executionOrder.contains("Async")) {
                    executionOrder.add("Async");
                }
            }
        }
        // first in Stacktrace, late in execution
        Collections.reverse(executionOrder);
        System.out.println(executionOrder);
        return executionOrder.equals(List.of("Async", "Transactional"));
    }
}
