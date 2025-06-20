@Test public void testBindingCommandRefreshInterval(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(1,props.getCommandRefreshInterval());
}