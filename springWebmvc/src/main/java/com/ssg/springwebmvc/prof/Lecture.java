package com.ssg.springwebmvc.prof;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@ToString
public class Lecture {

    private final Professor professor;
}
