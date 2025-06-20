@Test public void testCustomBanner() throws Exception {
assertThat(this.out.toString(),containsString("My Banner"));
}