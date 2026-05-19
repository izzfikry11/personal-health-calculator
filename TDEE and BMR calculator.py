package healthcalculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CaloriesBurnService")
public class CaloriesBurnService {

    @WebMethod(operationName = "calculateTDEE")
    public String calculateTDEE(
            @WebParam(name = "weightPounds") double weightPounds,
            @WebParam(name = "heightFeet") double heightFeet,
            @WebParam(name = "heightInches") double heightInches,
            @WebParam(name = "age") int age,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "minutesExercise") int minutes) {

        // Input Validation
        if (weightPounds <= 0 || heightFeet <= 0 || age <= 0) {
            return "SOAP Fault: Invalid input values.";
        }

        // Convert units
        double KG = weightPounds / 2.20462;
        double CM = (heightFeet * 30.48) + (heightInches * 2.54);

        // Calculate BMR
        double BMR;

        if (gender.equalsIgnoreCase("male")) {
            BMR = (10 * KG) + (6.25 * CM) - (5 * age) + 5;
        } else {
            BMR = (10 * KG) + (6.25 * CM) - (5 * age) - 161;
        }

        // Activity multiplier
        double multiplier;

        if (minutes <= 60) {
            multiplier = 1.2;
        } else if (minutes <= 150) {
            multiplier = 1.375;
        } else if (minutes <= 300) {
            multiplier = 1.55;
        } else if (minutes <= 420) {
            multiplier = 1.725;
        } else {
            multiplier = 1.9;
        }

        // Calculate TDEE
        double TDEE = Math.ceil(BMR * multiplier);

        // Calorie goals
        double mildLoss = TDEE - 250;
        double moderateLoss = TDEE - 500;
        double mildGain = TDEE + 250;
        double moderateGain = TDEE + 500;

        // Output
        String result =
                "===== Calories Burn Rate Report =====\n" +
                "BMR: " + Math.ceil(BMR) + " kcal/day\n" +
                "TDEE: " + TDEE + " kcal/day\n\n" +

                "Calorie Goals:\n" +
                "Maintenance: " + TDEE + " kcal/day\n" +
                "Mild Weight Loss: " + mildLoss + " kcal/day\n" +
                "Moderate Weight Loss: " + moderateLoss + " kcal/day\n" +
                "Mild Weight Gain: " + mildGain + " kcal/day\n" +
                "Moderate Weight Gain: " + moderateGain + " kcal/day";

        return result;
    }
}
