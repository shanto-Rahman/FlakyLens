public void testBinarySearch() throws Exception {
assertEquals(1,Bytes.binarySearch(arr,key1,0,1,Bytes.BYTES_RAWCOMPARATOR));
assertEquals(0,Bytes.binarySearch(arr,key1,1,1,Bytes.BYTES_RAWCOMPARATOR));
assertEquals(-(2 + 1),Arrays.binarySearch(arr,key2_2,Bytes.BYTES_COMPARATOR));
assertEquals(-(2 + 1),Bytes.binarySearch(arr,key2,0,1,Bytes.BYTES_RAWCOMPARATOR));
assertEquals(4,Bytes.binarySearch(arr,key2,1,1,Bytes.BYTES_RAWCOMPARATOR));
assertEquals(2,Bytes.binarySearch(arr,key3,0,1,Bytes.BYTES_RAWCOMPARATOR));
assertEquals(5,Bytes.binarySearch(arr,key3,1,1,Bytes.BYTES_RAWCOMPARATOR));
}