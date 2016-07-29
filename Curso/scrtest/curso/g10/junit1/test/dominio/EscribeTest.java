package dominio;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class EscribeTest {

	@Test
	public void testWriteASentence() throws IOException {
	  FileWriter writer = mock(FileWriter.class);

	  writeASentence (writer);
	}

}
