public void testInstanceMethod_exceptionTypes() throws Exception {
  Invokable<?,?> delegate=Prepender.method("prepend",Iterable.class);
  assertEquals(ImmutableList.of(TypeToken.of(IllegalArgumentException.class),TypeToken.of(NullPointerException.class)),delegate.getExceptionTypes());
}
