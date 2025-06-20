@Test public void emptyServerWhenPortIsMinusOne() throws Exception {
assertThat(this.container.getPort(),lessThan(0));
}