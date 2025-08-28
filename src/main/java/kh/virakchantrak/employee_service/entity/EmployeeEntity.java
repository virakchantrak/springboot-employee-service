package kh.virakchantrak.employee_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import kh.virakchantrak.library.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = EmployeeEntity.TABLE_NAME)
public class EmployeeEntity extends BaseEntity {
    public static final String TABLE_NAME = "employees";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    @Email
    private String email;

    private String position;

    private String departmentCode;
}
