# FileHandle
![Travis-CI:;](https://img.shields.io/travis/jiangbai333/FileHandle.svg) ![jdk:v1.7+;](https://img.shields.io/badge/jdk-v1.7%2B-green.svg) ![version:v0.2;](https://img.shields.io/badge/version-V0.2-orange.svg) ![license:GUN;](https://img.shields.io/badge/license-GUN-blue.svg)
## 简介
&emsp;&emsp;FileHandle提供一个更简便的文件操作句柄，你可以利用它方便的对文件进行操作。它由java编写，可直接引入到项目，亦可通过maven以依赖的形式引入。FileHandle提供多个工具方法用来操作文件、目录，当你使用时，你会发现它是如此简单以及高性能。
## 功能
- 获取文件实例
- 获取文件类型
- 获取文件大小
- 获取文件名称
- 获取文件内容
- 更改文件属性
- 构建目录树
- 建立、修改文件

## 安装
### 通过maven引入依赖
使用前请确保已经安装了`maven`以及`jdk1.7+`
```bash
git clone git@github.com:jiangbai333/FileHandle.git ;cd FileHandle
mvn install
```
将依赖添加至你项目中的`pom.xml`文件中
```xml
<dependency>
    <groupId>fh</groupId>
    <artifactId>fileHandle</artifactId>
    <version>0.2</version>
</dependency>
```
### 通过import直接在项目中引用
克隆源代码，并将`/scr/main/java/com/filehandle`目录复制到你的项目类库包中
```bash
git clone git@github.com:jiangbai333/FileHandle.git ；cd FileHandle
cp -R /scr/main/java/com/filehandle /yourpackage/filehandle
```
在文件中引入FielHandle
```java
improt yourpackage.com.filehandle.FileHandle;
```

## 使用
```java
FileHandle.fromObject("filepath"); // 通过文件路径获取FileHandle实例
FileHandle.fromObject(File); // 通过File实例获取FileHandle实例
```
### 方法参考docs目录下文档及wiki