@Test public void testCreateListOfAddresses() throws Exception {
assertEquals(2,tupleList.size());
assertEquals("the.user@me.com",tupleList.get(0).x);
assertEquals("The user",tupleList.get(0).y);
assertEquals("another.user@me.com",tupleList.get(1).x);
assertEquals(null,tupleList.get(1).y);
}