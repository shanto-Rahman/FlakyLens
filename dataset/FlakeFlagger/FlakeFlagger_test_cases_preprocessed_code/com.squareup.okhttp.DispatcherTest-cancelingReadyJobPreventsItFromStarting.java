@Test public void cancelingReadyJobPreventsItFromStarting() throws Exception {
executor.finishJob("http://a/1");//IT
executor.assertJobs();//IT
}