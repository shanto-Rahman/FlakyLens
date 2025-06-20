@Test(expected=RuntimeException.class) public void test_Normal_Ex() throws Exception {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(requestId,ret.getId());//IT
}