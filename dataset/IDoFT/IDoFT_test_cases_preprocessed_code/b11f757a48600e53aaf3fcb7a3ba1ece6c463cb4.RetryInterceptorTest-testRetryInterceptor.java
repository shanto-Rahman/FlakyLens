@Test public void testRetryInterceptor(){
Assert.fail("ActivitiException expected.");
Assert.assertTrue(e.getMessage().contains(retryInterceptor.getNumOfRetries() + " retries failed"));
Assert.assertEquals(retryInterceptor.getNumOfRetries() + 1,counter.get());//RW
}