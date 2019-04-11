package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.xml.bind.JAXBException;

import javafx.embed.swing.SwingFXUtils;

import map.MapGraph;
import map.MapPoint;
import xmlhandle.JAXBMarshalling;

public class GraphOverlayFactory {
	public BufferedImage localBufferedMapImage;
	public static String loadPath = "resources/GoTGraph.xml";

	public static void drawGraphOverImage(BufferedImage localBufferedMapImage) {
		localBufferedMapImage = SwingFXUtils.fromFXImage(MainMenuController.mapImage, null);
		Graphics graphics = localBufferedMapImage.getGraphics();
		graphics.setColor(Color.YELLOW);
		MapGraph mapGraph = null;

		try {
			mapGraph = JAXBMarshalling.loadMapGraph(loadPath);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (MapPoint point : mapGraph.getNodes()) {
		//	graphics.drawOval(point.getxCoord()-5,point.getyCoord()-5 , 15, 15);
			graphics.fillOval(point.getxCoord()-5,point.getyCoord()-5 , 15, 15);
			graphics.setColor(Color.YELLOW);

		}
		MainMenuController.mapImageViewStatic.setImage(SwingFXUtils.toFXImage(localBufferedMapImage, null));
		graphics.dispose();

	}

}
