# RPC常用接口调用说明
教你怎么调用应用链的RPC接口
## 1、获取账户信息
```
http://59.110.220.75:8888/v1/chain/get_account
POST方式传值到body以下内容
{"account_name":"目标账户名"}
```
## 2、获取账户余额
```
http://59.110.220.75:8888/v1/chain/get_currency_balance
POST方式传值到body以下内容
{"code":"目标币合约","account":"目标账户名","symbol":"目标币种"}
```
## 3、获取账户交易记录
```
http://59.110.220.75:8888/v1/history/get_actions
POST方式传值到body以下内容
{"account_name":"目标账户名","pos":"目标记录id","offset":"查询偏移量"}
```
## 4、创建账户
```
http://59.110.220.75/eosSak/CreateSysAccount
POST方式传值到body以下内容
{"accountName":"想创建的账户名","pk":"想创建的账户的公钥"}
```
