package org.kicktipp.annotationorder;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class AsyncThenSpringTransactionalService {

    private final StackTraceVerifyer stackTraceVerifyer;

    @Async
    public Future<Boolean> run() {
        return transactional();
    }

    @Transactional
    public Future<Boolean> transactional() {
        var stacktrace = Thread.currentThread().getStackTrace();
        var ok = stackTraceVerifyer.verify(stacktrace);
        return CompletableFuture.completedFuture(ok);
    }
}
