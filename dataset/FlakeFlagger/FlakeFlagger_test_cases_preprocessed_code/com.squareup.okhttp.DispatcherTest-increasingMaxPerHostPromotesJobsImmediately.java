@Test public void increasingMaxPerHostPromotesJobsImmediately() throws Exception {
executor.assertJobs("http://a/1","http://a/2","http://a/3","http://a/4");//IT
}