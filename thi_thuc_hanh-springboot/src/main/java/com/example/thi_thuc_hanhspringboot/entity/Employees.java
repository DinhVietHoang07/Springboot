package com.example.thi_thuc_hanhspringboot.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    private String id;
    private String name;
    private double wage;
    private int status;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;

}
