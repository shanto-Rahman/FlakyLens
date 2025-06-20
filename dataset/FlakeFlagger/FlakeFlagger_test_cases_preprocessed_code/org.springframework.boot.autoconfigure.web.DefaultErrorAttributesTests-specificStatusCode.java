@Test public void specificStatusCode() throws Exception {
assertThat(attributes.get("error"),equalTo((Object)HttpStatus.NOT_FOUND.getReasonPhrase()));
assertThat(attributes.get("status"),equalTo((Object)404));
}