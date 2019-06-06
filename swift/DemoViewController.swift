import UIKit
import TradeSDK

class DemoViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        EosWallet.shared.setChainIp(ip: "节点地址")

        // ---- 获取随机秘钥对，返回值逗号分隔（私钥,公钥）-----
        let k = EosWallet.shared.getKey()

        // ---- 发起交易 ----
        let from = "转出账户"
        let to = "转入账户"
        let quantity = "交易金额"
        let memo = "交易备注"
        let code = "合约名"
        let privateKey = "签名账户私钥"

        EosWallet.shared.transfer(from: from, to: to, quantity: quantity, memo: memo, code: code, privateKey: privateKey) { (result, error) in
            // 成功返回result: 交易ID; 失败返回result: nil
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}
