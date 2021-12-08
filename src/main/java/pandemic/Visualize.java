package pandemic;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;


public class Visualize extends JFrame{
	private Person[][]	_grid = {};
	private int			_windowSize;

	public Visualize(int gridsize){
		super("Pandemic Simulator");

		if (gridsize < 16)
			_windowSize = 50;
		else if (gridsize < 26)
			_windowSize = 30;
		else if (gridsize < 40)
			_windowSize = 20;
		else
			_windowSize = 15;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(gridsize * _windowSize + 50, gridsize * _windowSize + 50);
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
				g.fillOval((x * _windowSize + 25), (y * _windowSize + 30), _windowSize - 5, _windowSize - 5); 
				g.setColor(Color.BLACK);
				g.drawOval((x * _windowSize + 25), (y * _windowSize + 30), _windowSize - 5, _windowSize - 5);
			}
		}
	}
}