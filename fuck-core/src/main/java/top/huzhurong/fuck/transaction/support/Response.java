package top.huzhurong.fuck.transaction.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenshun00@gmail.com
 * @since 2018/11/30
 */
@Getter
@Setter
@ToString
public class Response implements Serializable {
    private String requestId;
    private Boolean success;
    private Object object;
    private Boolean async;
    private Throwable exception;
}
