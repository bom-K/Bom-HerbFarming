package bomFarming;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends Frame{

	private static final long serialVersionUID = -290436493918196992L;
	public GUI(){
		BomFarming.guiRun = true;
		
		//setup display
		final JFrame frame = new JFrame("Bom's Speed Herb Farming");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel top = new JPanel();
		JLabel whichHerb = new JLabel("Select an herb seed: ");
		String[] herbs = {"Guam","Marrentill","Tarromin","Harralander","Ranarr","Toadflax","Irit Leaf","Avantoe","Kwuarm","Snapdragon","Cadantine","Lantadyme","Dwarf Weed","Torstol"};
		final JComboBox<String> selectHerb = new JComboBox<String>(herbs);
		top.add(whichHerb);
		top.add(selectHerb);
		JPanel bot = new JPanel();
		JButton submit = new JButton("Run Script");
		bot.add(submit);
		frame.setLocationRelativeTo(null);
		frame.add(top);
		frame.add(bot);
		frame.pack();
		frame.setVisible(true);
		
		//setup actions
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (selectHerb.getSelectedIndex()){
				
				case 0:
					BomFarming.SEEDid=5292;
					break;
				case 1:
					BomFarming.SEEDid=5293;
					break;
				case 2:
					BomFarming.SEEDid=5294;
					break;
				case 3:
					BomFarming.SEEDid=5295;
					break;
				case 4:
					BomFarming.SEEDid=5296;
					break;
				case 5:
					BomFarming.SEEDid=5297;
					break;
				case 6:
					BomFarming.SEEDid=5298;
					break;
				case 7:
					BomFarming.SEEDid=5299;
					break;
				case 8:
					BomFarming.SEEDid=5300;
					break;
				case 9:
					BomFarming.SEEDid=5301;
					break;
				case 10:
					BomFarming.SEEDid=5302;
					break;
				case 11:
					BomFarming.SEEDid=5303;
					break;
				case 12:
					BomFarming.SEEDid=5304;
					break;
				case 13:
					BomFarming.SEEDid=5305;
					break;
				}
				
				BomFarming.guiRun = false;
				frame.setVisible(false);
			}
		});
	}
	public static void main(String[] args){
		new GUI();
	}

}
