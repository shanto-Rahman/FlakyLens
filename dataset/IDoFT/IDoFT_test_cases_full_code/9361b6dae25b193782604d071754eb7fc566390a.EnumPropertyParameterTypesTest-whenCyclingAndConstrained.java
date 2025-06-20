@Test public void whenCyclingAndConstrained(){
  assertThat(testResult(EnumWithValuesOfAndConstraint.class),isSuccessful());
  assertEquals(repeat(asList(E1,E2,E4,E5),25),EnumWithValuesOfAndConstraint.values);
}
