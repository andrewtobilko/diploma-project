package com.tobilko.lifecycle;

import com.tobilko.lifecycle.state.ServerLifeCycleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerLifecycleService {

//    private final ApplicationEventPublisher publisher;
//
//    public void runCommand(ServerLifeCycleCommand command) {
//        publishEventByServerLifeCycleCommand(command);
//    }
//
//    private void publishEventByServerLifeCycleCommand(ServerLifeCycleCommand command) {
//        publisher.publishEvent(command.generateApplicationEvent());
//    }

}
