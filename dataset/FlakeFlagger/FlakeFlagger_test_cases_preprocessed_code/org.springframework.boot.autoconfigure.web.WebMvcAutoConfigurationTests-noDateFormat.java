@Test public void noDateFormat() throws Exception {
assertThat(cs.convert(date,String.class),equalTo(date.toString()));
}