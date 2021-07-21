package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 멀티스레드 환경에서 여러개가 동시에 스토어에 접근하게되면 HashMap을 쓰면안된다.
    // 실무에선 해쉬맵을 사용하면안된다! ConcurrentHashMap을 사용

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return  store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    //프로젝트 규모가커지면 UpataParamDto 데이터 클래스를 만들어서 사용하는게 좋다
   public void update(long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear(); // HashMap 데이터 삭제
    }
}
