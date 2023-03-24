package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    public int dx, dy;
    int mouseX, mouseY;
    int initialMouseX, initialMouseY;

    @Override
    public void mouseClicked(MouseEvent e) {
        // get mouse position
        initialMouseX = e.getX();
        initialMouseY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // get mouse position
        mouseX = e.getX();
        mouseY = e.getY();
        dx = initialMouseX - mouseX;
        dy = initialMouseY - mouseY;
        initialMouseX = mouseX;
        initialMouseY = mouseY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
