package consoleKit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Supports nested menus
 * @author villa
 */
public class MenuStack {
	Deque<Menu> obj;
	   

    public MenuStack() {
        
        obj = new ArrayDeque<Menu>();
        
    }

    public Menu getCurrent() {
        
        return obj.getFirst();
        
    }

    public void add(Menu menu) {
        
        obj.addFirst(menu);
                
    }
    
    public void toPreviousMenu() {
        
        obj.removeFirst();
        
    }
    
    public void run() {
        
        obj.getFirst().execute();
        
    }
    
}
