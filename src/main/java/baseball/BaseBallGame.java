package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class BaseBallGame {

    static String computerAnswer="";
    static String userAnswer="";
    static List<String> computer = new ArrayList<>();

    public void start() throws IllegalArgumentException{
        System.out.println("숫자 야구게임을 시작합니다.");
        computerAnswer=computerInput();

        // 사용자 입력
        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            userAnswer = readLine();
            userAnswer=checkUserInput();
            if(userAnswer.equals("재시작")) {
                start();
                return;
            }
            else if(userAnswer.equals("종료")) return;

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            break;
        }
    }
    //사용자 입력값 체크
    private String checkUserInput() throws IllegalArgumentException{
        if(userAnswer.equals("1")) return "재시작";
        else if(userAnswer.equals("2")) return "종료";

        if(userAnswer.length() !=3){
            throw new IllegalArgumentException();
        }

        //중복검사
        String[] answerRepeat = userAnswer.split("");
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(answerRepeat[i].equals(answerRepeat[j]))  throw new IllegalArgumentException();
            }
        }
        return userAnswer;
    }

    //컴퓨터 값 입력
    private String computerInput() {
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // List<String> => 문자열로 변환
        return computer.stream().collect(Collectors.joining());
    }

}
