package Cicurts.Cicurts;
import java.awt.Color;
import Func.fun;
import java.util.ArrayList; // import the ArrayList class
import stdlib.Picture;
import memory.Memory;


public class CU{

		Memory memory ; 
		int r0 =0; // the address
		int r1 = 0; // the function
		int r2 = 0; // the address
		int r3 =0; // inputs
		int r4 = 0;
		int r5=0;
		int r6=0;
		int r7=0;
		Picture display = new Picture(16,16);
		public ArrayList<fun> funcs = new ArrayList<fun>();
		int func_hold;
		public ArrayList<String> funcs_list = new ArrayList<String>();
		int rm =r0;
	// all r are memory pointers 

		public CU (Memory mem){
			r0 = 0;
			memory = mem;
			funcReset();
			
		}
		public void funcReset(){
			funcs.add((int[] R)  -> set(R[0],R[1]) );//1
			funcs.add((int[] R)  -> mov(R[0],R[1]) );//2
			funcs.add(  (int[] R)  -> push(R[0]) );
			funcs.add( (int[] r1)  -> pop(r1[0]) );
			funcs.add( (int[] r1)  -> inc(r1[0]) );
			funcs.add( (int[] r1)  -> dec(r1[0]) );
			funcs.add(  (int[] r1)  -> neg(r1[0]) );
			funcs.add(  (int[] r1)  -> add(r1[0],r1[1]) );
			funcs.add(  (int[]r1)  -> sub(r1[0],r1[1]) );
			funcs.add((int[]r1)  -> imul(r1[0],r1[1]) );
			funcs.add ( (int[]r1)  -> xor(r1[0],r1[1]) );
			funcs.add ((int[]r1)  -> or(r1[0],r1[1]) );
			funcs.add ((int[]r1)  -> and(r1[0],r1[1]) );
			funcs.add ((int[]r1)  -> jmp(r1[0]) );
			funcs.add ((int[]r1)  -> eqz(r1[0]));
			funcs.add ( (int[]r1)  -> neqz(r1[0]) );
			funcs.add ( (int[]r1)  -> eqn(r1[0]));
			funcs.add ((int[]r1)  -> gt(r1[0],r1[1]));
			funcs.add ( (int[] r1)  -> lt(r1[0],r1[1]));
			funcs.add ((int[] r1) -> setd(r1[0],r1[1],r1[2] ));
			funcs.add ((int[] r1) -> out(r1[0],r1[1]));

			funcs_list.add("set");
			funcs_list.add("mov");
			funcs_list.add("push");
			funcs_list.add("pop");
			funcs_list.add("inc");
			funcs_list.add("dec");
			funcs_list.add("neg");
			funcs_list.add("add");
			funcs_list.add("sub");
			funcs_list.add("imul");
			funcs_list.add("xor");
			funcs_list.add("or");
			funcs_list.add("and");
			funcs_list.add("jmp");
			funcs_list.add("eqz");
			funcs_list.add("neqz");
			funcs_list.add("eqn");
			funcs_list.add("gt");
			funcs_list.add("lt");
			funcs_list.add("setd");
			funcs_list.add("out");
		}
		public void update(){
			this.r1 = this.r0+1;
			this.r2 = this.r1+1;
			this.r3 = this.r2+1;
			this.r4 = this.r3+1;
			this.r5 = this.r4+1;
			this.r6 = this.r5+1;
			this.r7 =this.r6 +1;
			

		}

		public void run(int start){
			System.out.println("worky2");
			r0 = start;


			int hold = r0;
			int i =0; // this is to check if the program is told to stop
			while (true ){
				hold = r0;
				update();
				//System.out.println(i);
				IntToFunction(r1, r2, r3,r4,r5,r6,r7);
				// so rm is what is updated in the intTo and then the r's are set to the new values this goes until it told to stop

				if (hold == r0){

					i++;
					}
				else{
					i = 0;
					}
				if(i >= 10){
					break;
					}
			
				update();
				postdisplay();
				System.out.print("worky");
				display.show();
			}
		}
	private void IntToFunction(int r1,int r2, int r3, int r4,int r5,int r6, int r7){}


