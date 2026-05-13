package org.kicktipp.annotationorder;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class AsyncAndJakartaTransactionalService {

    private final StackTraceVerifyer stackTraceVerifyer;

    @Async
    @Transactional
    public Future<Boolean> run() {
        var stacktrace = Thread.currentThread().getStackTrace();
        var ok = stackTraceVerifyer.verify(stacktrace);
        return CompletableFuture.completedFuture(ok);
    }

}
