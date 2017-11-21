package it.sevenbits.app.io.closable;

public interface IClosable extends AutoCloseable {

    @Override
    void close() throws ClosableException;
}
