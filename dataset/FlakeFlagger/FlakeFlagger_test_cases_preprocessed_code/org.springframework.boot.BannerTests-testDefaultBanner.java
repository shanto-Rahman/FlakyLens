@Test public void testDefaultBanner() throws Exception {
assertThat(this.out.toString(),containsString(":: Spring Boot ::"));
}