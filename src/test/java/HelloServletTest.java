import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.example.jenkinsdemo.HelloServlet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    HelloServlet helloServlet;
    StringWriter stringWriter;
    PrintWriter writer;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        helloServlet = new HelloServlet();
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
    }

    @Test
    public void shallReturnHelloWithName() throws IOException {
        when(request.getPathInfo()).thenReturn("/john");
        when(response.getWriter()).thenReturn(writer);

        helloServlet.doGet(request, response);
        writer.flush();

        assertTrue(stringWriter.toString().contains("Hello john!"));
    }

    @Test
    public void shallReturnHelloWithGuest() throws IOException {
        when(request.getPathInfo()).thenReturn(null);
        when(response.getWriter()).thenReturn(writer);

        helloServlet.doGet(request, response);
        writer.flush();

        assertTrue(stringWriter.toString().contains("Hello Guest!"));
    }
}
