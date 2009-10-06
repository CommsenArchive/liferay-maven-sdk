package com.commsen.liferay;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.liferay.portal.tools.ThumbnailBuilder;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal build-thumbnail
 * 
 * @phase process-sources
 */
public class BuildThumbnail extends AbstractMojo {

	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project}"
	 */
	private MavenProject mavenProject;

	/**
	 * Location of the file.
	 * 
	 * @parameter default-value="/src/main/webapp/images/screenshot.png"
	 */
	private String screenshot;

	/**
	 * Location of the file.
	 * 
	 * @parameter expression="/src/main/webapp/images/thumbnail.png"
	 */
	private String thumbnail;

	/**
	 * Location of the file.
	 * 
	 * @parameter default-value="160"
	 */
	private int width;

	/**
	 * Location of the file.
	 * 
	 * @parameter default-value="120"
	 */
	private int height;

	/**
	 * Location of the file.
	 * 
	 * @parameter default-value="false"
	 */
	private boolean overwrite;


	public void execute() throws MojoExecutionException, MojoFailureException {

		File src = new File(mavenProject.getBasedir(), screenshot);
		File dest = new File(mavenProject.getBasedir(), thumbnail);

		getLog().debug("Going to create thumbnail in " + dest.getAbsolutePath() + " from " + src.getAbsolutePath());
		new ThumbnailBuilder(src, dest, height, width, overwrite);

	}

}
