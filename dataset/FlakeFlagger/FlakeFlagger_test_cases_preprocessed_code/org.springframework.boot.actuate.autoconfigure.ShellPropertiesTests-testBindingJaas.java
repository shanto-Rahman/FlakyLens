@Test public void testBindingJaas(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("my-test-domain",p.get("crash.auth.jaas.domain"));
}