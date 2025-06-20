@Test public void testRunClientAndVisit() throws Exception {
executor.execute(runner);
assertTrue(runner.awaitRunState(true,DELAY));//IT
assertSame(client,visitor.getLastVisited());
}