package lab1;

import java.util.ArrayList;

public class GroceryLists {
    public static void main(String[] args) {
        /* DO NOT EDIT THE MAIN METHOD */

        //declare and initialize an ArrayList for each person
        ArrayList<GroceryItem> aList = new ArrayList<GroceryItem>();
        ArrayList<GroceryItem> bList = new ArrayList<GroceryItem>();
        ArrayList<GroceryItem> cList = new ArrayList<GroceryItem>();

        //populate all three lists
        addGroceries(aList, bList, cList);

        //print the three lists
        System.out.println("Arya's List:");
        printList(aList);
        System.out.println("Brighton's List:");
        printList(bList);
        System.out.println("Charlie's List:");
        printList(cList);

        //combine the three lists into one ArrayList (allList)
        System.out.println("Combined List: ");
        ArrayList<GroceryItem> allList = combineLists(aList, bList, cList);
        printList(allList);

        //remove all "broccoli" from allList
        deleteByName(allList, "broccoli");
        System.out.println("No more broccoli:");
        printList(allList);

        //count the number of unique items in allList
        System.out.println("Number of unique items: "+countUnique(allList)
                +"\n***");

        //print a temporary list containing only the fruit category
        System.out.println("Just the fruits:");
        printList(findCategory(allList,"fruit"));


        //BONUS: combine duplicated items (e.g. 2 apple + 1 apple = 3 apple)
        combineDuplicates(allList);
        System.out.println("BONUS - Combined duplicates:");
        printList(allList);
    }

    private static void addGroceries(ArrayList<GroceryItem> aList, ArrayList<GroceryItem> bList, ArrayList<GroceryItem> cList) {
        /* DO NOT EDIT THIS METHOD */

        //adding items to Arya's list
        aList.add(new GroceryItem("bell pepper", "vegetable", 2));
        aList.add(new GroceryItem("pineapple", "fruit", 1));
        aList.add(new GroceryItem("apple", "fruit", 2));
        aList.add(new GroceryItem("cheese", "dairy", 2));
        aList.add(new GroceryItem("bagel", "bakery", 2));

        //adding items to Brighton's list
        bList.add(new GroceryItem("broccoli", "vegetable", 3));
        bList.add(new GroceryItem("apple", "fruit", 4));
        bList.add(new GroceryItem("bagel", "bakery", 6));
        bList.add(new GroceryItem("bacon", "meat", 1));
        bList.add(new GroceryItem("yogurt", "dairy", 1));

        //adding items to Charlie's list
        cList.add(new GroceryItem("cheese", "dairy", 1));
        cList.add(new GroceryItem("bagel", "bakery", 4));
        cList.add(new GroceryItem("banana", "fruit", 6));
        cList.add(new GroceryItem("turkey", "meat", 1));
        cList.add(new GroceryItem("broccoli", "vegetable", 2));
    }

    private static ArrayList<GroceryItem> combineLists(ArrayList<GroceryItem> aList, ArrayList<GroceryItem> bList, ArrayList<GroceryItem> cList) {
        ArrayList<GroceryItem> combineList = new ArrayList<>();
        combineList.addAll(aList);
        combineList.addAll(bList);
        combineList.addAll(cList);

        return combineList; //temporary, change this later
    }

    private static void deleteByName(ArrayList<GroceryItem> list, String name) {
        // Go over the entire list and match each element name with the given name
        // We are doing an operation on each element while tranversing over the list
        // It may raise an ConccurenceException
        // So I think it would be convienent to use an iterator.
        java.util.Iterator<GroceryItem> it = list.iterator();

        while (it.hasNext()) {
            GroceryItem e = it.next();
            if (e.getName().equals(name))
                it.remove();
        }
    }

    private static void printList(ArrayList<GroceryItem> list) {
        // Go to each element and print it after the "- "
        for (GroceryItem e: list) {
            System.out.println("- "+e);
        }

        // End the list with thre ***
        System.out.println("***");
    }

    private static ArrayList<GroceryItem> findCategory(ArrayList<GroceryItem> list, String category) {
        ArrayList<GroceryItem> result = new ArrayList<>();
        // Go over the entire list, and match each element catergory with the given one
        for (GroceryItem e: list) {
            // If matched,
            if (e.getCategory().equals(category))
                result.add(e);
        }
        return result; //temporary, change this later
    }

    private static int countUnique(ArrayList<GroceryItem> list) {
        // Create an array to store non duplicates
        ArrayList<GroceryItem> temp = new ArrayList<>();
        for (GroceryItem e: list) {
           boolean nonDup = true;
           for (GroceryItem item: temp) {
               if (item.getName().equals(e.getName())) {
                   nonDup = false;
                   break;
               }
           }

           if (nonDup) temp.add(e);
        }
        return temp.size(); // The size of the temp list is the number of non duplicates
    }

    private static void combineDuplicates(ArrayList<GroceryItem> list) {
        ArrayList<GroceryItem> temp = new ArrayList<>();
        for (GroceryItem e: list) {
           boolean nonDup = true;
           for (GroceryItem item: temp) {
               if (item.getName().equals(e.getName())) {
                   nonDup = false;
                   item.setQuantity(item.getQuantity() + e.getQuantity());
                   break;
               }
           }
           if (nonDup) temp.add(e);
        }
        //Clear list
        list.clear();
        //Copy contents into the old list
        list.addAll(temp);
    }
}

