@Test public void testBindingSpring(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("role1, role2",p.get("crash.auth.spring.roles"));
}