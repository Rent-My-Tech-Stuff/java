package com.lambdaschool.backend.exceptions;

/**
 * A custom exception to be used when a resource is not but is suppose to be
 */
public class ResourceNotFoundException
    extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error from a MyTechStuff App: " + message);
    }
}