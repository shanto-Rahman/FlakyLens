@Test public void checkReads() throws Exception {
assertEquals(0,database.getCollection("ISomeMatch").count());
assertEquals(1,database.getCollection("ISomeMatch").count());
assertEquals(1,someMatch_r2.getPlayers().get().size());
assertEquals(somePlayer_r2,someMatch_r2.getPlayers().get().get(0));
}