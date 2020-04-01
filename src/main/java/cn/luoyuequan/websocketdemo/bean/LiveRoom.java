package cn.luoyuequan.websocketdemo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p>
 * 直播房间
 * </p>
 *
 * @author luoyuequan
 * @date 2020/04/01
 * @time 10:50
 */
@Getter
@Setter
@Accessors(chain = true)
public class LiveRoom<T> {
    /**
     * 房间号
     */
    private Long roomId;
    /**
     * 播主
     */
    private T broadcaster;
    /**
     * 观众
     */
    private Set<T> audience;

    public LiveRoom(Long roomId, T broadcaster) {
        this.roomId = roomId;
        this.broadcaster = broadcaster;
        this.audience = new CopyOnWriteArraySet<>();
    }

}
