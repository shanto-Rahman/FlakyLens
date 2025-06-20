@Test public void oldJobFinishesNewJobWithSameHostStarts() throws Exception {
executor.finishJob("http://a/1");//IT
executor.assertJobs("http://b/1","http://a/2");//IT
}