package org.pierre.duplicatefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ScanComponent {
	private final ScanService service;

	@Autowired
	public ScanComponent(ScanService service) {
		this.service = service;
	}

	@ShellMethod("Scan a folder for all files")
	public String scanfolder(@ShellOption() String folder) throws Exception {
		// invoke service
		return service.scan(folder);
	}

}
