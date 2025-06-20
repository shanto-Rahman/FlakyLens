/** 
 * Sends a bit more messages trying to uncover concurrency issues.
 */
@Test public void heavierTest() throws ExecutionException, InterruptedException {
assertTrue(set.size() > 1);
assertTrue(set.size() <= 100);
}