		private void set(int s , int d){
			memory.set(s,d);
	
			r0 +=8;
		
		}



		private void mov(int s , int d) {
			memory.set(d, memory.read(s));		
			// Move source to destination
			r0+=8;
		}
		private void push(int s){

		}
		private void pop(int d){

		}
		// 3.2.1 Unary Operations
		private void inc(int d){
			memory.set(d , memory.read(d) +1);
			r0+=8;
		}
		private void dec(int d){
			memory.set(d , memory.read(d) -1);
			r0+=8;
		}
		private void neg(int d){
			memory.set(d , -memory.read(d));
			r0+=8;
		}

		//3.2.2 Binary Operations

		// leaq S, D Load effective address of source into destination 178
		// add S, D Add source to destination 178
		// sub S, D Subtract source from destination 178
		// imul S, D Multiply destination by source 178
		// xor S, D Bitwise XOR destination by source 178
		// or S, D Bitwise OR destination by source 178
		// and S, D Bitwise AND destination by source 178
		private void add(int s,int d){
			memory.set(s, memory.read(s) + memory.read(d));
			r0+=8;
		}
		private void sub(int s,int d){
			memory.set(s, memory.read(s) + memory.read(d));
			r0+=8;
		}
		private void imul(int s,int d){
			memory.set(s, memory.read(s) * memory.read(d));
			r0+=8;
		}
		private void xor(int s,int d){
			memory.set(s, memory.read(s) ^ memory.read(d));
			r0+=8;
		}
		private void or(int s,int d){
			memory.set(s, memory.read(s) | memory.read(d));
			r0+=8;
		}
		private void and(int s,int d){
			memory.set(s, memory.read(s) & memory.read(d));
			r0+=8;
		}
		private void jmp(int s){
			//System.out.println("jump to " + s + ";");
			r0 = s;
		}
		// Conditional Sets
		// how this works is by skiping the next instruction if the condition is not met
		private void eqz(int s){
			if(memory.read(s) == 0  ){
				r0 +=8;
			}
			else{
				r0 +=16;
			}
		}
		private void neqz(int s){
			if(memory.read(s) == 0  ){
				r0 += 16;
			}
			else{
				r0 +=8;
			}
		}
		private void eqn(int s){
			if (memory.read(s) >= 0){
				r0 +=8;
			}
			else{
				r0 +=16;
			}
		}
		private void gt(int s , int d){
			if (memory.read(s) > memory.read(d)){
					r0 +=8;
				}
				else{
					r0 +=16;
				}
		}
		private void lt(int s , int d){
			if (memory.read(s) < memory.read(d)){
				r0 +=8;
			}
			else{
				r0 +=16;
			}
		}

		// greater order functions 


		// break down so def take over not the run function it puts all of the key words below the def untill end  then to give contorl back to the run function. the string name is stored as a lamnda function in a hashmap so you could use it agian.
	private void def(String name ,int r2, int r3){

					jmp(r2);
					func_hold = r0+8;
					funcs.add( (int[] r1) -> jmp(r1[0]));
					funcs_list.add(name);
				}
				private void end(int start){
					jmp(func_hold);
				}	
		private void setd(int x ,int y, int val ){
			int pos  = 100 ;
			pos += y * 16;
			pos += x;
			memory.set(pos,val);
			// val is a number so is x and y they are the pos of the display not memory
			postdisplay();
			}
		public void postdisplay(){
			int pos = 99;
			Color colour = new Color(0,0,0);
			for (int i = 0 ; i < 16 ; i++){
				for (int j = 0 ; j < 16 ; j++){
					pos++;
					int val = memory.read(pos);
					colour = new Color(0,95,0);
					if (val > 0) colour = new Color	(0,142,0);
					display.set(j,i,colour);
				}
			}
			display.show();
		}

