package pl.sda.medicalcrm.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmailSenderDto {

    @Email
    private String patientEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String patientName;


    private String emailTitle;
    private String emailHeader;
    private String emailText;
}

















