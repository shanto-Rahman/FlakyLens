@Test public void testModelAPString(){
  ModelAPString model=createModelAPString();
  testSerDeser(model,ModelAPString.class);
}
