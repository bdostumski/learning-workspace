package combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Borislav", "b.dostumski@gmial.com", "+0889815914", LocalDate.of(1988, 12, 14));
//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        boolean isCustomerValid = validatorService.isValid(customer);
//        System.out.println(isCustomerValid);

        // Using combinator pattern
        // the code is LAZY LOADING until we don't call apply()
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }

}
