package org.pierre.duplicatefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ShellComponent
public class ScanComponent {
	private final ScanService service;

	@Autowired
	public ScanComponent(ScanService service) {
		this.service = service;
	}

	@ShellMethod("Scan a folder for all files")
	public String scanfolder(@ShellOption() String folder) throws Exception {
		return service.scan(folder);
	}
	
	@ShellMethod("display current user")
	public String whoami() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getPrincipal());
		return "";
	}

}
