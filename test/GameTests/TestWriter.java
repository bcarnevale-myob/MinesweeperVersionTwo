package GameTests;

import Game.Writer;

import java.util.ArrayList;

public class TestWriter implements Writer {

    ArrayList<String> messagesReceived;

    TestWriter() {
        this.messagesReceived = new ArrayList<>();
    }

    @Override
    public void write(String message) {
        this.messagesReceived.add(message);
    }

}
