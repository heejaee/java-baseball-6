package baseball.service;

import baseball.input.ComputerInput;
import baseball.input.UserInput;
import java.util.List;

public class InputService {
    private final ComputerInput computerInput = new ComputerInput();
    private final UserInput userInput = new UserInput();

    public void computerAnswer(){
        computerInput.create();
    }

    public List<String> getComputer(){
        return computerInput.value();
    }

    public void userAnswer(){
        userInput.create();
        userInput.checking();
    }

    public String getUser(){
        return userInput.value();
    }
}
