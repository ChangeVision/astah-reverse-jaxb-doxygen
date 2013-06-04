package com.change_vision.astah.extension.plugin.reverser;

import static java.lang.String.format;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.CompounddefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxygenType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.index.CompoundKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.index.CompoundType;
import com.change_vision.astah.extension.plugin.exception.IndexXmlNotFoundException;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

/**
 * Parse Doxygen's xml to generate jude model
 * 
 */
public class DoxygenXmlParser {
	private static final Logger LOG = LoggerFactory.getLogger(DoxygenXmlParser.class);

	private ProjectAccessor projectAccessor;

	private IModel project;

	private File xmlDir;
	private List<CompounddefType> compounddefTypes = new ArrayList<CompounddefType>();

	private Creator creator;

	public DoxygenXmlParser() {
	}

	public void setProjectAccessor(ProjectAccessor projectAccessor) {
		this.projectAccessor = projectAccessor;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public void parser(String path) throws LicenseNotFoundException, ProjectLockedException, IndexXmlNotFoundException, Throwable {
		this.initIndexXml(path);

		LOG.info("Importing... please wait..");

		this.parserIndexXml();

		this.createAllTheCompound();

		LOG.info("Import Done.");
	}

	protected void initIndexXml(String path) throws IOException, SAXException, IndexXmlNotFoundException {
		if (findFile(path, "index.xml") == null) {
			throw new IndexXmlNotFoundException();
		}
		xmlDir = new File(path);
	}

	public void initProject() throws LicenseNotFoundException, ProjectNotFoundException, NonCompatibleException, ClassNotFoundException,
			ProjectLockedException, Throwable {
		// check template project
		InputStream stream = getClass().getResourceAsStream("C++.asta");
		projectAccessor.open(stream);
		// get current jude project's root
		this.project = projectAccessor.getProject();

		BasicModelEditor basicModelEditor = projectAccessor.getModelEditorFactory().getBasicModelEditor();
		// set the project type
		basicModelEditor.setLanguageCPlus(project, true);
	}

	/**
	 * 
	 * @param fileName
	 *            : target indexFile
	 * @return the Set
	 * @throws IOException
	 * @throws SAXException
	 */
	protected void parserIndexXml() throws IOException, SAXException, ProjectNotFoundException, ClassNotFoundException, InvalidEditingException {
		XMLStreamReader indexReader = null;
		try {
			// TODO 1.8.3.1 ではなく、adapter 的な何かへ変更したい
			// index.xml の jaxb.
			JAXBElement<com.change_vision.astah.extension.plugin.doxygen._1_8_4.index.DoxygenType> indexElement = null;
			{
				long start = System.currentTimeMillis();
				ClassLoader classLoader = com.change_vision.astah.extension.plugin.doxygen._1_8_4.index.ObjectFactory.class.getClassLoader();
				JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_4.index", classLoader);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				XMLInputFactory factory = XMLInputFactory.newInstance();
				indexReader = factory.createXMLStreamReader(new FileInputStream(format("%s/index.xml", xmlDir.getAbsolutePath())));
				indexElement = unmarshaller.unmarshal(indexReader, com.change_vision.astah.extension.plugin.doxygen._1_8_4.index.DoxygenType.class);
				LOG.trace(format("index loaded : %,d", System.currentTimeMillis() - start));
			}
			{
				ClassLoader classLoader = com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.ObjectFactory.class.getClassLoader();
				List<CompoundType> compoundTypes = indexElement.getValue().getCompound();
				int size = compoundTypes.size();
				LOG.debug(format("compoundTypes size : %d", size));
				long start = System.currentTimeMillis();
				int count = 0;
				for (CompoundType compoundType : compoundTypes) {
					long oneStart = System.currentTimeMillis();
					++count;
					if (compoundType.getKind() == null) {
						if (LOG.isDebugEnabled()) {
							LOG.debug(format("%d / %d, compounddefType skipped : %,d ms, %s.xml", count, size, System.currentTimeMillis() - oneStart,
									compoundType.getRefid()));
						}
						continue;
					}
					switch (compoundType.getKind()) {
					case NAMESPACE:
					case CLASS:
					case INTERFACE:
					case STRUCT:
					case UNION:
					case FILE:
						if (compoundType.getKind() == CompoundKind.FILE && (compoundType.getMember() == null || compoundType.getMember().isEmpty())) {
							if (LOG.isDebugEnabled()) {
								LOG.debug(format("%d / %d, compounddefType skipped : %,d ms, %s.xml", count, size, System.currentTimeMillis()
										- oneStart, compoundType.getRefid()));
							}
							continue;
						}
						{
							XMLStreamReader r = null;
							try {
								XMLInputFactory factory = XMLInputFactory.newInstance();
								r = factory.createXMLStreamReader(new FileInputStream(format("%s/%s.xml", xmlDir.getAbsolutePath(),
										compoundType.getRefid())));
								JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound",
										classLoader);
								Unmarshaller unmarshaller = context.createUnmarshaller();
								JAXBElement<DoxygenType> element = unmarshaller.unmarshal(r, DoxygenType.class);
								this.compounddefTypes.add(element.getValue().getCompounddef().get(0));
							} finally {
								if (r != null) {
									r.close();
								}
							}
							if (LOG.isDebugEnabled()) {
								LOG.debug(format("%d / %d, compounddefType loaded : %,d ms, %s.xml", count, size, System.currentTimeMillis()
										- oneStart, compoundType.getRefid()));
							}
						}
						break;
					case CATEGORY:
					case DIR:
					case EXAMPLE:
					case EXCEPTION:
					case GROUP:
					case PAGE:
					case PROTOCOL:
					default:
						if (LOG.isDebugEnabled()) {
							LOG.debug(format("%d / %d, compounddefType skipped : %,d", count, size, System.currentTimeMillis() - oneStart));
						}
						break;
					}
				}
				LOG.debug(format("all compounddefTypes loaded : %,d", System.currentTimeMillis() - start));
			}

		} catch (JAXBException e) {
			// TODO throwするエラーを変更すること
			throw new IOException(e);
		} catch (FactoryConfigurationError e) {
			// TODO throwするエラーを変更すること
			throw new IOException(e);
		} catch (XMLStreamException e) {
			// TODO throwするエラーを変更すること
			throw new IOException(e);
		} finally {
			if (indexReader != null) {
				try {
					indexReader.close();
				} catch (XMLStreamException e) {
					// TODO throwするエラーを変更すること
					throw new IOException(e);
				}
			}
		}
	}

