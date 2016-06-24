import controllers.Application;
import org.junit.Test;
import play.mvc.Results;
import play.twirl.api.Content;
import views.html.index;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void indexTest() {
        Application application = new Application();
        assertEquals(application.index().toString(), Results.ok(index.render("Your new application is ready.")).toString());
    }

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void testString() {
        String str = "Hello world";
        assertFalse(str.isEmpty());
    }

    @Test
    public void testSum() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", contentType(html));
        assertTrue(contentAsString(html).contains("Your new application is ready."));
    }

}
