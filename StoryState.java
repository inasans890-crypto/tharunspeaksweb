class StoryState {
    private int angerLevel;
    private int calmLevel;
    private int curiosityLevel;
    private int playCount;
    private java.util.ArrayList<String> unlockedEndings;
    
    public StoryState() {
        this.angerLevel = 0;
        this.calmLevel = 0;
        this.curiosityLevel = 0;
        this.playCount = 1;
        this.unlockedEndings = new java.util.ArrayList<>();
    }
    
    public void increaseAnger() { 
        angerLevel++;
        if (angerLevel > 10) angerLevel = 10;
    }
    
    public void increaseCalm() { 
        calmLevel++;
        if (calmLevel > 10) calmLevel = 10;
    }
    
    public void increaseCuriosity() { 
        curiosityLevel++;
        if (curiosityLevel > 10) curiosityLevel = 10;
    }
    
    public int getAngerLevel() { return angerLevel; }
    public int getCalmLevel() { return calmLevel; }
    public int getCuriosityLevel() { return curiosityLevel; }
    
    public void addEnding(String ending) {
        if (!unlockedEndings.contains(ending)) {
            unlockedEndings.add(ending);
        }
    }
    
    public java.util.ArrayList<String> getUnlockedEndings() {
        return unlockedEndings;
    }
}