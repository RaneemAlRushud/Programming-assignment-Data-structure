///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package pa;
//
///**
// *
// * @author raneemalrashoud
// */
public class PA {
//
//    /**
//     * @param args the command line arguments
//     */


	public static void main(String[] args) {


		LinkedList<String> tag1 = new LinkedList<String>();
		tag1.insert("animal");
		tag1.insert("hedgehog");
		tag1.insert("apple");
		tag1.insert("grass");
		tag1.insert("green");

		LinkedList<String> tag2 = new LinkedList<String>();
		tag2.insert("animal");
		tag2.insert("bear");
		tag2.insert("cub");
		tag2.insert("grass");
		tag2.insert("wind");

		LinkedList<String> tag3 = new LinkedList<String>();
		tag3.insert("insect");
		tag3.insert("butterfly");
		tag3.insert("flower");
		tag3.insert("color");

		LinkedList<String> tag4 = new LinkedList<String>();
		tag4.insert("insect");
		tag4.insert("butterfly");
		tag4.insert("black");
		tag4.insert("flower");

		LinkedList<String> tag5 = new LinkedList<String>();
		tag5.insert("animal");
		tag5.insert("fox");
		tag5.insert("tree");
		tag5.insert("forest");
		tag5.insert("grass");

		LinkedList<String> tag6 = new LinkedList<String>();
		tag6.insert("animal");
		tag6.insert("bear");
		tag6.insert("panda");
		tag6.insert("grass");

		LinkedList<String> tag7 = new LinkedList<String>();
		tag7.insert("animal");
		tag7.insert("wolf");
		tag7.insert("mountain");
		tag7.insert("sky");
		tag7.insert("snow");
		tag7.insert("cloud");

		LinkedList<String> tag8 = new LinkedList<String>();
		tag8.insert("animal");
		tag8.insert("raccoon");
		tag8.insert("log");
		tag8.insert("snow");

		LinkedList<String> tag9 = new LinkedList<String>();
		tag9.insert("animal");
		tag9.insert("desert");
		tag9.insert("scales");
		tag9.insert("warm");

		Photo p1 = new Photo("hedgehog.jpg", tag1);
		Photo p2 = new Photo("bear.jpg", tag2);
		Photo p3 = new Photo("butterfly1.jpg", tag3);
		Photo p4 = new Photo("butterfly2.jpg", tag4);
		Photo p5 = new Photo("fox.jpg", tag5);
		Photo p6 = new Photo("panda.jpg", tag6);
		Photo p7 = new Photo("wolf.jpg", tag7);
		Photo p8 = new Photo("raccoon.jpg", tag8);
		Photo p9 = new Photo("lizard.jpg", tag9);

		PhotoManager pm = new PhotoManager();

		pm.addPhoto(p1);
		pm.addPhoto(p2);
		pm.addPhoto(p3);
		pm.addPhoto(p4);
		pm.addPhoto(p5);
		pm.addPhoto(p6);
		pm.addPhoto(p7);
		pm.addPhoto(p8);
		pm.addPhoto(new Photo("image.jpg", new LinkedList<String>())); // add it

		Album album = new Album("ALL", "", pm);
		System.out.println("All Photos in Album");
		display(album.getPhotos()); // displays all photos
		
		System.out.println("_________________________________________");

		pm.deletePhoto("butterfly1.jpg");
		System.out.println("All Photos in Album w/o butterfly1.jpg");
		display(album.getPhotos()); // displays all photos w/o butterfly1.jpg
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("Bears", "bear", pm);
		System.out.println("All Photos Containing bear Tag");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("empty", "gecko", pm);
		System.out.println("All Photos Containing gecko Tag");
		display(album.getPhotos()); // should be empty
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("empty", "animal AND grass", pm);
		System.out.println("All Photos Containing animal and grass Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("Bears", "animal AND grass AND bear", pm);
		System.out.println("All Photos Containing animal and grass and bear Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("Wolf", "wolf AND sky AND snow AND cloud", pm);
		System.out.println("All Photos Containing wolf and sky and snow and cloud Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		
		System.out.println("_________________________________________");

		album = new Album("empty", "animal AND omnivore", pm);
		System.out.println("All Photos Containing animal and omnivore Tags");
		display(album.getPhotos()); // empty
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("Butterfly", "insect AND black AND flower AND butterfly", pm);
		System.out.println("All Photos Containing insect and black and flower and butterfly Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("empty", "animal AND black AND flower", pm);
		System.out.println("All Photos Containing animal and black and flower Tags");
		display(album.getPhotos()); // empty
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		pm.addPhoto(p9);
		album = new Album("ALL", "", pm);
		System.out.println("All Photos in Album");
		display(album.getPhotos()); // include lizard
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");
		
		album = new Album("Lizard", "desert AND animal", pm);
		System.out.println("All Photos Containing desert and animal Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		album = new Album("Lizard", "animal AND desert", pm);
		System.out.println("All Photos Containing desert and animal Tags");
		display(album.getPhotos());
		System.out.println(album.getNbComps());
		System.out.println();
		
		System.out.println("_________________________________________");

		pm.deletePhoto("image.jpg");
		album = new Album("ALL", "", pm);
		System.out.println("All Photos in Album");
		display(album.getPhotos()); // empty
		System.out.println(album.getNbComps());
	}

	public static void display(LinkedList<Photo> l) {
		if (l == null || l.empty()) {
			System.out.println("Empty Photo List \n");
			return;
		}

		l.findFirst();
		while (!l.last()) {
			System.out.print(l.retrieve().getPath() + " --> ");
			l.findNext();
		}
		System.out.print(l.retrieve().getPath());
		System.out.println("\n");
	}












}

//
//		LinkedList<String> tag1 = new LinkedList<String>();
//		tag1.insert("animal");
//		tag1.insert("hedgehog");
//		tag1.insert("apple");
//		tag1.insert("grass");
//		tag1.insert("green");
//
//		LinkedList<String> tag2 = new LinkedList<String>();
//		tag2.insert("animal");
//		tag2.insert("bear");
//		tag2.insert("cub");
//		tag2.insert("grass");
//		tag2.insert("wind");
//
//		LinkedList<String> tag3 = new LinkedList<String>();
//		tag3.insert("insect");
//		tag3.insert("butterfly");
//		tag3.insert("flower");
//		tag3.insert("color");
//
//
//		Photo p1 = new Photo("hedgehog.jpg", tag1);
//		Photo p2 = new Photo("bear.jpg", tag2);
//		Photo p3 = new Photo("butterfly1.jpg", tag3);
//	
//		PhotoManager pm = new PhotoManager();
//
//		pm.addPhoto(p1);
//		pm.addPhoto(p2);
//		pm.addPhoto(p3);
//		pm.addPhoto(new Photo("image.jpg", new LinkedList<String>())); // add it
//
//		Album album = new Album("ALL", "", pm);
//		System.out.println("All Photos in Album");
//		display(album.getPhotos()); // displays all photos
//		System.out.println("_________________________________________");
//
//		album = new Album("Bears", "bear", pm);
//		System.out.println("All Photos Containing bear Tag");
//		display(album.getPhotos());
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("empty", "gecko", pm);
//		System.out.println("All Photos Containing gecko Tag");
//		display(album.getPhotos()); // should be empty
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("empty", "animal AND grass", pm);
//		System.out.println("All Photos Containing animal and grass Tags");
//		display(album.getPhotos());
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		pm.addPhoto(p1);
//		album = new Album("Bears", "animal AND grass AND bear", pm);
//		System.out.println("All Photos Containing animal and grass and bear Tags");
//		display(album.getPhotos());
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("empty", "animal AND omnivore", pm);
//		System.out.println("All Photos Containing animal and omnivore Tags");
//		display(album.getPhotos()); // empty
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("Butterfly", "insect AND black AND flower AND butterfly", pm);
//		System.out.println("All Photos Containing insect and black and flower and butterfly Tags");
//		display(album.getPhotos());
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("empty", "animal AND black AND flower", pm);
//		System.out.println("All Photos Containing animal and black and flower Tags");
//		display(album.getPhotos()); // empty
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//		System.out.println("_________________________________________");
//
//		album = new Album("ALL", "", pm);
//		System.out.println("All Photos in Album");
//		display(album.getPhotos()); // include lizard
//		System.out.println(album.getNbComps());
//		System.out.println();
//		
//	}
//
//	public static void display(LinkedList<Photo> l) {
//		if (l == null || l.empty()) {
//			System.out.println("Empty Photo List \n");
//			return;
//		}
//
//		l.findFirst();
//		while (!l.last()) {
//			System.out.print(l.retrieve().getPath() + " --> ");
//			l.findNext();
//		}
//		System.out.print(l.retrieve().getPath());
//		System.out.println("\n");
//	}
//
//}

//        // TODO code application logic here
////       String condition="ffkfkfk mmvv and kkk";
////            String tagsOfCondition[];
////        tagsOfCondition = condition.split("AND");
////        for (int counter = 0; counter < tagsOfCondition.length; counter++) {
////            tagsOfCondition[counter].trim();
////        }
////        
////System.out.println(tagsOfCondition[1]);
//
//System.out.println("first add method getRoot in BST class to return root");
//System.out.println("the follwing checking photo manager ");
//System.out.println("==================== ==================");
//LinkedList<String>tags1=new LinkedList<String>();
//tags1.insert("animal");
//tags1.insert("hedgehog");
//tags1.insert("apple");
//tags1.insert("grass");
//tags1.insert("green");
//Photo p1=new Photo("hedgehog.jpg", tags1);
//
//LinkedList<String>tags2=new LinkedList<String>();
//tags2.insert("animal");
//tags2.insert("bear");
//tags2.insert("cub");
//tags2.insert("grass");
//tags2.insert("wind");
//Photo p2=new Photo("bear.jpg",tags2);
//
//LinkedList<String>tags3=new LinkedList<String>();
//tags3.insert("insect");
//tags3.insert("butterfly");
//tags3.insert("flower");
//tags3.insert("color");
//Photo p3=new Photo("butterfly1.jpg",tags3);
//
//LinkedList<String>tags4=new LinkedList<String>();
//tags4.insert("insect");
//tags4.insert("butterfly");
//tags4.insert("black");
//tags4.insert("flower");
//Photo p4=new Photo("butterfly2.jpg",tags4);
//
//LinkedList<String>tags5=new LinkedList<String>();
//tags5.insert("animal");
//tags5.insert("fox");
//tags5.insert("tree");
//tags5.insert("forest");
//tags5.insert("grass");
//Photo p5=new Photo("fox.jpg",tags5);
//
//LinkedList<String>tags6=new LinkedList<String>();
//tags6.insert("animal");
//tags6.insert("bear");
//tags6.insert("panda");
//tags6.insert("grass");
//Photo p6=new Photo("panda.jpg",tags6);
//
//LinkedList<String>tags7=new LinkedList<String>();
//tags7.insert("animal");
//tags7.insert("wolf");
//tags7.insert("mountain");
//tags7.insert("sky");
//tags7.insert("snow");
//tags7.insert("cloud");
//Photo p7=new Photo("wolf.jpg",tags7);
//
//LinkedList<String>tags8=new LinkedList<String>();
//tags8.insert("animal");
//tags8.insert("raccoon");
//tags8.insert("log");
//tags8.insert("snow");
//Photo p8=new Photo("raccoon.jpg",tags8);
//
//    //////////////////
//PhotoManager manager1=new PhotoManager();
//manager1.deletePhoto("raccoon.jpg");
//manager1.addPhoto(p1);
//manager1.addPhoto(p1);//dublicate adding
//BST<LinkedList<Photo>>index=manager1.getPhotos();//try add photo without tags
//System.out.println("==================== ==================");
//System.out.println("After Adding first Photo index as follwing");
//inOrder(index);//print tree with one node
//
//
//LinkedList<Photo>llP=manager1.getPhotosHaveBeenInsertedInBST();
//
//System.out.println("End Adding first Photo index .........");
//System.out.println("==================== ==================");
//displayListOfPhoto(llP);//check the list of photos
//manager1.deletePhoto("hedgehog.jpg");
//index=manager1.getPhotos();
//
//System.out.println("==================== ==================");
//System.out.println("After deleting first Photo index as follwing");
//inOrder(index);//print tags without photo
//
//System.out.println("End deleting first Photo index .........");
//System.out.println("==================== ==================");
//manager1.addPhoto(p2);
//manager1.addPhoto(p3);
//manager1.addPhoto(p4);
//manager1.addPhoto(p5);
//manager1.addPhoto(p6);
//manager1.addPhoto(p7);
//manager1.addPhoto(p8);
//index=manager1.getPhotos();
//
//System.out.println("==================== ==================");
//System.out.println("After Adding 8 Photos index as follwing");
//inOrder(index);
//System.out.println("End Adding 8 Photos index .........");
//
//System.out.println("==================== ==================");
//manager1.deletePhoto("hedgehog.jpg");
//manager1.deletePhoto("bear.jpg");
//manager1.deletePhoto("butterfly1.jpg");
//manager1.deletePhoto("butterfly2.jpg");
//manager1.deletePhoto("fox.jpg");
//manager1.deletePhoto("panda.jpg");
//manager1.deletePhoto("wolf.jpg");
//manager1.deletePhoto("raccoon.jpg");
//index=manager1.getPhotos();
//
//System.out.println("==================== ==================");
//System.out.println("After deleting All Photo index as follwing");
//inOrder(index);
//System.out.println("End deleting All Photo index .........");
//System.out.println("==================== ==================");
//System.out.println("End checking photo manager ");
//System.out.println("==================== ==================");
//System.out.println("the follwing checking Album......... ");
//System.out.println("==================== ==================");
//manager1.addPhoto(p1);
//manager1.addPhoto(p2);
//manager1.addPhoto(p3);
//manager1.addPhoto(p4);
//manager1.addPhoto(p5);
//manager1.addPhoto(p6);
//manager1.addPhoto(p7);
//manager1.addPhoto(p8);
//
//displayListOfPhoto(llP);
//
//Album A=new Album("album1","animal AND grass", manager1);//try the wrong and empty conditions
//LinkedList<Photo>res=A.getPhotos();
//displayListOfPhoto(res);//مو جالس يضيف لي ؟ يطلع امبتي لست
//System.out.println(A.getNbComps());
//A=new Album("album1","animal",manager1);
//res=A.getPhotos(); displayListOfPhoto(res);
//System.out.println(A.getNbComps());
//A=new Album("album1","animal AND gra", manager1);
//res=A.getPhotos(); displayListOfPhoto(res);
//System.out.println(A.getNbComps());
//A=new Album("album1","animal AND grass AND panda", manager1);
//res=A.getPhotos();
//displayListOfPhoto(res);
//System.out.println(A.getNbComps());
//A=new Album("album1","animal AND grass AND bear", manager1); res=A.getPhotos();
//displayListOfPhoto(res);
//System.out.println(A.getNbComps());
//A=new Album("album1","animal AND gra AND bear", manager1); res=A.getPhotos();
//displayListOfPhoto(res);
//System.out.println(A.getNbComps());
//A=new Album("album1","", manager1);
//res=A.getPhotos();
//displayListOfPhoto(res); System.out.println(A.getNbComps());
//
//    }//end main
//   
//   
//   
//   
//   
//   
//   
//   
//   
//   
//   
//   
//    //helping methods
//     //1- temp displayListOfPhoto method to check my solution
//    public static void displayListOfPhoto(LinkedList<Photo>L)
//    {
//if(L==null) {System.out.println("null List");}
//else if(L.empty()) {System.out.println("empty list");} else
//{
//L.findFirst(); while(!L.last()){
//   
//   
//System.out.print(L.retrieve().getPath()+ " ");
//L.findNext(); }
////L.retrieve().display();
//System.out.println(L.retrieve().getPath( )+" ");
//System.out.println("---------------- --------------");
//}
//}
//
//    //2-
//   
//public static void inOrder(BST<LinkedList<Photo>>index) {
//if(index.empty())
//System.out.println("empty tree"); else
//recinOrder(index.getRoot());
//}
////3-
//private static void recinOrder(BSTNode<LinkedList<Photo>>p) {
//if(p==null) return; recinOrder(p.left); System.out.println("key= "+ p.key); displayListOfPhoto(p.data); recinOrder(p.right);
//}
//
//
//}