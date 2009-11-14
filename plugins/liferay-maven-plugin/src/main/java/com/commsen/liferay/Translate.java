package com.commsen.liferay;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.liferay.portal.tools.LangBuilder;

/**
 * Goal which translates resource bundles
 * 
 * @goal translate
 * 
 * @phase process-sources
 */
public class Translate extends AbstractMojo {

	/**
	 * @parameter expression="${basedir}/src/main/resources/content"
	 */
	private String langDir;

	/**
	 * @parameter default-value="Language"
	 */
	private String langFile;


	public void execute() throws MojoExecutionException, MojoFailureException {

		System.setProperty("external-properties", "com/liferay/portal/tools/dependencies/portal-tools.properties");
		System.setProperty("file.encoding", "UTF-8");
		System.setProperty("user.country", "US");
		System.setProperty("user.language", "en");

		File langFolder = new File(langDir);
		if (!langFolder.exists()) {
			throw new MojoExecutionException("Folder " + langFolder.getAbsolutePath() + " does not exists!");
		}
		if (!langFolder.isDirectory()) {
			throw new MojoExecutionException("Resource " + langFolder.getAbsolutePath() + " is not a folder!");
		}

		LangBuilder.main(new String[] { langDir, langFile });

		File orig = new File(langFolder, langFile + ".properties");
		File en = new File(langFolder, langFile + "_en.properties");

		if (!orig.exists() || !orig.isFile()) {
			throw new MojoExecutionException("File " + orig.getAbsolutePath() + " does not exists or is not a file!");
		}

		try {
			FileUtils.copyFile(orig, en);
		} catch (IOException e) {
			getLog().warn(e);
		}

		try {
			Class n2aMain = Class.forName("sun.tools.native2ascii.Main");
			Class[] param = new Class[] { String[].class };
			Method convert = n2aMain.getMethod("convert", param);
			if (convert == null) {
				throw new MojoExecutionException("Could not find convert() method in sun.tools.native2ascii.Main");
			}
			Object o = n2aMain.newInstance();
			for (Iterator<File> resourceIterator = FileUtils.iterateFiles(new File(langDir), new String[] { "native" }, false); resourceIterator.hasNext();) {
				File sourceFile = resourceIterator.next();
				File destFile = new File(sourceFile.getParentFile(), sourceFile.getName().replace(".native", ""));
				String[] params = new String[] { "-encoding", "UTF8", sourceFile.getAbsolutePath(), destFile.getAbsolutePath() };
				boolean success = false;
				try {
					success = ((Boolean) convert.invoke(o, new Object[] { params })).booleanValue();
					if (!success) {
						getLog().warn("Failed to convert " + sourceFile.getAbsolutePath() + " to " + destFile.getAbsolutePath());
					}
				} catch (IllegalArgumentException e) {
					getLog().warn("Failed to convert " + sourceFile.getAbsolutePath() + " to " + destFile.getAbsolutePath(), e);
				} catch (IllegalAccessException e) {
					getLog().warn("Failed to convert " + sourceFile.getAbsolutePath() + " to " + destFile.getAbsolutePath(), e);
				} catch (InvocationTargetException e) {
					getLog().warn("Failed to convert " + sourceFile.getAbsolutePath() + " to " + destFile.getAbsolutePath(), e);
				}
			}

		} catch (ClassNotFoundException e) {
			throw new MojoExecutionException("Failed to run native2ascii", e);
		} catch (InstantiationException e) {
			throw new MojoExecutionException("Failed to run native2ascii", e);
		} catch (IllegalAccessException e) {
			throw new MojoExecutionException("Failed to run native2ascii", e);
		} catch (SecurityException e) {
			throw new MojoExecutionException("Failed to run native2ascii", e);
		} catch (NoSuchMethodException e) {
			throw new MojoExecutionException("Failed to run native2ascii", e);
		}
	}
}
