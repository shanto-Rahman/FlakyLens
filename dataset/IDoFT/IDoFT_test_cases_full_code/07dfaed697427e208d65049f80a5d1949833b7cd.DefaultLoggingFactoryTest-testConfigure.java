@Test public void testConfigure() throws Exception {
  final File newAppLog=folder.newFile("example-new-app.log");
  final File newAppNotAdditiveLog=folder.newFile("example-new-app-not-additive.log");
  final File defaultLog=folder.newFile("example.log");
  final StringSubstitutor substitutor=new StringSubstitutor(Maps.of("new_app",StringUtils.removeEnd(newAppLog.getAbsolutePath(),".log"),"new_app_not_additive",StringUtils.removeEnd(newAppNotAdditiveLog.getAbsolutePath(),".log"),"default",StringUtils.removeEnd(defaultLog.getAbsolutePath(),".log")));
  final String configPath=Resources.getResource("yaml/logging_advanced.yml").getFile();
  final DefaultLoggingFactory config=factory.build(new SubstitutingSourceProvider(new FileConfigurationSourceProvider(),substitutor),configPath);
  config.configure(new MetricRegistry(),"test-logger");
  LoggerFactory.getLogger("com.example.app").debug("Application debug log");
  LoggerFactory.getLogger("com.example.app").info("Application log");
  LoggerFactory.getLogger("com.example.newApp").debug("New application debug log");
  LoggerFactory.getLogger("com.example.newApp").info("New application info log");
  LoggerFactory.getLogger("com.example.legacyApp").debug("Legacy application debug log");
  LoggerFactory.getLogger("com.example.legacyApp").info("Legacy application info log");
  LoggerFactory.getLogger("com.example.notAdditive").debug("Not additive application debug log");
  LoggerFactory.getLogger("com.example.notAdditive").info("Not additive application info log");
  config.stop();
  assertThat(Files.readAllLines(defaultLog.toPath())).containsOnly("INFO  com.example.app: Application log","DEBUG com.example.newApp: New application debug log","INFO  com.example.newApp: New application info log","DEBUG com.example.legacyApp: Legacy application debug log","INFO  com.example.legacyApp: Legacy application info log");
  assertThat(Files.readAllLines(newAppLog.toPath())).containsOnly("DEBUG com.example.newApp: New application debug log","INFO  com.example.newApp: New application info log");
  assertThat(Files.readAllLines(newAppNotAdditiveLog.toPath())).containsOnly("DEBUG com.example.notAdditive: Not additive application debug log","INFO  com.example.notAdditive: Not additive application info log");
}
