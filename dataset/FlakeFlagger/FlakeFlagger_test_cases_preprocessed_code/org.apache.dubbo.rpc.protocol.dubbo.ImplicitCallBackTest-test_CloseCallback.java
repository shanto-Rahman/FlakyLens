@Test public void test_CloseCallback() throws Exception {
Person ret=demoProxy.get(1);//IT
Assert.assertEquals(1,ret.getId());//IT
}