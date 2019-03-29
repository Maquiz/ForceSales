package com.example.forcesales.Data.consoleKit;

/**
 * Regular exit from a program
 * @author villa
 */
public class ReturnFromMenu implements MenuItem {
    private final String msg;
    private final MenuStack menus;
    
    public ReturnFromMenu(String prevMenuName, MenuStack _menus) {
        this.msg = prevMenuName;
        this.menus = _menus;
    }

    @Override
    public void execute() {
        while(menus.getCurrent().toString() != msg)
        {
            menus.toPreviousMenu();
        }
    }
    
    @Override
    public String toString() {
        return this.msg;
    }
    
}
