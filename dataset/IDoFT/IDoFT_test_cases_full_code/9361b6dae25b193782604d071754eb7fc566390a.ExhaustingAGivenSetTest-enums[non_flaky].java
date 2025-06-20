@Test public void enums(){
  assertThat(testResult(Enums.class),isSuccessful());
  assertEquals(2,Enums.iterations);
  assertEquals(EnumSet.of(HALF_UP,HALF_EVEN),Enums.testCases);
  Enums.iterations=0;
}
