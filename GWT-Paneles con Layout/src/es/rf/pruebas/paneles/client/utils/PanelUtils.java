package es.rf.pruebas.paneles.client.utils;

public class PanelUtils {
  
  /** Some random body text for testing in various panels. */
  
  public static String randomText() {
    String text =
      " Lorem ipsum dolor sit amet, ornare sit, accumsan nascetur libero. Sagittis rutrum mollis wisi orci"+
    " suspendisse eu, amet ipsum adipiscing amet nec. Varius enim tempus, lacus sit aliquam est egestas dictum"+
    		  " est, quis pellentesque vivamus vel urna. Litora scelerisque, integer amet at. Natoque amet. Sapien eget auctor"+
    " lectus, urna sem viverra ridiculus arcu sed, morbi risus mauris scelerisque, donec justo pellentesque rhoncus pellentesque, "+
    		  "adipiscing consectetuer integer sodales dignissim in elementum. Nulla vitae hendrerit ullamcorper, ut etiam, pharetra"+
    " morbi donec magna. Nulla phasellus torquent morbi dictum cras ultrices. Libero ut natoque consequat et ultricies, nibh quisque, "+
    		  "ligula elit in aenean, enim purus wisi orci dolor. Nunc vel vestibulum velit eu. Dis primis enim, "+
    "id elit ut dapibus quisque, vel nascetur erat a eget, neque aliquet neque erat tempor elit in. Felis sit et, enim "+
    		  "auctor massa vestibulum tempor, ipsum et, tellus blandit nec orci, et rhoncus tincidunt."+
    "Vitae vel blandit luctus, suscipit tempor venenatis et hymenaeos eget pretium, ipsum nec suspendisse est gravida ipsum,"+
    		  " ante vehicula congue mi tellus nec potenti, sem wisi suscipit. Nunc volutpat et neque, non mattis a ultrices,"+
    " vestibulum id magnis. Sed vulputate arcu, elit tristique dolor placerat est mollis class, a ipsum. Suspendisse non mi luctus ut ornare."+
    		  " Voluptatibus mauris consectetuer mollis eleifend, ut quis ad suscipit, ultrices morbi consequat cras ante mauris sodales."+
    " Condimentum maecenas elit, vel gravida neque eget at nunc, at donec tempor nulla vestibulum placerat wisi,"+
    		  " ac dictumst neque velit nibh lacus elementum, quis quam convallis nibh ipsum tristique."+
    "Commodo quam, turpis id, ac dapibus lectus, turpis luctus ut ac justo tempor curabitur. "+
    		  "Tempor ultricies, ultrices augue amet. Necessitatibus consectetuer mollit tincidunt sit, "+
    "eu orci aliquam, orci dignissim habitasse fames sit amet nostrum, euismod turpis eros sodales molestias in velit. "+
    		  "Cras egestas non sapien at laoreet, velit sit. Semper enim felis ante condimentum libero sagittis, "+
    "est enim erat vel vel et. Cum viverra, ac eleifend."+
    		  "Id libero, iaculis tellus et sociosqu tortor aenean, commodo aliquam nec lacinia quo habitasse, id nonummy. "+
    "Nostra senectus fringilla vitae suspendisse pharetra suscipit, augue egestas wisi. Ac sed aliquam nulla feugiat quam neque,"+
    		  " ac in metus, purus arcu dolor sed elit. Vulputate viverra sodales nam suspendisse gravida, quam sollicitudin pellentesque,"+
    " curabitur proin nunc sed, proin volutpat ac pharetra sed arcu eu, elit congue felis quam. Tellus nascetur. Arcu vivamus,"+
    		  " ipsum accumsan purus ac quis scelerisque vitae, at sit ipsum sit massa dui. Risus ad ipsum, rutrum eget."+
    " At consectetuer orci viverra. Tempor senectus ipsum enim, ac varius fermentum, quisque in vestibulum ut erat,"+
    		  " magna rhoncus etiam volutpat ut. Tempus feugiat hendrerit sit lectus eu, nulla ut semper, non ultrices,"+
    " eu faucibus amet est ut, rutrum feugiat dignissim congue vitae sollicitudin taciti.";
    
    for(int i=0; i<5; i++) {
      text = text + text;
    }
    return("<span class='bodyText'>" +
           text + "</span>");
  }
  
  /** Given a string like "foo13", returns 13 as an int.
   *  Returns 0 if there are problems parsing the string.
   */
  public static int findIndex(String label) {
    int index = 0;
    try {
      label = label.replaceAll("[^0-9]+", "");
      index = Integer.parseInt(label);
    } catch(Exception e) {}
    return(index);
  }
}
