//package application;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;



public class Main extends Application {
	Stage primaryStage;
	boolean changeColor = false;

	GridPane grid = new GridPane();
	Labyrint lab = null;
	Stabel<String>list = new Stabel<String>() ;
	boolean [][]bol;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
			primaryStage.setTitle("Choose a labyrint file");
			HBox topBox = setToppBox();
			//topBox.getChildren().add(grid);
			VBox root = new VBox(topBox);



			Scene scene = new Scene(root,600,900);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();


			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Creating a factory method the be passed to the root
	 * @return HBox
	 */
	private HBox setToppBox() {
		 TextField text = new TextField();

		Button chooseFile = new Button("Choose File...");
		chooseFile.setOnAction(new FileChooser1(text));


		Button insertBtn = new Button("Insert");
		insertBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				File fil = new File(text.getText());
				try{
					 lab = Labyrint.lesFraFil(fil);

				readFromFile(fil);

			}catch (Exception e) {

			}
			Scene maze = new Scene(grid,1800,1800);
			//GridPane.setHgrow(box, Priority.Always);


			primaryStage.setScene(maze);
			primaryStage.sizeToScene();
			//	Scene maze = new Scene(grid,600,600, Color.YELLOW);
				//primaryStage.setScene(maze);

			}
		});


		HBox returnBox = new HBox(50,chooseFile, text, insertBtn);
		return returnBox;

	}



	private  void readFromFile(File fil) throws FileNotFoundException {
		Scanner scanner = new Scanner(fil);
		String[]  cordinates = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(cordinates[0]);
		int colomns = Integer.parseInt(cordinates[1]);
		bol = new boolean [rows][colomns];
		GridPane g = new GridPane();

		//GridPane grid1 = new GridPane();
		int x = 0;
		while(scanner.hasNextLine()) {

			String reader = scanner.nextLine();
			char[] splitter = reader.toCharArray();
			for(int i =0; i< splitter.length; i++) {
				if(splitter[i] == '#'){
					Rectangle black = setRute(Color.BLACK, Color.WHITE, x, i);
					//black.setOnMouseClicked(new Klickt(black,x,i,rows, colomns));

				//	black.setOnMouseAction()
					//black.setStroke(Color.WHITE);
					//maze.array[x][i]= black;
					g.add(black, i, x);
				}else{
					if(x>0 && x< rows-1 && i>0 && i<colomns-1){
						Rectangle white = setRute(Color.WHITE, Color.BLACK, x, i);


					//	white.setOnMouseClicked(new Klickt(white,x,i,rows, colomns));

					//	white.setStroke(Color.BLACK);

						//maze.array[x][i] = white;
						g.add(white, i, x);

					}else{
						Rectangle open = setRute(Color.WHITE, Color.BLACK, x, i);//new Rectangle(60,60, Color.WHITE);
					//	open.setOnMouseClicked(new Klickt(open,x,i,rows, colomns));

					//	open.setStroke(Color.BLACK);

						//maze.array[x][i] = open;
						g.add(open,i,x);

					}


				}


			}
			x++;
		}



		grid = g;
	}
	private Rectangle setRute(Color normal, Color border,int row,int colomn){
		Rectangle rec = new Rectangle(20,20, normal);
		rec.setStroke(border);
		//grid.add(rec, colomn, row);
		if (normal == Color.WHITE) {
			rec.setOnMouseClicked(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent m){
					 list = lab.finnUtveiFra(colomn+1, row+1);
					if (!list.erTom()) {
						String  s = list.fjern();
						bol =	lab.losningStringTilTabell(s, lab.antallKoloner, lab.antallRader);
						for(int i =0; i< lab.antallRader; i++){

							for(int j = 0; j< lab.antallKoloner; j++){
						if (bol[i][j]) {
							System.out.println(bol[i][j]);
							System.out.println(lab.array[row][colomn].getCord());
							System.out.println(""+ colomn+""+ row);
							Rectangle rec1 = new Rectangle(20,20, Color.BLUE);

							//rec.setFill(Color.BLUE);
							grid.add(rec1, j, i);
						}
					}



					}
				}
			}
			});
		
		}

		return rec;

	}


	public static void main(String[] args) {
		launch(args);
	}
/**
	private class Klickt implements EventHandler<MouseEvent> {
		private final int row , colomn, rows, colomns;
		Rectangle rec ;
		public Klickt(Rectangle rec,int row,int  colomn,int rows,int colomns){
			this.row = row+1;
			this.colomn= colomn+1;
			this.rec = rec;
			this.rows = rows;
			this.colomns = colomns;
			//bol = new boolean[colomns][rows];
		}
		@Override
		public void handle(MouseEvent m){
			Stabel<String>list = lab.finnUtveiFra(colomn, row);
			System.out.println(list);
			if(list.erTom()){
				System.out.println("no solution");
				System.exit(0);
			}else{

				String s = list.fjern();
			bol =	lab.losningStringTilTabell(s, colomns, rows);
			for(int i =0; i< lab.antallRader-1; i++){

				for(int j = 0; j< lab.antallKoloner; j++){
			if (bol[row-1][colomn-1]) {
				//System.out.println(" there si a solution"+ row +" co"+ colomn);
				Rectangle ny = new Rectangle(40,40, Color.BLUE);

				//rec.setFill(Color.BLUE);
				grid.add(ny, colomn, row);
			}else{
				rec.setFill(Color.RED);

				System.out.println(" not a part of solution"+ row +" co"+ colomn);
			}
		}



		}
	}
}
}*/
	private class FileChooser1 implements EventHandler<ActionEvent>{
		TextField text;
		public FileChooser1(TextField text) {
			// TODO Auto-generated constructor stub
			this.text = text;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Choose a file");
			/**fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files","*.in","*.txt"),
					new ExtensionFilter("Media Files","*.mp3"),
					new ExtensionFilter("All Files","*.")
					);*/
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				text.setText(selectedFile.getPath());
				//System.out.println(selectedFile.getPath());
			}
		}
	}
}
