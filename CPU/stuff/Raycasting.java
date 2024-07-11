




class Raycasting{



	//1 1 1 1 1
	//1 0 0 0 1
	//1 0 1 0 1
	//1 2 0 0 1 
	//1 1 1 1 1


	int[] map
	int playerX =0;
	int playerY =0;
	double playerAngle = 0;
	public Raycasting(int[] map){
		this.map = map;
	}


	private double getHorizontal(int x,int y , double angle){
		 return y/Math.tan(angle);
	}
	private double getVertival(int x,int y , double angle){
		 return x*Math.tan(angle);
	}

	private double getInt(int x,int y , double angle){

		whlie(true){
			double xs=getHorizontal(x,y,angle);
			double ys=getvertival(x,y,angle);
			if ([(int) ys+y][(int) xs+x] == 1)]){
				return Math.sqrt(xs*xs + ys*ys);
			}
			x = (int) xs;
			y = (int) ys;
		}
		return 0;
	}


	
}