@Test public void testComboIndex() throws Exception {
assertNotNull(args);
assertEquals("was expecting a call with 5 args",5,args.length);
if (stmtC == 0) {
assertEquals("CREATE TABLE `comboindex` (`stuff` VARCHAR(255) , `junk` BIGINT ) ",args[0]);
if (stmtC == 1) {
assertEquals("CREATE INDEX `" + ComboIndex.INDEX_NAME + "` ON `comboindex` ( `stuff`, `junk` )",args[0]);
if (stmtC == 2) {
assertEquals("DROP INDEX `" + ComboIndex.INDEX_NAME + "`",args[0]);
if (stmtC == 3) {
assertEquals("DROP TABLE `comboindex` ",args[0]);
fail("Should only be called 4 times");
}
}
}
}
assertEquals(StatementType.EXECUTE,args[1]);
assertEquals(0,((FieldType[])args[2]).length);
}