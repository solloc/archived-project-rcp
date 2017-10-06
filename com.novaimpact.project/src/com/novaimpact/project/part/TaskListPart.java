
package com.novaimpact.project.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.widgets.Composite;

import com.novaimpact.project.service.ISecondTaskService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;

public class TaskListPart {
	private List<String> tableData;
	
	@Inject
	private ISecondTaskService secondTaskService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		
		this.tableData = this.secondTaskService.getTasks();		
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(this.tableData);
		tableViewer.getTable();
		
	}
}