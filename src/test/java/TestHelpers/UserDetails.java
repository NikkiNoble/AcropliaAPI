package TestHelpers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetails {
   @JsonProperty("uuid")
    private String uuid;
}
