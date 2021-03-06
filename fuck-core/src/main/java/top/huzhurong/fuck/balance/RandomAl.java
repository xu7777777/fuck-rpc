package top.huzhurong.fuck.balance;

import top.huzhurong.fuck.transaction.support.Provider;

import java.util.List;

/**
 * 随机（Random）法
 *
 * @author chenshun00@gmail.com
 * @since 2018/11/24
 */
public class RandomAl implements LoadBalance {

    @Override
    public Provider getProvider(List<Provider> providers) {
        check(providers);
        int size = providers.size();
        Integer location = size( 0,size - 1);
        Provider provider = providers.get(location);
        if (provider == null) {
            provider = providers.get(0);
        }
        return provider;
    }
}
