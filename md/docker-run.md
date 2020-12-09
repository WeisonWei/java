### docker run --rm
在容器启动时设置--rm选项，这样在容器退出时就能够自动清理容器内部的文件系统
`docker run --rm studentService` 等价于 `docker run --rm=true studentService`

### docker run --name
在容器启动时设置--rm选项，这样在容器退出时就能够自动清理容器内部的文件系统

### docker run sh -c "cd /usr && ls"
同时执行多个命令

### docker run --add-host 
使用该参数可以配置多个host

### docker run --hostname 
指定hostname

### docker run --net 
指定网络模式

### docker run --ip
指定IP

### docker run --add-host 
指定往/etc/hosts添加的host

### docker run -v=[]
宿主机绑定: -v<host>:<container>:[rw|ro]
绑定挂载目录

### docker run -i 
以交互模式运行容器，通常与 -t 同时使用

### docker run -t 
伪终端

### docker run -it cid /bin/bash
启动容器交互方式为伪终端，shell为/bin/bash

### docker exec -it cid /bin/bash
以交互方式为伪终端 shell为/bin/bash 进入容器

### docker attach cid
进入容器