package template.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
            public Integer doSomethingWithFile(BufferedReader br) throws IOException {
                int sum = 0;
                String line;
                System.out.println("sum values");
                while((line=br.readLine())!= null){
                    sum += Integer.parseInt(line);
                }
                return sum;
            }
        };
        return fileReadTemplate(filepath,sumCallback);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback mulCallback = new BufferedReaderCallback() {
            public Integer doSomethingWithFile(BufferedReader br) throws IOException {
                int ret = 1;
                String line;
                System.out.println("multiply values");
                while((line=br.readLine())!= null){
                    ret *= Integer.parseInt(line);
                }
                return ret;
            }
        };
        return fileReadTemplate(filepath,mulCallback);
    }

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try{
            System.out.println("file read");
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithFile(br);
            System.out.println("return value : "+ret);
            return ret;
        }catch(IOException exception){
            System.out.println(exception.getMessage());
            throw exception;
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException exception){
                    System.out.println(exception.getMessage());
                }
            }
        }
    }
}
