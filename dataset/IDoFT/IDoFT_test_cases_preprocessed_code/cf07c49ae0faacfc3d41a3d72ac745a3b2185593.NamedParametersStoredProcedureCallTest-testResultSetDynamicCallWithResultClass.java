@Test public void testResultSetDynamicCallWithResultClass() throws Exception {
assertThat(listResult).containsExactly(new Car(1,"title"));
}