	protected void createAllTheCompound() throws Exception {
		long start = System.currentTimeMillis();
		LOG.debug(format("start create models"));
		// 名前空間だけ作成
		for (CompounddefType compounddefType : this.compounddefTypes) {
			creator.createNamespace(project, compounddefType);
		}
		// グローバルを追加する
		for (CompounddefType compounddefType : this.compounddefTypes) {
			creator.createGlobalClass(compounddefType);
		}
		// Class等の型を作成する
		for (CompounddefType compounddefType : this.compounddefTypes) {
			creator.createClass(compounddefType);
		}
		// 作った型に対して属性・操作を追加する
		for (CompounddefType compounddefType : this.compounddefTypes) {
			creator.modifyClass(compounddefType);
		}
		// 作ったグローバルな型に対して属性・操作を追加する
		for (CompounddefType compounddefType : this.compounddefTypes) {
			creator.modifyGlobalClass(compounddefType);
		}
		LOG.debug(format("finish create models : %,d", System.currentTimeMillis() - start));
	}

	// TODO ここじゃない
	public String saveProject() throws IOException, LicenseNotFoundException, ProjectNotFoundException, ProjectLockedException, Throwable {
		String astahModelPath = getTempAstahModelPath();
		projectAccessor.saveAs(astahModelPath);
		projectAccessor.close();
		return astahModelPath;
	}

	protected String getTempAstahModelPath() throws IOException {
		String tempFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File tempFile = File.createTempFile(tempFileName, ".asta");
		tempFile.deleteOnExit();
		return tempFile.getAbsolutePath();
	}

	/**
	 * 
	 * @param path
	 *            : target Path
	 * @param fileName
	 *            : target file's name
	 * @return the target file
	 * @throws IOException
	 * @throws SAXException
	 */
	public static File findFile(String path, String fileName) throws IOException, SAXException {
		File dir = new File(path);
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (fileName.equals(files[i].getName())) {
					return files[i];
				}
			}
		}
		return null;
	}
}