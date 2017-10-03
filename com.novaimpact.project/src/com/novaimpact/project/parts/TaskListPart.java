
package com.novaimpact.project.parts;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.widgets.Composite;

import com.novaimpact.project.service.ITaskService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;

public class TaskListPart {
	private List<String> tableData;
	
//	@Inject
//	private ITaskService taskService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		
		this.tableData = Arrays.asList("abc","def","ghi","qwert","asdfg","yxcvb");
//		this.tableData = this.taskService.getTasks();
		
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(this.tableData);
		tableViewer.getTable();
		
	}
}