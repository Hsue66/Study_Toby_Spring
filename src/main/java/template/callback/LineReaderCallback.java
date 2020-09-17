package template.callback;

public interface LineReaderCallback<T> {
    public T doSomethingWithLine(String line, T value);
}
