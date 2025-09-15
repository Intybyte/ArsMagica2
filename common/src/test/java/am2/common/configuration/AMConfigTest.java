package am2.common.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class AMConfigTest {
	@Test
	void testWithNoFile(@TempDir Path tempDir) {
		Path filePath = tempDir.resolve("AM2_config.cfg");
		File file = filePath.toFile();

		AMConfig.init(file);

		AMConfig cfg = AMConfig.getInstance();

		assertNotNull(cfg);

		assertEquals(8, cfg.getWorldgen().getChimerite().getFrequency());
	}

	@Test
	void testWithFile(@TempDir Path tempDir) throws IOException {
		Path filePath = tempDir.resolve("AM2_config.cfg");
		File file = filePath.toFile();
		file.createNewFile();

		AMConfig.init(file);

		AMConfig cfg = AMConfig.getInstance();

		assertNotNull(cfg);

		assertEquals(8, cfg.getWorldgen().getChimerite().getFrequency());
	}
}
