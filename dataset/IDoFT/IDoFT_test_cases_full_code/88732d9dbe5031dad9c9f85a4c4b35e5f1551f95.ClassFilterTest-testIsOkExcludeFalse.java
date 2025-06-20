@Test public void testIsOkExcludeFalse(){
  ClassFilter filter=new ClassFilter();
  filter.setFilterToken("XYZDatabaseProducer");
  filter.setExclude(true);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
