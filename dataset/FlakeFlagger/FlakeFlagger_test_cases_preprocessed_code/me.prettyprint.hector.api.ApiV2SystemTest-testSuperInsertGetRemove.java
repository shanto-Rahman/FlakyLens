@Test public void testSuperInsertGetRemove(){
assertNotNull(r);
assertNotNull(sc);
assertEquals(2,sc.getSize());
assertEquals("value1",value);
assertEquals("name1",name);
assertEquals("name2",c2.getName());
assertEquals("value2",c2.getValue());
assertNull(sc);
}