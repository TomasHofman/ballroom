/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package org.jboss.ballroom.client.widgets.tools;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import org.jboss.ballroom.client.rbac.OperationAddressAware;

/**
 * @author Heiko Braun
 * @date 2/28/11
 */
public class ToolButton extends Button implements OperationAddressAware {

    private String resource;
    private String op;
    private boolean enabled = true;
    private boolean permitted = true;

    public ToolButton(String title) {
        super(title);
        //addStyleName("default-button");
        addStyleName("toolstrip-button");
        getElement().setTabIndex(0);
    }

    public ToolButton(String title, ClickHandler handler) {
        this(title);
        addClickHandler(handler);
        getElement().setTabIndex(0);
    }

    @Override
    public void setOperationAddress(String resource, String op) {
        this.resource = resource;
        this.op = op;
    }

    @Override
    public String[] getOperationAddress() {
        return new String[] {resource, op};
    }

    @Override
    public boolean hasOperationAddress() {
        return resource!=null && op!=null;
    }

    public void setPermitted(boolean permitted) {
        setEnabled(isEnabled(), permitted);
    }

    @Override
    public boolean isPermitted() {
        return permitted;
    }

    @Override
    public void setEnabled(boolean enabled) {
        setEnabled(enabled, permitted);
    }

    private void setEnabled(boolean enabled, boolean permitted) {
        this.enabled = enabled;
        this.permitted = permitted;
        super.setEnabled(enabled && permitted);
    }
}

