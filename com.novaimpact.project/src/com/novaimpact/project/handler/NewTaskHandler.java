 
package com.novaimpact.project.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.descriptor.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

import com.novaimpact.project.service.task.ITaskService;

public class NewTaskHandler {
	
	@Inject
	private ITaskService taskService;
	
	@Inject
	private IEclipseContext context;
	
	@Execute
	public void execute(EPartService partService, EModelService modelService) {
		String task = this.taskService.createTask("new-task-1");
		MPartDescriptor partDescriptor = MBasicFactory.INSTANCE.createPartDescriptor();
		partDescriptor.setContributionURI("bundleclass://com.novaimpact.project/com.novaimpact.project.part.TaskPart");
		MPart part = modelService.createPart(partDescriptor);
		part.setLabel("New Task");
		part.setCloseable(true);
//		IEclipseContext context = part.getContext();
		context.set("task-object", task);
//		part.setObject(task);
		partService.showPart(part, PartState.ACTIVATE);
	}
		
}