package org.automation.testcases.testdata;

import org.automation.generators.Generator;
import org.automation.models.placeholder.user.AddressDto;
import org.automation.models.placeholder.user.UserDto;

public class UserTestData {

    UserTestData() {
        // default constructor
    }

    public UserDto randomUser() {
        return UserDto.newBuilder()
            .withEmail(Generator.randomString() + "@pochta.com")
            .withAddress(new AddressDto()
                .setCity("Lviv")
                .setStreet("Bandery")
                .setSuite("Lviv reg")
                .setZipcode("79000")
                .setAddressGeo("", "")
            )
            .withPhone("123-456-789")
            .withWebsite("www.userapisite.com.ua")
            .withCompany("hata na tata LC", "", "target do not burn hata")
            .build();
    }

}
