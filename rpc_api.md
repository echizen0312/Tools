# RPC常用接口调用说明
教你怎么调用应用链的RPC接口
## 1、获取账户信息
```
http://{host}:{port}/v1/chain/get_account
POST方式传值到body以下内容
{"account_name":"目标账户名"}
```
## 2、获取账户余额
```
http://{host}:{port}/v1/chain/get_currency_balance
POST方式传值到body以下内容
{"code":"目标币合约","account":"目标账户名","symbol":"目标币种"}
```
## 3、获取账户交易记录
```
http://{host}:{port}/v1/history/get_actions
POST方式传值到body以下内容
{"account_name":"目标账户名","pos":"目标记录id","offset":"查询偏移量"}
```
