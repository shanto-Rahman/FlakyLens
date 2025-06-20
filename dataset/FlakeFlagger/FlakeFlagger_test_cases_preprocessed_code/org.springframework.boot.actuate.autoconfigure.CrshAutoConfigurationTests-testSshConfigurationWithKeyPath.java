@Test public void testSshConfigurationWithKeyPath(){
assertEquals("~/.ssh/id.pem",lifeCycle.getConfig().getProperty("crash.ssh.keypath"));
}