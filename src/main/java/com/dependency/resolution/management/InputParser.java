package com.dependency.resolution.management;

import com.dependency.resolution.management.command.CommandException;

public class InputParser {

    public String[] parse(String commandString) throws CommandException {
        return commandString.split("\\s+");
    }

}
