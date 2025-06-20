@Test public void testBindingIgnoredSingleValued(){
assertFalse(this.binder.getBindingResult().hasErrors());
assertEquals(1,this.security.getIgnored().size());
}