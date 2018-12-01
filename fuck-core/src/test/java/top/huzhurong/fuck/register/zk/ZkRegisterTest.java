package top.huzhurong.fuck.register.zk;

import org.junit.Before;
import org.junit.Test;
import top.huzhurong.fuck.register.IRegister;
import top.huzhurong.fuck.transaction.support.Provider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/12/1
 */
public class ZkRegisterTest {

    private List<Provider> providers = new ArrayList<>(4);
    private IRegister register = new ZkRegister("127.0.0.1:2181");

    @Before
    public void before() {
        {
            Provider provider = new Provider();
            provider.setHost("127.0.0.1");
            provider.setPort(4376);
            provider.setServiceName("top.huzhurong.fuck.UserService");
            provider.setVersion("1.0.0");
            providers.add(provider);
        }
        {
            Provider provider = new Provider();
            provider.setHost("127.0.0.1");
            provider.setPort(2387);
            provider.setServiceName("top.huzhurong.fuck.UserService");
            provider.setVersion("1.0.0");
            providers.add(provider);
        }
        {
            Provider provider = new Provider();
            provider.setHost("127.0.0.1");
            provider.setPort(8336);
            provider.setServiceName("top.huzhurong.fuck.CheckService");
            provider.setVersion("2.0.0");
            providers.add(provider);
        }
    }

    @Test
    public void registerService() throws InterruptedException {
        register.registerService(providers);
        Thread.sleep(100000000000L);
    }

    @Test
    public void discover() throws InterruptedException {
        List<Provider> discover = register.discover("top.huzhurong.fuck.UserService", "1.0.0");
        discover.forEach(System.out::println);
        discover.forEach(provider -> {
            String path = ZkRegister.root_path + "/" + provider.getServiceName() + ZkRegister.root_provider;
            ((ZkRegister) register).getZkClient().subscribeChildChanges(path, (parent, children) -> {
                System.out.println(parent);
                children.forEach(System.out::println);
                System.out.println("=============");
            });
        });
        Thread.sleep(100000000000L);
    }
}