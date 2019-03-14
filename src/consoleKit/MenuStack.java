package consoleKit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Supports nested menus
 * @author villa
 */
public class MenuStack {

    private ArrayDeque<Menu> stack;

    public MenuStack() {
        this.stack = new ArrayDeque<Menu>();
    }

    public Menu getCurrent() {
        return stack.getFirst();
    }

    public void add(Menu menu) {
        stack.addFirst(menu);
    }
    
    public void toPreviousMenu() {
       stack.removeFirst();
    }
    
    public void run() {
        getCurrent().execute();
    }
    
}
