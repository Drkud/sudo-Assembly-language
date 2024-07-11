//import java.lang.Byte;
package memory;

public class Memory{


	//private Byte[] raw_Mem;
	private int[] Mem_num;
	private String[] Mem_str;
	public int size;
	// Mem_str is the string version of the memory , raw_mem is bi , and mem_num is int

	public Memory(int size){


		//this.raw_Mem = new Byte[size];
		this.Mem_num = new int[size];
		this.Mem_str = new String[size];
		for (int i = 0 ; i < size ; i++){
			this.Mem_str[i] = "0";
			this.Mem_num[i] = 0;
			//this.raw_Mem[i] = new Byte(0);
		}

		this.size = size;
		// Memory ONLY MAKES ALL ZERO MEMORY
	}

	public void set(int index, int by){
		//raw_Mem[index] = by;
		Mem_num[index] = by;
		Mem_str[index] = String.valueOf(by);
	}
	public int read(int index){
		return Mem_num[index] ;
	}
	public String readStr(int index){
		return Mem_str[index];
	}

}