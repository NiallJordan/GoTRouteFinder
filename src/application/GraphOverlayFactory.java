package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.xml.bind.JAXBException;

import graph.Edge;
import graph.Node;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import map.MapGraph;
import map.MapPath;
import map.MapPoint;
import xmlhandle.JAXBMarshalling;

public class GraphOverlayFactory {
	public BufferedImage localBufferedMapImage;
	public static MapGraph mapGraph;
	public static String loadPath = "resources/GoTGraph.xml";

	public static void drawGraphOverImage(BufferedImage localBufferedMapImage) {
		localBufferedMapImage = SwingFXUtils.fromFXImage(MainMenuController.mapImage, null);
		Graphics graphics = localBufferedMapImage.getGraphics();

		try {
			mapGraph = JAXBMarshalling.loadMapGraph(loadPath);
			for (MapPoint point : mapGraph.getNodes()) {
				graphics.fillOval(point.getxCoord() - 5, point.getyCoord() - 5, 15, 15);
				graphics.setColor(Color.YELLOW);
				graphics.drawString(point.getName(), point.getxCoord() + 10, point.getyCoord());
//				List<MapPoint> neighbors = point.getNeighbors();
				for (MapPoint point2 : point.getNeighbors()) {
//					System.out.println("node " +point+ " is connected to "+point2);
					System.out.println("Overlaying graph");
					graphics.drawLine(point.getxCoord(), point.getyCoord(), point2.getxCoord(), point2.getyCoord());
					graphics.drawString(point2.getName(), point2.getxCoord() + 10, point2.getyCoord());

				}

			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainMenuController.mapImageViewStatic.setImage(SwingFXUtils.toFXImage(localBufferedMapImage, null));
		graphics.dispose();
	}

}
