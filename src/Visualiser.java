import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualiser extends JPanel {

	static int maxDataAmount = 1000;
	static int currentDataAmount = 15;
	static ArrayList<Integer> data = utils.Utils.genTestingData(currentDataAmount, 600);

	static int WIDTH = 1280;
	static int HEIGHT = 720;

	static int currIndex = 0;

	public Visualiser() {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Visualiser vis = new Visualiser();
		vis.setDoubleBuffered(true);

		JFrame frame = new JFrame("Algorithm Sorter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(vis);

		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
		// Enable double buffering
		// Less accurate but completely needed due to "refresh flashing"
		vis.setDoubleBuffered(true);

		while (true) {
			if (!utils.Utils.testData(data)) {
				// bubbleSort();
				// bogoSort();
				selectionSort();
			} else {
				// Give time to look at sorted Data
				Thread.sleep(1500);
				
				currIndex = 0;
				int nextAmt = (new Random().nextInt(maxDataAmount)) + 1;
				
				// Less deviation = less space on right side of screen.
				// Not the best way to solve this issue but a way nonetheless.
				while (WIDTH % nextAmt > 15) {
					nextAmt = (new Random().nextInt(maxDataAmount)) + 1;
				}
				currentDataAmount = nextAmt;
				data = utils.Utils.genTestingData(currentDataAmount, 600);
			}

			// Slow down progress to allow viewing data being sorted.
			Thread.sleep(17);

			// Canvas Refreshing
			vis.repaint();
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		int spaceBetween = 1;
		int squareSize = (WIDTH - (currentDataAmount * spaceBetween)) / currentDataAmount;
		int squareSpace = squareSize + spaceBetween;

		int offset = 0;
		for (int val : data) {
			g.setColor(Color.white);
			g.fillRect(offset * squareSpace, this.getHeight() - val, squareSize, val);
			offset++;
		}
	}

	public static void selectionSort() {
		int minValIndex = currIndex;
		for (int i = currIndex; i < data.size(); i++) {
			if ((data.get(i) < data.get(currIndex)) && (data.get(i) < data.get(minValIndex))) {
				minValIndex = i;
			}
		}

		if (minValIndex != currIndex) {
			int val1 = data.get(currIndex);
			int val2 = data.get(minValIndex);
			data.set(minValIndex, val1);
			data.set(currIndex, val2);
		}

		currIndex++;
	}

	public static void bogoSort() {
		int ranSpot1 = ThreadLocalRandom.current().nextInt(0, data.size());
		int ranSpot2 = ThreadLocalRandom.current().nextInt(0, data.size());

		int val1 = data.get(ranSpot1);
		int val2 = data.get(ranSpot2);

		data.set(ranSpot1, val2);
		data.set(ranSpot2, val1);
	}

	public static void bubbleSort() {
		for (int i = 0; i < data.size(); i++) {
			if ((i + 1) < data.size()) {
				int dot = data.get(i);
				int dot1 = data.get(i + 1);

				if (dot > dot1) {
					data.set(i, dot1);
					data.set(i + 1, dot);
				}
			}
		}
	}

}