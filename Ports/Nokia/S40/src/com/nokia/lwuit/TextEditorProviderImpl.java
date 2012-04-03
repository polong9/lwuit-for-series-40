/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nokia.lwuit;

import com.nokia.mid.ui.S40TextEditor;
import com.nokia.mid.ui.TextEditor;
import com.sun.lwuit.Dialog;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;

/**
 *
 * @author tkor
 */
class TextEditorProviderImpl extends TextEditorProvider implements com.nokia.mid.ui.TextEditorListener {
    
    private TextEditor editor = null;
    private TextEditorListener internalListener = null;
    
    public TextEditorProviderImpl() {
    
        //create some default values just so that we can instantiate the actual class
        editor = TextEditor.createTextEditor("", 500, 0, 100, 100);

    }
    public void delete(int offset, int length) {
        editor.delete(offset, length);
    }

    public int getBackgroundColor() {
        return editor.getBackgroundColor();
        
    }

    public int getCaretPosition() {
        return editor.getCaretPosition();
    }

    public int getConstraints() {
        return editor.getConstraints();
    }

    public String getContent() {
        return editor.getContent();
    }

    public int getContentHeight() {
        return editor.getContentHeight();
    }

    public Font getFont() {
        return editor.getFont();
    }

    public int getForegroundColor() {
        return editor.getForegroundColor();
    }

    public String getInitialInputMode() {
        return editor.getInitialInputMode();
    }

    public int getLineMarginHeight() {
        return editor.getLineMarginHeight();
    }

    public int getMaxSize() {
        return editor.getMaxSize();
    }

    public String getSelection() {
        return editor.getSelection();
    }

    public int getVisibleContentPosition() {
        return editor.getVisibleContentPosition();
    }

    public int getZPosition() {
        return editor.getZPosition();
    }

    public boolean hasFocus() {
        return editor.hasFocus();
    }

    public void insert(String text, int position) {
        editor.insert(text, position);
    }

    public boolean isMultiline() {
        return editor.isMultiline();
    }

    public void setBackgroundColor(int color) {
        editor.setBackgroundColor(color);
    }

    public void setCaret(int index) {
        editor.setCaret(index);
    }

    public void setConstraints(int constraints) {
        editor.setConstraints(constraints);
    }

    public void setContent(String content) {
        editor.setContent(content);
    }

    public void setFocus(boolean focused) {
        editor.setFocus(focused);
    }

    public void setFont(Font font) {
        editor.setFont(font);
    }

    public void setForegroundColor(int color) {
        editor.setForegroundColor(color);
    }

    public void setHighlightBackgroundColor(int color) {
        editor.setHighlightBackgroundColor(color);
    }

    public void setHighlightForegroundColor(int color) {
        editor.setHighlightForegroundColor(color);
    }

    public void setInitialInputMode(String characterSubset) {
        editor.setInitialInputMode(characterSubset);
    }

    public int setMaxSize(int maxSize) {
        editor.setMaxSize(maxSize);
        return editor.getMaxSize();
    }

    public void setMultiline(boolean aMultiline) {
        editor.setMultiline(aMultiline);
    }

    public void setParent(Object parent) {
        editor.setParent(parent);
    }

    public void setPosition(int x, int y) {
        editor.setPosition(x, y);
    }

    public void setSelection(int index, int length) {
        editor.setSelection(index, length);
    }

    public void setSize(int width, int height) {
        editor.setSize(width, height);
    }

    public void setTextEditorListener(TextEditorListener listener) {
        internalListener = listener;
        editor.setTextEditorListener(this);
    }

    public void setVisible(boolean visible) {
        editor.setVisible(visible);
    }

    public void setZPosition(int z) {
        editor.setZPosition(z);
    }

    public int size() {
        return editor.size();
    }
    public boolean isVisible() {
        return editor.isVisible();
    }

    public int getHeight() {
        return editor.getHeight();
    }

    public int getPositionX() {
        return editor.getPositionX();
    }

    public int getPositionY() {
        return editor.getPositionY();
    }

    public int getWidth() {
        return editor.getWidth();
    }
    
    public Image[] getInputIndicators() {
        Image [] imgs = new Image[0];
        try {
                S40TextEditor s40editor = (S40TextEditor) editor;
                imgs = s40editor.getIndicatorIcons();
                
            }catch(ClassCastException se) {
                System.out.println("getting input indicators not supported.");
            }
        
        return imgs;
    }
    public int getInputMode() {
        int ret = 0;
        try {
            S40TextEditor s40editor = (S40TextEditor) editor;
            ret = s40editor.getInputMode();
        }catch(ClassCastException se) {
            System.out.println("getting input mode is not supported.");
        }
        
        return ret;
    }
    

    public void inputAction(TextEditor textEditor, int actions) {
        if(internalListener != null) {
            internalListener.inputAction(this, actions);
        }
    }

    public void setIndicatorVisibility(boolean visible) {
        editor.setIndicatorVisibility(visible);
    }

    public void setIndicatorLocation(int x, int y) {
        editor.setIndicatorLocation(x, y);
    }
    
    
}
