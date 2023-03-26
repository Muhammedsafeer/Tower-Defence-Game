package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener, MouseWheelListener {

    public int dx, dy;
    public int mouseX, mouseY;
    public int initialMouseX, initialMouseY;

    public boolean leftClick, rightClick;

    public boolean scrollingDown, scrollingUp;

    @Override
    public void mouseClicked(MouseEvent e) {
        // get mouse position
        initialMouseX = e.getX();
        initialMouseY = e.getY();

        if (e.getButton() == MouseEvent.BUTTON1) {
            leftClick = true;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightClick = true;
        }
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
        // get mouse position
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // check if mouse wheel is moved down
        if (e.getWheelRotation() < 0) {
            scrollingDown = true;
        }
        // check if mouse wheel is moved up
        if (e.getWheelRotation() > 0) {
            scrollingUp = true;
        }
    }
}
