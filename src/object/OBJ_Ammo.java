package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Ammo extends SuperObject{
	
	public OBJ_Ammo() 
	{
		name = "Ammo";
		try 
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/ammo.png"));
			
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		collision = true;
	}
}
