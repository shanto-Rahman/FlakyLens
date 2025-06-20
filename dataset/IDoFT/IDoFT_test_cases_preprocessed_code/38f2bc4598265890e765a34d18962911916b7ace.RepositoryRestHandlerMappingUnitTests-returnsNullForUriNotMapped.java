@Test public void returnsNullForUriNotMapped() throws Exception {
assertThat(handlerMapping.get().getHandler(mockRequest)).isNull();
}