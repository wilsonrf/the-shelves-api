import static ch.qos.logback.classic.Level.INFO


def appenderList = []

// See http://logback.qos.ch/manual/groovy.html for details on configuration

appender('STDOUT', ConsoleAppender) {

    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %X{event} %logger{36} - %msg%n"
    }
}

appenderList.add("STDOUT")


root(INFO, appenderList)