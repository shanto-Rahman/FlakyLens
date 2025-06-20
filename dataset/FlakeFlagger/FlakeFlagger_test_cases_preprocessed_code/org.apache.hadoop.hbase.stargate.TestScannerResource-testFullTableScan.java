public void testFullTableScan() throws IOException {
assertEquals(fullTableScan(model),expectedRows1);//RW
assertEquals(fullTableScan(model),expectedRows2);//RW
}