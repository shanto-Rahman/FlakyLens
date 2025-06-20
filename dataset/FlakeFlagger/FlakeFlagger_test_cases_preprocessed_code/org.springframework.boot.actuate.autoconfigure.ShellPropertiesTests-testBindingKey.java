@Test public void testBindingKey(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("~/.ssh/test.pem",p.get("crash.auth.key.path"));
}