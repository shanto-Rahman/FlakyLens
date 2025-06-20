@Test public void testMergeUrl() throws Exception {
Assert.assertFalse(url.hasParameter(Constants.THREADS_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.THREADS_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.THREADPOOL_KEY));
Assert.assertFalse(url.hasParameter(Constants.CORE_THREADS_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.CORE_THREADS_KEY));
Assert.assertFalse(url.hasParameter(Constants.QUEUES_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.QUEUES_KEY));
Assert.assertFalse(url.hasParameter(Constants.ALIVE_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.ALIVE_KEY));
Assert.assertFalse(url.hasParameter(Constants.THREAD_NAME_KEY));
Assert.assertFalse(url.hasParameter(Constants.DEFAULT_KEY_PREFIX + Constants.THREAD_NAME_KEY));
Assert.assertEquals(url.getPath(),"path");
Assert.assertEquals(url.getUsername(),"username");
Assert.assertEquals(url.getPassword(),"password");
Assert.assertEquals(url.getParameter(Constants.PID_KEY),"1234");
Assert.assertEquals(url.getParameter(Constants.THREADPOOL_KEY),"foo");
}