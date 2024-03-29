package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    //DEBUGGING
    boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // we do not use this method at all we only use the KeyPressed
        // and KeyReleased methods
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //play state
        if(gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.pauseState;

            }
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;

            }
            //DEUBUGGING
            if(code == KeyEvent.VK_T){
                if(checkDrawTime == false){
                    checkDrawTime = true;
                }
                else if(checkDrawTime == true){
                    checkDrawTime = false;
                }
            }
        }
        //Pause state
        else if(gp.gameState == gp.pauseState){
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.playState;

            }
        }
        //Dialogue state
        else if(gp.gameState == gp.dialogueSate){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }


    }
}

