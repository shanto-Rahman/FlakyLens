@Test public void increasingMaxRequestsPromotesJobsImmediately() throws Exception {
executor.assertJobs("http://a/1","http://b/1","http://c/1","http://a/2");//IT
}