import io.plactal.eoscommander.rpc.Ecc;
import io.plactal.eoscommander.rpc.Rpc;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] arg) {
        // 初始化
        Rpc rpc = new Rpc("节点地址");

        // 发起交易
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("from", "转出账户");
        args.put("to", "转入账户");
        args.put("quantity", "交易金额");
        args.put("memo", "交易备注");
        String res = rpc.pushTransaction(
                "合约名",
                "方法",
                "签名账户",
                "签名账户私钥",
                args);

        System.out.println(res);

        // 生成秘钥对
        String privateKey = Ecc.seedPrivate("随机种子");
        String publicKey = Ecc.getPublicKey(privateKey);

        System.out.println(privateKey);
        System.out.println(publicKey);
    }
}
