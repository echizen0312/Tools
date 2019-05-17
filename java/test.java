import io.plactal.eoscommander.rpc.utils.Rpc;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] arg) {
        Rpc rpc = new Rpc("http://59.110.220.75:8888");

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
    }
}
