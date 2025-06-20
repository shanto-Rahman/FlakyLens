@Test public void testMiscHTableStuff() throws IOException {
Put put=new Put(ROW);//RW
Get get=new Get(ROW);//RW
assertTrue("wrong table descriptor returned",Bytes.compareTo(desc.getName(),tableAname) == 0);
assertFalse("missing HTD attribute value",value == null);
assertFalse("HTD attribute value is incorrect",Bytes.compareTo(value,attrValue) != 0);
assertFalse("missing HCD attribute value",value == null);
assertFalse("HCD attribute value is incorrect",Bytes.compareTo(value,attrValue) != 0);
}