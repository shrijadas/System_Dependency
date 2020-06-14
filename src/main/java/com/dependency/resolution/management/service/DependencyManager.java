package com.dependency.resolution.management.service;

import java.util.Set;

import com.dependency.resolution.management.model.Program;

public interface DependencyManager {
    Set<Program> list() throws ServiceException;

    void depend(Program source, Set<Program> dest) throws ServiceException;

    Set<Program> add(Program program) throws ServiceException;

    Set<Program> remove(Program program) throws ServiceException;
}
