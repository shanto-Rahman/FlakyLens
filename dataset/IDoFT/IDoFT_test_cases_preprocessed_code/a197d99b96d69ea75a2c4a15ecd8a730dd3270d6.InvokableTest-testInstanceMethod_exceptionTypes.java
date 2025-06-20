public void testInstanceMethod_exceptionTypes() throws Exception {
assertEquals(ImmutableList.of(TypeToken.of(IllegalArgumentException.class),TypeToken.of(NullPointerException.class)),delegate.getExceptionTypes());
}