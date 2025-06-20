@Test public void testHex() throws IOException {
if (b1 < 10) builder.append((char)('0' + b1));
 else builder.append((char)('A' + (b1 - 10)));
if (b2 < 10) builder.append((char)('0' + b2));
 else builder.append((char)('A' + (b2 - 10)));
}