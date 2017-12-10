package it.fox.app.io.closable;

public interface IClosable extends AutoCloseable {

    @Override
    void close() throws ClosableException;
}
