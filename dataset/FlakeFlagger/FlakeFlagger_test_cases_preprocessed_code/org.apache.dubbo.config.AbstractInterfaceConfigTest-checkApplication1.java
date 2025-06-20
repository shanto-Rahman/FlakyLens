@Test public void checkApplication1() throws Exception {
TestCase.assertEquals("demo",appConfig.getName());
TestCase.assertEquals("100",System.getProperty(Constants.SHUTDOWN_WAIT_KEY));
TestCase.assertEquals("1000",System.getProperty(Constants.SHUTDOWN_WAIT_SECONDS_KEY));
}