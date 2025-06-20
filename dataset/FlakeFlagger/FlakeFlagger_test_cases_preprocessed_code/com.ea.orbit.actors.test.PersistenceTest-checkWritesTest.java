@Test public void checkWritesTest() throws ExecutionException, InterruptedException {
assertEquals(0,fakeDatabase.values().size());
assertTrue(fakeDatabase.values().size() > 0);
}