package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DoctorValidationTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void shouldValidateName() {
        //given
        String incorrectName = "Name123";
        Doctor doctor = new Doctor("someLogin",
                "somePass",
                incorrectName,
                "IncorrectName123",
                "Surname",
                "Spec"
        );

        //when
        Set<ConstraintViolation<Doctor>> constraintViolations = validator.validate(doctor);

        //then
        Assertions.assertEquals(constraintViolations.size(), 1);
        ConstraintViolation<Doctor> constraintViolation = constraintViolations.iterator().next();
        Assertions.assertEquals(constraintViolation.getInvalidValue(), "IncorrectName123");
    }


}
