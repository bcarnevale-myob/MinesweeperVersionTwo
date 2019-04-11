package GameTests;

import Game.Reader;

import java.util.ArrayList;

public class TestReader implements Reader {

    private ArrayList<String> userResponses;
    private int callCounter = -1;

    TestReader(ArrayList<String> userResponses) {
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
