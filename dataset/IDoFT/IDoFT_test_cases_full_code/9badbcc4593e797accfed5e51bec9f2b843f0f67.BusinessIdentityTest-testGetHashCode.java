@Test public void testGetHashCode(){
  for (  final HashCodeTestData hashCodeTestData : getHashCodeTestData()) {
    Assert.assertEquals(String.format("HashCode test failed for Data=[%s]",hashCodeTestData),hashCodeTestData.expectedHashCode,BusinessIdentity.getHashCode(hashCodeTestData));
  }
}
