public void testGet() throws Exception {
assertTrue(Bytes.equals(get.getRow(),desGet.getRow()));
assertTrue(desGet.getFamilyMap().containsKey(entry.getKey()));
assertTrue(desSet.contains(qualifier));
assertEquals(get.getLockId(),desGet.getLockId());
assertEquals(get.getMaxVersions(),desGet.getMaxVersions());
assertEquals(tr.getMax(),desTr.getMax());
assertEquals(tr.getMin(),desTr.getMin());
}