@Test public void customContentType() throws Exception {
assertThat(result,containsString("home"));
assertThat(response.getContentType(),equalTo("application/json;charset=UTF-8"));
}