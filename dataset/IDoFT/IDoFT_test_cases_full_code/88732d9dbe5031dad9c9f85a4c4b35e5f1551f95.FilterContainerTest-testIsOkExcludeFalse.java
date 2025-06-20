@Test public void testIsOkExcludeFalse(){
  SourcecodeFilter filter=new SourcecodeFilter();
  filter.setFilterToken(".ag XYZ oncal.");
  filter.setExclude(true);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
