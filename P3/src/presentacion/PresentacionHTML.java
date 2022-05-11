package presentacion;

public class PresentacionHTML {
	public static final String DOCTYPE = "<!DOCTYPE html>";
	public static final String CIERRE = "</body>\n</html>";

	public static String CabecerasConCss(String titulo, String estilo) {
		StringBuilder stb = new StringBuilder();
		stb.append("<html>");
		stb.append("<head>");
		stb.append("<meta charset=\"UTF-8\">");
		stb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + estilo + "\">");
		stb.append("<link rel=\"icon\" href=\"favicon.ico\"  type=\"image/icon type\">\n"
				+ "");
		stb.append("<title>" + titulo + "</title>\n");
		stb.append("</head>");
		stb.append("<body>");
		//stb.append("");
		return stb.toString();

	}
	
	public static String CabeceraYCuerpo(String cuerpo,String titulo) {
		StringBuilder stb= new StringBuilder();
		stb.append("<html>");
		stb.append("<head>");
		stb.append("<meta charset=\"UTF-8\">");
		stb.append("<title>"+titulo+"</title>");
		stb.append("</head>");
		stb.append("<body>");
		stb.append(cuerpo);
		return stb.toString();
	}
	public static String CabecerasConCssYCuerpo(String titulo, String estilo, String cuerpo) {
		StringBuilder stb = new StringBuilder();
		stb.append("<html>");
		stb.append("<head>");
		stb.append("<meta charset=\"UTF-8\">");
		stb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + estilo + "\">");
		stb.append("<link rel=\"icon\" href=\"favicon.ico\"  type=\"image/icon type\">\n"
				+ "");
		stb.append("<title>" + titulo + "</title>\n");
		stb.append("</head>");
		stb.append("<body>");
		stb.append(cuerpo);
		return stb.toString();

	}
}