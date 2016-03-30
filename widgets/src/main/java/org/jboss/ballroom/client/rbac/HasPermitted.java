package org.jboss.ballroom.client.rbac;

/**
 * @author Tomas Hofman (thofman@redhat.com)
 */
public interface HasPermitted {

    void setPermitted(boolean rbacEnabled);

    boolean isPermitted();

}
