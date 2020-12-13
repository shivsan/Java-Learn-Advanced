import java.util.ArrayList;
import java.util.List;

public class Generics {
    public void addDifferentSubTypeToSuperTypeList() {
        List<A> listA = new ArrayList<>();
        listA.add(new B());
        listA.add(new C());
    }

//    public void

}


class A {
}

class B extends A {
}

class C extends A {
}
