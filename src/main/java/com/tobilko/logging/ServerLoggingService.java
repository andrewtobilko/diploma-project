package com.tobilko.logging;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;

@Service
public class ServerLoggingService {

    private final String LOGGER_FILE_LOCATION = "C:\\Users\\andre\\IdeaProjects\\diploma-project\\server.log";

    @Transactional
    public List<String> fetchLatestLoggerMessages() {
        return fetchLatestLoggerMessagesFromFile();
    }

    @SneakyThrows
    private List<String> fetchLatestLoggerMessagesFromFile() {
        return lines(get(LOGGER_FILE_LOCATION)).collect(toList());
    }

}
