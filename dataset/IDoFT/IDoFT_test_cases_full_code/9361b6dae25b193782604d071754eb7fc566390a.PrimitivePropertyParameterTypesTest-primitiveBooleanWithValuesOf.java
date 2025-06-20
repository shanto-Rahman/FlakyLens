@Test public void primitiveBooleanWithValuesOf(){
  assertThat(testResult(PrimitiveBooleanWithValuesOf.class),isSuccessful());
  assertEquals(repeat(asList(false,true),50),PrimitiveBooleanWithValuesOf.values);
}
