@Test public void testNormalException(){
assertThat(response,not(nullValue()));
assertThat(response.getEntity(),instanceOf(String.class));
}