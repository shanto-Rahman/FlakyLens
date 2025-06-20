@Test @SuppressWarnings("rawtypes") public void testErrorForMachineClient() throws Exception {
assertThat(entity.getBody().toString(),endsWith("status=500, " + "error=Internal Server Error, " + "exception=java.lang.IllegalStateException, "+ "message=Server Error, "+ "path=/}"));
}