		private void out(int r1 , int r2){
				int[] list = new int[memory.size];
				for(int i = 0 ; i < memory.size ; i++){

				  list[i] = memory.read(i);
				}
				for(int i  = 0 ; i < list.length ; i++){
				  if ((i >= r1) && (i <= r2))
				  System.out.println(Character.toString( (char) list[i]));
				}
				rm += 3;
			}
			private void outi(int r1 , int r2){
				//System.out.print("CALLL ME");
				int[] list = new int[memory.size];
					for(int i = 0 ; i < memory.size ; i++){

					  list[i] = memory.read(i);
					}
					for(int i  = 0 ; i < list.length ; i++){
					  if ((i >= r1) && (i <= r2))
					  System.out.println(list[i]);
					}
					rm += 3;
				}





	}





// //import Cicurts.*;
// package Cicurts;
// import memory.Memory;

// public class CU{

// 	Memory memory ; 
// 	int rm;
// 	int r0 ;
// 	int r1;
// 	int r2;

// 	int next = 0;
// 	public CU (Memory mem){
// 		memory = mem;
// 		rm = 0;
// 		r0 = memory.read(rm);
// 		r1 = memory.read(rm+1);
// 		r2 = memory.read(rm+2);
// 	}
// 	private void update(){
// 		r0 = memory.read(rm);
// 		r1 = memory.read(rm+1);
// 		r2 = memory.read(rm+2);
// 	}

// 	public void read(int index){
// 		r0 = memory.read(index);
// 	}

// 	public void start(int newR0 , int newR1){
// 		// one for function other for input
// 		rm = 0;
// 		r0 = newR0;
// 		r1 = newR1;
// 		r2 = memory.read(newR1 ++); 

// 	}
// 	public void run(int start){
// 		rm = start;
		
		
// 		int hold = rm;
// 		int i =0; // this is to check if the program is told to stop
// 		while (true ){
// 			hold = rm;
// 			update();
// 			//System.out.println(i);
// 			IntToFunction(r0, r1, r2);
// 			// so rm is what is updated in the intTo and then the r's are set to the new values this goes until it told to stop
			
// 			if (hold == rm){
				
// 				i++;
// 			}
// 			else{
// 				i = 0;
// 			}
// 			if(i >= 10){
// 				break;
// 			}
// 			//System.out.println(r1);
// 			r0 =memory.read(rm);
// 			r1 = memory.read(rm +1);
// 			r2 = memory.read(rm+2);






// 		}




// 	}
// 	private void IntToFunction(int r0,int r1,int r2){
// 		//System.out.print(r0);
// 		// r0 is not a address
// 		//System.out.println(r0);
// 		switch(r0){
// 		case 1:
// 			//System.out.print("set");
// 			set(r1,r2);
// 			break;
// 		case 2:
// 			mov(r1,r2);
// 			break;
// 		case 3:
// 			push(r1);
// 			break;
// 		case 4:
// 			pop(r1);
// 			break;
// 		case 5:
// 			inc(r1);
// 			break;
// 		case 6:
// 			dec(r1);
// 			break;
// 		case 7:
// 			neg(r1);
// 			break;
// 		case 8:
// 			add(r1, r2);
// 			break;
// 		case 9:
// 			sub(r1,r2);
// 			break;
// 		case 10:
// 			imul(r1,r2);
// 			break;
// 		case 11:
// 			xor(r1,r2);
// 			break;
// 		case 12:
// 			or(r1,r2);
// 			break;
// 		case 13:
// 			and(r1,r2);
// 			break;
// 		case 14:
// 			//System.out.println("14");
// 			jmp(r1);
// 			break;
// 		case 15:
// 			eqz(r1);
// 			break;
// 		case 16:
// 			neqz(r1);
// 			break;
// 		case 17:
// 			eqn(r1);
// 			break;

// 		case 18:
// 			gt(r1,r2);
// 			break;
// 		case 19:
// 			lt(r1,r2);
// 			break;
// 		case 20 :
// 			out(r1,r2);
// 			break;
		
// 		case 21:
// 				//System.out.print("called me");
// 				outi(r1,r2);
// 				break;
// 		case 0:
// 				break;
		
// 		}





// 	}
// 	public void stop(){

// 	}

// 	private void out(int r1 , int r2){
// 		int[] list = new int[memory.size];
// 		for(int i = 0 ; i < memory.size ; i++){

