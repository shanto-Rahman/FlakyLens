@Test public void mergeDuplicate_neitherPresentAtAllLocations(){
  CatalogObject master=createCatalogObjectPresentAtLocations("L1","L2");
  CatalogObject dup=createCatalogObjectPresentAtLocations("L2","L3");
  DuplicateTaxInfo taxInfo=new DuplicateTaxInfo(master);
  taxInfo.mergeDuplicate(dup,logger);
  CatalogObject result=taxInfo.getMasterTax();
  assertThat(result.getPresentAtAllLocations()).isFalse();
  assertThat(result.getPresentAtLocationIds()).containsExactly("L1","L2","L3");
  assertThat(result.getAbsentAtLocationIds()).isNullOrEmpty();
}
