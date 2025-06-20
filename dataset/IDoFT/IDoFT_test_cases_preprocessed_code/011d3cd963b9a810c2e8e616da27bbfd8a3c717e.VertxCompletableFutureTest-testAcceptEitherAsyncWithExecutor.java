@Test @Repeat(50) public void testAcceptEitherAsyncWithExecutor(TestContext tc){
tc.assertEquals(i,1);
tc.assertEquals(i,1);
failure.acceptEitherAsync(success,i -> tc.fail("Should not be called"),executor).whenComplete((res,err) -> {
  tc.assertNotNull(err);
  tc.assertNull(res);
  async2.complete();
}
);
tc.assertNotNull(err);
tc.assertNull(res);
tc.assertEquals(i,1);
}