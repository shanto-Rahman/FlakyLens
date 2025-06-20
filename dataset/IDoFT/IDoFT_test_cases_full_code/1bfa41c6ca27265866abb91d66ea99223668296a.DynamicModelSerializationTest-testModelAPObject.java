@Test public void testModelAPObject(){
  ModelAPObject model=createModelAPObject();
  testSerDeser(model,ModelAPObject.class);
}
