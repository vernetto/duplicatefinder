package org.pierre.duplicatefinder;

import java.io.FileInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class ScanService {

	public String scan(String folder) throws Exception {
		System.out.println("scanning " + folder);
		Path dir = Paths.get(folder);

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path entry : stream) {
				if (entry.toFile().isFile()) {
					FileInputStream fis = new FileInputStream(entry.toFile());
					String md5 = DigestUtils.md5Hex(fis);
					fis.close();
					System.out.println(entry.toString() + " md5=" + md5);
				}
			}
		}
		return null;
	}

}
