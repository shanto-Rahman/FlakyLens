@Test public void testBindingAuth(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals("spring",props.getAuth());
}