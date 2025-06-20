@Test public void testResultSetStaticCallWithResultClass() throws Exception {
assertThat(listResult).containsExactly(new Car(1,"title"));
}