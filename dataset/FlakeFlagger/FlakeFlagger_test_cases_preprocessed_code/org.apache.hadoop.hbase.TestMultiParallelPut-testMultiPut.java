public void testMultiPut() throws Exception {
assertTrue(r.containsColumn(BYTES_FAMILY,QUALIFIER));
assertEquals(0,Bytes.compareTo(VALUE,r.getValue(BYTES_FAMILY,QUALIFIER)));
assertEquals(2,cs.getServers());
assertTrue(info.getLoad().getNumberOfRegions() > 10);
}