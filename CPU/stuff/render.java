import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO; 
import java.awt.image.ColorModel;
import stdlib.Picture;
import java.awt.Color;

class render{


	// ▁ ▂ ▃ ▄ ▅ ▆ ▇ ▉
	static private String[] pix = { " ", "." ,":", "+" ,"=", "&","#", "@", "▉"};

	public static String[] ParseTexture(Picture pic){
		String[] build = new String[pic.height()];
		String hold = "";
		String colour = "";
		for(int i = 0; i < pic.height()-1; i++){
			//System.out.println(i);
			for(int j = 0 ; j < pic.width() ; j++){
				Color col = pic.get(j,i);
				int r = col.getRed();
				int b = col.getBlue();
				int g = col.getGreen();
				double gray = (r+g+b)/3.0;
				//System.out.println(gray + "," + ((gray/255) ));


				colour = "\u001b[38;2;"+r+";"+g+";"+b+"m";

				hold +=  colour+pix[ (int) ((gray/255) * pix.length)] ;
				

				
			}
			build[i]= hold+ "\n";
		
			hold = "";
		}
		System.out.println(build[0]);
		return build;

}

	public static void render(String[] ascii){
		for(int i = 0; i < ascii.length; i++){

			if(i%2 == 0) System.out.print(ascii[i]);
		}

}
	public static void main(String[] args){

		 Picture pic = new Picture("doom 2 start screen.jpg");
		String[] stuff=  ParseTexture(pic);
		render(stuff);

	}













}