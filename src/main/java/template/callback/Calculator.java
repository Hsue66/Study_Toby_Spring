package template.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        LineReaderCallback<Integer> sumCallback = (line,value) -> value+Integer.parseInt(line);
        return lineReadTemplate(filepath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineReaderCallback<Integer> mulCallback = (line, value) -> value*Integer.parseInt(line);
        return lineReadTemplate(filepath, mulCallback, 1);
    }

    public String concatLines(String filepath) throws IOException {
        LineReaderCallback<String> concatCallback = (line, value) -> value+line;
        return lineReadTemplate(filepath, concatCallback, "");
    }

    private <T> T lineReadTemplate(String filepath, LineReaderCallback<T> callback, T value) throws IOException {
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
