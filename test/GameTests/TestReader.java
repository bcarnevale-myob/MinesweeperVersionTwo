package GameTests;

import Game.IReader;

import java.util.ArrayList;

public class TestReader implements IReader {

    private ArrayList<String> userResponses;
    private int callCounter = -1;

    public TestReader(ArrayList<String> userResponses) {
        this.userResponses = userResponses;
    }

    @Override
    public String prompt(String message) {
        callCounter++;

        if (callCounter == userResponses.size()) {
            callCounter = 0;
        }

        return userResponses.get(callCounter);
    }

}
