@Test public void testModelAPProtectedCtor(){
  ModelAPProtectedCtor model=createModelAPProtectedCtor();
  testSerDeser(model,ModelAPProtectedCtor.class);
}
