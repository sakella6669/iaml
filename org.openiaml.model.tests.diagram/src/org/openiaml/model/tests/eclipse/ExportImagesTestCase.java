/**
 * 
 */
package org.openiaml.model.tests.eclipse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.openiaml.model.diagram.custom.actions.ExportImagePartsAction;

/**
 * Emulate right click > export images to PNG
 * 
 * @author jmwright
 *
 */
public class ExportImagesTestCase extends EclipseTestCaseHelper {

	public void testExport() throws Exception {
		// register errors
		addLogListener();

		// copy our local file into the project
		IFile targetModel = getProject().getFile("generation-sync-multiple.iaml");
		copyFileIntoWorkspace("src/org/openiaml/model/tests/eclipse/generation-sync-multiple.iaml",
				targetModel);
		IFile targetDiagram = getProject().getFile("generation-sync-multiple.iaml_diagram");
		copyFileIntoWorkspace("src/org/openiaml/model/tests/eclipse/generation-sync-multiple.iaml_diagram",
				targetDiagram);
		
		// target files
		IFile target1 = getProject().getFile("generation-sync-multiple.png");
		IFile target2 = getProject().getFile("generation-sync-multiple-2.png");
		IFile target3 = getProject().getFile("generation-sync-multiple-3.png");
		IFile target4 = getProject().getFile("generation-sync-multiple-4.png");
		IFile target5 = getProject().getFile("generation-sync-multiple-5.png");
		IFile target6 = getProject().getFile("generation-sync-multiple-6.png");

		assertNotExists(target1);
		assertNotExists(target2);
		assertNotExists(target3);
		assertNotExists(target4);
		assertNotExists(target5);
		assertNotExists(target6);

		// do the export action
		ExportImagePartsAction act = new ExportImagePartsAction();
		act.doExport(targetDiagram, null, new NullProgressMonitor());
		
		assertExists(target1);
		assertExists(target2);
		assertExists(target3);
		assertExists(target4);
		assertNotExists(target5);
		assertNotExists(target6);

	}
	
}
