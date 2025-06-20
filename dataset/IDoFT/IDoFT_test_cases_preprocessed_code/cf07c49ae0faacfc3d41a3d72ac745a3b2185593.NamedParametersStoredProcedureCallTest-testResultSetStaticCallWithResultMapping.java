@Test public void testResultSetStaticCallWithResultMapping() throws Exception {
assertThat(listResult).containsExactly(new Car(2,"title'2"));
}