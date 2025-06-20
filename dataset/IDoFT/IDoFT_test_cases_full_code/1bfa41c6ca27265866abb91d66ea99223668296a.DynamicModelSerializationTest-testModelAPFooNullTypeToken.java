@Test public void testModelAPFooNullTypeToken(){
  ModelAPFooNullTypeToken model=createModelAPFooNullTypeToken();
  testSerDeser(model,ModelAPFooNullTypeToken.class);
}
