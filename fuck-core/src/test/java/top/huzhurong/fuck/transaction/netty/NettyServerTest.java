package top.huzhurong.fuck.transaction.netty;

import org.junit.Test;
import top.huzhurong.fuck.register.IRegister;
import top.huzhurong.fuck.register.zk.ZkRegister;
import top.huzhurong.fuck.serialization.ISerialization;
import top.huzhurong.fuck.serialization.protobuff.ProtoBuffSerilize;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/12/1
 */
public class NettyServerTest {

    @Test
    public void nettyServer() {
        ISerialization serialization = new ProtoBuffSerilize();
        IRegister register = new ZkRegister("127.0.0.1:2181");

        UserService userService = new DefaultUserService();
        NettyServer nettyServer = new NettyServer(serialization, userService, register);
        //zkCli 可以查看服务信息
        nettyServer.bind(21111);
    }

}