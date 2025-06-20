@Test public void testPut() throws IOException {
assertEquals(put.size(),1);
assertEquals(put.getFamilyMap().get(CONTENTS_FAMILY).size(),1);
assertTrue(Bytes.equals(kv.getFamily(),CONTENTS_FAMILY));
assertTrue(Bytes.equals(kv.getQualifier(),new byte[0]));
assertTrue(Bytes.equals(kv.getValue(),value));
}