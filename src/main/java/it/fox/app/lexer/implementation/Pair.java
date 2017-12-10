package it.fox.app.lexer.implementation;

public class Pair<A, B> {

    public final A fst;
    public final B snd;

    public Pair(final A fst, final B snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public String toString() {
        return "Pair[" + fst + "," + snd + "]";
    }

    private static boolean equals(final Object x, final Object y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    public boolean equals(final Object other) {
        return
                other instanceof Pair &&
                        equals(fst, ((Pair) other).fst) &&
                        equals(snd, ((Pair) other).snd);
    }

    public int hashCode() {
        if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
        else if (snd == null) return fst.hashCode() + 2;
        else return fst.hashCode() * 17 + snd.hashCode();
    }

    public static <A, B> Pair<A, B> of(final A a, final B b) {
        return new Pair<A, B>(a, b);
    }
}