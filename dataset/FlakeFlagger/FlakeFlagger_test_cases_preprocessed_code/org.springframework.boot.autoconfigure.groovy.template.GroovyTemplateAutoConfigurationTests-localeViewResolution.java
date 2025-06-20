@Test public void localeViewResolution() throws Exception {
assertThat(result,containsString("voila"));
assertThat(response.getContentType(),equalTo("text/html;charset=UTF-8"));
}