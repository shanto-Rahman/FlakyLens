public void testGet_Basic() throws IOException {
assertEquals(expected.length,res.size());
assertEquals(0,Bytes.compareTo(expected[i].getRow(),res.raw()[i].getRow()));
assertEquals(0,Bytes.compareTo(expected[i].getFamily(),res.raw()[i].getFamily()));
assertEquals(0,Bytes.compareTo(expected[i].getQualifier(),res.raw()[i].getQualifier()));
assertEquals(count,res.size());
}