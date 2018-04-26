package io.swagger.sample.utils;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author tplevko
 */
@Slf4j
@Component
public class LoggingTraceRepository implements TraceRepository {

    private final TraceRepository delegate = new InMemoryTraceRepository();

    @Override
    public List<Trace> findAll() {
        return delegate.findAll();
    }

    @Override
    public void add(Map<String, Object> traceInfo) {
        log.info(traceInfo.toString());
        this.delegate.add(traceInfo);
    }
}
