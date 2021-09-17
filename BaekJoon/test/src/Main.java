import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public static boolean isGreenApple( Apple apple){
        return "GREEN".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p){
                result.add(apple);
            }
        }
        return result;
    }

    public class Apple{
        String color;
        int weight;

        Apple(){
            color = "GREEN";
            weight = 30;
        }
        String getColor(){
            return color;
        }
        int getWeight(){
            return weight;
        }
    }
}
