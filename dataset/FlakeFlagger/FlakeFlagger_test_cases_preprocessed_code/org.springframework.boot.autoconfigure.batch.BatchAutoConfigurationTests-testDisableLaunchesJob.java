@Test public void testDisableLaunchesJob() throws Exception {
assertNotNull(this.context.getBean(JobLauncher.class));
assertEquals(0,this.context.getBeanNamesForType(CommandLineRunner.class).length);
}