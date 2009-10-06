package com.commsen.liferay;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import com.liferay.portal.tools.servicebuilder.ServiceBuilder;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal build-service
 * 
 * @phase process-sources
 */
public class BuildService extends AbstractMojo {

	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${basedir}"
	 */
	private File baseDir;

	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project}"
	 */
	private MavenProject mavenProject;

	/**
	 * Location of the file.
	 * 
	 * @parameter
	 */
	private List<Dependency> serviceDependencies;

	/**
	 * @parameter default-value="/src/main/java"
	 */
	private String srcFolderName;

	/**
	 * @parameter default-value="/src/main/java-service-api"
	 */
	private String serviceApiFolderName;

	/**
	 * @parameter default-value="/src/main/resources"
	 */
	private String resourcesFolderName;

	/**
	 * @parameter default-value="/src/main/webapp"
	 */
	private String webappFolderName;


	public void execute() throws MojoExecutionException {

		String webRootFolder = baseDir.getAbsolutePath() + webappFolderName;
		String srcFolder = baseDir.getAbsolutePath() + srcFolderName;
		String srcServiceFolder = baseDir.getAbsolutePath() + serviceApiFolderName;
		String resourcesFolder = baseDir.getAbsolutePath() + resourcesFolderName;
		String sqlFolder = webRootFolder + "/WEB-INF/sql";

		File inputFile = new File(webRootFolder + "/WEB-INF/service.xml");
		if (!inputFile.exists()) {
			getLog().warn("No service input file (" + inputFile.getAbsolutePath() + ") found! Skipping service API generation!");
			return;
		}

		try {
			FileUtils.forceMkdir(new File(sqlFolder));
		} catch (IOException e) {
			getLog().warn(e);
		}

		System.setProperty("external-properties", "com/liferay/portal/tools/dependencies/portal-tools.properties");
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger");
		System.setProperty("service.input.file", inputFile.getAbsolutePath());
		System.setProperty("service.hbm.file", resourcesFolder + "/META-INF/portlet-hbm.xml");
		System.setProperty("service.model.hints.file", resourcesFolder + "/META-INF/portlet-model-hints.xml");
		System.setProperty("service.spring.file", resourcesFolder + "/META-INF/portlet-spring.xml");
		System.setProperty("service.spring.base.file", resourcesFolder + "/META-INF/base-spring.xml");
		System.setProperty("service.spring.dynamic.data.source.file", resourcesFolder + "/META-INF/dynamic-data-source-spring.xml");
		System.setProperty("service.spring.hibernate.file", resourcesFolder + "/META-INF/hibernate-spring.xml");
		System.setProperty("service.spring.infrastructure.file", resourcesFolder + "/META-INF/infrastructure-spring.xml");
		System.setProperty("service.api.dir", srcServiceFolder);
		System.setProperty("service.impl.dir", srcFolder);
		System.setProperty("service.sql.dir", sqlFolder);
		System.setProperty("service.sql.file", "tables.sql");
		System.setProperty("service.sql.indexes.file", "indexes.sql");
		System.setProperty("service.sql.indexes.properties.file", "indexes.properties");
		System.setProperty("service.sql.sequences.file", "sequences.sql");
		System.setProperty("service.auto.namespace.tables", "true");
		System.setProperty("service.bean.locator.util", "com.liferay.util.bean.PortletBeanLocatorUtil");
		System.setProperty("service.props.util", "com.liferay.util.service.ServiceProps");
		System.setProperty("service.plugin.name", mavenProject.getArtifactId());
		ServiceBuilder.main(new String[0]);

		if (serviceDependencies != null && !serviceDependencies.isEmpty()) {
			List<Dependency> projectDependecies = mavenProject.getDependencies();
			projectDependecies.addAll(serviceDependencies);
		}

		mavenProject.addCompileSourceRoot(srcServiceFolder);

		File srcServiceProperties = new File(srcFolder, "service.properties");
		File resServiceProperties = new File(resourcesFolder, "service.properties");
		FileUtils.deleteQuietly(resServiceProperties);
		try {
			FileUtils.moveFile(srcServiceProperties, resServiceProperties);
		} catch (IOException e) {
			getLog().warn(e);
		}
	}
}
