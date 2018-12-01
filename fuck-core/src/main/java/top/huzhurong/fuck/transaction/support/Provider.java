package top.huzhurong.fuck.transaction.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/12/1
 */
@Getter
@Setter
@ToString
public class Provider {
    private String serviceName;
    private String host;
    private Integer port;
    private String version;
}
