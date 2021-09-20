# ProtoBuffer
Android 支持protobuffer格式文件处理 

### protobuffer是google开发的一种数据描述语言，它能够将结构化的数据序列化，并切可以将序列化的数据进行反序列化恢复原有的数据结构。一般用于数据存储以及通信协议方面。

protoBuffer相比于xml的优点
更加简介
体积小：消息大小只需要xml的1/10~1/3
解析速度快：解析速度比xml快20~100倍
使用proto Buffer的编译器，可以生成方便在编程中使用的数据访问代码.
具有更好的兼容性，很好的支持向上或向下兼容的特性
提供多种序列化的出口和入口,如文件流，string流,array流等等


## 集成ProtoBuffer流程：

### 1.引入类库
```
dependencies {
    implementation 'com.google.protobuf:protobuf-lite:3.0.1'
}
```
### 2.在app build文件下配置protobuf相关信息
```

protobuf {
    protoc {
        artifact = 'com.google.protobuf:protoc:3.5.1-1'

    }
    plugins {
        javalite {
            artifact = 'com.google.protobuf:protoc-gen-javalite:3.0.0'
        }
    }
    generateProtoTasks {
        all().each { task ->
            task.builtins {
                remove java
            }
            task.plugins {
                javalite {}
            }
        }
    }
}


```
### 3.指定Proto文件位置
```

    sourceSets {
        main {
            java {
                srcDir 'src/main/java'
            }
            proto {
                srcDir 'src/main/proto'
            }
        }
    }

```
### 4.apply
```
apply plugin: 'com.google.protobuf'

```

### 5.在project build文件下配置
```
 dependencies {
     
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.6'
     
    }
```
### 6.在项目main目录下新建proto文件夹
### 7.将proto文件放入proto文件夹
### 8.build项目



build之后，就会根据proto文件生成一个.java文件类，然后就可以进行二进制转换了。

```
        byte[] bol = getBytefromBase64(base64);


        try {
            //通过byte[]获取到json字符串
            Dataformat.ReturnVO returnVO = Dataformat.ReturnVO.parseFrom(bol);
            Log.i("data==", returnVO.getData());


        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
```

-----------------------完成--------------------

有遇到其他问题可以加我qq进行沟通
 ：459005147 备注：android交流



