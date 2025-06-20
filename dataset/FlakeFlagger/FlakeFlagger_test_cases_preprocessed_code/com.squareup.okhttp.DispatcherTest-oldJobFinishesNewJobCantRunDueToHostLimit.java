@Test public void oldJobFinishesNewJobCantRunDueToHostLimit() throws Exception {
executor.finishJob("http://b/1");//IT
executor.assertJobs("http://a/1");//IT
}