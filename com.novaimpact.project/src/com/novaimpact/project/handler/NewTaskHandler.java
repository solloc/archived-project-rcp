 
package com.novaimpact.project.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.descriptor.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class NewTaskHandler {
	@Execute
	public void execute(EPartService partService, EModelService modelService) {
		MPartDescriptor partDescriptor = MBasicFactory.INSTANCE.createPartDescriptor();
		partDescriptor.setContributionURI("bundleclass://com.novaimpact.project/com.novaimpact.project.part.TaskPart");
		MPart part = modelService.createPart(partDescriptor);
		part.setLabel("New Task");
		part.setCloseable(true);
		partService.showPart(part, PartState.ACTIVATE);
	}
		
}