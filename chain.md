# 应用链接入说明
帮助你接入应用链的一个说明文档
# NodeJs模式
## 1、安装依赖
### NPM
```
npm install eosjs --save
npm install eosjs-ecc --save
```
## 2、导入依赖
### NodeJs导入
```
const { Api, JsonRpc, RpcError } = require('eosjs');
const { JsSignatureProvider } = require('eosjs/dist/eosjs-jssig');
const fetch = require('node-fetch');
const { TextEncoder, TextDecoder } = require('util');
const eosjs_ecc = require('eosjs-ecc');
```
## 3、配置参数
### 配置应用链节点地址
```
const rpc = new JsonRpc('节点地址', {fetch});
```
### 配置发起交易要用到的私钥
```
const pk = '你的私钥';
const signatureProvider = new JsSignatureProvider([pk]);
```
### 配置API
```
const api = new Api({rpc, signatureProvider, textDecoder: new TextDecoder(), textEncoder: new TextEncoder()});
```
## 4、通过公钥获取账户名
```
let getKeyAccounts_test = function () {
    rpc.history_get_key_accounts('公钥').then(result => {
        // 输出结果
        console.dir(result);
    }).catch(e => {
        // 处理报错信息
        console.dir(e);
    });
};
getKeyAccounts_test();
```
## 5、查询账户信息
```
let getAccount_test = function () {
    rpc.get_account('aaaaaaaaaaaa').then(result => {
        // 输出结果
        console.dir(result);
    }).catch(e => {
        // 处理报错信息
        console.dir(e);
    });
};
getAccount_test();
```
## 6、查询账户特定币种余额
```
let getBalance_test = function () {
    rpc.get_currency_balance(
        'eosio.token',  // 目标币合约
        'aaaaaaaaaaaa', // 目标账户
        'TOK'           // 目标币名
    ).then(result => {
        // 输出结果
        console.dir(result)
    }).catch(e => {
        // 处理报错信息
        console.dir(e)
    })
};
getBalance_test();
```
## 7、查询账户交易记录
```
let getActions_test = function () {
    rpc.history_get_actions(
        'aaaaaaaaaaaa', // 目标账户
        -1,             // 查询起始位置
        -10,            // 查询偏移量
    ).then(result => {
        // 输出结果
        console.dir(result)
    }).catch(e => {
        // 处理报错信息
        console.dir(e)
    })
};
getActions_test();
```
## 8、发起交易
### 创建交易体
```
let tr = {
    actions: [{
        account: 'eosio.token',     // 合约名
        name: 'transfer',           // 合约方法
        authorization: [{
            actor: 'aaaaaaaaaaaa',  // 签名账户
            permission: 'active',
        }],
        data: {
            from: 'aaaaaaaaaaaa',   // 发送账户
            to: 'bbbbbbbbbbbb',     // 接收账户
            quantity: '0.0001 TOK', // 发送金额
            memo: ''                // 备注
        }
    }]
};
```
### 发起交易
```
let pushTRX_test = function () {
    api.transact(tr, {
        blocksBehind: 3,
        expireSeconds: 30,
    }).then(result => {
        // 输出结果
        console.dir(result)
    }).catch(e => {
        // 处理报错信息
        console.dir(e)
    })
};
pushTRX_test();
```
## 9、随机生成秘钥对
```
let randomKey_test = function () {
    eosjs_ecc.randomKey().then(privateKey => {
        // 私钥转换为公钥
        let publicKey = eosjs_ecc.privateToPublic(privateKey);
        let result = {
            privateKey: privateKey,
            publicKey: publicKey
        }
        // 输出结果
        console.dir(result);
    }).catch(e => {
        // 处理报错信息
        console.dir(e);
    });
};
randomKey_test();
```
# H5模式
## 1、安装依赖
### 下载必要文件
```
[dist-web](https://github.com/echizen0312/Tools/tree/master/dist-web)
```
## 2、导入依赖
### 引用js文件
```
<script src='dist-web/eosjs-api.js'></script>
<script src='dist-web/eosjs-jsonrpc.js'></script>
<script src='dist-web/eosjs-jssig.js'></script>
<script src="dist-web/eosjs-ecc.min.js"></script>
```
## 3、配置参数
### 配置应用链节点地址
```
const rpc = new eosjs_jsonrpc.JsonRpc('节点地址');
```
### 配置发起交易要用到的私钥
```
const pk = "私钥";
const signatureProvider = new eosjs_jssig.JsSignatureProvider([pk]);
```
### 配置API
```
const api = new eosjs_api.Api({rpc, signatureProvider});
```
## 4、通过公钥获取账户名（同NodeJs）
## 5、查询账户信息（同NodeJs）
## 6、查询账户特定币种余额（同NodeJs）
## 7、查询账户交易记录（同NodeJs）
## 8、发起交易（同NodeJs）
## 9、随机生成秘钥对（同NodeJs）
