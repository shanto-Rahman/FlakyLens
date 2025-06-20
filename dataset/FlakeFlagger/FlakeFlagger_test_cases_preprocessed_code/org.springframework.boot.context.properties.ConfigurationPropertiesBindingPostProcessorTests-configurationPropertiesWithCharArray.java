@Test public void configurationPropertiesWithCharArray() throws Exception {
assertThat(this.context.getBean(PropertyWithCharArray.class).getChars(),equalTo("word".toCharArray()));
}