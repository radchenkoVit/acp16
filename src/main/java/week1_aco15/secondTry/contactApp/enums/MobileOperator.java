package week1_aco15.secondTry.contactApp.enums;

import java.util.Arrays;
import java.util.List;

public enum  MobileOperator {
    Unknown(Arrays.asList("")),
    Life(Arrays.asList("063", "093")),
    KyivStar(Arrays.asList("067", "097")),
    MTC(Arrays.asList("050", "095"));

    private List<String> operatorIdList;

    MobileOperator(List<String> operatorIdList){
        this.operatorIdList = operatorIdList;
    }

    public List<String> getOperatorIdList(){return operatorIdList;}

    public static MobileOperator getMobileOperator(String phoneNumber){
        String operatorId = phoneNumber.substring(2, 5);

        for (MobileOperator operator: MobileOperator.values()){
            if (operator.getOperatorIdList().contains(operatorId))
                return operator;
        }

        return Unknown;
    }
}
