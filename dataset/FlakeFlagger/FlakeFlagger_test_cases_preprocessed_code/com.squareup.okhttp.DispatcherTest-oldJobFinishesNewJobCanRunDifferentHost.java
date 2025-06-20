@Test public void oldJobFinishesNewJobCanRunDifferentHost() throws Exception {
executor.finishJob("http://a/1");//IT
executor.assertJobs("http://b/1");//IT
}