@Test public void testMap(){
  String testInput="1:1,2:2,3:3";
  HiveGenericUDF udf=init(GenericUDFStringToMap.class,new Object[]{null},new DataType[]{DataTypes.VARCHAR(testInput.length())});
  assertEquals(new HashMap<String,String>(){
{
      put("1","1");
      put("2","2");
      put("3","3");
    }
  }
,udf.eval(testInput));
  HiveGenericUDF udf2=init(GenericUDFMapKeys.class,new Object[]{null},new DataType[]{DataTypes.MAP(DataTypes.STRING(),DataTypes.STRING())});
  Object[] result=(Object[])udf2.eval(udf.eval(testInput));
  assertEquals(3,result.length);
  assertThat(Arrays.asList(result),containsInAnyOrder("1","2","3"));
}
