@Test public void testMain() throws Exception {
assertThat(s,is(Bytes.bytes2short(Bytes.short2bytes(s))));
assertThat(i,is(Bytes.bytes2int(Bytes.int2bytes(i))));
assertThat(l,is(Bytes.bytes2long(Bytes.long2bytes(l))));
assertThat(f,is(Bytes.bytes2float(Bytes.float2bytes(f))));
assertThat(d,is(Bytes.bytes2double(Bytes.double2bytes(d))));
assertThat(Bytes.int2bytes(i),is(int2bytes(i)));
assertThat(Bytes.long2bytes(l),is(long2bytes(l)));
assertThat(bytes,is("dubbo".getBytes()));
assertThat(bytesWithC64,is(bytes));
}