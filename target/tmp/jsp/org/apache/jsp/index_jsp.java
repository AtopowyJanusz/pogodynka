package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import services.SelectCityGenerator;
import services.ShowWeather;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />\n");
      out.write("    <title>Pogoda</title>\n");
      out.write("\n");
      out.write("    ");
      services.OpenWeatherMapApi apiService = null;
      synchronized (application) {
        apiService = (services.OpenWeatherMapApi) _jspx_page_context.getAttribute("apiService", PageContext.APPLICATION_SCOPE);
        if (apiService == null){
          apiService = new services.OpenWeatherMapApi();
          _jspx_page_context.setAttribute("apiService", apiService, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("apiService"), "city", request.getParameter("city"), request, "city", false);
      out.write("\n");
      out.write("\n");
      out.write("    ");
 SelectCityGenerator selectCityGenerator = new SelectCityGenerator("src/cityPL"); 
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h2>Aktualna pogoda w Polsce:</h2>\n");
      out.write("<br>\n");
      out.write("<form action=\"index.jsp\">\n");
      out.write("    Miejsce:&nbsp\n");
      out.write("    <select name=\"city\">\n");
      out.write("        ");
      out.print(selectCityGenerator.make());
      out.write("\n");
      out.write("    </select>\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"wybierz\">\n");
      out.write("</form>\n");
      out.write("\n");
 if (apiService.getCity()!=null) {
    ShowWeather showWeather = new ShowWeather();
    out.print(showWeather.make(apiService));
} 
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
