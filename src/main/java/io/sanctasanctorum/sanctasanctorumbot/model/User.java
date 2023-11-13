package io.sanctasanctorum.sanctasanctorumbot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity(name = "userDataTable")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    Long id;

    String firstName;

    String lastName;

    String userName;

    Timestamp registeredAt;
}
