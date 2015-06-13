package bomFarming;

import org.parabot.core.Context;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.Items.Option;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.SceneObject;

public class PlantPatch implements Strategy
{

	@Override
	public boolean activate() {
		BomFarming.outOfSeeds = !Inventory.contains(BomFarming.SEEDid) && Game.isLoggedIn();
		if (BomFarming.outOfSeeds){	Context.getInstance().getRunningScript().setState(Script.STATE_STOPPED);return false;}

		return !BomFarming.outOfSeeds && !BomFarming.planted;
	}

	@Override
	public void execute() {
		
		SceneObject patch = null;
		try {
			patch = SceneObjects.getNearest(8151)[0];
			}
		catch(Exception e)
			{
				System.out.println(e);
				Context.getInstance().getRunningScript().setState(Script.STATE_STOPPED);
				return;
			}
		
		Inventory.getItem(BomFarming.SEEDid).interact(Option.USE);
		Time.sleep(200);
		Menu.sendAction(62,patch.getHash(),patch.getLocalRegionX(),patch.getLocalRegionY(),patch.getId(),1);
		
		Time.sleep(2000);
		BomFarming.seedsPlanted++;
		BomFarming.planted=!BomFarming.planted;
	}

}
