# 蚊子社区demo

###### 学习markdown语法 标题使用#并且后面需要跟空格

## 字体

#### **加粗**

#### *斜体*

####  ***斜体加粗***

####  ~~删除线~~

#### freemarker语法中if--else 

```injectedfreemarker
<#if 变量??>
	变量名后面通过放置 ?? 来询问一个变量是否存在。
	将它和 if 指令合并， 那么如果变量不存在的话将会忽略整个问候的代码段：
	<#else>
        else语句，类型Java中的if else 但是这里的else不要闭区间 </\#else>
</#if>
```
#### freemarker语法的插值
```injectedfreemarker
    ${user} 表示插入某个值
```

```java 
 User user = new User();
```


