package GameTests;

import Game.Writer;

import java.util.ArrayList;
import java.util.Collection;

public class TestWriter implements Writer {

    Collection<String> messagesReceived;

    TestWriter() {
        this.messagesReceived = new ArrayList<>();
    }

    @Override
    public void write(String message) {
        this.messagesReceived.add(message);
    }

}
