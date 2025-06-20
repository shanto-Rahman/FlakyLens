@Test public void testGetSchema(){
Assert.assertEquals(entry.getValue(),schema.getKeyPropertyId(entry.getKey()));
Assert.assertNotNull(properties);
Assert.assertTrue(properties.contains(PropertyHelper.getPropertyName(propertyId)));
Assert.assertNotNull(properties);
Assert.assertTrue(properties.contains(PropertyHelper.getPropertyName(propertyId)));
}