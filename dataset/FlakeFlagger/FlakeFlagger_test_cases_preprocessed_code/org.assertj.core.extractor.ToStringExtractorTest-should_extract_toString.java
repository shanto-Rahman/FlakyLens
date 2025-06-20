@Test public void should_extract_toString() throws Exception {
assertThat(result).isEqualTo("Employee[id=1, name=Name[first='John Doe', last='null'], age=28]");
}