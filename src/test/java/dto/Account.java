package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {
    String name;
    String phone;
    String fax;
    String webSite;
    String rating;
    String industry;
    String street;
    String city;
    String zipCode;
    String priority;
    String locationNumber;
    String opportunity;

    /*public Account(String name, String phone, String fax, String webSite, String rating,
                   String industry, String street, String city, String zipCode, String priority,
                   String locationNumber, String opportunity) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.webSite = webSite;
        this.rating = rating;
        this.industry = industry;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.priority = priority;
        this.locationNumber = locationNumber;
        this.opportunity = opportunity;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getRating() {
        return rating;
    }

    public String getIndustry() {
        return industry;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPriority() {
        return priority;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public String getOpportunity() {
        return opportunity;
    }*/
}
