@Test public void testBindingIgnoredMultiValuedList(){
assertFalse(this.binder.getBindingResult().hasErrors());
assertEquals(2,this.security.getIgnored().size());
assertTrue(this.security.getIgnored().contains("/foo/**"));
}