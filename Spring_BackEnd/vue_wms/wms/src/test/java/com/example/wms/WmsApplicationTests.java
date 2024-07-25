package com.example.wms;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class WmsApplicationTests {

public void testUuid(){
    for (int i = 0; i < 10; i++) {
        UUID.randomUUID().toString();

    }
}


}
