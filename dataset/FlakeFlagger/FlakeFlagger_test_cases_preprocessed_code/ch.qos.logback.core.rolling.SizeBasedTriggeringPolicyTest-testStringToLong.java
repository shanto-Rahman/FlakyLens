public void testStringToLong(){
assertEquals(new Long("123"),result);
assertEquals(new Long("125952"),result);
assertEquals(new Long("128974848"),result);
assertEquals(new Long("132070244352"),result);
assertEquals(new Long(SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE),result);
assertEquals(2,context.getStatusManager().getCount());
}