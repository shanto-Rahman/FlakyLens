@SuppressWarnings("unchecked") @Test public void testNormal02() throws Exception {
if (e.tag.startsWith("noprefix")) {
if (e.tag.startsWith("testtag00")) {
}
}
threadManager.submit(fluentd);//IT
Thread.sleep(2000);
threadManager.join();//IT
assertEquals(counts[0],elists[0].size());
assertEquals("testtag00.test00",e.tag);
assertEquals(counts[1],elists[1].size());
assertEquals("testtag01.test01",e.tag);
assertEquals(counts[2],elists[2].size());
assertEquals("noprefix01",e.tag);
}