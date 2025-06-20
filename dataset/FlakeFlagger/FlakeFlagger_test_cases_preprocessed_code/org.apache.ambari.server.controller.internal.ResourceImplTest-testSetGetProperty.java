@Test public void testSetGetProperty(){
Assert.assertEquals("foo",resource.getPropertyValue(propertyId));
Assert.assertEquals(1,resource.getPropertyValue(propertyId));
Assert.assertEquals((float)1.99,resource.getPropertyValue(propertyId));
Assert.assertEquals(1.99,resource.getPropertyValue(propertyId));
Assert.assertEquals(65L,resource.getPropertyValue(propertyId));
}