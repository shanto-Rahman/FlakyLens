public void testScan() throws Exception {
assertTrue(Bytes.equals(scan.getStartRow(),desScan.getStartRow()));
assertTrue(Bytes.equals(scan.getStopRow(),desScan.getStopRow()));
assertEquals(scan.getCacheBlocks(),desScan.getCacheBlocks());
assertTrue(desScan.getFamilyMap().containsKey(entry.getKey()));
assertTrue(desSet.contains(column));
assertTrue(f instanceof PrefixFilter);
assertEquals(scan.getMaxVersions(),desScan.getMaxVersions());
assertEquals(tr.getMax(),desTr.getMax());
assertEquals(tr.getMin(),desTr.getMin());
}