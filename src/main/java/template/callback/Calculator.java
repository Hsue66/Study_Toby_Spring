package template.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        LineReaderCallback sumCallback = new LineReaderCallback() {
            @Override
            public Integer doSomethingWithLine(String line, int value) {
                System.out.println("calculate");
                return value+Integer.parseInt(line);
            }
        };
        return lineReadTemplate(filepath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineReaderCallback mulCallback = new LineReaderCallback() {
            @Override
            public Integer doSomethingWithLine(String line, int value) {
                return value*Integer.parseInt(line);
            }
        };
        return lineReadTemplate(filepath, mulCallback, 1);
    }

    private Integer lineReadTemplate(String filepath, LineReaderCallback callback, int value) throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            String line;
            System.out.println("file read by line");
            while((line=br.readLine())!=null){
                value = callback.doSomethingWithLine(line,value);
                System.out.println(value);
            }
            System.out.println("return value : "+value);
            return value;
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

    /*private Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
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
    }*/
}
