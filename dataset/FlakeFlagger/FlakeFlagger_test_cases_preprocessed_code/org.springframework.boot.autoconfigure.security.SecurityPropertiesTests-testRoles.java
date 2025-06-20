@Test public void testRoles(){
assertFalse(this.binder.getBindingResult().hasErrors());
assertEquals("[USER, ADMIN]",this.security.getUser().getRole().toString());
}