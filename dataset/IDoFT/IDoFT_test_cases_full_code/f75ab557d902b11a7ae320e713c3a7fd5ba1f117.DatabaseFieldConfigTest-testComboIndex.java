@Test public void testComboIndex() throws Exception {
  Field[] fields=ComboIndex.class.getDeclaredFields();
  assertTrue(fields.length >= 2);
  DatabaseFieldConfig fieldConfig=DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]);
  String tableName="foo";
  assertEquals(ComboIndex.INDEX_NAME,fieldConfig.getIndexName(tableName));
  fieldConfig=DatabaseFieldConfig.fromField(databaseType,tableName,fields[1]);
  assertEquals(ComboIndex.INDEX_NAME,fieldConfig.getIndexName(tableName));
}
