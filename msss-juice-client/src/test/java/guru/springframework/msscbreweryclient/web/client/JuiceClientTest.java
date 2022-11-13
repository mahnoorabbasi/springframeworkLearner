package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.JuiceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JuiceClientTest {

    @Autowired
    JuiceClient client;
    @Test
    void getJuiceById() {
        JuiceDto juiceDto=client.getJuiceById(UUID.randomUUID());
        assertNotNull(juiceDto);
    }

    @Test
    void saveJuiceDto(){
        JuiceDto juiceDto=JuiceDto.builder().juiceName("NewJuice").build();
        URI uri=client.saveJuiceDto(juiceDto);
        assertNotNull(uri);
        System.out.println(uri);

    }
    @Test
    void updateJuiceDto(){
        UUID uuid=UUID.randomUUID();
        JuiceDto juiceDto=JuiceDto.builder().id(uuid).juiceName("NewJuice").build();
        client.updateJuiceDto(juiceDto.getId(),juiceDto);


    }
    @Test
    void deleteJuiceDto(){
        client.deleteJuiceDto(UUID.randomUUID());


    }
}