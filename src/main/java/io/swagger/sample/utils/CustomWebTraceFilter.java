//package io.swagger.sample.utils;
//
///**
// *
// * @author tplevko
// */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.actuate.trace.TraceProperties;
//import org.springframework.boot.actuate.trace.TraceRepository;
//import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class CustomWebTraceFilter extends WebRequestTraceFilter {
//
//    public CustomWebTraceFilter(TraceRepository repository, TraceProperties properties) {
//        super(repository, properties);
//    }
//
//    @Override
//    protected Map<String, Object> getTrace(HttpServletRequest request) {
//        Map<String, Object> trace = super.getTrace(request);
//        if (request.getMethod().equals("POST")) {
//            try {
//                StringBuilder buffer = new StringBuilder();
//                MultiReadHttpServletRequest requestCopy = new MultiReadHttpServletRequest(request);
//                BufferedReader reader = requestCopy.getReader();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    buffer.append(line);
//                }
//                String data = buffer.toString();
//                log.info("********************");
//                log.info(data);
//                log.info("********************");
//            } catch (IOException ex) {
//                log.error("Error:" + ex);
//            }
//        }
//        return trace;
//    }
//}
