package it.fox.app.lexer.implementation;

public final class StateLexer {

    private final String name;

    public StateLexer(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateLexer that = (StateLexer) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "StateLexer{" +
                "name='" + name + '\'' +
                '}';
    }
}
