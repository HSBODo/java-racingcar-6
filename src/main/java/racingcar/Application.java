package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
      inputCarName();


    }
    public static String inputCarName(){
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      String input = Console.readLine();
      return input;
    }

    public static String[] inputCarNameSplit(String inputCarName){
      String[] cars = inputCarName.split(",");

      if(cars.length<2){
        throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분합니다.");
      }

      return cars;
    }

    public static Map<String,Integer> inputCarNameValidation(String[] inputCarNameSplit){
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차이름은 5자 이하만 가능합니다.");
        }

        cars.put(car,0);
      }

      return cars;
    }

    public static String inputAttempts(){
      System.out.println("시도할 회수는 몇회인가요?");
      String input = Console.readLine();
      return input;
    }

    public static int inputAttemptsValidation(String inputAttempts){
      try {
        int attempts = Integer.parseInt(inputAttempts);
        return attempts;

      } catch (NumberFormatException e){
        throw new IllegalArgumentException("숫자만 입력해 주세요.");
      }
    }

    public static Map<String,Integer> movementCount(Map<String,Integer> cars){

      cars.forEach((carName, movement) -> {
        int number = Randoms.pickNumberInRange(1, 9);

        if(number>=4){
          movement = movement.intValue();
          movement++;
          cars.replace(carName,movement);
        }
      });

      return cars;
    }

    public static void progressDisplay(Map<String,Integer> cars){
      cars.forEach((carName, movement) -> {
        String result = "";
        for(int i =  1; i<=movement ; i++){
          result+="-";
        }
        System.out.println(carName + " : " + result);

      });
      System.out.println("");
    }

    public void winnerDisplay(Map<String,Integer> cars){

    }
}
