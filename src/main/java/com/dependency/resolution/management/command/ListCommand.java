package com.dependency.resolution.management.command;

import com.dependency.resolution.management.model.Program;
import com.dependency.resolution.management.service.ServiceException;

import java.util.Set;

public class ListCommand extends AbstractCommand {
    @Override
    public String executeInternal(String[] args) throws CommandException, ServiceException {
        verifyHasExactNumberOfArguments(args, 1);

        Set<Program> installed = dependencyManager.list();

        StringBuffer response = new StringBuffer();
        for (Program program : installed) {
            response.append("\t").append(program.getName()).append("\n");
        }

        return response.toString();
    }
}
