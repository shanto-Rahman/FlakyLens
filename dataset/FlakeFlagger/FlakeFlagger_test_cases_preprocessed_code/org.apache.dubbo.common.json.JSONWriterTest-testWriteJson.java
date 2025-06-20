public void testWriteJson() throws Exception {
assertEquals(w.getBuffer().toString(),"null");
assertEquals(w.getBuffer().toString(),"[null,false,16]");
assertEquals(w.getBuffer().toString(),"{\"type\":\"org.apache.dubbo.TestService\",\"version\":\"1.1.0\"}");
}