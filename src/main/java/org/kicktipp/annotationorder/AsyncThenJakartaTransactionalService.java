package org.kicktipp.annotationorder;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class AsyncThenJakartaTransactionalService {

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
