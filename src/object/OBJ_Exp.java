package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Exp extends SuperObject{
	
	public OBJ_Exp() 
	{
		name = "Exp";
		try 
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/exp.png"));
			
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
