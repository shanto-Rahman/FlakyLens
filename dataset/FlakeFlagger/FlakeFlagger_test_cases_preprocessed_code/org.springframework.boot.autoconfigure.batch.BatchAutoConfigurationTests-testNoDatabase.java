@Test public void testNoDatabase() throws Exception {
assertNotNull(this.context.getBean(JobLauncher.class));
assertNotNull(explorer);
assertEquals(0,explorer.getJobInstances("job",0,100).size());
}