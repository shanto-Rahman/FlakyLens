@Test public void deepTreeSerialization() throws IOException {
assertTrue("serialized logger should be less than 100 bytes",sizeA < 100);
assertTrue("serialized loggers should be nearly the same size a:" + sizeA + ", sizeB:"+ sizeB,(sizeA - sizeB) < 10);
}