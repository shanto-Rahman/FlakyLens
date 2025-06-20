@Test public void testGetHashCode(){
Assert.assertEquals(String.format("HashCode test failed for Data=[%s]",hashCodeTestData),hashCodeTestData.expectedHashCode,BusinessIdentity.getHashCode(hashCodeTestData));
}