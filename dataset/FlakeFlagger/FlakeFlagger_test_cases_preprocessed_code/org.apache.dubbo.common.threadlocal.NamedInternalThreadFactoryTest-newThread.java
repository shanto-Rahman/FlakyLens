@Test public void newThread() throws Exception {
Assert.assertTrue("thread is not InternalThread",t.getClass().equals(InternalThread.class));
}