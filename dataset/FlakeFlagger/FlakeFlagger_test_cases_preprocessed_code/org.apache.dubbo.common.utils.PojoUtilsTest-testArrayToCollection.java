@Test public void testArrayToCollection() throws Exception {
assertTrue(o instanceof LinkedList);
assertEquals(((List)o).get(0),person1);
assertEquals(((List)o).get(1),person2);
}