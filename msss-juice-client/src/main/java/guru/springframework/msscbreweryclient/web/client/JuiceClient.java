package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.JuiceDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;


@Component
@ConfigurationProperties(value = "sfg.juicer", ignoreUnknownFields = false)
public class JuiceClient {

    public final String JUICE_PATH="/app/v1/juice/";

    private RestTemplate restTemplate;

    public JuiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public JuiceDto getJuiceById(UUID uuid){
        return restTemplate.getForObject(apiHost+JUICE_PATH+uuid.toString(), JuiceDto.class);
    }

    public URI saveJuiceDto(JuiceDto juiceDto){
        return restTemplate.postForLocation(apiHost+JUICE_PATH,juiceDto);
    }
    public void updateJuiceDto(UUID uuid,JuiceDto juiceDto){
        restTemplate.put(apiHost+JUICE_PATH+uuid.toString(),juiceDto);
    }
    public void deleteJuiceDto(UUID uuid){
        restTemplate.delete(apiHost+JUICE_PATH+ uuid);
    }

    String apiHost;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
