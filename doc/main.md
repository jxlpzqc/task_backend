# 任务提交系统后端接口

## /sendsms

```json
{
    "phonenumber":""
}
```

#### 成功

```
{
	"status":true,
	"message":"发送成功"
}
```

#### 失败

```json
{
	"status":false,
	"message":"您发送过于频繁，请稍后再试"
}
```



---

## /login

##### 无账号直接注册普通用户账号，uplevel是上级用户的username

```json
{
	"phonenumber":"用户手机号",
    "code":"短信验证码",
    "uplevel":"username",
    "admin":false
}
```

##### 管理员登录

```json
{
    "username":"",
    "password":"",
    "admin":true
}
```



#### 成功

```json
{
    "status":true,
    "message":"登陆成功"
    "sessionkey":"sessionkey"
    "admin":true/false
}
```

#### 失败

```json
{
    "status":false,
    "message":"登录失败,验证码输入错误"
}
```

---

## /admin/registAdmin

##### 管理员账号注册

```json
{
    "sessionkey":"其他管理员的session",
    "username":"用户名",
    "password":"密码"
}
```

#### 成功

```json
{
    "status":true,
    "message":"注册成功"
}
```

#### 失败

```json
{
    "status":false,
    "message":"注册失败，您没有权限/管理员用户名已存在"
}
```

## /admin/getAdminList

##### 获取管理员列表

```json
{
    "sessionkey":"",
}
```

#### 成功

```json
{
    "status":true,
    "data":[
        {
            "username":"abc"
        },
        {
            "username":"def"
        }
    ]
}
```

## /admin/removeAdmin

##### 删除管理员

```json
{
    "sessionkey":"",
    "username":""
}
```

#### 成功

```json
{
    "status":"true",
	"message":"删除成功"
}
```

#### 失败

```json
{
    "status":false,
	"message":"删除失败"
}
```

## /task/putTask

##### 添加任务(管理员和普通用户都行)

```json
{
    "sessionkey":"",
    "title":"",
    "content":"",
    "fee":10.5,
    "new":true
}
```

##### 重新申请被驳回的任务

```json
{
    "sessionkey":"",
    "taskid":"",
    "new":false
}
```

#### 成功

```json
{
    "status":true,
    "taskid":"",
    "message":"发布成功，等待管理员审核"
}
```

#### 失败

```json
{
    "status":false,
    "message":"发布失败"
}
```

## /task/getSendTasks

##### 获取我发布的任务的列表 task元素的status字段0代表此发布未支付，1代表此发布等待admin审核，2代表发布被admin驳回，3代表发布成功，4代表已有人接单，5代表已收货

```json
{
    "sessionkey":"",
    "page":0,
    "size":5
}
```

#### 成功

```json
{
	"status":true,
    "data":[
        {
            "id":"taskid",
            "status":1,
            "title":"",
            "content":""
        }
    ]
}
```

#### 失败

```json
{
    "status":false
    "message":"获取失败"
}
```

## /task/getTaskById

##### 用户用id获取task内容

```json
{
    "sessionkey":"",
    "taskid":""
}
```

#### 成功

```json
{
    "status":true,
    "data":{
        "title":"",
        "status":1,
        "content":""
    }
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```

## /getUserTask

##### 获取指定用户的所有task

```json
{
    "selectuser":true,
    "username":"",
    "page":"",
    "size":""
}
```

##### 获取所有用户的所有task

```json'
{
	"sessionkey":"",
    "selectuser":false,
    "page":""
    "size":""
}
```

#### 成功

```json
{
    "status":true,
    "data":[
        {
            "status":1,
            "id":"",
            "title":"",
            "content":""
        }
    ]
}
```

#### 失败

```json'
{
	"status":false,
	"message":"您没有权限"
}
```



## /admin/refuseTask

##### 管理员拒绝task任务发布 或者撤回已发布任务

```json
{
    "sessionkey":"",
    "taskid"
}
```

#### 成功

```json
{
    "status":true,
    "message":"撤回成功"
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```

## /admin/acceptTask

##### 管理员通过task

```json
{
    "sessionkey":"",
    "taskid":""
}
```

#### 成功

```json
{
    "status":true,
    "message":"撤回成功"
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```

## /getcash

##### 用户申请提现接口

