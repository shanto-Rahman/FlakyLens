@Test public void checkReads() throws ExecutionException, InterruptedException {
assertEquals(0,fakeDatabase.values().size());
assertTrue(fakeDatabase.values().size() > 0);
assertEquals(1,someMatch_r2.getPlayers().get().size());
assertEquals(somePlayer_r2,someMatch_r2.getPlayers().get().get(0));
}