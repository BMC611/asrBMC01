package asr.proyectoFinal.services;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions.Builder;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

public class TxtToSpeech
{
	public final static String USER_NAME = "51cffcad-3cb8-4c54-aa28-fd1f0c04b502";
	public final static String PASSWORD = "uNDSYwnfUJ8v";
	
	public static void txtToSpeech(String palabra)
	{
		
		TextToSpeech service = new TextToSpeech(USER_NAME, PASSWORD);
		
		//List<Voice> voices = service.getVoices().execute();
		//System.out.println(voices);
		
		Voice voice = service.getVoice("en-US_AllisonVoice").execute();
		//es-ES_LauraVoice
		//fr-FR_ReneeVoice
		//pt-BR_IsabelaVoice
		//System.out.println(voice);
		
		//TextToSpeech textService = new TextToSpeech(IBM_WATSON_USERNAME, IBM_WATSON_PASSWORD);
		 //String voice = "en-US_AllisonVoice";
		 String text = "This is Just awesome And i am going to experience the effect";
		 //String format = "audio/mp3";
		 try {
		     InputStream in = service.synthesize(text, Voice.EN_ALLISON, AudioFormat.OGG_VORBIS)
		             .execute();
		     System.out.println(in.available());
		 } catch (IOException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
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
