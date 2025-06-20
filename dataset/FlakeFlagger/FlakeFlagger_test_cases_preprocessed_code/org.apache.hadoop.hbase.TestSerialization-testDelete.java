public void testDelete() throws Exception {
assertTrue(Bytes.equals(delete.getRow(),desDelete.getRow()));
assertTrue(desDelete.getFamilyMap().containsKey(entry.getKey()));
assertTrue(list.get(i).equals(desList.get(i)));
}