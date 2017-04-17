package com.tobilko.lifecycle.state;

import org.springframework.context.ApplicationEvent;

public enum  ServerLifeCycleCommand {

    START() {

        @Override
        public ApplicationEvent generateApplicationEvent() {
            return null;
        }

    },
    RESTART() {

        @Override
        public ApplicationEvent generateApplicationEvent() {
            return null;
        }

    },
    STOP() {

        @Override
        public ApplicationEvent generateApplicationEvent() {
            return null;
        }

    };

    public abstract ApplicationEvent generateApplicationEvent();

}
