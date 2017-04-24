package com.tobilko.logging;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Service
public class ServerLoggingService {

    @Transactional
    public List<String> fetchLatestLoggerMessages() {
        return fetchLatestLoggerMessagesFromFile(new File(""));
    }

    private List<String> fetchLatestLoggerMessagesFromFile(File file) {
        return null;
    }

}
