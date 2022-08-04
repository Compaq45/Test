package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "Usrs")

public class User {
    @Id
    private long userId;

    private String firstName;
    private String lastName;
    private String ldapaccount;
    private long groupId;
}
