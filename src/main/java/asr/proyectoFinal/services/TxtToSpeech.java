package asr.proyectoFinal.services;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
//import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions.Builder;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

public class TxtToSpeech
{
	public final static String USER_NAME = "51cffcad-3cb8-4c54-aa28-fd1f0c04b502";
	public final static String PASSWORD = "uNDSYwnfUJ8v";
	
	public static void txtToSpeech(HttpServletRequest req, HttpServletResponse resp)
	{
		
		//TextToSpeech textService = new TextToSpeech(USER_NAME, PASSWORD);

		//Voice voces = textService.listVoices().execute();
		
		
		//List<Voice> voices = service.getVoices().execute();
		//System.out.println(voices);
		
		//Voice voice = textService.getVoice("en-US_AllisonVoice").execute();
		//es-ES_LauraVoice
		//fr-FR_ReneeVoice
		//pt-BR_IsabelaVoice
		//System.out.println(voice);
		
		//TextToSpeech textService = new TextToSpeech(IBM_WATSON_USERNAME, IBM_WATSON_PASSWORD);
		 //String voice = "en-US_AllisonVoice";
		//boolean download = "true".equalsIgnoreCase(req.getParameter("download"));

		InputStream in = null;
		OutputStream out = null;	
		try {
			TextToSpeech textService = new TextToSpeech(USER_NAME, PASSWORD);
	         String voice = "en-US_AllisonVoice";//req.getParameter("voice");
	         String text = req.getParameter("palabra");//req.getParameter("text");
	         String format = "audio/ogg; codecs=opus";
	         in = textService.synthesize(text, new Voice(voice, null, null), format);
	         
	         //if (download) {
	             resp.setHeader("content-disposition",
	                            "attachment; filename=transcript.ogg");
	        // }
	         
	         out = resp.getOutputStream();
	         byte[] buffer = new byte[2048];
	         int read;
	         while ((read = in.read(buffer)) != -1) {
	             out.write(buffer, 0, read);
	         }
		} catch (Exception e) {
			// Log something and return an error message
			logger.log(Level.SEVERE, "got error: " + e.getMessage(), e);
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		} finally {
		    close(in);
		    close(out);
		}
		
		/*
		try {
			  String text = "Hello world";
			  InputStream stream = service.synthesize(text, Voice.EN_ALLISON,AudioFormat.WAV).execute();
			  InputStream in = WaveUtils.reWriteWaveHeader(stream);
			  OutputStream out = new FileOutputStream("hello_world.wav");
			  byte[] buffer = new byte[1024];
			  int length;
			  while ((length = in.read(buffer)) > 0) {
			    out.write(buffer, 0, length);
			  }
			  out.close();
			  in.close();
			  stream.close();
			}
			catch (Exception e) {
			  e.printStackTrace();
			}*/
		
		
		
		/*
		//LanguageTranslator service = new LanguageTranslator();
		//service.setUsernameAndPassword(USER_NAME, PASSWORD);
		TranslateOptions translateOptions = new TranslateOptions.Builder().addText(palabra).modelId("es-en").build();
		TranslationResult translationResult = service.translate(translateOptions).execute();
		
		System.out.println(translationResult);
		
		String traduccionJSON = translationResult.toString();
		
		JsonParser parser = new JsonParser();
		JsonObject rootObj = parser.parse(traduccionJSON).getAsJsonObject();
		
		String wordCount = rootObj.get("word_count").getAsString();
		JsonArray traducciones = rootObj.getAsJsonArray("translations");
		String traduccionPrimera = palabra;
		
		if(traducciones.size()>0)
			traduccionPrimera = traducciones.get(0).getAsJsonObject().get("translation").getAsString();
		
		return traduccionPrimera;*/
	}
}
