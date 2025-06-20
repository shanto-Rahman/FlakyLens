@Test public void testRole(){
assertFalse(this.binder.getBindingResult().hasErrors());
assertEquals("[ADMIN]",this.security.getUser().getRole().toString());
}