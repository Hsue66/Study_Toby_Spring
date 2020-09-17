package template.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        try{
            int sum = 0;
            String line;
            while((line=br.readLine())!= null){
                sum += Integer.parseInt(line);
            }
            return sum;
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

    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        try{
            int ret = 1;
            String line;
            while((line=br.readLine())!= null){
                ret *= Integer.parseInt(line);
            }
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
