@Test public void testCollectionToArray() throws Exception {
assertTrue(o instanceof Person[]);
assertEquals(((Person[])o)[0],person1);
assertEquals(((Person[])o)[1],person2);
}