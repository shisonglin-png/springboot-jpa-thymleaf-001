package com.offcn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name" ,length = 50,nullable = false)
    private String name;
    @Column(name = "age",length = 50,nullable = false)
    private Long age;
}
