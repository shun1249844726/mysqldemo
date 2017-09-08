# mysqldemo
java mysql demo
mysql demo

1. 加载驱动程序
Class.forName(driverClass)
加载Mysql驱动：Class.forName("com.mysql.jdbc.Driver");
加载Oracle驱动：Class.forName("oracle.jdbc.driver.OracleDriver")

2. 获得数据库连接
DriverManager.getConnection("jdbc:mysql:127.0.0.1:3306/imooc","root","root")

3. 创建statement对象
conn.creatStatement();
