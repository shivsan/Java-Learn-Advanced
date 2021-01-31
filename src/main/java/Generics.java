import java.util.ArrayList;
import java.util.List;

public class Generics {
    public void addDifferentSubTypeToSuperTypeList() {
        List<A> listA = new ArrayList<>();
        listA.add(new B());
        listA.add(new C());
    }

    public void addDifferentSubTypeToDifferentSubTypeList() {
        List<? super A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
//        listA = listB;

        listA.add(new A());
        listA.add(new C());
    }

}


class A {
}

class B extends A {
}

class C extends A {
}
