package com.insurance.application.models.dtos;

public class InitialInfoDto {

    private int carBrand;

    private int carModel;

    private String carCubic;

    private String registrationDate;

    private String driverBirthDate;

    private boolean hasAccidents;

    public InitialInfoDto() {
    }

    public int getCarBrand() {
        return carBrand;
    }

    public int getCarModel() {
        return carModel;
    }

    public String getCarCubic() {
        return carCubic;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getDriverBirthDate() {
        return driverBirthDate;
    }

    public boolean getHasAccidents() {
        return hasAccidents;
    }

    public void setCarBrand(int carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarModel(int carModel) {
        this.carModel = carModel;
    }

    public void setCarCubic(String carCubic) {
        this.carCubic = carCubic;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setDriverBirthDate(String driverBirthDate) {
        this.driverBirthDate = driverBirthDate;
    }

    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
    }
}
