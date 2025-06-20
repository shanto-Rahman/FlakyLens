@Test public void test() throws Exception {
assertThat(status,notNullValue());
logger.info("load status level: " + status.getLevel());//RW
logger.info("load status message: " + status.getMessage());//RW
}