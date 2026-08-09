class HighestAltitude {

  public int largestAltitude(int gain[]) {
    int largest = 0;
    int gains[] = new int[gain.length + 1];
    gains[0] = 0;
    for(int i = 0; i < gain.length; i++) {
      gains[i+1] = gains[i] + gain[i];
    }
    for(int g : gains) {
      largest = Math.max(largest, g);
    }
    return largest;
  }

  void main() {
    int gain[] = {-5, 1, 5, 0, -7};
    System.out.println(largestAltitude(gain));
  }
}