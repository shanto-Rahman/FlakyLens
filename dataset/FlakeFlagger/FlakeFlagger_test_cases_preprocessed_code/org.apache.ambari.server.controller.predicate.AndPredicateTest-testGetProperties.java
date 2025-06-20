@Test public void testGetProperties(){
Assert.assertEquals(3,ids.size());
Assert.assertTrue(ids.contains(propertyId1));
Assert.assertTrue(ids.contains(propertyId2));
Assert.assertTrue(ids.contains(propertyId3));
}