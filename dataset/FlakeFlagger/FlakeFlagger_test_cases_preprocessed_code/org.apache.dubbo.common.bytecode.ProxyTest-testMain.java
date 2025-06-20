@Test public void testMain() throws Exception {
if ("getName".equals(method.getName())) {
assertEquals(args.length,0);
if ("setName".equals(method.getName())) {
assertEquals(args.length,2);
assertEquals(args[0],"qianlei");
assertEquals(args[1],"hello");
}
}
assertNull(instance.getName());//IT
instance.setName("qianlei","hello");//IT
}