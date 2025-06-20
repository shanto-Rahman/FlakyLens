@Test public void testConfigure() throws Exception {
assertThat(Files.readAllLines(defaultLog.toPath())).containsOnly("INFO  com.example.app: Application log","DEBUG com.example.newApp: New application debug log","INFO  com.example.newApp: New application info log","DEBUG com.example.legacyApp: Legacy application debug log","INFO  com.example.legacyApp: Legacy application info log");
assertThat(Files.readAllLines(newAppLog.toPath())).containsOnly("DEBUG com.example.newApp: New application debug log","INFO  com.example.newApp: New application info log");
assertThat(Files.readAllLines(newAppNotAdditiveLog.toPath())).containsOnly("DEBUG com.example.notAdditive: Not additive application debug log","INFO  com.example.notAdditive: Not additive application info log");
}