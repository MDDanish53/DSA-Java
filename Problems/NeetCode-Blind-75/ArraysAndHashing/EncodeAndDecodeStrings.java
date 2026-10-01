class EncodeAndDecodeStrings {

  public String encode(String arr[]) {

    if (arr.length == 0) {
      return Character.toString((char) 258);
    }

    String separate = Character.toString((char) 257);
    StringBuilder sb = new StringBuilder();
    for (String s : arr) {
      sb.append(s);
      sb.append(separate);
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public ArrayList<String> decode(String s) {
    if (s.equals(Character.toString((char) 258))) {
      return new ArrayList<>();
    }

    String separate = Character.toString((char) 257);
    return new ArrayList<>(Arrays.asList(s.split(separate, -1)));
  }
}