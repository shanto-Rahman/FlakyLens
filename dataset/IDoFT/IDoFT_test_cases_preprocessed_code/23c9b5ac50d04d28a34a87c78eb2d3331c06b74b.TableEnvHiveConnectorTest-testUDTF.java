@Test public void testUDTF() throws Exception {
hiveShell.execute("create database db1");//RW
hiveShell.execute("create table db1.simple (i int,a array<int>)");//RW
hiveShell.execute("create table db1.nested (a array<map<int, string>>)");//RW
hiveShell.execute("create function hiveudtf as 'org.apache.hadoop.hive.ql.udf.generic.GenericUDTFExplode'");//RW
hiveShell.insertInto("db1","simple").addRow(3,Arrays.asList(1,2,3)).commit();//RW
hiveShell.insertInto("db1","nested").addRow(Arrays.asList(map1,map2)).commit();//RW
assertEquals("[1, 2, 3]",results.toString());
assertEquals("[{1=a, 2=b}, {3=c}]",results.toString());
hiveShell.execute("drop database db1 cascade");//RW
hiveShell.execute("drop function hiveudtf");//RW
}