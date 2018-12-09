package top.huzhurong.fuck.transaction.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.UUID;

/**
 * @author luobo.cs@raycloud.com
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
    transient private String serialization;
    transient private Provider provider;
    transient Integer timeout;

    public static Request buildRequest(Provider provider, Method method, Object[] args,Integer timeout) {
        Request request = new Request();
        request.setRequestId(UUID.randomUUID().toString());
        request.setServiceName(provider.getServiceName());
        request.setArgs(args);
        request.setMethodName(method.getName());
        request.setParameters(method.getParameterTypes());
        request.setSerialization(provider.getSerialization());
        request.setProvider(provider);
        request.setTimeout(timeout);
        return request;
    }
}
