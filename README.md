# GuliMall
谷粒商城项目

### 环境配置：

- ubuntu安装docker：

  ```
  curl -fsSL get.docker.com -o get-docker.sh
  sudo sh get-docker.sh --mirror Aliyun
  
  //启动docker
  systemctl enable docker
  systemctl start docker
  ```

- 安装mysql

  ```
  docker pull --platform linux/amd64 mysql
  
  //启动mysql容器
  docker run -p 3306:3306 --name mysql \
  -v /mydata/mysql/log:/var/log/mysql \
  -v /mydata/mysql/data:/var/lib/mysql \
  -v /mydata/mysql/conf:/etc/mysql  \
  -e MYSQL_ROOTPASSWORD=root \
  -d mysql:5.7
  ```

  M1 芯片有bug，直接在主机使用docker安装mysql

  ```yaml
  version: "3.9"
  services:
    db:
      container_name: mysql57
      image: mysql/mysql-server:5.7
      environment:
        MYSQL_DATABASE: 'db'
        MYSQL_ROOT_PASSWORD: 'root'
        MYSQL_ROOT_HOST: '%'
      ports:
        - '3306:3306'
      expose:
        - '3306'
      volumes:
        - './mydata/mysql/data:/var/lib/mysql'
        - './initial.sql:/docker-entrypoint-initdb.d/initial.sql'
        - './mysql_5.1.7/SQLDATA:/SQLDATA'
        - './mydata/mysql/conf:/etc/mysql'
  
    # for WebUI
    adminer:
      image: adminer:4.8.1
      ports:
        - "10010:8080"
  
  ```



- 安装redis

  ```
  docker pull redis
  ```

- 配置git

  ```
  git config --global user.name  ""
  git config --global user.email ""
  
  ssh-keygen -t rsa -C "email" 
  ```

### 创建项目微服务

商品服务、仓储服务、订单服务、优惠券服务、用户服务

共同点：

1）web，openfeign

2）每一个服务包名都是`com.gulimall.xxx`（product/order/ware/coupon/member)

3）模块名 gulimall-xxx

  ![image-20230210152942270](README.assets/image-20230210152942270.png)



导入数据库文件

![image-20230210153027177](README.assets/image-20230210153027177.png)



### 使用人人开源搭建后台管理系统

```
git clone https://gitee.com/renrenio/renren-fast.git
```

![image-20230210153512938](README.assets/image-20230210153512938.png)

将lombok 版本修改为：`1.8.20`

```
git clone https://gitee.com/renrenio/renren-fast-vue.git
```

![image-20230210153557910](README.assets/image-20230210153557910.png)

M1 芯片运行时需要将node版本降级：

```
解决方法：将node版本降低为14
1.安装版本控制工具： sudo npm install n -g
2.安装14版本：sudo n 14
  ps:安装稳定版本 sudo n stable
     安装最新版本 sudo n latest
3.npm install --ignore-scripts (执行前删除node-modules)
```

renren-fast-vue 报错：

![image-20230210165556814](README.assets/image-20230210165556814.png)

```
npm install --save node-sass --unsafe-perm=true --allow-root
```

![image-20230210170046272](README.assets/image-20230210170046272.png)



安装代码生成器：

```
git clone https://gitee.com/renrenio/renren-generator.git
```

 springboot2.6及以后的版本要在yml加上

```
spring:
  main:
    allow-circular-references: true
```

要不然会报一个循环引用的错误

使用 renren-generator 生成代码 然后放入之前创建的模块

![image-20230210205148225](README.assets/image-20230210205148225.png)





生成代码后将 `UndoLogEntity`中的Longblob修改为 `byte`，java无法识别Longblob



### product模块



这里遇到一个bug：

![image-20230210215550542](README.assets/image-20230210215550542.png)

是因为把`renren-generator`中的`@RequestMapping("${moduleName}/${pathName}")`注释掉了。

