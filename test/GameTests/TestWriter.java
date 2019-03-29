package GameTests;

import Game.IWriter;

import java.util.ArrayList;

public class TestWriter implements IWriter {

    public ArrayList<String> messagesReceived;

    public TestWriter() {
        this.messagesReceived = new ArrayList<>();
    }

    @Override
    public void write(String message) {
        this.messagesReceived.add(message);
    }

}
