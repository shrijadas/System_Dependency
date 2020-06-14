package com.dependency.resolution.management.command;

import com.dependency.resolution.management.Command;
import com.dependency.resolution.management.service.DependencyManager;
import com.dependency.resolution.management.service.ServiceException;

public abstract class AbstractCommand implements Command {

    protected DependencyManager dependencyManager;

    public abstract String executeInternal(String[] args) throws CommandException, ServiceException;

    public String execute(String[] args) throws CommandException {
        try {
            return executeInternal(args);
        } catch (CommandException | ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }

    public void setDependencyManager(DependencyManager dependencyManager) {
        this.dependencyManager = dependencyManager;
    }

    protected void verifyHasExactNumberOfArguments(String[] args, int count) throws CommandException {
        if (args.length != count) {
            throw new CommandException("Incorrect number of command arguments, expected (" +
                    count + ") received (" + args.length + ")");
        }
    }

    protected void verifyHasMinimumNumberOfArguments(String[] args, int count) throws CommandException {
        if (args.length < count) {
            throw new CommandException("Incorrect number of command arguments, expected at least (" +
                    count + ") received (" + args.length + ")");
        }
    }

}
