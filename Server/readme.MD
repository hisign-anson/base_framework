#后端说明文档
### 架构
采用微服务架构，除了common和run-server模块其他模块都属于各自
有各自的REST结构，SERVICE，API。

###common
主要是一些公用的父类，接口，工具等等

###run-server
主要是关注服务运行本身，例如服务安全，服务REST接口，batis设置等等。
SpringCloud的一些内容。

###server-x
主要关注x的业务，统一API模块（REST还如此主要是为了防止API模块的循环依赖），
以及REST接口开放其他模块引用。
