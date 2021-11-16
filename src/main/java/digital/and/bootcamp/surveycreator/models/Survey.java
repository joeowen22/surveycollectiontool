package digital.and.bootcamp.surveycreator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
public class Survey {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private List<String> questions;

}
