package com.novaimpact.project.ui;

import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredContentProvider;

import com.novaimpact.project.model.Task;

public class TaskTableContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		@SuppressWarnings("unchecked")
		LinkedList<Task> taskList = (LinkedList<Task>)inputElement;
		return taskList.toArray();
	}

}
