@Test public void testMock() throws Exception {
assertThat(methodConfig.getMock(),isEmptyOrNullString());
assertThat(methodConfig.getMock(),equalTo("true"));
assertThat(methodConfig.getMock(),equalTo("return null"));
assertThat(methodConfig.getMock(),equalTo("mock"));
}