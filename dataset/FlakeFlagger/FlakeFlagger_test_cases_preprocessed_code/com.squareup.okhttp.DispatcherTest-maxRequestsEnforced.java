@Test public void maxRequestsEnforced() throws Exception {
executor.assertJobs("http://a/1","http://a/2","http://b/1");//IT
}