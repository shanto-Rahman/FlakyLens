@Test public void testKeysOnlyPredicate(){
assertNotNull(row.getKey());
assertEquals(0,row.getColumnSlice().getColumns().size());
assertNotNull(row.getKey());
assertEquals(2,row.getColumnSlice().getColumns().size());
}