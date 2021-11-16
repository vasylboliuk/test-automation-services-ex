package paleceholder.service;

import org.assertj.core.api.Assertions;
import org.automation.models.placeholder.UserDto;
import org.automation.services.Services;
import org.automation.testcases.groups.BaseGroups;
import org.testng.annotations.Test;
import paleceholder.BaseTestNgTests;


public class TestUserCrud extends BaseTestNgTests {

    @Test(testName = "TC-01",
          description = "REST: POST: Verify ability to create new user",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testCreatingNewUser() {
        UserDto userDto = new UserDto();
//            .setUserName(name)
//            .setEmail(email)
//            .setAddress(addressDto)
//            .setPhone(phone);
        UserDto createdUserResponse = Services.placeholderApi().user().create(userDto);

        // Verification
        Assertions.assertThat(createdUserResponse)
            .usingRecursiveComparison()
            .ignoringAllOverriddenEquals()
            .ignoringFields("id")
            .isEqualTo(userDto);
    }

}
