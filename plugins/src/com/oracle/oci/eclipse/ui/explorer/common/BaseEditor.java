/**
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 * Licensed under the Universal Permissive License v 1.0 as shown at http://oss.oracle.com/licenses/upl.
 */
package com.oracle.oci.eclipse.ui.explorer.common;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.EditorPart;

public class BaseEditor extends EditorPart {

    @Override
    public void doSave(IProgressMonitor monitor) {}

    @Override
    public void doSaveAs() {}

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSite(site);
        setInput(input);
        setPartName(input.getName());
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    public ScrolledForm initForm(Composite parent) {
        FormToolkit toolkit = new FormToolkit(Display.getDefault());
        ScrolledForm form = new ScrolledForm(parent, SWT.V_SCROLL);
        form.setExpandHorizontal(true);
        form.setExpandVertical(true);
        form.setBackground(toolkit.getColors().getBackground());
        form.setForeground(toolkit.getColors().getColor(IFormColors.TITLE));
        form.setFont(JFaceResources.getHeaderFont());
        form.getBody().setLayout(new GridLayout(1, false));
        return form;
    }

    @Override
    public void createPartControl(Composite parent) {
    }

    @Override
    public void setFocus() {
    }

}

