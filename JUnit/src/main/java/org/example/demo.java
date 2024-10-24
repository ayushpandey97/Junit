class Demo{
    public static void main(String[] args){
        System.out.println("this is a demo file. ");
        String str= "Looking for an entry-level position in a growing financial organization. Passionate about learning business concepts and possess the ability to handle work pressure and customer issues professionally. Have exceptional advisory skills to introduce new schemes and help customers to meet their financial goals.";
        String[] words= str.split(" ");
        for (String word:words){
            System.out.println(word);
        }
    }
}