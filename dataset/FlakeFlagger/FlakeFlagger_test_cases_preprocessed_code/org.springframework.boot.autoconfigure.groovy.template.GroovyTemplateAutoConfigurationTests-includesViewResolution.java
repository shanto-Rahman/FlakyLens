@Test public void includesViewResolution() throws Exception {
assertThat(result,containsString("here"));
assertThat(response.getContentType(),equalTo("text/html;charset=UTF-8"));
}