package ingjulianvega.ximic.msscasucompanion.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompanionEntity extends BaseEntity {

    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID documentTypeId;

    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String firstLastName;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String secondLastName;

    @Column(length = 15, columnDefinition = "varchar(15)")
    private String homePhone;

    @Column(length = 15, columnDefinition = "varchar(15)")
    private String mobilePhone;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String email;
}
