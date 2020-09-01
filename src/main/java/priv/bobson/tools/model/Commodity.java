package priv.bobson.tools.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Commodity {
    private String name;
    private String shop;
    private String market;
    private String keyword;
    private String link;
    private int price;
}
