@Test public void testConstraintViolationException(){
assertThat(response,not(nullValue()));
assertThat(response.getEntity(),instanceOf(ViolationReport.class));
}