// 		  list[i] = memory.read(i);
// 		}
// 		for(int i  = 0 ; i < list.length ; i++){
// 		  if ((i >= r1) && (i <= r2))
// 		  System.out.print(Character.toString( (char) list[i]));
// 		}
// 		rm += 3;
// 	}
// 	private void outi(int r1 , int r2){
// 		//System.out.print("CALLL ME");
// 		int[] list = new int[memory.size];
// 			for(int i = 0 ; i < memory.size ; i++){

// 			  list[i] = memory.read(i);
// 			}
// 			for(int i  = 0 ; i < list.length ; i++){
// 			  if ((i >= r1) && (i <= r2))
// 			  System.out.println(list[i]);
// 			}
// 			rm += 3;
// 		}
	
// 	private void set(int s , int d){
// 		memory.set(s,d);
// 		//System.out.print(s + " = " + d);
// 		rm +=3;
// 	}



// 	private void mov(int s , int d) {
// 		memory.set(d, memory.read(s));		
// 		// Move source to destination
// 		rm+=3;
// 	}
// 	private void push(int s){

// 	}
// 	private void pop(int d){

// 	}
// 	// 3.2.1 Unary Operations
// 	private void inc(int d){
// 		memory.set(d , memory.read(d) +1);
// 		rm+=3;
// 	}
// 	private void dec(int d){
// 		memory.set(d , memory.read(d) -1);
// 		rm+=3;
// 	}
// 	private void neg(int d){
// 		memory.set(d , -memory.read(d));
// 		rm+=3;
// 	}

// 	//3.2.2 Binary Operations

// 	// leaq S, D Load effective address of source into destination 178
// 	// add S, D Add source to destination 178
// 	// sub S, D Subtract source from destination 178
// 	// imul S, D Multiply destination by source 178
// 	// xor S, D Bitwise XOR destination by source 178
// 	// or S, D Bitwise OR destination by source 178
// 	// and S, D Bitwise AND destination by source 178
// 	private void add(int s,int d){
// 		memory.set(s, memory.read(s) + memory.read(d));
// 		rm+=3;
// 	}
// 	private void sub(int s,int d){
// 		memory.set(s, memory.read(s) + memory.read(d));
// 		rm+=3;
// 	}
// 	private void imul(int s,int d){
// 		memory.set(s, memory.read(s) * memory.read(d));
// 		rm+=3;
// 	}
// 	private void xor(int s,int d){
// 		memory.set(s, memory.read(s) ^ memory.read(d));
// 		rm+=3;
// 	}
// 	private void or(int s,int d){
// 		memory.set(s, memory.read(s) | memory.read(d));
// 		rm+=3;
// 	}
// 	private void and(int s,int d){
// 		memory.set(s, memory.read(s) & memory.read(d));
// 		rm+=3;
// 	}

// 	private void jmp(int s){
// 		System.out.println("jump to " + s + ";");
// 		rm = s;
// 	}
// 	// Conditional Sets
// 	private void eqz(int s){
// 		if(memory.read(s) == 0  ){
// 			rm +=3;
// 		}
// 		else{
// 			rm +=6;
// 		}
// 	}
// 	private void neqz(int s){
// 		if(memory.read(s) == 0  ){
// 			rm += 6;
// 		}
// 		else{
// 			rm +=3;
// 		}
// 	}
// 	private void eqn(int s){
// 		if (memory.read(s) >= 0){
// 			rm +=3;
// 		}
// 		else{
// 			rm +=6;
// 		}
// 	}
// 	private void gt(int s , int d){
// 		if (memory.read(s) > memory.read(d)){
// 				rm +=3;
// 			}
// 			else{
// 				rm +=6;
// 			}

// 	}
// 	private void lt(int s , int d){
// 		if (memory.read(s) < memory.read(d)){
// 			rm +=3;
// 		}
// 		else{
// 			rm +=6;
// 		}
// 	}


// 	// no clue what leaq does so i am not adding it

// 	// GREATER FUNCTIONS
// 	// this is where the functions that are able to be made in the langue but are so useful then need to be easyer to use.
	

// }