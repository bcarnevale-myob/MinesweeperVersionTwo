package GameTests;

import Game.Writer;

import java.util.ArrayList;

public class TestWriter implements Writer {

    public ArrayList<String> messagesReceived;

    public TestWriter() {
        this.messagesReceived = new ArrayList<>();
    }

    @Override
    public void write(String message) {
        this.messagesReceived.add(message);
    }

}
