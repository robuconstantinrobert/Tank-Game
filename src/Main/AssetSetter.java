package Main;

import object.OBJ_Ammo;
import object.OBJ_Exp;
import object.OBJ_Fuel;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) 
	{
		this.gp = gp;
		
		
	}
	
	public void setObject() 
	{
		
		gp.obj[0] = new OBJ_Ammo();
		gp.obj[0].worldX = 1 * gp.tileSize;
		gp.obj[0].worldY = 13 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Ammo();
		gp.obj[1].worldX = 14 * gp.tileSize;
		gp.obj[1].worldY = 7 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Exp();
		gp.obj[2].worldX = 7 * gp.tileSize;
		gp.obj[2].worldY = 17 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Fuel();
		gp.obj[3].worldX = 27 * gp.tileSize;
		gp.obj[3].worldY = 6 * gp.tileSize;
	}
}
