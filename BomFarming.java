package bomFarming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import org.parabot.core.Context;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;


@ScriptManifest(author = "BOM", category = Category.FARMING, description = "Speed Farming herbs for IKOV......(1)Have a rake, secateurs, seed dibber, and SEEDS in your inventory. (2) Be near the herb patch in Catherby. ", name = "bomHerbFarming", servers = { "Ikov" }, version = 1)
public class BomFarming extends Script implements Paintable{

		public static final int RAKE = 5342;
		public static int SEEDid;
		
		public static boolean guiRun = false;
		public static boolean planted = true;
		public static boolean hasRAKE = false;
		public static int seedsPlanted = 0;
		private static final int startExp = Skill.getCurrentExperience(Skill.FARMING.getIndex());
		private Timer runTime = new Timer();
		public static Boolean outOfSeeds= true;
		private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
		

		@Override
		public boolean onExecute() {
			
			new GUI();
			while(guiRun)
			{
				Time.sleep(500);
			}
			strategies.add(new ClearPatch());
			strategies.add(new PlantPatch());
			provide(strategies);
			return true;
			
		}	
			

		@Override
		public void onFinish() {
			Time.sleep(1000);
			Context.getInstance().getRunningScript().setState(STATE_STOPPED);
			
		}
		
		//Basic paint (not my creation)
		@Override
	    public void paint(Graphics g) {
			int expGained = Skill.getCurrentExperience(Skill.FARMING.getIndex())-startExp;
		    int seedsHr = (int) (seedsPlanted*3600000.0D/runTime.getElapsedTime());
		    int expHr = (int) (expGained*3600000.0D/runTime.getElapsedTime());
		    Graphics2D g2 = (Graphics2D)g;
		    Graphics2D gRect = (Graphics2D)g;
		    gRect.fill3DRect(300, 363, 200, 125,true);
		    gRect.setBackground(Color.black);
		    shadowedString(g2,"Bom's speed farmer",310,380);
			shadowedString(g2,"Runtime: "+runTime.toString(), 310,400);
			shadowedString(g2,"Seeds planted: "+seedsPlanted, 310,420);
			shadowedString(g2,"Seeds planted per hour: "+seedsHr, 310,440);
			shadowedString(g2,"EXP gained: "+expGained, 310,460);
			shadowedString(g2,"EXP gained per hour: "+expHr, 310,480);
			
		}
	    public void shadowedString(Graphics g, String text, int x, int y){
			g.setColor(Color.green);
			g.drawString(text, x+1, y-1);
			g.setColor(Color.white);
			g.drawString(text, x, y);
		}


}
