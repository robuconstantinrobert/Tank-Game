package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Medal extends SuperObject {
	public OBJ_Medal() 
	{
		name = "Medal";
		try 
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/medal.png"));
			
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
