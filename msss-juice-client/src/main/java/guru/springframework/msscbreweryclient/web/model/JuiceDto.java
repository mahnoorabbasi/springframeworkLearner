package guru.springframework.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuiceDto {

    private UUID id;
    private String juiceName;
    private String juiceStyle;
    private Long upc;
}
