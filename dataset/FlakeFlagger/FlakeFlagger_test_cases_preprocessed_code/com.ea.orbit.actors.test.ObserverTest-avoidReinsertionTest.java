@Test public void avoidReinsertionTest() throws ExecutionException, InterruptedException {
assertNotNull(ref1);
assertNotNull(ref2);
assertSame(ref1,ref2);
}