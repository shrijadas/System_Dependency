package com.dependency.resolution.management;

import com.dependency.resolution.management.command.CommandException;

public interface Command {
     String execute(String[] args) throws CommandException;
}
