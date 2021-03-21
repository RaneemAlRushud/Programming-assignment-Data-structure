package pa;
//new
public class Album {

   private String name;
   private String condition;
    private PhotoManager manager;

    // Constructor

    public Album(String name, String condition, PhotoManager manager) {
        this.name=name;
        this.condition=condition;
        this.manager=manager;
    }
    // Return the name of the album

    public String getName() {
        return name;
    }
    // Return the condition associated with the album

    public String getCondition() {
        return condition;
    }
    // Return the manager

    public PhotoManager getManager() {
        return manager;
    }
    // Return all photos that satisfy the album condition

    public LinkedList<Photo> getPhotos() {
        try{
       LinkedList<Photo> emptyList =new LinkedList<Photo>();
//        if (condition==null) return new LinkedList<Photo>();//the empty LL that just has been created? since the condition pointer to null???
        if (condition.equals("")) return manager.getPhotosHaveBeenInsertedInBST(); // or getAllPhotos(aNodeInBST); photos with tags only? implement it down
      
//or empty list as the G said (photos with tags only? implement it down)
       if(manager.getPhotosHaveBeenInsertedInBST().empty()) return emptyList;
       
        String tagsOfCondition[];
        tagsOfCondition = condition.split(" AND ");
      

     
        LinkedList<Photo> allPhoInBSTthatWanted =new LinkedList<Photo>();
        LinkedList<Photo> llAachWordOfCondition;
         LinkedList<Photo>reassignmentLL=new LinkedList<Photo>();
          LinkedList<String>allTagsEachPhoto=new LinkedList<String>();
       boolean doubleCheck=true;
        int sizeAllPhoInBSTthatWanted;//that we are adding in
         boolean tagExist;
         int counter2=0;
         
        for (int counter = 0; counter < tagsOfCondition.length; counter++) { //check if tag exist
            tagExist = manager.getPhotos().findKey(tagsOfCondition[counter]);
            if (!tagExist){
              
                return emptyList;}
        }
        
        allPhoInBSTthatWanted=manager.getPhotosHaveBeenInsertedInBST();
       Photo tempPhotoInBSTthatWanted=null;
        allPhoInBSTthatWanted.findFirst();
        while(true){

            tempPhotoInBSTthatWanted=allPhoInBSTthatWanted.retrieve();
            allTagsEachPhoto=tempPhotoInBSTthatWanted.getTags();
            if(!allTagsEachPhoto.empty()){
            
                counter2=0;
                for(int i=0;i<tagsOfCondition.length;i++){
                    allTagsEachPhoto.findFirst();
                    while(true){
                if(tagsOfCondition[i].equals(allTagsEachPhoto.retrieve())){
                    counter2++;
                  
                    break;
                }
                if(!allTagsEachPhoto.last())
        allTagsEachPhoto.findNext();
        else break;
            }
                }


if(counter2==tagsOfCondition.length)
reassignmentLL.insert(tempPhotoInBSTthatWanted);
                
            
            }
        if(!allPhoInBSTthatWanted.last())
        allPhoInBSTthatWanted.findNext();
        else break;
            
            
        }
        
        
        
  return reassignmentLL;}
    catch(Exception raneem){return null;}
    }//end getPhotos()
        
     

    public int getNbComps() {
        try{
    if(condition.equals("")) return 0;//??
       int totalNbComps=0;
             String tagsOfCondition[];
        tagsOfCondition = condition.split(" AND ");
       
        
   BST<LinkedList<Photo>> aNodeInBST= manager.getPhotos();
        //   {//change enhanced for loop to for (int counter = 0; counter < tagsOfCondition.length; counter++)???
         for (String tagsOfCondition1 : tagsOfCondition)
        totalNbComps += aNodeInBST.numberOfComparisons(tagsOfCondition1);
       
        
        
        
        
        
        return totalNbComps;}
        catch(Exception raneem){return 0;}
    }

    
    
    
    
    //Adding external methods 
    


    private int sizeOfallPhoInALL(LinkedList<Photo> sizeOfallPhoInBST) {
        try{
        if(sizeOfallPhoInBST.empty()) return 0;
        int size = 0;
        sizeOfallPhoInBST.findFirst();
        while (true) {
             size++;
            if (!sizeOfallPhoInBST.last()) {
               
                sizeOfallPhoInBST.findNext();
            } else {
                break;
            }
        }
       //for the last node
        return size;
    }
    catch(Exception raneem){return 0;}
}}
