package ingjulianvega.ximic.msscasucompanion.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Companion implements Serializable {

    static final long serialVersionUID = 810280258361686107L;
    private UUID documentTypeId;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String homePhone;
    private String mobilePhone;
    private String email;

}
