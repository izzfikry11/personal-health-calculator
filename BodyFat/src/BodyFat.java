package BodyFat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.soap.SOAPFaultException;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPFault;

@WebService(serviceName = "BodyFat")
public class BodyFat {

    @WebMethod(operationName = "calculateBodyFat")
    public String calculateBodyFat(
            @WebParam(name = "bmi") double bmi, 
            @WebParam(name = "age") int age, 
            @WebParam(name = "gender") String gender) {
        
        if (gender == null || (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))) {
            try {
                SOAPFault fault = SOAPFactory.newInstance().createFault();
                fault.setFaultString("Invalid Input Error: Gender must be specified as 'male' or 'female'.");
                throw new SOAPFaultException(fault);
            } catch (SOAPFaultException sfe) {
                throw sfe;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        
        if (bmi <= 0 || age < 0) {
            try {
                SOAPFault fault = SOAPFactory.newInstance().createFault();
                fault.setFaultString("Invalid Input Error: BMI and Age must be greater than zero.");
                throw new SOAPFaultException(fault);
            } catch (SOAPFaultException sfe) {
                throw sfe;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        double bfp = 0.0;
        boolean isMale = gender.equalsIgnoreCase("male");

        if (age >= 18) {
            if (isMale) {
                bfp = (1.20 * bmi) + (0.23 * age) - 16.2;
            } else {
                bfp = (1.20 * bmi) + (0.23 * age) - 5.4;
            }
        } else {
            if (isMale) {
                bfp = (1.51 * bmi) - (0.70 * age) - 2.2;
            } else {
                bfp = (1.51 * bmi) - (0.70 * age) + 1.4;
            }
        }

        if (bfp < 0) {
            bfp = 0.0;
        }

        String status;
        if (age >= 18) {
            if (isMale) {
                if (bfp < 6.0) status = "Essential Fat / Too Low - Consider reviewing nutritional intake.";
                else if (bfp >= 6.0 && bfp < 14.0) status = "Athletic - Excellent body composition with lean muscle focus.";
                else if (bfp >= 14.0 && bfp < 18.0) status = "Fitness - Healthy and well-proportioned body fat level.";
                else if (bfp >= 18.0 && bfp < 25.0) status = "Average - Acceptable ranges, maintaining an active routine is advised.";
                else status = "High Body Fat - Watching your caloric intake and active cardio routines is recommended.";
            } else {
                if (bfp < 14.0) status = "Essential Fat / Too Low - Consider reviewing nutritional intake.";
                else if (bfp >= 14.0 && bfp < 21.0) status = "Athletic - Excellent body composition with lean muscle focus.";
                else if (bfp >= 21.0 && bfp < 25.0) status = "Fitness - Healthy and well-proportioned body fat level.";
                else if (bfp >= 25.0 && bfp < 32.0) status = "Average - Acceptable ranges, maintaining an active routine is advised.";
                else status = "High Body Fat - Watching your caloric intake and active cardio routines is recommended.";
            }
        } else {
            if (bfp < 10.0) status = "Low Body Fat Range - Support growth with healthy nutrient-dense diets.";
            else if (bfp >= 10.0 && bfp < 26.0) status = "Normal Range - Healthy composition optimal for physical development.";
            else status = "Elevated Body Fat Range - Focus on promoting fun physical play and balanced nutrition.";
        }

        return String.format("Your Body Fat Percentage is: %.2f%%. Status: %s", bfp, status);
    }
}