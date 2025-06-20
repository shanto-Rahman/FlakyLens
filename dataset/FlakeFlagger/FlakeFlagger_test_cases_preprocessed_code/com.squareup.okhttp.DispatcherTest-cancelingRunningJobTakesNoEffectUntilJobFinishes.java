@Test public void cancelingRunningJobTakesNoEffectUntilJobFinishes() throws Exception {
executor.assertJobs("http://a/1");//IT
executor.finishJob("http://a/1");//IT
executor.assertJobs("http://a/2");//IT
}