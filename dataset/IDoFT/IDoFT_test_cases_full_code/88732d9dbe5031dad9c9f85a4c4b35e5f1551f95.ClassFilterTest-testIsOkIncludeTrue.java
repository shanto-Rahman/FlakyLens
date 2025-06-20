@Test public void testIsOkIncludeTrue(){
  ClassFilter filter=new ClassFilter();
  filter.setFilterToken("DatabaseProducer");
  filter.setExclude(false);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
