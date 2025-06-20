@Test public void testBindingSimple(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("username123",p.get("crash.auth.simple.username"));
assertEquals("password123",p.get("crash.auth.simple.password"));
}