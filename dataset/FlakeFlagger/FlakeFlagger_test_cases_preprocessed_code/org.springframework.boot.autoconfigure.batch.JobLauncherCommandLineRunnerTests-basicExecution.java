@Test public void basicExecution() throws Exception {
assertEquals(1,this.jobExplorer.getJobInstances("job",0,100).size());
assertEquals(2,this.jobExplorer.getJobInstances("job",0,100).size());
}