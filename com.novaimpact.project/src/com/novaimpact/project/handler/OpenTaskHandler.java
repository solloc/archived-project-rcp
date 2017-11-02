 
package com.novaimpact.project.handler;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.descriptor.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.w3c.dom.views.AbstractView;

import com.novaimpact.project.model.Task;
import com.novaimpact.project.part.TaskPart;
import com.novaimpact.project.service.task.TaskService;

public class OpenTaskHandler {
	
	
	
	@Execute
	public void execute(@Optional @Named("com.novaimpact.project.commandparameter.taskid") String task) {
//		Command command = commandService.getCommand("com.novaimpact.project.command.opentaskcommand");
//		try {
//			IParameter[] parameter = command.getParameters();
//		} catch (NotDefinedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Execute
//	public void execute(EPartService partService, EModelService modelService) {
//		
//		
//		
//		MPartDescriptor partDescriptor = MBasicFactory.INSTANCE.createPartDescriptor();
//		partDescriptor.setContributionURI("bundleclass://com.novaimpact.project/com.novaimpact.project.part.TaskPart");
//		MPart part = modelService.createPart(partDescriptor);
//		part.setLabel("New Task");
//		part.setCloseable(true);
//		
//		partService.showPart(part, PartState.ACTIVATE);
//		
////		Map parameter = event.getParameters();
////		Task task = (Task)parameter.get("task");
//		
//		
//		
//		TaskPart taskPart = (TaskPart) part.getObject();
////		taskPart.setTask(task);		
//	}
		
}