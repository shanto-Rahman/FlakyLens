@Test public void testIsOkIncludeTrue(){
  SourcecodeFilter filter=new SourcecodeFilter();
  filter.setFilterToken(".agoncal.");
  filter.setExclude(false);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
