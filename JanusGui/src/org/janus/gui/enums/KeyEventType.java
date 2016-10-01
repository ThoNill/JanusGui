package org.janus.gui.enums;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public enum KeyEventType {
    ENTER(KeyEvent.VK_ENTER), DOWN(KeyEvent.VK_DOWN), UP(KeyEvent.VK_UP), F1(
            KeyEvent.VK_F1), F2(KeyEvent.VK_F2), F3(KeyEvent.VK_F3), F4(
            KeyEvent.VK_F4), F5(KeyEvent.VK_F5), F6(KeyEvent.VK_F6), F7(
            KeyEvent.VK_F7), F8(KeyEvent.VK_F8), F9(KeyEvent.VK_F9), F10(
            KeyEvent.VK_F10), F11(KeyEvent.VK_F11), F12(KeyEvent.VK_F12), CTRL_D(
            KeyEvent.VK_D, InputEvent.CTRL_MASK), CTRL_ENTER(KeyEvent.VK_ENTER,
            InputEvent.CTRL_MASK), COPY(KeyEvent.VK_INSERT,
            InputEvent.CTRL_MASK), PAST(KeyEvent.VK_INSERT,
            InputEvent.SHIFT_MASK), ;

    private final int ev;
    private int mask;

    private KeyEventType(int ev, int mask) {
        this.ev = ev;
        this.mask = mask;
    }

    private KeyEventType(int ev) {
        this(ev, 0);
    }

    public int getKeyEvent() {
        return ev;
    }

    public int getMask() {
        return mask;
    }
}
