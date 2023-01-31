# 测试

| Version | Update Time | Status | Author | Description |
|---------|-------------|--------|--------|-------------|
|v2023-01-31 16:10:37|2023-01-31 16:10:37|auto|@Administrator|Created by smart-doc|



## 
### 使用用户对象登录
**URL:** http://localhost:3000/api/user/login

**Type:** POST


**Content-Type:** application/json

**Description:** 使用用户对象登录

**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false||-|
|username|string|false|用户名|-|
|account|string|false|账号|-|
|password|string|false|密码|-|
|gender|object|false|性别|-|
|education|string|false|学历|-|
|homeAddress|string|false|家庭住址|-|
|email|string|false|邮箱|-|
|identity|string|false|身份证|-|
|dateOfBirth|string|false|出生年月日|-|
|creationTime|string|false|创建时间|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:3000/api/user/login --data '{
  "id": 851,
  "username": "carlton.willms",
  "account": "c5cza0",
  "password": "m0q98f",
  "gender": {
    "object": "any object"
  },
  "education": "6oad39",
  "homeAddress": "0614 Art Greens， Port Theofort， SD 02502",
  "email": "perry.dickinson@gmail.com",
  "identity": "zoyka8",
  "dateOfBirth": "2023-01-31 16:10:38",
  "creationTime": "2023-01-31 16:10:38"
}'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "code": 405,
  "message": "success",
  "data": {}
}
```


