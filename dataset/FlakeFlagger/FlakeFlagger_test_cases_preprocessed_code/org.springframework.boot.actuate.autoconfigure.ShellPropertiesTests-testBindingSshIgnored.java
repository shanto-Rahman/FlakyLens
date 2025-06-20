@Test public void testBindingSshIgnored(){
assertFalse(binder.getBindingResult().hasErrors());
assertNull(p.get("crash.ssh.port"));
assertNull(p.get("crash.ssh.keypath"));
}