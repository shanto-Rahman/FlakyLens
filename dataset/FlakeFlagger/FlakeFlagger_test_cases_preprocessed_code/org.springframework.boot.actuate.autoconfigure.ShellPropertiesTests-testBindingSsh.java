@Test public void testBindingSsh(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("2222",p.get("crash.ssh.port"));
assertEquals("~/.ssh/test.pem",p.get("crash.ssh.keypath"));
}