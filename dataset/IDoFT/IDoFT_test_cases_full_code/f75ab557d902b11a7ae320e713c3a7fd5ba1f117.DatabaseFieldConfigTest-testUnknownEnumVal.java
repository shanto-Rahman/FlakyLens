@Test(expected=IllegalArgumentException.class) public void testUnknownEnumVal() throws Exception {
  Field[] fields=BadUnknownVal.class.getDeclaredFields();
  assertTrue(fields.length >= 1);
  DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]);
}
