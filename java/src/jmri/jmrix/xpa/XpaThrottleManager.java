package jmri.jmrix.xpa;

import jmri.ThrottleManager;
import jmri.LocoAddress;
import jmri.jmrix.AbstractThrottleManager;

/**
 * XPA implementation of a ThrottleManager
 * @author     Paul Bender Copyright (C) 2004
 * @version    $Revision$
 */

public class XpaThrottleManager extends AbstractThrottleManager implements ThrottleManager {

    /**
     * Constructor.
     */
    public XpaThrottleManager()
    {
       super();
       userName = "XPA";
    }

    /**
     * Request a new throttle object be creaetd for the address, and let
     * the throttle listeners know about it.
     **/
     public void requestThrottleSetup(LocoAddress address, boolean control) {
	XpaThrottle throttle=new XpaThrottle(address);
        notifyThrottleKnown(throttle,address);
     }

    /*
     * The XPA DOES NOT use the Dispatch Function
     */
    public boolean hasDispatchFunction() { return false; }

    /**
     * Address 100 and above is a long address
     **/
    public boolean canBeLongAddress(int address) {
        return isLongAddress(address);
    }
    
    /**
     * Address 99 and below is a short address
     **/
    public boolean canBeShortAddress(int address) {
        return !isLongAddress(address);
    }

    /**
     * Are there any ambiguous addresses (short vs long) on this system?
     */
    public boolean addressTypeUnique() { return true; }

    /*
     * Local method for deciding short/long address
     */
    static boolean isLongAddress(int num) {
        return (num>=100);
    }
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(XpaThrottleManager.class.getName());

}

