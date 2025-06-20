@Test @SuppressWarnings("rawtypes") public void testErrorForAnnotatedException() throws Exception {
assertThat(entity.getBody().toString(),endsWith("status=400, " + "error=Bad Request, " + "exception=org.springframework.boot.autoconfigure.web.BasicErrorControllerIntegrationTests$TestConfiguration$Errors$ExpectedException, "+ "message=Expected!, "+ "path=/annotated}"));
}