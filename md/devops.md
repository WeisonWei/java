# DevOps
DevOps的概念在软件开发行业中逐渐流行起来。越来越多的团队希望实现产品的敏捷开发，DevOps 使一切成为可能。
有了 DevOps ，团队可以定期发布代码、自动化部署、并将持续集成 / 持续交付作为发布过程的一部分。

五种最流行、功能最强大的 DevOps 工具：

    Terraform
    Ansible
    Packer
    Docker
    Kubernetes

## linux安装
```bash
sudo apt-get install docker-ce docker-ce-cli containerd.io
#启动docker并设置开机自启
systemctl start docker
sudo systemctl start docker
sudo systemctl enable docker 

#添加docker组
sudo groupadd docker
#将当权用户添加到docker组
sudo gpasswd -a $USER docker
newgrp docker

#添加 镜像加速
sudo vim /etc/docker/daemon.json
sudo systemctl daemon-reload
sudo systemctl restart docker

#登陆
docker login --> weisonwei/Hello@2019
docker pull portainer
```    

