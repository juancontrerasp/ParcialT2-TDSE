package co.edu.eci.lambda.springrest.web;

import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import co.edu.eci.lambda.springrest.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/fibwin")
    public Operation fib(@RequestParam(value = "n", defaultValue = "0") int n){
        n++;
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i ++){
            nums.add(fibonnaci(i));
        }

        return new Operation(n, nums, window(nums));
    }


    private int fibonnaci(int n){
        int a = 0;
        int b = 1;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fibonnaci(n-1) + fibonnaci(n-2);
    }

    private ArrayList<Integer> window(ArrayList<Integer> original) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i < original.size(); i++){
            result.add(original.get(i)*2);
        }
        return result;
    }





    //@GetMapping("/greeting")
    //public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //    return new Greeting(counter.incrementAndGet(), String.format(template, name));
    //}
}
