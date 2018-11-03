package org.pierre.duplicatefinder;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class ScanService {

	public String scan(String folder) throws Exception {
		System.out.println("scanning " + folder);
		Path dir = Paths.get(folder);

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path entry : stream) {
				System.out.println(entry.toString());

			}
		}
		return null;
	}

}
