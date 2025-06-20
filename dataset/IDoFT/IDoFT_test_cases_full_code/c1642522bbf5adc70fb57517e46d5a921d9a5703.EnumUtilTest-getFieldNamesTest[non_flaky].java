@Test public void getFieldNamesTest(){
  List<String> names=EnumUtil.getFieldNames(TestEnum.class);
  Assert.assertTrue(names.contains("type"));
  Assert.assertTrue(names.contains("name"));
}
