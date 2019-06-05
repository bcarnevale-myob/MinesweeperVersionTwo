package GameTests;

import Game.Writer;

import java.util.ArrayList;
import java.util.List;

public class TestWriter implements Writer {

    List<String> messagesReceived;

    TestWriter() {
        this.messagesReceived = new ArrayList<>();
    }

    @Override
    public void write(String message) {
        this.messagesReceived.add(message);
    }

}
