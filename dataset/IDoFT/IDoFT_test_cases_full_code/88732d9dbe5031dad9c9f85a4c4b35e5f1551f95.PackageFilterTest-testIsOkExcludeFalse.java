@Test public void testIsOkExcludeFalse(){
  PackageFilter filter=new PackageFilter();
  filter.setFilterToken("XYZpetstore");
  filter.setExclude(true);
  FilterContainer.getInstance().add(filter);
  assertEquals(true,FilterContainer.getInstance().isOk(javaSource));
}
