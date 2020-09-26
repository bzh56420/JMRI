package jmri.managers;

import jmri.InstanceManager;
import jmri.jmrix.internal.InternalSystemConnectionMemo;
import jmri.util.JUnitUtil;
import jmri.util.junit.annotations.ToDo;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * @author Paul Bender Copyright (C) 2017
 */
public class DefaultRouteManagerTest extends AbstractProvidingManagerTestBase<jmri.RouteManager, jmri.Route> {

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists", l);
    }
    
    @Test
    @Override
    @ToDo("Use test when tested class performs class-specific name validation.")
    public void testMakeSystemNameWithNoPrefixNotASystemName() {}
    
    @Test
    @Override
    @ToDo("Use test when tested class performs class-specific name validation.")
    public void testMakeSystemNameWithPrefixNotASystemName() {}

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        l = new DefaultRouteManager(InstanceManager.getDefault(InternalSystemConnectionMemo.class));
    }

    @AfterEach
    public void tearDown() {
        l = null;
        JUnitUtil.tearDown();
    }

}
