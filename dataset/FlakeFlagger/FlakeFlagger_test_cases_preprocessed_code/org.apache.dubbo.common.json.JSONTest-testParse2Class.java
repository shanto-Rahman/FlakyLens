@Test @SuppressWarnings("unchecked") public void testParse2Class() throws Exception {
assertEquals(o2.length,5);
assertEquals(o1[i],o2[i]);
assertEquals(l1.size(),5);
assertEquals(o1[i],((Number)l1.get(i)).intValue());
assertEquals(bean.getName(),"qianlei");//IT
assertEquals(bean.getDisplayName(),"钱磊");//IT
assertEquals(bean.array.length,5);
assertEquals(bean.$$,214726);
assertEquals(bean.$b,true);
}