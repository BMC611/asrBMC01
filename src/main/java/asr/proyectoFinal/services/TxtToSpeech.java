package asr.proyectoFinal.services;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions.Builder;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

/**
 * Servlet implementation class Controller
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/toSpeech"})

public class TxtToSpeech extends HttpServlet {

	private static final long serialVersionUID = 3L;
	public final static String USER_NAME = "51cffcad-3cb8-4c54-aa28-fd1f0c04b502";
	public final static String PASSWORD = "uNDSYwnfUJ8v";
	//private static Logger logger = Logger.getLogger(DemoServlet.class.getName());
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	  {
//	public static void txtToSpeech(HttpServletRequest req, HttpServletResponse resp) throws IOException
//	{
		
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
		PrintWriter outhtml = resp.getWriter();
		  outhtml.println("<html><head><meta charset=\"UTF-8\"></head><body>");
		/*InputStream stream = null;
		InputStream in = null;
		OutputStream out = null;	*/
		//Map<String, String> headers = new HashMap<String, String>();
		//headers.put("X-Watson-Learning-Opt-Out", "true");
		try {
			TextToSpeech service = new TextToSpeech();
			service.setUsernameAndPassword(USER_NAME, PASSWORD);
			//service.setDefaultHeaders(headers);
			
			
				  String text = "Hello world";
				  InputStream stream = service.synthesize(text, Voice.EN_ALLISON,AudioFormat.WAV).execute();
				  InputStream in = WaveUtils.reWriteWaveHeader(stream);
				  OutputStream out = new FileOutputStream("hello_world.wav"); //resp.getOutputStream();
				  byte[] buffer = new byte[1024];
				  int length;
				  while ((length = in.read(buffer)) > 0) {
				    out.write(buffer, 0, length);
				  }
				  
				  outhtml.println("<audio controls autoplay> <source src=\"hello_world.wav\" ></audio>");
				  outhtml.println("</html>");
				  out.close();
				  in.close();
				  stream.close();
				}
				catch (Exception e) {
				  e.printStackTrace();
				}
			
			/*
	         String text = "Hello my friend"; //req.getParameter("leerTexto");
	         //AudioFormat format = new AudioFormat("audio/ogg; codecs=opus");
	         Voice voice = service.getVoice("en-US_AllisonVoice").execute(); //Voice.ES_LAURA
	         stream = service.synthesize(text, voice).execute();
	         //in = (InputStream) textService.synthesize(text, new Voice(voice, null, null));
	         
	         in = WaveUtils.reWriteWaveHeader(stream);
	         //if (download) {
	       //      resp.setHeader("content-disposition",
	         //                   "attachment; filename=transcript.ogg");
	        // }
	         
	         out = resp.getOutputStream();
	         byte[] buffer = new byte[1024];//[2048];
	         int length;
	         while ((length = in.read(buffer)) != -1) {
	             out.write(buffer, 0, length);
	         }
		} catch (Exception e) {
			// Log something and return an error message
			System.out.println(e.getMessage());
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
		    
		    out.close();
		    in.close();
		    stream.close();
		    
			    */
		
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
