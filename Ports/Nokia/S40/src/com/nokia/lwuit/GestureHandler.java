/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nokia.lwuit;

import com.nokia.mid.ui.gestures.GestureEvent;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.impl.LWUITImplementation;
import com.sun.lwuit.impl.s40.S40GestureImplementation;
import java.lang.ref.WeakReference;

/**
 *
 * @author tkor
 */
public abstract class GestureHandler {
    
    private WeakReference form;
    
    public static void setGlobalGestureHandler(GestureHandler h) {
        LWUITImplementation impl = Display.getInstance().getImplementation();
        if(impl instanceof S40GestureImplementation) {
            ((S40GestureImplementation)impl).setGlobalGestureHandler(h);
        }
    }
    public static void setFormGestureHandler(Form f, GestureHandler h) { 
        h.setForm(f);
        LWUITImplementation impl = Display.getInstance().getImplementation();
        if(impl instanceof S40GestureImplementation) {
            ((S40GestureImplementation) impl).addGestureHandler(h);
        }
    }
    private void setForm(Form f) {
        form = new WeakReference(f);
    }
    
    public Form getForm() {
        return (Form) form.get();
    }
    
    public abstract void gestureAction(GestureEvent e);
}