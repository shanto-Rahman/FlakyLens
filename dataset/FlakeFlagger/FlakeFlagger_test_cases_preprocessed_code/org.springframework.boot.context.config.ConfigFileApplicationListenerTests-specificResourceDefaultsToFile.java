@Test public void specificResourceDefaultsToFile() throws Exception {
assertThat(this.environment,containsPropertySource("applicationConfig: [file:" + location + "]"));
}