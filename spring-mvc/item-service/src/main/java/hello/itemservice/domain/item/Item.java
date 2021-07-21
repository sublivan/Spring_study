package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@Data // 핵심도메인에서는 위험하다 : 예측하지 못하게 동작할 수 있다., 필요한것만 찾아서 쓰기
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // 가격 책정 안될 수 있기에, null 허용
    private Integer quantity; // 수량 책정 안될 수 있기에, null 허용

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