```json
{
    "sessionkey":"",
    "fee":52.4
}
```

#### 成功

```json
{
    "status":true,
    "message":"提现成功，现金稍后到账微信"
}
```

#### 失败

```json
{
    "status":false,
    "message":"失败，您没有权限"
}
```

## /receiveTask

##### 用户接单接口

```
{
	"sessionkey":true,
	"taskid":""
}
```

#### 成功

```json
{
    "status":true,
    "message":"接单成功"
}
```

#### 失败

```json
{
    "status":false,
    "message":"接单失败"
}
```

## /getReceivedTasks

##### 用户获取管理员通过了的接单，task对象的status的0代表已接但是管理员还未通过的，1代表管理员驳回的，2代表已确认收获的（确认收货钱到账）

```json
{
    "sessionkey":true,
    "page":0,
    "size":5
}
```

#### 成功

```json
{
    "status":true,
    "data":[
        {
            "username":"",
            "id":"taskid",
            "status":1/2,
            "title":"",
            "content":""
        }
    ]
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```

## /payTask

##### 为某任务支付酬金

```json
{
    "sessionkey":"",
    "taskid":""
}
```

#### 成功

```json
{
    "status":true,
    "wxdata":{
        "timeStamp": "1557818968759",
        "package": "prepay_id=wx14152928725959d03d01cfa72839770060",
        "paySign": "A2824366A539ADF48D6BC5BCA28E6678",
        "appId": "wxa29ce004daf82d48",
        "signType": "MD5",
        "nonceStr": "d2e24dc8ebde45b3895761658c68243b"
    }
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```



## /wxlogin

##### 微信登录接口,hasphonenum代表服务器有没有获取用户手机号，若没有则需要按login接口获取，若有则不需要

```json
{
    "encrypted_data":"",
    "iv":"",
    "code":""
}
```

#### 成功

```json
{
    "status":true,
    "sessionkey":"",
    "hasphonenum":false
}
```

#### 失败

```json
{
    "status":false,
    "message":"登录失败"
}
```



## /cancelTask

##### 用户取消任务

```json
{
    "sessionkey":"",
    "taskid":""
}
```

#### 成功

```json
{
    "status":true,
    "message":"取消成功"
}
```

#### 失败

```json
{
    "status":false,
    "message":"您没有权限"
}
```

## 

## /get_cos_credentials

##### 获取腾讯云对象存储秘钥

```json
{
    "sessionkey":""
}
```

#### 成功

```json
{
    "status":true,
    "data":{
    "credentials": {
            "tmpSecretId": "AKIDV7Ht5GMyFZrUlHPu1SDXhRTQKqfDYqMz5NMkwDOEc_-4z6Lvuq3ippsMK2kEzzV3",
            "tmpSecretKey": "vMt63Pq6bJMUMWcTN4sgB/K6C3o8cfAvgJ1Lwfztgek=",
            "sessionToken": "y2QE4Z95PUl7SI3TwrKhKGY1laztb76ef0e74b0bd1a3dd6aed7d14c06458d3865x-_ao8k10UidUh40OXFfhFc0SymiEhL7juuKvgd0UHsLPyS9KcFpKFhi6t36_ypzBYttWNj166RIkz3_LsJPPS4mHyrS_YFWVAV3PFEEyr8rTI2qpPa-eHz0FgYLJFkHx-Sm4eYrUjmGBTmAEnj7AHWoIK71UK5Su12V9ZHiB9nxVOqVPZ4piq2rNC6Gtekw1tBmg-j-r6IfW9j_MMlG3gna3KeXkpWuCPij7DnS9I"
        },
        "requestId": "0ae29ed6-ad34-4759-9751-66d00e4fa066",
        "expiration": "2020-03-20T06:59:01Z",
        "startTime": 1584687421,
        "expiredTime": 1584687541
    }
}
```

## /getBalance

##### 获取账户余额

```json
{
    "sessionkey":""
}
```

#### 成功

```json
{
    "balance":58.38,
    "status":true
}
```

#### 失败

```
{
	"status":false
}
```

## /getUserInfo
通过sessionKey拿到用户信息
```
{
	sessionKey:'dsf341jkl432jlk1'
}
```

### Response
```
{
	status:true
	message:null
	phonenumber:''
	admin:true
}
```
