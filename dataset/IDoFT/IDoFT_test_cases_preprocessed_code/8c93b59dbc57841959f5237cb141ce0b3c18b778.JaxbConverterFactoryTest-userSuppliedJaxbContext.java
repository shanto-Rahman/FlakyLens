@Test public void userSuppliedJaxbContext() throws Exception {
assertThat(request.getHeader("Content-Type")).isEqualTo("application/xml; charset=utf-8");
assertThat(request.getBody().readUtf8()).isEqualTo(SAMPLE_CONTACT_XML);
}