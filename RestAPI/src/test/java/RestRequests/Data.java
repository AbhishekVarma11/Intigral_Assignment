package RestRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    //private String id;
    private String name;
    private Device data;  // Nested data object, can be null
}
