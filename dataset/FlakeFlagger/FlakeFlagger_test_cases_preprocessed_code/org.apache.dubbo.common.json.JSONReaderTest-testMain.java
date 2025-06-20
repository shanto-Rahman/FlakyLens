public void testMain() throws Exception {
assertEquals(reader.nextToken().type,JSONToken.LBRACE);
assertEquals(reader.nextToken().type,JSONToken.IDENT);
assertEquals(reader.nextToken().type,JSONToken.COLON);
assertEquals(reader.nextToken().type,JSONToken.STRING);
assertEquals(reader.nextToken().type,JSONToken.COMMA);
assertEquals(reader.nextToken().type,JSONToken.IDENT);
assertEquals(reader.nextToken().type,JSONToken.COLON);
assertEquals(reader.nextToken().type,JSONToken.LSQUARE);
assertEquals(reader.nextToken().type,JSONToken.INT);
assertEquals(reader.nextToken().type,JSONToken.COMMA);
assertEquals(reader.nextToken().type,JSONToken.NULL);
assertEquals(reader.nextToken().type,JSONToken.COMMA);
assertEquals(reader.nextToken().type,JSONToken.FLOAT);
assertEquals(reader.nextToken().type,JSONToken.COMMA);
assertEquals(reader.nextToken().type,JSONToken.RSQUARE);
assertEquals(reader.nextToken().type,JSONToken.RBRACE);
}