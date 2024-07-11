// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

import Cicurts.CU;
import memory.Memory;
import stdlib.In;
import Func.fun;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) {

    In in= new In("scirpt.txt");
    Memory mem = new Memory(10000);
      int rm=0 ;
      int r0 ;
      int r1 ;
      int r2 ;
      int r3 ;
      int r4 ;
      int r5 ;
      int r6 ;
      int r7 ;
      int[] rs = new int[8];
      String line = in.readLine();
      rm=Integer.parseInt(line);
      int start = rm;
      int func_num;
      CU computer = new CU(mem);// pls fix bad var name
      while(in.hasNextLine()){
        
        line = in.readLine();
        rs[0]=read(line,computer);
        rs = rsMakyer(rs[0],line); // we are taking the rs[0] to add to the list
        

        if (rs[0] >= 0){
          System.out.println("worky");
          computer.funcs.get(rs[0]).run(Arrays.copyOfRange(rs,1,8));
        }
      
        

      }
    
  }
  public static int read(String line,CU computer){


    for(int i = 0 ; i < computer.funcs_list.size() ; i++){
   
      if (trim(line).equals(computer.funcs_list.get(i))){
      
        return i;
      }
    }
    return -1;
  }
  

  public static String trim(String line){
    // to break up strings in to parts
    String build = "";
    for (int i = 0 ; i < line.length(); i++){
      if ( line.substring(i,i+1).equals(" ")) return build;
      build += line.charAt(i);
      
    }
    return "";
  }
  public static int[] rsMakyer(int func_num,String line){
    int[] build = new int[8];
    String[] list = line.split(" ");
    build[0] = func_num;
    int hold =0;
    for(int i =1 ; i < 8;i++){
      if(i == 0 ){
        build[i] = func_num;;
        
      }
      else{
        try{
          
          build[i] = Integer.parseInt(list[i]);
        }
        catch(Exception e){
          build[i]=0;
        }

      }
    }
    return build;
} 
}   
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
