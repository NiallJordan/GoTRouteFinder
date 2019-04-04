
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
import xmlhandle.JAXBMarshalling;

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

	@FXML
	MenuBar menuBar;
	@FXML
	Menu settingsMenu, systemMenu;
	@FXML
	MenuItem refreshMenuItem, exitMenuItem, aboutMenuItem, stopMusicMenuItem;
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
		imageHeight = mapImage.getHeight();
		imageWidth = mapImage.getWidth();
		mapImageView.setFitHeight(imageHeight);
		mapImageView.setFitWidth(imageWidth);
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
		initialize();
	}

	@FXML
	public void showAboutMenu(ActionEvent e) {
		System.out.println("Showing authorship");
		JOptionPane.showMessageDialog(null, "This Project has been created for Data And Algorithms 2 Continous assesment \n by: Hubert Stefanski, Niall Jordan and Oliver Baverstock");
		System.out.println("Authorship shown");
	}

	@FXML
	public void exit(ActionEvent e) {
		System.out.println("Process has been terminated");
		Platform.exit();
	}

}
