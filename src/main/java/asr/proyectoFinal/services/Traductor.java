package asr.proyectoFinal.services;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions.Builder;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

public class Traductor
{
	public final static String USER_NAME = "47d2f216-0717-4d32-a0c9-fd65421a1d78";
	public final static String PASSWORD = "i6ziPXDo4G1p";
	
	public static String translate(String palabra)
	{
		LanguageTranslator service = new LanguageTranslator();
		
		service.setUsernameAndPassword(USER_NAME, PASSWORD);
		TranslateOptions translateOptions = new TranslateOptions.Builder().addText(palabra).modelId("en-es").build();
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
		
		return traduccionPrimera;
	}
}
