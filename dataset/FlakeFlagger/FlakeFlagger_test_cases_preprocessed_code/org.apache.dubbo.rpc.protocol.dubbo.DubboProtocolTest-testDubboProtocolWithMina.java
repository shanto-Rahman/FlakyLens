@Test public void testDubboProtocolWithMina() throws Exception {
assertEquals(service.enumlength(new Type[]{}),Type.Lower);
assertEquals(service.getSize(null),-1);
assertEquals(service.getSize(new String[]{"","",""}),3);
assertEquals(set.size(),1);
assertEquals(set.iterator().next(),"aa");
assertEquals(echo.$echo(buf.toString()),buf.toString());
assertEquals(echo.$echo("test"),"test");
assertEquals(echo.$echo("abcdefg"),"abcdefg");
assertEquals(echo.$echo(1234),1234);
}