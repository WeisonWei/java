


## JVM
编译过程：
java --> class --> 机器码(二进制)

查看字节码：`javap -c JsonTest`

```shell
weison git:(master) ✗ javap -c JsonTest
警告: 二进制文件JsonTest包含com.weison.JsonTest
Compiled from "JsonTest.java"
public class com.weison.json.JsonTest {
  public com.weison.json.JsonTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void covertToJson();
    Code:
       0: ldc           #2                  // String {\n  \"gmt_create\": \"2020-09-02 12:05:46\",\n  \"charset\": \"utf-8\",\n  \"seller_email\": \"meishubao1v1@qq.com\",\n  \"subject\": \"美术宝写字体验课\",\n  \"sign\": \"Dpx/qkjUApkGd84yQhejv9XVj9XarQPw8YLsCGFtVjf51xQ61fuL361+iO5rnMLFUC8NDphBQfhgUASkqcsp9huBh/TeE1Zu4oM2QkpoirKsmDG9ZX3y/AD3qI29goJ7ulFD5b85ZS73cVXlcohJnbo12pPHr23SrTNf/up3S5qnXe2NL1yqBXQFeu7xq4E5Lh+ZTUsPsQVXNAOMx7lxzrLzPX2iIo1GiYO4V4GM3KvJYhJHFDgFJ0HzdTfOBIZCHidkiF7hbqAOfkAqM0tPqOm2fcoVtlQf9m5y2ZLLER8vv+QAG5l939RfSRoTT8WsgLRFwNYXu66a5TruQy9p/Q==\",\n  \"buyer_id\": \"2088102702539597\",\n  \"invoice_amount\": \"0.01\",\n  \"notify_id\": \"2020090200222120547039591419623081\",\n  \"fund_bill_list\": \"[{\\"amount\\":\\"0.01\\",\\"fundChannel\\":\\"PCREDIT\\"}]\",\n  \"notify_type\": \"trade_status_sync\",\n  \"trade_status\": \"TRADE_SUCCESS\",\n  \"receipt_amount\": \"0.01\",\n  \"buyer_pay_amount\": \"0.01\",\n  \"app_id\": \"2021001191600034\",\n  \"sign_type\": \"RSA2\",\n  \"seller_id\": \"2088921870903937\",\n  \"gmt_payment\": \"2020-09-02 12:05:46\",\n  \"notify_time\": \"2020-09-02 12:05:47\",\n  \"passback_params\": \"{\\"couponUserId\\":\\"0\\",\\"subject\\":\\"write\\",\\"type\\":\\"ALONE\\",\\"grouponId\\":\\"0\\"}\",\n  \"version\": \"1.0\",\n  \"out_trade_no\": \"xiong2020090212052835966\",\n  \"total_amount\": \"0.01\",\n  \"trade_no\": \"2020090222001439591452617639\",\n  \"auth_app_id\": \"2021001191600034\",\n  \"buyer_logon_id\": \"707***@qq.com\",\n  \"point_amount\": \"0.00\"\n}
       2: astore_1
       3: aload_1
       4: invokestatic  #3                  // Method cn/hutool/json/JSONUtil.parseObj:(Ljava/lang/String;)Lcn/hutool/json/JSONObject;
       7: astore_2
       8: aload_2
       9: ldc           #4                  // String subject
      11: invokevirtual #5                  // Method cn/hutool/json/JSONObject.get:(Ljava/lang/Object;)Ljava/lang/Object;
      14: invokestatic  #6                  // Method java/util/Objects.nonNull:(Ljava/lang/Object;)Z
      17: ifeq          32
      20: aload_2
      21: ldc           #4                  // String subject
      23: invokevirtual #5                  // Method cn/hutool/json/JSONObject.get:(Ljava/lang/Object;)Ljava/lang/Object;
      26: invokevirtual #7                  // Method java/lang/Object.toString:()Ljava/lang/String;
      29: goto          34
      32: ldc           #8                  // String ai
      34: astore_3
      35: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      38: new           #10                 // class java/lang/StringBuilder
      41: dup
      42: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
      45: ldc           #12                 // String ==subject==
      47: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      50: aload_3
      51: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      54: invokevirtual #14                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      57: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      60: return

  public void sleep() throws java.lang.InterruptedException;
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: bipush        20
       5: if_icmpge     22
       8: getstatic     #16                 // Field java/util/concurrent/TimeUnit.SECONDS:Ljava/util/concurrent/TimeUnit;
      11: iload_1
      12: i2l
      13: invokevirtual #17                 // Method java/util/concurrent/TimeUnit.sleep:(J)V
      16: iinc          1, 1
      19: goto          2
      22: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      25: ldc           #18                 // String ==sleep== over
      27: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      30: return
}
```

[JVM指令手册](https://www.jianshu.com/p/0978d7ab7113)





## 垃圾回收

### 垃圾确认
引用计数
可达性分析

Java引用 强弱虚弱

### 垃圾回收算法
标记清除算法
复制算法
标记整理
分代收集
分区收集

### 垃圾收集器

新生代 -- 复制算法
Serial
ParNew
Paralle

老年代 -- 标记算法
CMS
Serial old
Parall Old
G1
