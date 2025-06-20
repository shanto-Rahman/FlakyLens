@Test public void rejectsUnexpandedUriTemplateWithNotFound() throws Exception {
assertThat(handlerMapping.get().getHandler(mockRequest)).isNull();
}