@Test public void testNoBatchConfiguration() throws Exception {
assertEquals(0,this.context.getBeanNamesForType(JobLauncher.class).length);
assertEquals(0,this.context.getBeanNamesForType(JobRepository.class).length);
}