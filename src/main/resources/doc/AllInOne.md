# 测试

| Version | Update Time | Status | Author | Description |
|---------|-------------|--------|--------|-------------|
|v2023-02-01 09:47:29|2023-02-01 09:47:29|auto|@Administrator|Created by smart-doc|



## 
### 
**URL:** http://localhost:3000

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 

**Request-example:**
```
curl -X GET -i http://localhost:3000/
```

**Response-example:**
```
string
```

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
  "id": 161,
  "username": "annita.krajcik",
  "account": "hmrpvx",
  "password": "n0v1k4",
  "gender": {
    "object": "any object"
  },
  "education": "ta9cmq",
  "homeAddress": "2834 Ryan River， Annmarieside， LA 74928",
  "email": "andreas.schaden@gmail.com",
  "identity": "58j83m",
  "dateOfBirth": "2023-02-01 09:47:31",
  "creationTime": "2023-02-01 09:47:31"
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
  "code": 585,
  "message": "success",
  "data": {}
}
```

### 
**URL:** http://localhost:3000/api/user/test

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 

**Request-example:**
```
curl -X GET -i http://localhost:3000/api/user/test
```

**Response-example:**
```
string
```

### 上传Excel 用户数锯
**URL:** http://localhost:3000/api/user/upload

**Type:** POST


**Content-Type:** multipart/form-data

**Description:** 上传Excel 用户数锯

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|file|file|false|No comments found.|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: multipart/form-data' -F 'file=' -i http://localhost:3000/api/user/upload
```

**Response-example:**
```
string
```


