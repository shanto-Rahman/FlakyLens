@Test public void defaultViewResolution() throws Exception {
assertThat(result,containsString("home"));
assertThat(response.getContentType(),equalTo("text/html;charset=UTF-8"));
}