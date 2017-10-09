
package com.novaimpact.project.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("restriction")
public class IncidentListPart {
	private Text txtIncident;
	private Table table;
	
//	@Inject
//	private ECommandService commandService;
	
	@Inject
	public ECommandService commandService;
	
	@Inject
	public EHandlerService handlerService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		txtIncident = new Text(parent, SWT.READ_ONLY);
		txtIncident.setText("Incident");
		txtIncident.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.setText("new incident");
		
		btnNewButton.addSelectionListener(new SelectionListener() {

			ECommandService commandService;
			EHandlerService handlerService;
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("selected");
				Command command = this.commandService.getCommand("com.novaimpact.project.command.newTask");
				ParameterizedCommand parCommmand = new ParameterizedCommand(command, null);
				if (this.handlerService.canExecute(parCommmand)) {
					this.handlerService.executeHandler(parCommmand);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public SelectionListener init(ECommandService commandService, EHandlerService handlerService) {
				this.commandService = commandService;
				this.handlerService = handlerService;
				return this;
			}
		}.init(this.commandService, this.handlerService));		
		
		
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
	}

}