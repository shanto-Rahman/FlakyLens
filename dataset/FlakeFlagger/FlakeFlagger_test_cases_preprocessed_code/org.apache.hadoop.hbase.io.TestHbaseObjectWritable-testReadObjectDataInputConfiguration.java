@SuppressWarnings("boxing") public void testReadObjectDataInputConfiguration() throws IOException {
assertTrue(doType(conf,COUNT,int.class).equals(COUNT));
assertTrue(WritableComparator.compareBytes(testing,0,testing.length,result,0,result.length) == 0);
doType(conf,new File("a"),File.class);//RO
assertTrue(exception);
assertTrue(((byte[])obj)[0] == A);
assertTrue(obj instanceof Text);
assertTrue(obj instanceof List);
Assert.assertArrayEquals(list.toArray(),((List)obj).toArray());
assertTrue(obj instanceof ArrayList);
Assert.assertArrayEquals(list.toArray(),((ArrayList)obj).toArray());
assertTrue(obj instanceof PrefixFilter);
}