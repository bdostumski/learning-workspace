package com.example.lombokexample.model;

import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor // default constructor
@AllArgsConstructor
@RequiredArgsConstructor() // create constructor only with fields data are set @NotNull
@ToString(exclude = "minutes") // exclude minutes field from toString method
@EqualsAndHashCode(exclude = "minutes") // exclude minutes field from equals and hash code methods
@Builder // use builder design pattern to create builder for Movie class
//@Data // automatically generate getters, setters, toString, equals, hashCode methods
@Slf4j(topic = "MovieDAO") // topic rename the Movie class to MovieDAO for the log.info() method
//@CustomLog // use lombok.config file to configure logging data
public class Movie {

//    @Setter(AccessLevel.NONE) // Does not create setters
//    @Getter(AccessLevel.NONE) // Does not create getters
    @Accessors(fluent = true) // remove get and set prefix on the methods [instead getId(), now it is id()]
    @NotNull
    private Long id;

    @NotNull
    private String title;

    private String description;

    private String country;

    @NotNull
    private int rating;

    @Setter(AccessLevel.PROTECTED)
    private URL officialSite;

    private String language;

    @Singular("cast") // now we can add only one object that is contained in the list, no need to create list for it
    private List<String> cast;

    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    @Builder.Default // because minutes are final or can be static,
        // they will not exist in the builder class use this annotation to add them
    private final int minutes = 120;

    public int getMinutesPlusX(@NotNull int x) {
        log.info("Adding {}", x); // used from @Slf4j annotation
//        log.info("Adding " + x); // used from @CustomLog annotation
        return this.minutes + x;
    }
}
