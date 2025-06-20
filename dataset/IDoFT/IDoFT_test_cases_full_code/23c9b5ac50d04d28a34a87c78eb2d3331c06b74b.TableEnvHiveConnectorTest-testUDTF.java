@Test public void testUDTF() throws Exception {
  String hiveVersion=HiveShimLoader.getHiveVersion();
  Assume.assumeTrue(hiveVersion.compareTo("2.0.0") >= 0 || hiveVersion.compareTo("1.3.0") >= 0);
  hiveShell.execute("create database db1");
  try {
    hiveShell.execute("create table db1.simple (i int,a array<int>)");
    hiveShell.execute("create table db1.nested (a array<map<int, string>>)");
    hiveShell.execute("create function hiveudtf as 'org.apache.hadoop.hive.ql.udf.generic.GenericUDTFExplode'");
    hiveShell.insertInto("db1","simple").addRow(3,Arrays.asList(1,2,3)).commit();
    Map<Integer,String> map1=new HashMap<>();
    map1.put(1,"a");
    map1.put(2,"b");
    Map<Integer,String> map2=new HashMap<>();
    map2.put(3,"c");
    hiveShell.insertInto("db1","nested").addRow(Arrays.asList(map1,map2)).commit();
    TableEnvironment tableEnv=getTableEnvWithHiveCatalog();
    List<Row> results=HiveTestUtils.collectTable(tableEnv,tableEnv.sqlQuery("select x from db1.simple, lateral table(hiveudtf(a)) as T(x)"));
    assertEquals("[1, 2, 3]",results.toString());
    results=HiveTestUtils.collectTable(tableEnv,tableEnv.sqlQuery("select x from db1.nested, lateral table(hiveudtf(a)) as T(x)"));
    assertEquals("[{1=a, 2=b}, {3=c}]",results.toString());
  }
  finally {
    hiveShell.execute("drop database db1 cascade");
    hiveShell.execute("drop function hiveudtf");
  }
}
