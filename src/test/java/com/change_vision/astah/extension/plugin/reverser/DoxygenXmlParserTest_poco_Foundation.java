package com.change_vision.astah.extension.plugin.reverser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.junit.Before;
import org.junit.Test;

import com.change_vision.astah.extension.plugin.common.AstahModelUtil;
import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class DoxygenXmlParserTest_poco_Foundation {
	private ProjectAccessor projectAccessor;
	private Creator util;
	private File xmlDir;
	private TypeUtil typeUtil;
	private AstahModelUtil astahModelUtil;

	@Before
	public void before() throws Exception {
		projectAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
		util = new Creator();
		util.setProjectAccessor(projectAccessor);
		util.setBasicModelEditor(projectAccessor.getModelEditorFactory().getBasicModelEditor());
		typeUtil = new TypeUtil();
		astahModelUtil = new AstahModelUtil();
		typeUtil.setAstahModelUtil(astahModelUtil);
		util.setTypeUtil(typeUtil);
	}

	@Test
	public void poco_Foundationの作成_無名名前空間を表示するオプションon() throws Throwable {
		try {
			xmlDir = new File(getClass().getClassLoader().getResource("poco_Foundation/xml").getFile());
			this.typeUtil.setXmlDir(xmlDir);
			DoxygenXmlParser xmlParser = new DoxygenXmlParser();
			xmlParser.setProjectAccessor(projectAccessor);
			xmlParser.setCreator(util);

			xmlParser.initProject();
			TransactionManager.beginTransaction();
			xmlParser.parser(xmlDir.getAbsolutePath());
			TransactionManager.endTransaction();
			String tempFilepath = xmlParser.saveProject();
			copy2Target(new File(tempFilepath), "poco_Foundation.asta");
		} catch (Exception e) {
			TransactionManager.abortTransaction();
			e.printStackTrace();
			throw e;
		}
	}

	public static void copy2Target(File srcPath, String outName) {
		FileChannel srcChannel = null;
		FileChannel destChannel = null;
		try {
			srcChannel = new FileInputStream(srcPath).getChannel();
			destChannel = new FileOutputStream(String.format("./target/%s", outName)).getChannel();

			srcChannel.transferTo(0, srcChannel.size(), destChannel);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (srcChannel != null) {
				try {
					srcChannel.close();
				} catch (IOException e) {
				}
			}
			if (destChannel != null) {
				try {
					destChannel.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
