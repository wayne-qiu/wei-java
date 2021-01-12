package binarysearch;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    @Override
    public String toString() {
        return "I am a Fruit !!";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "I am an Apple !!";
    }
}

class AsianApple extends Apple {
    @Override
    public String toString() {
        return "I am an AsianApple !!";
    }
}

public final class WrongWay
{

    public static void producerExtends(List<? extends Apple> a) {
        // 读取animals
        Apple a1 = a.get(0);

        List<Fruit> f = new ArrayList<Fruit>();

        f.add(new Apple());

        // 添加animal
//        a.add(new Fruit());//编译错
//        a.add(new Apple());        //编译错
//        a.add(new AsianApple());        //编译错
    }


//    public final void display(){
//        System.out.println("Hello welcome to Tutorialspoint");
//    }
//
//    class Sample extends WrongWay{
//        public void display(){
//            System.out.println("hi");
//        }
//    }

//    public static void producerExtends(List<Apple> a) {
//        // 读取animals
//        Apple a1 = (Apple)a.get(0);
//
//        // 添加animal
//        final boolean add = a.add(new Fruit());//编译错
//        a.add(new Apple());
//        a.add(new AsianApple());
//    }

    final int value;

    WrongWay(){
        value = 12;
    }

    public static void main(String[] args)
    {

    }
}