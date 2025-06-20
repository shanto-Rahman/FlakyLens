@Test public void testName2() throws Exception {
assertThat(module.getName(),equalTo("module-name"));
assertThat(module.getId(),equalTo("module-name"));
assertThat(parameters,hasEntry("module","module-name"));
}