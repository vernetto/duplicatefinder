package org.pierre.duplicatefinder;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class ScanService {

	public String scan(String folder, boolean recursive, List<ScanItem> scanitems) throws Exception {
		System.out.println("scanning " + folder);
		Path dir = Paths.get(folder);

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path entry : stream) {
				File file = entry.toFile();
				if (file.isFile()) {
					FileInputStream fis = new FileInputStream(file);
					String md5 = DigestUtils.md5Hex(fis);
					fis.close();
					String filename = file.getCanonicalPath();
					System.out.println(filename + " md5=" + md5);
					ScanItem item = new ScanItem();
					item.setFilename(filename);
					item.setMd5(md5);
					item.setSize(file.length());
					item.setTouchdate(file.lastModified());
					scanitems.add(item);
				}
				if (file.isDirectory() && recursive) {
					
				}
			}
		}
		return null;
	}

}
