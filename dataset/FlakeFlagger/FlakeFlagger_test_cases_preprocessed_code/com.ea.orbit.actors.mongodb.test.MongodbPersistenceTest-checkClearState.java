@Test public void checkClearState() throws Exception {
assertEquals(0,database.getCollection("ISomeMatch").count());
assertEquals(1,database.getCollection("ISomeMatch").count());
assertEquals(0,database.getCollection("ISomeMatch").count());
}