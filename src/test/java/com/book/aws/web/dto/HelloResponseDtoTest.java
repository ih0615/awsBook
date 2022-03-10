package com.book.aws.web.dto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void dtoTest() {
        //given
        String name = "test";
        int amount = 10000;
        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);
        //then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}