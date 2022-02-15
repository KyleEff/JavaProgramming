import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

// Main panel
public class GearSelect extends JPanel {
    // Attributes
    String[] decks = // Deck Names
        { "The Master Thrasher - $60", "The Dictator - $45", "The Street King - $50" };
    
    int[] deckPrices = // Deck Prices
        { 60, 45, 50 };
    
    String[] trucks = // Truck Names
        { "7.75 inch axle - $35", "8 inch axle - $40", "8.5 inch axle - $45" };
    
    int[] truckPrices = // Truck Prices
        { 35, 40, 45 };
    
    String[] wheels = // Wheel Names
        { "51 mm - $20", "55 mm - $22 ", "58 mm - $24", "61 mm - $28" };
    
    int[] wheelPrices = // Wheel Prices
        { 20, 22, 24, 28 };
    
    String[] misc = // Misc Gear
        { "Grip tape - $10", "Bearings - $30", "Riser pads - $2", "Nuts & bolts kit - $3" };
    
    int[] miscPrices = // Misc Prices
        { 10, 30, 2, 3 };
    
    String[] gearTitles = // Gear name strings
        { "Decks", "Trucks", "Wheels", "Misc" };
    
    String[][] gearNames = // Array of string arrays for initialization
        { decks, trucks, wheels, misc };
    
    int[][] gearPrices = // Array of the gear prices
        { deckPrices, truckPrices, wheelPrices, miscPrices };
    
    int[] gearTotals =
        { 0, 0, 0, 0 }; // used to keep track of gear price selection
    // 0 - decks, 1 - trucks, 2 - wheels, 3 - misc
    
    int[] miscTotals = // used to keep track of the misc gear selection
        { 0, 0, 0, 0 };
    
    public static double[] chargeAmts = 
        { 0.0, 0.0, 0.0 }; // Money amounts to be charged
    // 0 subtotal, 1 taxAmt, 2 total
    
    final double SALES_TAX = 0.06; // Sales tax percentage
    
    public static JList[] gearLists; // Lists for the decks, trucks, and wheels
    JPanel radioPanel; // Panel for radioButtons
    
    public GearSelect() {
        
        setLayout(new GridLayout(2, 2));
        
        buildLists();
    }
    
    void buildLists() {
        
        int // index variables
            j = 0, // used to index the gearNames array, and price arrays
            r = 3; // Used for visable rows
    
        gearLists = new JList[4];
        
        for (var i : gearLists) {
            
            i = new JList(gearNames[j]); // New List with names
            i.setVisibleRowCount(r); // Visable Rows
            i.setBorder(BorderFactory.createTitledBorder(gearTitles[j])); // Bordered list titles
            
            if (j < 3) 
                i.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection mode for the first three lists
            
            else
                i.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            i.addListSelectionListener(new ListSelectionListener() { // Event Listener for the lists

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    JList selection = (JList) e.getSource(); // Casts the source of the event as a JList
                    System.out.print("Selected Index: ");
                    System.out.println(selection.getSelectedIndex());
                    
                    /**
                     * The following loops cycle through the arrays looking for a match of the names,
                     *  and then use the index from the selection to pull the price from another array,
                     *  and then adds the price to the appropriate gearTotals index
                    **/

                    int k = 0; // panel number
                    
                    System.out.println("LOOP A");
                    for (var names : gearNames) { // cycle through the gear name arrays to find a match

                        if (selection.getSelectedIndex() < 3) { // if the selected index is less than 3
                            // This statement is because the third list has 3 indices
                            System.out.println("LOOP B1");
                            for (var i : names) { // cycle through the names array
                                
                                if (i.equals(selection.getSelectedValue())) { // if a match is found

                                    System.out.print("MATCH FOUND K = ");
                                    System.out.println(k);
                                    if (gearTotals[k] <= 0) { // if there nothing selected

                                        gearTotals[k] // add selection to the gear subtotal
                                            += gearPrices[k][selection.getSelectedIndex()];
                                    }

                                    else { // if there is already a selection

                                        gearTotals[k] = 0; // clear amount selected
                                        gearTotals[k] // add the selected gear to the selected gear subtotal
                                            += gearPrices[k][selection.getSelectedIndex()];
                                    }
                                    
                                    for (var s : miscTotals)
                                        System.out.println(s);

                                    break;
                                }
                            }
                            
                            k++;
                        }

                        else { // If the index selected is greater than 2
                            
                            k = 2; // Switch to the third panel
                            
                            System.out.println("LOOP B2");
                            for (var f : names) { // search the last gear name array
                                
                                if (k != 3) {
                                    // If the selection matches the gear name
                                    if (f.equals(selection.getSelectedValue())) {
                                        
                                        System.out.print("MATCH FOUND K = ");
                                        System.out.println(k);
                                        
                                        if (gearTotals[k] <= 0) { // if there is no selection

                                            gearTotals[k] // add selection
                                                += gearPrices[k][selection.getSelectedIndex()];

                                        }

                                        else { // if there is already a selection

                                            gearTotals[k] = 0; // clear spot
                                            gearTotals[k] // add selection
                                                += gearPrices[k][selection.getSelectedIndex()];

                                        } // clear the gearTotal and implement the new price
                                        
                                        for (var s : miscTotals)
                                                System.out.println(s);
                                        
                                        break;
                                    }
                                }   
                                
                                else {
                                    
                                    if (f.equals(selection.getSelectedValue())) {
                                        System.out.print("MATCH FOUND K = ");
                                        System.out.println(k);
                                        
                                        miscTotals[selection.getSelectedIndex()]
                                            += gearPrices[k][selection.getSelectedIndex()];
                                        
                                        break;
                                    }
                                }
                            }
                            
                            k++; // Next panel
                        }
                    }
                    
                    updateSubtotal();
                    calcTotal();
                    
                    System.out.println("\nAction"); // console prints
                    for (var i : gearTotals)
                        System.out.println(i);
                }
            });

        add(i); // add the list to the panel

        j++; // Next index in the array of string arrays

        // The 3rd list needs 4 visable rows, so the rows variable
        //  will be incremented after the second list
            if (j == 1)
                r++;
        }
    }
    
                
    // Used to update the subtotal for calculation
    private void updateSubtotal() {
        
        System.out.println("\nupdateSubtotal"); // Console Tag
    
        double temp = 0.0; // temp variable
        chargeAmts[0] = 0.0; // reset subtotal
        
        for (var i : miscTotals)
            temp += (double) i;
        
        gearTotals[3] += temp; // adding misc total to the subtotal
        
        temp = 0.0; // temp reset
        
        for (var i : gearTotals) // add totals to the temp variable
            temp += (double) i;
        
        //System.out.println(temp); // console print
        
        chargeAmts[0] += temp; // adding temp to subtotal
    }
    
    // Calculate the Total of the order within the array
    void calcTotal() {

        System.out.println("\ncalcTotal"); // console tag

        if (chargeAmts[1] > 0 || chargeAmts[2] > 0) { // if there is any taxAmt or Total
            // reset all amounts
            chargeAmts[1] = 0.0;
            chargeAmts[2] = 0.0;
        }

        chargeAmts[1] = chargeAmts[0] * SALES_TAX; // tax amount
        chargeAmts[2] += (chargeAmts[0] + chargeAmts[1]); // Total (Tax amount plus subtotal)
        
        
        // console print
        for (var i : chargeAmts)
            System.out.println(i);
    }
}
