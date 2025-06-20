@Test public void testGetFields(){
assertEquals(7,mapFields.size());
assertTrue(mapFields.containsKey(prop));
assertNull(mapFields.get(prop));
assertTrue(mapFields.containsKey(prop1));
assertNull(mapFields.get(prop1));
assertTrue(mapFields.containsKey(prop2));
assertEquals(new TemporalInfoImpl(1,2,3),mapFields.get(prop2));
assertTrue(mapFields.containsKey(prop3));
assertEquals(new TemporalInfoImpl(4,5,6),mapFields.get(prop3));
assertTrue(mapFields.containsKey(category4));
assertEquals(new TemporalInfoImpl(7,8,9),mapFields.get(category4));
assertTrue(mapFields.containsKey(subResource));
assertEquals(new TemporalInfoImpl(10,11,12),mapFields.get(subResource));
assertTrue(mapFields.containsKey(finalProp));
assertNull(mapFields.get(finalProp));
}