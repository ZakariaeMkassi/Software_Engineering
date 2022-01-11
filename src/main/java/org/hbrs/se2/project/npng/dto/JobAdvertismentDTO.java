package org.hbrs.se2.project.npng.dto;

import java.time.LocalDate;

public interface JobAdvertismentDTO {

    public String getTitle();
    public String getSector();
    public String getTypOfJobHiring();
    public LocalDate getDate();
    public String getDescription();

}
