@Test public void overrideDateFormat() throws Exception {
assertThat(cs.convert(date,String.class),equalTo("25*06*1988"));
}