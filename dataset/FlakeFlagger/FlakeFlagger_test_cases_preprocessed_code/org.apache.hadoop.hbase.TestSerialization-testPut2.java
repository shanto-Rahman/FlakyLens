public void testPut2() throws Exception {
assertTrue(Bytes.equals(put.getRow(),desPut.getRow()));
assertTrue(desPut.getFamilyMap().containsKey(entry.getKey()));
assertTrue(list.get(i).equals(desList.get(i)));
}