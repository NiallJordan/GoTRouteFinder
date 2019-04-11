
package application;

import javafx.scene.control.Button;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/*
 * @author Hubert stefanski
 *this class is responsible for running the scene and calling all relevant methods/classes to execute appropriate actions
 */

public class MainMenuController {
	private static File mapFile;
	private static BufferedImage bufferedMapImage;
	public static Image mapImage;
	public static double imageHeight;
	public static double imageWidth;
	public static ImageView mapImageViewStatic;

	@FXML
	MenuBar menuBar;
	@FXML
	Menu settingsMenu, systemMenu;
	@FXML
	MenuItem refreshMenuItem, exitMenuItem, aboutMenuItem, stopMusicMenuItem, overlayGraphMenuItem;
	@FXML
	ImageView backgroundImageView;
	@FXML
	ImageView mapImageView;
	@FXML
	Button findRoutesButton;
	@FXML
	ChoiceBox<String> originChoiceBox, destinationChoiceBox, waypointChoiceBox, avoidChoiceBox; // rawType to be
																								// determined
	@FXML
	AnchorPane mapImageAnchorPane;

	@FXML
	public void initialize() {
//		try {
//			JAXBMarshalling.loadMapGraph("resources/GoTGraph.xml");
//		} catch (JAXBException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		mapImageViewStatic=mapImageView;
		
		System.out.println("init");
		URL mapUrl = getClass().getResource("GoTMap.png");
		mapFile = new File(mapUrl.getPath());
		try {
			bufferedMapImage = ImageIO.read(mapFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Sets imageView and AnchorPane size to the resolution of the image, that way
		// regardless of what map is loaded in it will work
		mapImage = SwingFXUtils.toFXImage(bufferedMapImage, null);

		imageWidth = mapImage.getWidth();
		imageHeight = mapImage.getHeight();
		mapImageView.setFitWidth(imageWidth);
		mapImageView.setFitHeight(imageHeight);
		mapImageAnchorPane.setMinSize(imageWidth, imageHeight);
		mapImageView.setImage(mapImage);
		SoundFactory.playSound();

	}

	@FXML
	public void stopMusic(ActionEvent e) {
		SoundFactory.stopSound();

	}

	@FXML
	public void refreshApp(ActionEvent e) {
		mapImageView.setImage(mapImage);
	}

	@FXML
	public void overlayGraph(ActionEvent e) {
		BufferedImage bufferedMapImageToConvert = SwingFXUtils.fromFXImage(mapImage, null);
		GraphOverlayFactory.drawGraphOverImage(bufferedMapImageToConvert);

	}

	@FXML
	public void showAboutMenu(ActionEvent e) {
		System.out.println("Showing authorship");
		JOptionPane.showMessageDialog(null,
				"This Project has been created for Data And Algorithms 2 Continous assessment \n by: \n Hubert Stefanski \n Niall Jordan \n and \n Oliver Baverstock");
		System.out.println("Authorship shown");
	}

	@FXML
	public void exit(ActionEvent e) {
		System.out.println("--------------------Process has been terminated--------------------");
		Platform.exit();
	}

	public static double getImageHeight() {
		return imageHeight;
	}

	public static void setImageHeight(double imageHeight) {
		MainMenuController.imageHeight = imageHeight;
	}

	public static double getImageWidth() {
		return imageWidth;
	}

	public static void setImageWidth(double imageWidth) {
		MainMenuController.imageWidth = imageWidth;
	}

}
