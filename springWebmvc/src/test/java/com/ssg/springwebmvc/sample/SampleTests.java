package com.ssg.springwebmvc.sample;

import com.ssg.springwebmvc.prof.Lecture;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)      // Junit 버전에서 spring-test 이용하기 위한 설정 이노테이션
// 스프링의 섫정 정보를 로딩하기 위한
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
    // serivce DI 의존성 주입
    // 스프링에서 사용하는 의존성 주입 어노테이션

    @Autowired
    private SampleService sampleService;
    // SampleService를 멤버 변수 선언
    // 만일 지정된 빈이 존재한다면 이곳에 주입

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Lecture lecture;

    @Test
    public void testSampleService() {
        log.info("---------------------------------------------------------------------------------------");
        log.info(sampleService);
        log.info("---------------------------------------------------------------------------------------");
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testRestaurant() {
        log.info("---------------------------------------------------------------------------------------");
        log.info(restaurant);
        log.info("---------------------------------------------------------------------------------------");
        Assertions.assertNotNull(restaurant);
    }

    @Test
    public void testLecture() {
        log.info("---------------------------------------------------------------------------------------");
        log.info(lecture);
        log.info("---------------------------------------------------------------------------------------");
        Assertions.assertNotNull(lecture);
    }
}
