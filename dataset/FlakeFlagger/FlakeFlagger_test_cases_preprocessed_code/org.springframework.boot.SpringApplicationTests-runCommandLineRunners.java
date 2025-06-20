@Test public void runCommandLineRunners() throws Exception {
assertTrue(this.context.getBean("runnerA",TestCommandLineRunner.class).hasRun());
assertTrue(this.context.getBean("runnerB",TestCommandLineRunner.class).hasRun());
}