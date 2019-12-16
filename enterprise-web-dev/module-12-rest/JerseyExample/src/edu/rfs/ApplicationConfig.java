package edu.rfs;

import java.util.Set;
import javax.ws.rs.core.Application;

// NOTE: Most of this code is HEAVILY inspired by the examples from the lectures, if not directly drawn from

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(edu.rfs.TestEndPoint.class);
	}
}
