package top.huzhurong.fuck.transaction.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author chenshun00@gmail.com
 * @since 2018/11/30
 */
@Getter
@Setter
@ToString
public class Request implements Serializable {
    private String requestId;
    private String serviceName;
    private String methodName;
    private Class<?>[] parameters;
    private Object[] args;
    private Boolean async;
    /**
     * 1 biz
     * 2 heart
     */
    private Integer code = 1;
    transient private String serialization;
    transient private Provider provider;
    transient private Integer timeout;
    transient private Method method;

    public static Request buildRequest(Provider provider, Method method, Object[] args, Integer timeout) {
        Request request = new Request();
        request.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
        request.setServiceName(provider.getServiceName());
        request.setArgs(args);
        request.setMethodName(method.getName());
        request.setParameters(method.getParameterTypes());
        request.setSerialization(provider.getSerialization());
        request.setProvider(provider);
        request.setTimeout(timeout);
        request.setMethod(method);
        return request;
    }
}
