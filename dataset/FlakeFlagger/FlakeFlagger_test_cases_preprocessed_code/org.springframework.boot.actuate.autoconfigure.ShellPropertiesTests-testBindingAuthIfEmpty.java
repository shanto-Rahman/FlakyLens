@Test public void testBindingAuthIfEmpty(){
assertTrue(binder.getBindingResult().hasErrors());
assertEquals("simple",props.getAuth());
}