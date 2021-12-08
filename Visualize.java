import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Visualize extends JFrame{
	private Person[][] _grid;

	public Visualize(int gridsize){
		super("Pandemic Simulator");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(gridsize * 50 + 50, gridsize * 50 + 50);
		setVisible(true);
	}

	public void timeLapse(Person[][] grid){
		_grid = grid;
		repaint();
		setVisible(true);
	}

	public void paint(Graphics g){
		super.paint(g);

		for (int x = 0; x < _grid.length; x++){
			for(int y = 0; y < _grid.length; y++){
				if (_grid[y][x].isInfected())
					g.setColor(Color.RED);
				else
					g.setColor(Color.DARK_GRAY);
				g.fillOval((x * 50 + 25), (y * 50 + 25), 45, 45);
				g.setColor(Color.BLACK);
				g.drawOval((x * 50 + 25), (y * 50 + 25), 45, 45);
			}
		}
		//g.drawString(str, x, y);
	}
}