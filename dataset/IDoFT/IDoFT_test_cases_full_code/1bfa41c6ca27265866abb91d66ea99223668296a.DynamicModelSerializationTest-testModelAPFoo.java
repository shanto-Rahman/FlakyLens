@Test public void testModelAPFoo(){
  ModelAPFoo model=createModelAPFoo();
  testSerDeser(model,ModelAPFoo.class);
}
