@Test public void testModelAPInteger(){
  ModelAPInteger model=createModelAPInteger();
  testSerDeser(model,ModelAPInteger.class);
}
