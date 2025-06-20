@Test public void testWriteComplexType() throws Exception {
  String dbName="default";
  String tblName="dest";
  ObjectPath tablePath=new ObjectPath(dbName,tblName);
  TableSchema.Builder builder=new TableSchema.Builder();
  builder.fields(new String[]{"a","m","s"},new DataType[]{DataTypes.ARRAY(DataTypes.INT()),DataTypes.MAP(DataTypes.INT(),DataTypes.STRING()),DataTypes.ROW(DataTypes.FIELD("f1",DataTypes.INT()),DataTypes.FIELD("f2",DataTypes.STRING()))});
  RowTypeInfo rowTypeInfo=createDestTable(dbName,tblName,builder.build(),0);
  List<Row> toWrite=new ArrayList<>();
  Row row=new Row(rowTypeInfo.getArity());
  Object[] array=new Object[]{1,2,3};
  Map<Integer,String> map=new HashMap<Integer,String>(){
{
      put(1,"a");
      put(2,"b");
    }
  }
;
  Row struct=new Row(2);
  struct.setField(0,3);
  struct.setField(1,"c");
  row.setField(0,array);
  row.setField(1,map);
  row.setField(2,struct);
  toWrite.add(row);
  TableEnvironment tableEnv=HiveTestUtils.createTableEnv();
  Table src=tableEnv.fromTableSource(new CollectionTableSource(toWrite,rowTypeInfo));
  tableEnv.registerTable("complexSrc",src);
  tableEnv.registerCatalog("hive",hiveCatalog);
  tableEnv.sqlQuery("select * from complexSrc").insertInto("hive.`default`.dest");
  tableEnv.execute("mytest");
  List<String> result=hiveShell.executeQuery("select * from " + tblName);
  assertEquals(1,result.size());
  assertEquals("[1,2,3]\t{1:\"a\",2:\"b\"}\t{\"f1\":3,\"f2\":\"c\"}",result.get(0));
  hiveCatalog.dropTable(tablePath,false);
}
