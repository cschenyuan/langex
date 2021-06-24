package chenyuan.langex.book.designpattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2017/5/11.
 */
public class Composite extends Component {

    private ArrayList<Component> components = new ArrayList<>();

    public void add(Component one) {
        components.add(one);
    }

    public void remove(Component value) {
        components.remove(value);
    }

    public List<Component> getChildren() {
        return this.components;
    }

}
