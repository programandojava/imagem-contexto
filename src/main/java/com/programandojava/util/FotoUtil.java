package com.programandojava.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.programandojava.entity.Foto;

public class FotoUtil implements Serializable {
	private static final long serialVersionUID = -7538592532189320120L;
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-SSS");
	public static final String FOLDER = File.separator + "programandoJava" + File.separator;

	public static Foto handlePicture(byte[] imageToHandle) {
		String nomeFoto = DATE_FORMAT.format(Calendar.getInstance().getTime()) + ".png";
		
		Foto foto = new Foto(nomeFoto);
		
		try {
			salvarNoDisco(ImageIO.read(new ByteArrayInputStream(imageToHandle)), nomeFoto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return foto;
	}
	
	private static void salvarNoDisco(BufferedImage fotoSalvar, String nomeFoto) throws IOException{
		File f = new File(FOLDER);
		
		if(!f.exists()){
			f.mkdirs(); f.setReadable(true); f.setWritable(true);
		}
		
		ImageIO.write(fotoSalvar, "png", new File(FOLDER + nomeFoto));
	}
	
	public static StreamedContent recuperarFotoDisco(String fotoNome) throws FileNotFoundException{
		try {
			return new DefaultStreamedContent(new FileInputStream(new File(FOLDER + fotoNome)), "image/png");
		} catch (IOException e) {
			e.printStackTrace();
			
			return new DefaultStreamedContent(new FileInputStream(new File(FOLDER + "DEFAULT.png")), "image/png");
		}
	}
}