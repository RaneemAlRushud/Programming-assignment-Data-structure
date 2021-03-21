package pa;

public class PhotoManager {

    private BST<LinkedList<Photo>> aNodeInBST;
    private LinkedList<Photo> PhotosHaveBeenInsertedInBST;
    // Constructor

    public PhotoManager() {
        aNodeInBST = new BST<LinkedList<Photo>>();
        PhotosHaveBeenInsertedInBST = new LinkedList<Photo>();
    }

    // Add a photo
    //Adding in the BST after analyzed the created photo from main
    public void addPhoto(Photo p) {//ُTry diff. logic without external method!!!
        
     //   try{//try
     try{
if(p==null) return;
        if(p.getPath() == null || p.getTags() == null )
        return;
        
        
       
        
             if (!PhotosHaveBeenInsertedInBST.empty()) {
                    PhotosHaveBeenInsertedInBST.findFirst();
                    while (true) {
                        if (PhotosHaveBeenInsertedInBST.retrieve().getPath().equals(p.getPath())) {
                            return;//out of the method
                        } else if (!PhotosHaveBeenInsertedInBST.last()) {
                            PhotosHaveBeenInsertedInBST.findNext();
                        } else {
                            break;
                        }
                    }
                }
             
             
              PhotosHaveBeenInsertedInBST.insert(p);
               LinkedList<String> theLlTagsInAnOnePhoto = p.getTags();
        //no need
                if (theLlTagsInAnOnePhoto.empty()) {
            return; //What supposed do I do? (if there is no any tag in such a photo)!!!
        }
        
        
       //shoud I dublicate the declarations for both cases if and else?
       
       // int size = sizeOftheLlTagsInAnOnePhoto(theLlTagsInAnOnePhoto);
        theLlTagsInAnOnePhoto.findFirst();
     
       while(!theLlTagsInAnOnePhoto.last()){

            if (!aNodeInBST.findKey(theLlTagsInAnOnePhoto.retrieve())) {

                // if(theLlTagsInAnOnePhoto.empty())return; //What supposed do I do? (if there is no any tag in such a photo)!!!    why we do not check on PhotosHaveBeenInsertedInBST before also?
               LinkedList<Photo> photoInOneObj = new LinkedList<Photo>();//if a tag is new reassingment
              
                photoInOneObj.insert(p);
                aNodeInBST.insert(theLlTagsInAnOnePhoto.retrieve(), photoInOneObj);
            } else //the current already on the node that we searched before if is it existed or not
            { //if(PhotosHaveBeenInsertedInBST.empty()) return;
           

                // if(theLlTagsInAnOnePhoto.empty())return; //What supposed do I do? (if there is no any tag in such a photo)!!!
                //am i change the place of the current, should i put it first?
                
               LinkedList<Photo> aNodeInBST2= aNodeInBST.retrieve();
              // aNodeInBST2.findFirst();
              aNodeInBST2.insert(p);
            }
       theLlTagsInAnOnePhoto.findNext();}
       
       
if(theLlTagsInAnOnePhoto.last()){
              if (!aNodeInBST.findKey(theLlTagsInAnOnePhoto.retrieve())) {LinkedList<Photo> photoInOneObj = new LinkedList<Photo>();
                    photoInOneObj.insert(p);
                aNodeInBST.insert(theLlTagsInAnOnePhoto.retrieve(), photoInOneObj);
              
              } else {    LinkedList<Photo> aNodeInBST2= aNodeInBST.retrieve();
              aNodeInBST2.insert(p);}}
    
    
    
    
    
           // }//Check this out!!!


  
            
        }catch(Exception raneem){return ;}}

  //  }
   // catch(Exception raneem){//catch
    
    
   // }
    
    

    // Delete a photo
    public void deletePhoto(String path) {
        try{
        
        if (PhotosHaveBeenInsertedInBST.empty() ) {
            return;// make sure the photo is already existed
        }
        LinkedList<String> tagsOfTheRemovedPhoto = new LinkedList<String>();
boolean exist=false;
        PhotosHaveBeenInsertedInBST.findFirst();
        while (!PhotosHaveBeenInsertedInBST.last()) 
            {//try-catch
                if (PhotosHaveBeenInsertedInBST.retrieve().getPath().equals(path)) {
                    tagsOfTheRemovedPhoto = PhotosHaveBeenInsertedInBST.retrieve().getTags();
                    PhotosHaveBeenInsertedInBST.remove(); exist=true; break;
                } else {
                    PhotosHaveBeenInsertedInBST.findNext();
                }
            }//end while

            //if tag became without photos we should delete it
            if(PhotosHaveBeenInsertedInBST.last()){
           if ( PhotosHaveBeenInsertedInBST.retrieve().getPath().equals(path)) {//last photo in LL
                tagsOfTheRemovedPhoto = PhotosHaveBeenInsertedInBST.retrieve().getTags();
                PhotosHaveBeenInsertedInBST.remove(); exist=true;
            }} 
           if (!exist)
            return;//if the photo doesn't exist in the whole list so it's not in the tree
        

        //start deleting from BST
        //if we have a photo in a tree without tags which is impossiple
        if (tagsOfTheRemovedPhoto.empty()) {
            return; //should I put if it's null? so, first declare it as null or directly create an object of LL
        }
        Photo thatWantedPoDelete = new Photo(path, tagsOfTheRemovedPhoto);
        tagsOfTheRemovedPhoto.findFirst();
        while (true) {
            if (aNodeInBST.findKey(tagsOfTheRemovedPhoto.retrieve())) {//search about tag by tag
                deleteFromAlL(thatWantedPoDelete, aNodeInBST.retrieve());
                if (aNodeInBST.retrieve().empty()) {
                    aNodeInBST.removeKey(tagsOfTheRemovedPhoto.retrieve());//if the tag became without data (LL of Photo)
                }
            }  if (!tagsOfTheRemovedPhoto.last()) //LL of tags
            
                tagsOfTheRemovedPhoto.findNext();
             else 
                break;
            

        }
    }
    catch(Exception raneem){return ;}
    }// end deletePhoto

    // Return the inverted index of all managed photos
    public BST<LinkedList<Photo>> getPhotos() {
        return aNodeInBST;
    }//aNodeInBST return a whole BST

    public LinkedList<Photo> getPhotosHaveBeenInsertedInBST() {
        return PhotosHaveBeenInsertedInBST;
    }//ask the boy how?

    private void deleteFromAlL(Photo thatWantedPoDelete, LinkedList<Photo> llOfeachTag) {
        try{
        if (llOfeachTag.empty()) {
            return;
        }
        llOfeachTag.findFirst();
        while (true) {
            if (  !llOfeachTag.empty() && !llOfeachTag.last()) {

                if (llOfeachTag.retrieve().getPath().equals(thatWantedPoDelete.getPath())) {
                    llOfeachTag.remove(); return;//the curren will move to next node so no need for findNext \\should i put return since i am sure no dublicate of photos before ?
                } else {
                    llOfeachTag.findNext();//if not being deleted
                }
            }
            else if(!llOfeachTag.empty() && llOfeachTag.retrieve().getPath().equals(thatWantedPoDelete.getPath())) {
                llOfeachTag.remove();   break;
            } 
              
            else return;//if thatWantedPoDelete not matches 

        }


    }catch(Exception raneem){return ;}}
}
