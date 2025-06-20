@Test public void testServletPathAsMapping() throws Exception {
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("/foo/*",this.properties.getServletMapping());
assertEquals("/foo",this.properties.getServletPrefix());
}