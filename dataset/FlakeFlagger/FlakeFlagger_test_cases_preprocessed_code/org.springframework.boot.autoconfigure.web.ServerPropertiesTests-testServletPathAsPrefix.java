@Test public void testServletPathAsPrefix() throws Exception {
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("/foo/*",this.properties.getServletMapping());
assertEquals("/foo",this.properties.getServletPrefix());
}