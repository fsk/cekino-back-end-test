package com.cekino.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userdb")
@ApiModel(value = "Entity Model", description = "This Class is Entity Model for project of Cekino BackEnd test")
public class User {


    @Id
//    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "This property is ID for USER model")
    private Long id;

    @ApiModelProperty(value = "This property is NAME for USER model")
    @Column(name = "NAME")
    private String name;

    @ApiModelProperty(value = "This property is SURNAME for USER model")
    @Column(name = "SURNAME")
    private String surname;

    @ApiModelProperty(value = "This property is EMAIL for USER model")
    @Column(name = "EMAIL")
    private String email;

    @ApiModelProperty(value = "This property is USER NAME for USER model")
    @Column(name = "USER_NAME")
    private String userName;

    @ApiModelProperty(value = "This property is AGE for USER model")
    @Column(name = "AGE")
    private Integer age;

    @ApiModelProperty(value = "This property is IDENTITY NUMBER for USER model. And this property must be 11 character.")
    @Column(name = "IDENTITY_NUMBER", length = 11)
    private String identityNumber;

    @ApiModelProperty(value = "This property is GENDER for USER model. And this property must be 1 charachter.")
    @Column(name = "GENDER", length = 1)
    private String gender;

    @Column(name = "CREATED_AT")
    @ApiModelProperty(value = "This property is CreatedAd for USER model. Question: When created this model.?")
    private String createdAd;

    @Column(name = "UPDATED_AT")
    @ApiModelProperty(value = "This property is UpdateAd for USER model. Question: When updated this model.?")
    private String updatedAt;


}
