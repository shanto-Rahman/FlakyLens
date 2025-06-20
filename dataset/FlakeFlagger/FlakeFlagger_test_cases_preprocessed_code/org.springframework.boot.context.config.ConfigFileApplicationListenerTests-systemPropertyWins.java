@Test public void systemPropertyWins() throws Exception {
assertThat(property,equalTo("fromsystem"));
}