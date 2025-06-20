@Test public void test_Caught_Biz_Error() throws RemotingException {
fail();
Assert.assertEquals(BizException.class,e.getCause().getClass());
}