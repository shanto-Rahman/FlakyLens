@Test public void testNormal01() throws Exception {
threadManager.submit(fluentd);//IT
Thread.sleep(2000);
threadManager.join();//IT
assertEquals(2,elist.size());
assertEquals("testtag.test01",elist.get(0).tag);
assertEquals("testtag.test01",elist.get(1).tag);
}