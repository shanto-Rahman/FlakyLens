@Test public void testIsOkIncludeTrue(){
  PackageFilter filter=new PackageFilter();
  filter.setFilterToken("petstore");
  filter.setExclude(false);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
