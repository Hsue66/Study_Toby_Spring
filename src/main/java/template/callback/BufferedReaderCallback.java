package template.callback;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {
    public Integer doSomethingWithFile(BufferedReader br) throws IOException;
}
