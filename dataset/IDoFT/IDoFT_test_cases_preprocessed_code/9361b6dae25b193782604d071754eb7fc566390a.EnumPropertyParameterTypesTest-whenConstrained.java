@Test public void whenConstrained() throws Exception {
assertThat(testResult(EnumWithConstraint.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),EnumWithConstraint.values.size());//RW
assertThat(EnumWithConstraint.values,not(hasItem(E3)));//RW
}