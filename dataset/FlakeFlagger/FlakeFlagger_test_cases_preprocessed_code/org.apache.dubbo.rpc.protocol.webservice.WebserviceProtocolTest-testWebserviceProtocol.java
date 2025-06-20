@Test public void testWebserviceProtocol() throws Exception {
assertEquals(service.create(1,"kk").getName(),"kk");
assertEquals(service.getSize(null),-1);
assertEquals(service.getSize(new String[]{"","",""}),3);
assertEquals("webservice://127.0.0.1:9019/org.apache.dubbo.rpc.protocol.webservice.DemoService:invoke",object);
assertEquals(32800,service.stringLength(buf.toString()));
}