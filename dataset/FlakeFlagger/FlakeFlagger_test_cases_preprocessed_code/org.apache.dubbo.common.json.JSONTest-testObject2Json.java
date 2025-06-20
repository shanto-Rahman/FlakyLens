@Test public void testObject2Json() throws Exception {
bean.setName("ql");//IT
assertEquals(bean.getName(),"ql");//IT
assertEquals(bean.getDisplayName(),"钱磊");//IT
assertEquals(bean.bytes.length,DEFAULT_BYTES.length);//RW
assertEquals(bean.$$,DEFAULT_$$);//RW
assertEquals("{\"name\":\"ql\",\"array\":[1,3,4]}",JSON.json(bean,new String[]{"name","array"}));
}