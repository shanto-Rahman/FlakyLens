@Test public void specificResourceAsFile() throws Exception {
assertThat(this.environment,containsPropertySource("applicationConfig: [" + location + "]"));
}