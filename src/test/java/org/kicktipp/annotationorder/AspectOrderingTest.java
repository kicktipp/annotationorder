package org.kicktipp.annotationorder;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class AspectOrderingTest {

    private final AsyncAndJakartaTransactionalService asyncAndJakartaTransactionalService;
    private final AsyncAndSpringTransactionalService asyncAndSpringTransactionalService;
    private final AsyncThenJakartaTransactionalService asyncThenJakartaTransactionalService;
    private final AsyncThenSpringTransactionalService asyncThenSpringTransactionalService;

    @Test
    public void asyncThenSpringTransactionalOrdering() throws ExecutionException, InterruptedException {
        var ok = asyncThenSpringTransactionalService.run();
        assertTrue(ok.get());
    }

    @Test
    public void asyncThenJakartaTransactionalOrdering() throws ExecutionException, InterruptedException {
        var ok = asyncThenJakartaTransactionalService.run();
        assertTrue(ok.get());
    }

    @Test
    public void asyncAndSpringTransactionalOrdering() throws ExecutionException, InterruptedException {
        var ok = asyncAndSpringTransactionalService.run();
        assertTrue(ok.get());
    }

    @Test
    public void asyncAndJakartaTransactionalOrdering() throws ExecutionException, InterruptedException {
        var ok = asyncAndJakartaTransactionalService.run();
        assertTrue(ok.get());
    }
}
